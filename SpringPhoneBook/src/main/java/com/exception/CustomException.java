package com.exception;

import javassist.NotFoundException;

public class CustomException extends NotFoundException {

    public CustomException(String msg) {
        super(msg);
    }

    public CustomException(String msg, Exception e) {
        super(msg, e);
    }
}