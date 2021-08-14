package com.agency04.sbss.pizza.configuration;

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
        return new PizzeriaNautica();
    }

    @Bean
    public PizzaDeliveryService pizzaDeliveryService() {
        return new PizzaDeliveryService(pizzeriaNautica());
    }
}
