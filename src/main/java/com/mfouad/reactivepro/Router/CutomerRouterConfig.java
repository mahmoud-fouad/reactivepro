package com.mfouad.reactivepro.Router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CutomerRouterConfig {


    @Autowired
    CutomerRouterHandler handler;

    @Autowired
    CustomerRouterStreamHandler streamHandler;

    @Autowired
    CustomerByIdHandler customerByIdHandler ;

    @Autowired
    AddCutomerRouterHandler addCutomerRouterHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){

        //Reactive routes url and its handler
        return RouterFunctions.route()
        .GET("/router/customers", handler::loadCutomers)
        .GET("/router/customers/stream", streamHandler::loadCutomers)
        .GET("/router/customer/{id}", customerByIdHandler::getCustomer)
        .POST("/router/customers/", addCutomerRouterHandler::addCustomer)
        .build();
    }
    
}
