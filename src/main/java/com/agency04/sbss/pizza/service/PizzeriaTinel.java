package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.MenuItem;
import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PizzeriaTinel implements PizzeriaService {

    @Value("${tinel.name}")
    private String name;

    @Value("${tinel.address}")
    private String address;

    private MenuItem[] menu;

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

    @Override
    public void setMenu(MenuItem[] menu) {
        this.menu = menu;
    }

    @Override
    public MenuItem[] getMenu() {
        return menu;
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

}
