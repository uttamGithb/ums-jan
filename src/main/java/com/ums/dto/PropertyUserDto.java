package com.ums.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class PropertyUserDto {

    private Long id;
    @NotNull
    @Size(min = 2,message = "Name Should be atleast 2 characters")
    private String name;
    @Size(min = 10,max=10,message = "Number should be excat 10 digits")
    private String mobile;
    @Email
    private String emailId;

    private Date date;
    private PageDetails pageDetails;

    public PageDetails getPageDetails() {
        return pageDetails;
    }

    public void setPageDetails(PageDetails pageDetails) {
        this.pageDetails = pageDetails;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
