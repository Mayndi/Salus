package com.platform.salus.common.utils;

public class CommonFields {

    private String successMessage;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public CommonFields setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public CommonFields setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
        return this;
    }
}
