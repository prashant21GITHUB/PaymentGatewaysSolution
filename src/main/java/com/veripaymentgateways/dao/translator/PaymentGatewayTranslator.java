package com.veripaymentgateways.dao.translator;

import com.veripaymentgateways.dto.PaymentGateway;
import com.veripaymentgateways.hibernate.entities.PaymentGatewayEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author bajpai
 */
@Component
public class PaymentGatewayTranslator {

    public PaymentGateway translatePaymentGatewayToResponse(PaymentGatewayEntity entity) {
        PaymentGateway gateway = new PaymentGateway();
        gateway.setId(entity.getId());
        gateway.setBranding(entity.isBranding());
        gateway.setHow_to_url(entity.getHow_To_Url());
        gateway.setImage(entity.getImage());
        gateway.setPerTransactionFeePercentage(entity.getPerTransactionFeePercentage());
        gateway.setRating(entity.getRating());
        gateway.setSetUpFeeAmount(entity.getSetUpFeeAmount());
        gateway.setDescription(entity.getDescription());
        gateway.setSetUpFee(entity.isSetUpFee());
        gateway.setName(entity.getName());
        return gateway;
    }

    public PaymentGatewayEntity translatePaymentGateway(PaymentGateway pg) {
        PaymentGatewayEntity entity = new PaymentGatewayEntity();
        entity.setBranding(pg.isBranding());
        entity.setHow_To_Url(pg.getHow_to_url());
        entity.setImage(pg.getImage());
        entity.setPerTransactionFeePercentage(pg.getPerTransactionFeePercentage());
        entity.setRating(pg.getRating());
        entity.setSetUpFeeAmount(pg.getSetUpFeeAmount());
        entity.setDescription(pg.getDescription());
        entity.setSetUpFee(pg.isSetUpFee());
        entity.setName(pg.getName());
        return entity;
    }
}
