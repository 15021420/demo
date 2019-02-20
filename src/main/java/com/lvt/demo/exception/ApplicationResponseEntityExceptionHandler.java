package com.lvt.demo.exception;

import com.lvt.demo.bean.ResponseBasicObj;
import com.lvt.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ApplicationResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageService messageService;

    @Override
    @SuppressWarnings("unused")
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ResponseBasicObj responseBasicObj =
                new ResponseBasicObj(messageService.getCode(ErrorCode.BAD_REQUEST),
                        messageService.getMessage(ErrorCode.BAD_REQUEST));
        ex.getBindingResult().getFieldErrors().stream().forEach(f -> {
            String msgCode = f.getDefaultMessage();
            String code = messageService.getCode(msgCode);
            String message = messageService.getMessage(msgCode, f);
            // Check duplicate error code
            responseBasicObj.addErrors(code, message);
        });

        return new ResponseEntity(responseBasicObj, HttpStatus.BAD_REQUEST);
    }

    @SuppressWarnings("unchecked")
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ResponseBasicObj responseBasicObj =
                new ResponseBasicObj( messageService.getCode(ErrorCode.SYSTEM_ERROR),
                        messageService.getMessage(ErrorCode.SYSTEM_ERROR));

        return new ResponseEntity(responseBasicObj, HttpStatus.BAD_REQUEST);
    }

    @SuppressWarnings("unchecked")
    @ExceptionHandler(CustomApplicationException.class)
    public final ResponseEntity<Object> handleAgencyException(CustomApplicationException ex, WebRequest request) {
        ResponseBasicObj responseBasicObj = null;

        responseBasicObj = new ResponseBasicObj(messageService.getCode(ex.getCode()),
                messageService.getMessage(ex.getCode()));

        return new ResponseEntity(responseBasicObj, HttpStatus.BAD_REQUEST);
    }
}
