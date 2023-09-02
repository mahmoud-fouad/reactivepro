package com.mfouad.reactivepro.Router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mfouad.reactivepro.DTO.Customer;
import com.mfouad.reactivepro.Dao.CustomerDao;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CutomerRouterHandler {

    @Autowired
    private CustomerDao dao;

    // create functional endpoint
    public Mono<ServerResponse> loadCutomers(ServerRequest request){
       Flux<Customer> customers = dao.getCustomersReactiveWithoutSleep();

       return ServerResponse.ok().body(customers,Customer.class);
    }
    
}
