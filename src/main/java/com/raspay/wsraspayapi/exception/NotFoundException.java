package com.raspay.wsraspayapi.exception;

import org.springframework.data.mongodb.core.aggregation.BooleanOperators;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
