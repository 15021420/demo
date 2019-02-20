package com.lvt.demo.config;

import com.lvt.demo.bean.ResponseBasicObj;
import com.lvt.demo.exception.ErrorCode;
import com.lvt.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class ApplicationReponseBodyFilter implements ResponseBodyAdvice<Object> {

    @Autowired
    private MessageService messageService;

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return new ResponseBasicObj(messageService.getCode(ErrorCode.SUCCESS), messageService.getMessage(ErrorCode.SUCCESS), body);
    }

}
