package com.agency04.sbss.pizza.model.dto;

import com.agency04.sbss.pizza.model.pizza.Pizza;

public class MenuItem {

    private Size size;
    private Pizza pizza;

    public MenuItem(Size size, Pizza pizza) {
        this.size = size;
        this.pizza = pizza;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
}
