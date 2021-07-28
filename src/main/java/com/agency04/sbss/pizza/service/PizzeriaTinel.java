package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PizzeriaTinel implements PizzeriaService {

    @Value("${name}")
    private String name;

    @Value("${address}")
    private String address;

    public PizzeriaTinel() {}

    public PizzeriaTinel(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void makePizza(Pizza pizza) {
        System.out.printf("Making %s in %s...\n", pizza.getName(), this);
    }

    @Override
    public String toString() {
        return "Tinel: " +
                "name='" + name + '\'' +
                ", address='" + address + '\'';
    }
}
