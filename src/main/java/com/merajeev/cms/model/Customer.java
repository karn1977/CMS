package com.merajeev.cms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("ID")
    private int customerid;
    @JsonProperty("First Name")
    private String customerFirstName;
    @JsonProperty("Last Name")
    private String cutomerLastName;
    @JsonProperty("Email")
    private String customerEmail;

    public int getCustomerid () {
        return customerid;
    }

    public void setCustomerid (int customerid) {
        this.customerid = customerid;
    }

    public String getCustomerFirstName () {
        return customerFirstName;
    }

    public void setCustomerFirstName (String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCutomerLastName () {
        return cutomerLastName;
    }

    public void setCutomerLastName (String cutomerLastName) {
        this.cutomerLastName = cutomerLastName;
    }

    public String getCustomerEmail () {
        return customerEmail;
    }

    public void setCustomerEmail (String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
