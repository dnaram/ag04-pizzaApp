package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Carbonara;
import com.agency04.sbss.pizza.service.PizzeriaDeliveryService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        PizzeriaDeliveryService pds = context.getBean("pizzaDeliveryService", PizzeriaDeliveryService.class);
        System.out.println(pds.orderPizza(new Carbonara()));
        context.close();
    }

}
