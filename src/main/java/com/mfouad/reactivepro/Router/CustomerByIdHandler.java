package com.mfouad.reactivepro.Router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mfouad.reactivepro.DTO.Customer;
import com.mfouad.reactivepro.Dao.CustomerDao;
import com.mfouad.reactivepro.Exceptions.NotFoundCustomerException;

import reactor.core.publisher.Mono;

@Service
public class CustomerByIdHandler {

      @Autowired
    private CustomerDao dao;

    // create functional endpoint
    public Mono<ServerResponse> getCustomer(ServerRequest request){

       long id = Long.valueOf(request.pathVariable("id"));
     Mono<Customer> customer = dao. getCustomersReactiveWithoutSleep()
     .filter(cu->cu.getId()==id)
     .next()
     .switchIfEmpty(Mono.error(new NotFoundCustomerException(id)));

       return ServerResponse.ok()
       // make return type event stream
       .contentType(MediaType.TEXT_EVENT_STREAM)
       .body(customer,Customer.class);
    }
    
}
