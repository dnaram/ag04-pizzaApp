package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class PizzeriaNautica implements PizzeriaService {

    @Value("${nautica.name}")
    private String name;

    @Value("${nautica.address}")
    private String address;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void makePizza(Pizza pizza) {
        System.out.printf("Making pizza %s in %s...\n", pizza.getName(), this);
    }

    @Override
    public String toString() {
        return "Nautica: " +
                "name='" + name + '\'' +
                ", address='" + address + '\'';
    }
}
