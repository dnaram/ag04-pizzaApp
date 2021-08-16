package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.*;
import com.agency04.sbss.pizza.repo.Repository;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class PizzaRestController {

    @Autowired
    private PizzaDeliveryService pizzaDeliveryService;

    @GetMapping("/pizzeria")
    public PizzeriaService getPizzeria() {

        return pizzaDeliveryService.getPizzeriaService();
    }

    @GetMapping("/pizzeria/menu")
    public MenuItem[] getMenu() {

        return pizzaDeliveryService.getPizzeriaService().getMenu();
    }

    @GetMapping("/customer/{username}")
    public Customer getCustomer(@PathVariable String username) {

        return Repository.getInstance().getCustomerByUsername(username);
    }

    @PostMapping("/customer")
    public Customer postCustomer(@RequestParam String username) {
        return Repository.getInstance().addCustomer(username, false, 0);
    }

    @PutMapping("/customer")
    public Customer putCustomer(@RequestParam String username, @RequestParam int orders) {
        Customer customer = Repository.getInstance().getCustomerByUsername(username);
        if (customer != null) {
            customer.setOrders(orders);
        }

        return customer;
    }

    @DeleteMapping("customer/{username}")
    public Customer deleteCustomer(@PathVariable String username) {
        return Repository.getInstance().removeCustomer(username);
    }

    @PostMapping("/delivery/order")
    public ResponseEntity orderDelivery(@RequestBody DeliveryOrderForm deliveryOrderForm) {

        Set<String> availablePizzas = new HashSet<>();
        for (MenuItem menuItem : pizzaDeliveryService.getPizzeriaService().getMenu()) {
               availablePizzas.add(menuItem.getPizza().getName());
        }

        for (OrderItem orderItem : deliveryOrderForm.getOrderDetails()) {
            if (!availablePizzas.contains(orderItem.getName())) {
                throw new PizzaNotFoundException(String.format("Pizza ordered: %s is not available in pizzeria %s.",
                        orderItem.getName(), pizzaDeliveryService.getPizzeriaService().getName()));
            }
        }

        pizzaDeliveryService.addOrder(deliveryOrderForm);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/delivery/list")
    public List<DeliveryOrderForm> getOrders() {
        return pizzaDeliveryService.getOrders();
    }

}
