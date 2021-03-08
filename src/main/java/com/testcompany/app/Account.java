package com.testcompany.app;

import com.github.cliftonlabs.json_simple.JsonObject;

import java.math.BigDecimal;

/**
 * Account class for storing all account information
 */
public class Account {
    private String account_category;
    private String account_code;
    private String account_currency;
    private String account_identifier;
    private String account_status;
    private String account_name;
    private String account_type;
    private String account_type_bank;
    private String value_type;
    private String system_account;
    private BigDecimal total_value;

    public Account() {}

    public Account(JsonObject json_object) {
        this.account_category = (String) json_object.get("account_category");
        this.account_code = (String) json_object.get("account_code");
        this.account_currency = (String) json_object.get("account_currency");
        this.account_identifier = (String) json_object.get("account_identifier");
        this.account_status = (String) json_object.get("account_status");
        this.account_name = (String) json_object.get("account_name");
        this.account_type = (String) json_object.get("account_type");
        this.account_type_bank = (String) json_object.get("account_type_bank");
        this.value_type = (String) json_object.get("value_type");
        this.system_account = (String) json_object.get("system_account");
        this.total_value = (BigDecimal) json_object.get("total_value");
    }

    /**
     * @return account type
     */
    public String getAccountType() { return account_type; }

    /**
     * @return account category
     */
    public String getAccountCategory() { return account_category; }

    /**
     * @return total value of account
     */
    public BigDecimal getTotalValue() { return total_value; }

    /**
     * @return value type of account
     */
    public String getValueType() { return value_type; }

    /**
     *
     * @param total_value new total value of account
     */
    public void setTotalValue(BigDecimal total_value) {
        this.total_value = total_value;
    }
}
