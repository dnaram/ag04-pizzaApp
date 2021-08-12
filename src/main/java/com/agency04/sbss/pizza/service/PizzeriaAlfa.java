package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class PizzeriaAlfa implements PizzeriaService {

    private String name;
    private String address;

    @PostConstruct
    public void postConstruct() {
        this.name = "Alfa";
        this.address = "Vela Luka, Obala 2";
        System.out.printf("Name: %s, Address: %s\n", name, address);
    }

    @PreDestroy
    public void preDestroy() {
        name = "";
        address = "";
        System.out.printf("Name: %s, Address: %s\n", name, address);
    }

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
