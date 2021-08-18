package com.agency04.sbss.pizza.entity;

import javax.persistence.*;

@Entity
public class CustomerDetails {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String phone;

    @OneToOne(mappedBy = "customerDetails")
    private Customer customer;
}
