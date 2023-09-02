package com.mfouad.reactivepro.Router;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mfouad.reactivepro.DTO.Customer;

import reactor.core.publisher.Mono;

@Service
public class AddCutomerRouterHandler {

    
 // create functional endpoint
    public Mono<ServerResponse> addCustomer(ServerRequest request){
       Mono<Customer> customer = request.bodyToMono(Customer.class);
       Mono<String> respone =   customer.map(dto->dto.getName()+" --"+new Date().getTime());

       return ServerResponse.ok()
       // make return type event stream
       .contentType(MediaType.TEXT_EVENT_STREAM)
       .body(respone,String.class);
    }

}
