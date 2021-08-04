package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.configuration.PizzaConfig;
import com.agency04.sbss.pizza.model.Carbonara;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzaConfig.class);

        PizzaDeliveryService pds = context.getBean("pizzaDeliveryService", PizzaDeliveryService.class);

        System.out.println(pds.orderPizza(new Carbonara()));

        context.close();
    }
}
