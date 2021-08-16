package com.agency04.sbss.pizza.configuration;

import com.agency04.sbss.pizza.model.*;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaNautica;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.agency04.sbss.pizza")
@PropertySource("classpath:application.properties")
public class PizzaConfig {

    @Bean
    public PizzeriaService pizzeriaNautica() {
        PizzeriaService pizzeria = new PizzeriaNautica();

        MenuItem menuItem1 = new MenuItem(Size.SMALL, new Carbonara());
        MenuItem menuItem2 = new MenuItem(Size.REGULAR, new Carbonara());
        MenuItem menuItem3 = new MenuItem(Size.LARGE, new Carbonara());
        MenuItem menuItem4 = new MenuItem(Size.REGULAR, new Romana());
        MenuItem menuItem5 = new MenuItem(Size.LARGE, new Margherita());

        MenuItem[] menu = { menuItem1, menuItem2, menuItem3, menuItem4, menuItem5 };
        pizzeria.setMenu(menu);

        return pizzeria;
    }

    @Bean
    public PizzaDeliveryService pizzaDeliveryService() {
        return new PizzaDeliveryService(pizzeriaNautica());
    }
}