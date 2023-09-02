package com.mfouad.reactivepro.Exceptions;

public class NotFoundCustomerException extends RuntimeException{

    public NotFoundCustomerException(){
        super();
    }

    public NotFoundCustomerException(String message){
        super(message);
    }

    public NotFoundCustomerException(long id){
        super("Can not find customer with id "+id);
    }
    
}
