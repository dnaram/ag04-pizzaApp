package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;

public class PizzeriaAlfa implements PizzeriaService {

    private String name;
    private String address;

    public PizzeriaAlfa() {}

    public PizzeriaAlfa(String name, String address) {
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
        System.out.printf("Making pizza %s in %s...\n", pizza.getName(), getName());
    }
}
