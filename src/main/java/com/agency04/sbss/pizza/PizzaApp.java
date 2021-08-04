package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Carbonara;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {

    public static void main(String[] args) {

        // PostConstruct & PreDestroy demo

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        PizzaDeliveryService pds = context.getBean("pizzaDeliveryService", PizzaDeliveryService.class);
        System.out.println(pds.orderPizza(new Carbonara()));
        context.close();

    }

}
