package com.ums.dto;

import java.util.Date;

public class ErrorDetails {
    private String errorMessage;
    private Date date;
    private String WebRequest;

    public ErrorDetails(String errorMessage, Date date, String webRequest) {
        this.errorMessage = errorMessage;
        this.date = date;
        WebRequest = webRequest;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Date getDate() {
        return date;
    }

    public String getWebRequest() {
        return WebRequest;
    }
}


