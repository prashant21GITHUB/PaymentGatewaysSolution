package com.veripaymentgateways.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author bajpai
 */
@Entity
@Table(name = "currency_entity")
public class CurrencyEntity {

    @Id
    @SequenceGenerator(name = "currency_id", sequenceName = "CUR_SEQ_GEN", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "currency_id")
    private int id;
    @Column(unique = true)
    private String code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
