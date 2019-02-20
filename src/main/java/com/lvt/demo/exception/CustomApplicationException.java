package com.lvt.demo.exception;

public class CustomApplicationException extends Exception{
    private String code;

    public CustomApplicationException(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
