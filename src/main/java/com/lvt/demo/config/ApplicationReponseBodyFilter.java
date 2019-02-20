package com.lvt.demo.config;

import com.lvt.demo.bean.ResponseBasicObj;
import com.lvt.demo.exception.ErrorCode;
import com.lvt.demo.service.MessageService;
import com.lvt.demo.utils.ApplicationConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApplicationReponseBodyFilter implements ResponseBodyAdvice<Object> {

    @Autowired
    private MessageService messageService;

    @Autowired
    private HttpServletRequest request;

    @Override
    public boolean supports(MethodParameter arg0, Class<? extends HttpMessageConverter<?>> arg1) {
        if (arg0.getMethod().getReturnType() == ResponseEntity.class) {
            return false;
        }

        String servletPath = request.getServletPath();
        if (!StringUtils.startsWith(servletPath, ApplicationConstants.APPLICATION_API.API_PREFIX)) {
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return new ResponseBasicObj(messageService.getCode(ErrorCode.SUCCESS), messageService.getMessage(ErrorCode.SUCCESS), body);
    }

}
