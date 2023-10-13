package com.maveric.customerms.service.impl;

import com.maveric.customerms.exception.CustomerNotFoundException;
import com.maveric.customerms.exception.EmptyListException;
import com.maveric.customerms.model.Customer;
import com.maveric.customerms.service.ICustomerService;
import com.maveric.customerms.util.CommonUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerService implements ICustomerService {

    private Map<Integer, Customer> store=new HashMap<>();
    private int generatedId;

    private CommonUtils commonUtils=new CommonUtils();

    private int generateId(){
        return ++generatedId;
    }

    @Override
    public Customer register(String firstName, String lastName) {
        commonUtils.validateNames(firstName,lastName);
        int id=generateId();
        Customer customer=new Customer(id,firstName,lastName);
        store.put(id,customer);
        return customer;
    }

    @Override
    public Customer findById(int id) {
        commonUtils.checkValidEmployeeIdOrNot(id);
        commonUtils.checkEmptyStoreOrNot(store);
       return store.values().stream()
                .filter(emp->emp.getId()==id)
                .findFirst().orElseThrow(()->new CustomerNotFoundException("Customer Not Found With Id:"+id));
    }

    @Override
    public List<Customer> findCustomersByFirstNameAscendingId(String intputFirstName) {
        commonUtils.ValidateSearchingInput(intputFirstName);
        commonUtils.checkEmptyStoreOrNot(store);
        return store.entrySet().stream()
                .filter(entry->entry.getValue().getFirstName().toLowerCase().startsWith(intputFirstName))
                .map(en->{
                    return en.getValue();
                })
                .collect(Collectors.toList())
                .stream()
                .sorted((cust1,cust2)->cust1.getId().compareTo(cust2.getId()))
                .collect(Collectors.toList());
    }
}
