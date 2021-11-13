package com.BootCampProject1.BootCampProject1.ENTITIES;

import javax.persistence.*;
import java.util.List;

@PrimaryKeyJoinColumn(name = "USER_ID")
@Entity
public class SELLER extends USER {

    private double GST;
    private int COMPANY_CONTACT;
    private String COMPANY_NAME;

    public double getGST() {
        return GST;
    }

    public void setGST(double GST) {
        this.GST = GST;
    }

    public int getCOMPANY_CONTACT() {
        return COMPANY_CONTACT;
    }

    public void setCOMPANY_CONTACT(int COMPANY_CONTACT) {
        this.COMPANY_CONTACT = COMPANY_CONTACT;
    }

    public String getCOMPANY_NAME() {
        return COMPANY_NAME;
    }

    public void setCOMPANY_NAME(String COMPANY_NAME) {
        this.COMPANY_NAME = COMPANY_NAME;
    }
}
