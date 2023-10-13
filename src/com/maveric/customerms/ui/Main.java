package com.maveric.customerms.ui;

import com.maveric.customerms.exception.InvalidNameException;
import com.maveric.customerms.model.Customer;
import com.maveric.customerms.service.impl.CustomerService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService=new CustomerService();
        int choice;
        do {
            System.out.println("1.Register Employee              2.FindEmployeeById");
            System.out.println("3.findCustomersByFirstNameAscendingId ");
            System.out.println("4.Logout");
            System.out.print("Enter Your Choice:");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    try {
                        System.out.println("Enter Your FirstName:");
                        String fName=sc.next();
                        System.out.println();
                        System.out.println("Enter Your LastName:");
                        String lName=sc.next();
                        System.out.println(customerService.register(fName,lName));
                    }catch (InvalidNameException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 2: {
                    try {
                        System.out.print("Enter The CustomerId you Want Find:");
                        int custId=sc.nextInt();
                        System.out.println("Customer Details:"+customerService.findById(custId));
                    }catch (InvalidNameException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 3: {
                    try {
                        System.out.print("Enter the Text to search the customers:");
                        String txt=sc.next();
                        List<Customer> customers=customerService.findCustomersByFirstNameAscendingId(txt);
                        customers.forEach(System.out::println);
                    }catch (InvalidNameException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                default:
                    System.out.println("Invalid Input");
            }
        } while (choice != 4);
    }
}