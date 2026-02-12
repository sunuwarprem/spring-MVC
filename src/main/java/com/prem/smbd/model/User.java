package com.prem.smbd.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private Long mobileNum;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    public long getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(long mobileNum) {
        this.mobileNum = mobileNum;
    }



    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
