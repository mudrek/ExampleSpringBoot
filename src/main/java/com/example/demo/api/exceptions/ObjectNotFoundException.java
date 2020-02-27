package com.example.demo.api.exceptions;

import java.io.Serializable;

public class ObjectNotFoundException extends RuntimeException implements Serializable {

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
