package com.veripaymentgateways.dao.services;

import com.veripaymentgateways.dao.translator.PaymentGatewayTranslator;
import com.veripaymentgateways.dto.PaymentGateway;
import com.veripaymentgateways.dto.PaymentGatewaysWrapper;
import com.veripaymentgateways.hibernate.configs.HibernateUtils;
import com.veripaymentgateways.hibernate.entities.CurrencyEntity;
import com.veripaymentgateways.hibernate.entities.GatewayCurrencyKey;
import com.veripaymentgateways.hibernate.entities.Gateway_Currency;
import com.veripaymentgateways.hibernate.entities.PaymentGatewayEntity;
import com.veripaymentgateways.response.ResponseMessage;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bajpai
 */
@Service
public class PaymentGatewayServiceImpl implements IPaymentGatewayService {

    @Autowired
    private PaymentGatewayTranslator paymentGatewayTranslator;

    @Override
    public ResponseMessage addPaymentGateway(PaymentGateway pg) {
        PaymentGatewayEntity entity = paymentGatewayTranslator.translatePaymentGateway(pg);
        ResponseMessage resMsg = new ResponseMessage();
        try {
            Session session = HibernateUtils.getSession();
            session.beginTransaction();
            session.save(entity);
            saveCurrency(entity.getId(), session, pg.getCurrencies());
            session.getTransaction().commit();
            session.close();
            resMsg.setSuccess(true);
            resMsg.setMessage("New Payment Gateway added successfully.");
        } catch (ConstraintViolationException ex) {
            resMsg.setSuccess(false);
            resMsg.setMessage("Duplicate entry, Payment gateway with name: '" + pg.getName() + "' already exists in records.");
        }
        return resMsg;
    }

    private void saveCurrency(int gatewayId, Session session, List<String> currencies) {
        for (String code : currencies) {
            int currencyId;
            List<CurrencyEntity> list = session.createQuery("from CurrencyEntity where code = '" + code + "'").list();
            if (null == list || list.isEmpty()) {
                CurrencyEntity entity = new CurrencyEntity();
                entity.setCode(code);
                session.save(entity);
                currencyId = entity.getId();
            } else {
                currencyId = list.get(0).getId();
            }
            Gateway_Currency gatewayCurrency = new Gateway_Currency();
            GatewayCurrencyKey key = new GatewayCurrencyKey();
            key.setCurrencyId(currencyId);
            key.setGatewayId(gatewayId);
            gatewayCurrency.setKey(key);
            session.save(gatewayCurrency);
        }

    }

    @Override
    public PaymentGatewaysWrapper getAllGateways() {
        PaymentGatewaysWrapper wrapper = new PaymentGatewaysWrapper();
        List<PaymentGateway> responseList = new ArrayList<PaymentGateway>();
        Session session = HibernateUtils.getSession();
        List<PaymentGatewayEntity> gateways = session.createQuery("from PaymentGatewayEntity").list();
        for (PaymentGatewayEntity entity : gateways) {
            PaymentGateway pg = paymentGatewayTranslator.translatePaymentGatewayToResponse(entity);
            List<String> currencies = new ArrayList<String>();
            List<Integer> mapList = session.createSQLQuery("select currencyId from gateway_currency_map where gatewayid = " + pg.getId()).list();
            for (int m : mapList) {
                List<CurrencyEntity> cList = session.createCriteria(CurrencyEntity.class).add(Restrictions.eq("id", m)).list();
                currencies.add(cList.get(0).getCode());
            }
            pg.setCurrencies(currencies);
            responseList.add(pg);
        }
        wrapper.setPayment_gateways(responseList);
        session.close();
        return wrapper;
    }

    @Override
    public PaymentGatewaysWrapper getGatewaysByName(String name) {
        PaymentGatewaysWrapper wrapper = new PaymentGatewaysWrapper();
        List<PaymentGateway> responseList = new ArrayList<PaymentGateway>();
        Session session = HibernateUtils.getSession();
        List<PaymentGatewayEntity> gateways = session.createQuery("from PaymentGatewayEntity").list();
        for (PaymentGatewayEntity entity : gateways) {
            if (!entity.getName().toLowerCase().contains(name.toLowerCase())) {
                continue;
            }
            PaymentGateway pg = paymentGatewayTranslator.translatePaymentGatewayToResponse(entity);
            List<String> currencies = new ArrayList<String>();
            List<Integer> mapList = session.createSQLQuery("select currencyId from gateway_currency_map where gatewayid = " + pg.getId()).list();
            for (int m : mapList) {
                List<CurrencyEntity> cList = session.createCriteria(CurrencyEntity.class).add(Restrictions.eq("id", m)).list();
                currencies.add(cList.get(0).getCode());
            }
            pg.setCurrencies(currencies);
            responseList.add(pg);
        }
        wrapper.setPayment_gateways(responseList);
        session.close();
        return wrapper;
    }

    @Override
    public ResponseMessage deleteById(int id) {
        ResponseMessage resMsg = new ResponseMessage();
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        PaymentGatewayEntity entity = session.get(PaymentGatewayEntity.class, id);
        if (entity == null) {
            resMsg.setMessage("Record doesn't exist for Id: " + id);
        } else {
            session.delete(entity);
            int result = session.createSQLQuery("delete from gateway_currency_map where gatewayId = " + id).executeUpdate();
            if (result <= 0) {
                resMsg.setMessage("Partially deleted,the association between gateway and its Currency still exists, but the Payment gateway info is deleted ID: " + id);
            } else {
                resMsg.setMessage("Deleted successfully, ID: " + id);
            }
            resMsg.setSuccess(true);
        }
        session.getTransaction().commit();
        session.close();
        return resMsg;
    }

    @Override
    public PaymentGatewaysWrapper getGatewaysByCurrency(String currency) {
        PaymentGatewaysWrapper wrapper = new PaymentGatewaysWrapper();
        List<PaymentGateway> responseList = new ArrayList<PaymentGateway>();
        wrapper.setPayment_gateways(responseList);
        Session session = HibernateUtils.getSession();
        List<CurrencyEntity> cList = session.createQuery("from CurrencyEntity where code = '" + currency + "'").list();
        int cId;
        if (cList != null && !cList.isEmpty()) {
            cId = cList.get(0).getId();
        } else {
            return wrapper;
        }
        List<Integer> mapList = session.createSQLQuery("select gatewayId from gateway_currency_map where currencyId = " + cId).list();
        for (int id : mapList) {
            PaymentGateway pg = getGatewayById(id, session);
            responseList.add(pg);
        }
        session.close();
        return wrapper;
    }

    private PaymentGateway getGatewayById(int id, Session session) {
        PaymentGatewayEntity entity = session.get(PaymentGatewayEntity.class, id);
        PaymentGateway gateway = paymentGatewayTranslator.translatePaymentGatewayToResponse(entity);
        List<String> currencies = new ArrayList<String>();
        List<Integer> mapList = session.createSQLQuery("select currencyId from gateway_currency_map where gatewayid = " + gateway.getId()).list();
        for (int m : mapList) {
            List<CurrencyEntity> cList = session.createCriteria(CurrencyEntity.class).add(Restrictions.eq("id", m)).list();
            currencies.add(cList.get(0).getCode());
        }
        gateway.setCurrencies(currencies);
        return gateway;
    }
}
