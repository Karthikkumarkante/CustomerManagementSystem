package com.maveric.customerms.service;

import com.maveric.customerms.model.Customer;

import java.util.List;

public interface ICustomerService {
    Customer register(String firstName, String lastName);
    Customer findById(int id);
// find customers by firstName,
    List<Customer> findCustomersByFirstNameAscendingId(String firstName);
}
