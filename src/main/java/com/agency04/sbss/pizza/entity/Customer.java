package com.agency04.sbss.pizza.entity;

import javax.persistence.*;

@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String username;

//    @OneToOne
//    @JoinColumn(name = "customerDetails_id")
//    private CustomerDetails customerDetails;
//
//    @OneToMany(mappedBy = "delivery")
//    private List<Delivery> deliveries;
}
