package com.mfouad.reactivepro.Exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

@Component
// custom error attributes to return in error response
public class ErrorAttributes extends DefaultErrorAttributes{

    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {

    Map<String , Object> errors = new HashMap<>();
    Throwable error= getError(request);
    errors.put("message",error.getMessage());
    return errors;

    }
    
}
