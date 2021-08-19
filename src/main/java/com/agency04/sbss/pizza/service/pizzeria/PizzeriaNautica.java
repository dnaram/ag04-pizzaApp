package com.agency04.sbss.pizza.service.pizzeria;

import com.agency04.sbss.pizza.model.dto.MenuItem;
import com.agency04.sbss.pizza.model.dto.Size;
import com.agency04.sbss.pizza.model.pizza.Carbonara;
import com.agency04.sbss.pizza.model.pizza.Margherita;
import com.agency04.sbss.pizza.model.pizza.Pizza;
import com.agency04.sbss.pizza.model.pizza.Romana;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Primary
public class PizzeriaNautica implements PizzeriaService {

    @Value("${nautica.name}")
    private String name;

    @Value("${nautica.address}")
    private String address;

    private MenuItem[] menu;

    @PostConstruct
    public void init() {
        MenuItem menuItem1 = new MenuItem(Size.SMALL, new Carbonara());
        MenuItem menuItem2 = new MenuItem(Size.REGULAR, new Carbonara());
        MenuItem menuItem3 = new MenuItem(Size.LARGE, new Carbonara());
        MenuItem menuItem4 = new MenuItem(Size.REGULAR, new Romana());
        MenuItem menuItem5 = new MenuItem(Size.LARGE, new Margherita());

        MenuItem[] menu = { menuItem1, menuItem2, menuItem3, menuItem4, menuItem5 };
        setMenu(menu);
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
