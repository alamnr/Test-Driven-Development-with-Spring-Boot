package com.demo.tdd.exception;


import org.springframework.web.bind.annotation.ResponseStatus;

// Instead of handling exception in controller you can use @ResponseStatus here
//@ResponseStatus
public class CarNotFoundException extends RuntimeException {
}
