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
@Table(name = "payment_gateway_entity")
public class PaymentGatewayEntity {

    @Id
    @SequenceGenerator(name = "payment_gateway_id", sequenceName = "PAY_SEQ_GEN", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "payment_gateway_id")
    private int id;
    @Column(unique = true)
    private String name;
    private String image;
    private String description;
    private boolean branding;
    private float rating;
    private boolean setUpFee;
    private float setUpFeeAmount;
    private float perTransactionFeePercentage;
    private String how_To_Url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isBranding() {
        return branding;
    }

    public void setBranding(boolean branding) {
        this.branding = branding;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isSetUpFee() {
        return setUpFee;
    }

    public void setSetUpFee(boolean setUpFee) {
        this.setUpFee = setUpFee;
    }

    public float getSetUpFeeAmount() {
        return setUpFeeAmount;
    }

    public void setSetUpFeeAmount(float setUpFeeAmount) {
        this.setUpFeeAmount = setUpFeeAmount;
    }

    public float getPerTransactionFeePercentage() {
        return perTransactionFeePercentage;
    }

    public void setPerTransactionFeePercentage(float transactionFee) {
        this.perTransactionFeePercentage = transactionFee;
    }

    public String getHow_To_Url() {
        return how_To_Url;
    }

    public void setHow_To_Url(String how_To_Url) {
        this.how_To_Url = how_To_Url;
    }
}
