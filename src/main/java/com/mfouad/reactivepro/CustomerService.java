package com.mfouad.reactivepro;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfouad.reactivepro.DTO.Customer;
import com.mfouad.reactivepro.Dao.CustomerDao;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Service
@Slf4j
public class CustomerService {
    

    @Autowired
    CustomerDao dao;


    public List<Customer> loaCustomers(){
        long before= new Date().getTime();
        List<Customer> customers = dao.getCustomers();
        long after= new Date().getTime();
        log.info("get data in time  {} mili seconds ",after-before);
        return customers;
    }

     public Flux<Customer> loaCustomersReactive(){
        long before= new Date().getTime();
        Flux<Customer> customers = dao.getCustomersReactive();
        long after= new Date().getTime();
        log.info("get data in time  {} mili seconds ",after-before);
        return customers;
    }
}
