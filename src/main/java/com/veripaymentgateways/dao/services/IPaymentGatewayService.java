package com.veripaymentgateways.dao.services;

import com.veripaymentgateways.dto.PaymentGateway;
import com.veripaymentgateways.dto.PaymentGatewaysWrapper;
import com.veripaymentgateways.response.ResponseMessage;

/**
 *
 * @author bajpai
 */
public interface IPaymentGatewayService {

    ResponseMessage addPaymentGateway(PaymentGateway pg);

    PaymentGatewaysWrapper getAllGateways();

    PaymentGatewaysWrapper getGatewaysByName(String name);

    ResponseMessage deleteById(int id);

    PaymentGatewaysWrapper getGatewaysByCurrency(String currency);
}
