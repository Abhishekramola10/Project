package com.BootCampProject1.BootCampProject1.ENTITIES;

import javax.persistence.*;


@PrimaryKeyJoinColumn(name = "USER_ID")
@Entity
public class CUSTOMER extends USER {

    private int CONTACT;

    public int getCONTACT() {
        return CONTACT;
    }

    public void setCONTACT(int CONTACT) {
        this.CONTACT = CONTACT;
    }
}
