package com.mfouad.reactivepro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfouad.reactivepro.DTO.Customer;

import reactor.core.publisher.Flux;

@RestController
public class CustomerContoller {

    @Autowired
    CustomerService service;

    @GetMapping
    public List<Customer> getAllCustomers(){
return service.loaCustomers();
    }

     @GetMapping(value =  "/reactive",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomersReactive(){
return service.loaCustomersReactive();
    }
    
}
