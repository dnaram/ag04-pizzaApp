package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.MenuItem;
import com.agency04.sbss.pizza.model.Pizza;

public interface PizzeriaService {

    String getName();
    String getAddress();
    void setMenu(MenuItem[] menu);
    MenuItem[] getMenu();
    void makePizza(Pizza pizza);
}
