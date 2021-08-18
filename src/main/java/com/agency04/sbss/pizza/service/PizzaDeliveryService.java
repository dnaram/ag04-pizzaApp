package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.dto.DeliveryOrderForm;
import com.agency04.sbss.pizza.model.dto.MenuItem;
import com.agency04.sbss.pizza.model.dto.OrderItem;
import com.agency04.sbss.pizza.model.pizza.Pizza;
import com.agency04.sbss.pizza.exception.EntityNotFoundException;
import com.agency04.sbss.pizza.service.pizzeria.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PizzaDeliveryService {

    @Autowired
    private PizzeriaService pizzeriaService;

    private List<DeliveryOrderForm> orders;

    @PostConstruct
    private void initialize() {
        orders = new ArrayList<>();
    }

    public PizzaDeliveryService() {}

    public PizzaDeliveryService(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    public void setPizzeriaService(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    public PizzeriaService getPizzeriaService() {
        return pizzeriaService;
    }

    public String orderPizza(Pizza pizza) {
        pizzeriaService.makePizza(pizza);
        return String.format("Pizza ordered: %s\nPizzeria: %s", pizza.getName(), pizzeriaService.getName());
    }

    public void addOrder(DeliveryOrderForm order) {
        orders.add(order);
    }

    public List<DeliveryOrderForm> getOrders() {
        return orders;
    }

    public void checkAvailablePizzas(DeliveryOrderForm deliveryOrderForm) {
        Set<String> availablePizzas = new HashSet<>();
        for (MenuItem menuItem : getPizzeriaService().getMenu()) {
            availablePizzas.add(menuItem.getPizza().getName());
        }

        for (OrderItem orderItem : deliveryOrderForm.getOrderDetails()) {
            if (!availablePizzas.contains(orderItem.getName())) {
                throw new EntityNotFoundException(String.format("Pizza ordered: %s is not available in pizzeria %s.",
                        orderItem.getName(), getPizzeriaService().getName()));
            }
        }
    }
}