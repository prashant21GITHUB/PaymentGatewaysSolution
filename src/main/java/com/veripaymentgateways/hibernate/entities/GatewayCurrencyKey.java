package com.veripaymentgateways.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author bajpai
 */
@Embeddable
public class GatewayCurrencyKey implements Serializable {

    private int gatewayId;
    private int currencyId;

    public int getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(int gatewayId) {
        this.gatewayId = gatewayId;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }
}
