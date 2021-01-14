package com.platform.salus.converter.output;

public class SalusErrorOutput {

	private String message;

    public SalusErrorOutput(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

