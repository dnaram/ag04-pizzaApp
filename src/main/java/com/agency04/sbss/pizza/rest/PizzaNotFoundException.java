package com.agency04.sbss.pizza.rest;

public class PizzaNotFoundException extends RuntimeException {

    public PizzaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PizzaNotFoundException(String message) {
        super(message);
    }

    public PizzaNotFoundException(Throwable cause) {
        super(cause);
    }
}
