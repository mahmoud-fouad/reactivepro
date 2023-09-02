package com.mfouad.reactivepro.Dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.mfouad.reactivepro.DTO.Customer;

import reactor.core.publisher.Flux;

@Component
public class CustomerDao {

    int count = 20;

    private static void SleepExecution(int i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    public List<Customer> getCustomers(){
       return IntStream.range(1, count)
       .peek(CustomerDao::SleepExecution)
       .peek(i->System.out.println("processing "+i))
       .mapToObj( i-> new Customer("cutomer "+i, i)).collect(
            Collectors.toList());

                 }

// if the user cancel the http request ssytem will stop the loop and call onCancell method 
  public Flux<Customer> getCustomersReactive(){
       return Flux.range(1, count)
       .delayElements(Duration.ofSeconds(1))
       .doOnNext(i->System.out.println("processing in flux"+i))
       .doOnCancel(()->System.out.println("user cancel the request"))
       .map( i-> new Customer("cutomer "+i, i));

                 }
    
}
