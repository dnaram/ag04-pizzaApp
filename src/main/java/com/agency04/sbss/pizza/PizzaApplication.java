package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.CustomerDetails;
import com.agency04.sbss.pizza.model.Delivery;
import com.agency04.sbss.pizza.model.PizzaOrder;
import com.agency04.sbss.pizza.model.dto.Size;
import com.agency04.sbss.pizza.model.pizza.Carbonara;
import com.agency04.sbss.pizza.model.pizza.Margherita;
import com.agency04.sbss.pizza.model.pizza.Romana;
import com.agency04.sbss.pizza.repository.CustomerDetailsRepository;
import com.agency04.sbss.pizza.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PizzaApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(PizzaApplication.class, args);

        CustomerRepository customerRepository = configurableApplicationContext.getBean(CustomerRepository.class);
        CustomerDetailsRepository customerDetailsRepository = configurableApplicationContext.getBean(CustomerDetailsRepository.class);

        PizzaOrder order1 = new PizzaOrder("3", Size.LARGE, new Carbonara());
        PizzaOrder order2 = new PizzaOrder("2", Size.REGULAR, new Margherita());
        PizzaOrder order3 = new PizzaOrder("1", Size.SMALL, new Romana());
        List<PizzaOrder> orders = Arrays.asList(order1, order2, order3);

        CustomerDetails customerDetails = new CustomerDetails("John", "Doe", "555-333");
        customerDetailsRepository.save(customerDetails);

        Customer customer = new Customer("john");
        customer.setCustomerDetails(customerDetails);

        Delivery delivery1 = new Delivery(new Date(), customer, orders);
        Delivery delivery2 = new Delivery(new Date(), customer);
        Delivery delivery3 = new Delivery(new Date(), customer);
        List<Delivery> deliveries = Arrays.asList(delivery1, delivery2, delivery3);

        customer.setDeliveries(deliveries);
        customerRepository.save(customer);

    }
}
