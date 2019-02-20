package com.lvt.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lvt.demo.exception.Errors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResponseBasicObj implements Serializable {

    private Meta meta;

    private Object data;

    public ResponseBasicObj() {
    }

    public ResponseBasicObj(String code, String message, Object data) {
        this.meta = new Meta(code, message);
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @JsonIgnore
    public void addErrors(List<Errors> lstError) {
        if (this.meta.getErrors() == null) {
            this.meta.setErrors(new ArrayList<>());
        }
        this.meta.getErrors().addAll(lstError);
    }

    @JsonIgnore
    public void addErrors(String code, String message) {
        if (this.meta.getErrors() == null)
            this.meta.setErrors(new ArrayList<>());
        this.meta.addErrors(code, message);
    }

    @JsonIgnore
    public List<Errors> getErrors() {
        return this.meta.getErrors();
    }


    class Meta {

        @JsonProperty("code")
        String code;

        @JsonProperty("message")
        String message;

        @JsonProperty("errors")
        List<Errors> errors;

        public Meta(String code, String message, List<Errors> errors) {
            this.code = code;
            this.message = message;
            this.errors = errors;
        }

        public Meta(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public Meta() {
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @JsonIgnore
        public void addErrors(String code, String message) {
            if (null == this.errors) {
                this.errors = new ArrayList<>();
            }
            this.errors.add(new Errors(code, message));
        }

        public List<Errors> getErrors() {
            return errors;
        }

        public void setErrors(List<Errors> errors) {
            this.errors = errors;
        }
    }
}
