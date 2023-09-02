package com.mfouad.reactivepro.Router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mfouad.reactivepro.DTO.Customer;
import com.mfouad.reactivepro.Dao.CustomerDao;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerRouterStreamHandler {

    @Autowired
    private CustomerDao dao;

    // create functional endpoint
    public Mono<ServerResponse> loadCutomers(ServerRequest request){
       Flux<Customer> customers = dao.getCustomersReactiveWithoutSleep();

       return ServerResponse.ok()
       // make return type event stream
       .contentType(MediaType.TEXT_EVENT_STREAM)
       .body(customers,Customer.class);
    }
    
}
