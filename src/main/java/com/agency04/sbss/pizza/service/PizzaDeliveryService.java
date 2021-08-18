package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.Delivery;
import com.agency04.sbss.pizza.model.PizzaOrder;
import com.agency04.sbss.pizza.model.dto.DeliveryOrderForm;
import com.agency04.sbss.pizza.model.dto.MenuItem;
import com.agency04.sbss.pizza.model.dto.OrderItem;
import com.agency04.sbss.pizza.model.pizza.Carbonara;
import com.agency04.sbss.pizza.model.pizza.Margherita;
import com.agency04.sbss.pizza.model.pizza.Pizza;
import com.agency04.sbss.pizza.exception.EntityNotFoundException;
import com.agency04.sbss.pizza.model.pizza.Romana;
import com.agency04.sbss.pizza.repository.CustomerRepository;
import com.agency04.sbss.pizza.repository.DeliveryRepository;
import com.agency04.sbss.pizza.repository.PizzaOrderRepository;
import com.agency04.sbss.pizza.repository.PizzaRepository;
import com.agency04.sbss.pizza.service.pizzeria.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class PizzaDeliveryService {

    @Autowired
    private PizzeriaService pizzeriaService;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private PizzaOrderRepository pizzaOrderRepository;

    @Autowired
    private CustomerRepository customerRepository;

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

    public void addOrder(DeliveryOrderForm deliveryOrderForm) {
        Optional<Customer> result = customerRepository.findById(deliveryOrderForm.getUsername());
        if (result.isEmpty()) {
            throw new EntityNotFoundException(String.format("Can not find customer with username - %s", deliveryOrderForm.getUsername()));
        }

        Customer customer = result.get();
        List<PizzaOrder> orders = new ArrayList<>();

        for (var orderDetail : deliveryOrderForm.getOrderDetails()) {
            Pizza pizza = null;
            switch (orderDetail.getName()) {
                case "Romana":
                    pizza = new Romana();
                    break;
                case "Margherita":
                    pizza = new Margherita();
                    break;
                case "Carbonara":
                    pizza = new Carbonara();
                    break;
            }

            orders.add(new PizzaOrder(orderDetail.getQuantity(), orderDetail.getSize(), pizza));
        }

        Delivery delivery = new Delivery(new Date(), customer, orders);
        customer.getDeliveries().add(delivery);

        customerRepository.save(customer);
    }

    public List<PizzaOrder> getOrders() {
        List<PizzaOrder> orders = new ArrayList<PizzaOrder>();
        pizzaOrderRepository.findAll().forEach(orders::add);
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