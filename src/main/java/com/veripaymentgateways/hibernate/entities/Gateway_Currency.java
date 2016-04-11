package com.veripaymentgateways.hibernate.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author bajpai
 */
@Entity
@Table(name = "gateway_currency_map")
public class Gateway_Currency {

    @EmbeddedId
    private GatewayCurrencyKey key;

    public GatewayCurrencyKey getKey() {
        return key;
    }

    public void setKey(GatewayCurrencyKey key) {
        this.key = key;
    }


}
