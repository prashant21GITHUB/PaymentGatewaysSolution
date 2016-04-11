package com.veripaymentgateways.dto;

import java.util.List;

/**
 *
 * @author bajpai
 */
public class PaymentGatewaysWrapper {
    private List<PaymentGateway> payment_gateways;

    public List<PaymentGateway> getPayment_gateways() {
        return payment_gateways;
    }

    public void setPayment_gateways(List<PaymentGateway> payment_gateways) {
        this.payment_gateways = payment_gateways;
    }

}
