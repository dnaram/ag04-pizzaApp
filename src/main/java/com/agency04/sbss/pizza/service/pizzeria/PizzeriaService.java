package com.agency04.sbss.pizza.service.pizzeria;

import com.agency04.sbss.pizza.model.dto.MenuItem;
import com.agency04.sbss.pizza.model.pizza.Pizza;

public interface PizzeriaService {

    String getName();
    String getAddress();
    void setMenu(MenuItem[] menu);
    MenuItem[] getMenu();
    void makePizza(Pizza pizza);
}
