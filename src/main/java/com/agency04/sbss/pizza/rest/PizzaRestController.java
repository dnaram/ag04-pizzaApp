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
import java.util.List;

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
    public void orderDelivery(@RequestBody DeliveryOrderForm deliveryOrderForm) {

        System.out.println(deliveryOrderForm);

    }

    @PostMapping("/request")
    public ResponseEntity postController(@RequestBody LoginForm loginForm) {

        System.out.println(loginForm.getUsername());
        System.out.println(loginForm.getPassword());

        return ResponseEntity.ok(HttpStatus.OK);
    }


    // TODO: 16. 08. 2021. izbrisati kad zavrsis
    @GetMapping("order")
    public DeliveryOrderForm getOrder() {
        MenuItem item1 = new MenuItem(Size.SMALL, new Carbonara());
        MenuItem item2 = new MenuItem(Size.REGULAR, new Romana());
        MenuItem item3 = new MenuItem(Size.LARGE, new Margherita());

        List<OrderItem> orderItems = new ArrayList<>();

        OrderItem orderItem1 = new OrderItem(item1, 1);
        OrderItem orderItem2 = new OrderItem(item2, 2);
        OrderItem orderItem3 = new OrderItem(item3, 3);

        orderItems.add(orderItem1);
        orderItems.add(orderItem2);
        orderItems.add(orderItem3);

        DeliveryOrderForm dof = new DeliveryOrderForm("user1", orderItems);
        return dof;
    }

    @GetMapping("/login")
    public LoginForm getLogin() {
        return new LoginForm("username", "password");
    }

}
