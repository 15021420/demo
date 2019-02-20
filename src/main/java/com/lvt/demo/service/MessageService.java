package com.lvt.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private Environment environment;

    @Autowired
    private MessageSource messageSource;

    public String getCode(String message) {
        String code = messageSource.getMessage(message + ".code", null, null);
        if (StringUtils.isEmpty(code)) {
            return message + ".code";
        }
        return code;
    }

    public String getMessage(String message) {
        String msg = environment.getProperty(message + ".message");
        if (StringUtils.isEmpty(msg)) {
            return message + ".message";
        }
        return msg;
    }

    public String getMessage(String message, FieldError f) {
        String fieldName = f.getField().replaceAll("(.)(\\p{Upper})","$1_$2").toLowerCase();
        List<String> param = new ArrayList<>();

        String msg = messageSource.getMessage(message + ".message", param.stream().toArray(String[] :: new), null);
        if (StringUtils.isEmpty(msg)) {
            return message + ".message";
        }
        return msg;
    }
}
