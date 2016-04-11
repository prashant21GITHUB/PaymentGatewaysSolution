package com.veripaymentgateways.dto;

import java.util.List;

/**
 *
 * @author bajpai
 */
public class PaymentGateway {

    private int id;
    private String name;
    private String image;
    private String description;
    private boolean branding;
    private float rating;
    private boolean setUpFee;
    private float setUpFeeAmount;
    private float perTransactionFeePercentage;
    private String how_to_url;

    public String getHow_to_url() {
        return how_to_url;
    }

    public void setHow_to_url(String how_to_url) {
        this.how_to_url = how_to_url;
    }
    private List<String> currencies;

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

    public List<String> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<String> currencies) {
        this.currencies = currencies;
    }

}
