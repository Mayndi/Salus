package com.platform.salus.user.converter.output;

public class UserOutputCommonFields {

    private String successMessage;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public UserOutputCommonFields setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public UserOutputCommonFields setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
        return this;
    }
}
