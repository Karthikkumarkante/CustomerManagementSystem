package com.maveric.customerms.util;

import com.maveric.customerms.exception.EmptyListException;
import com.maveric.customerms.exception.InsufficientTextException;
import com.maveric.customerms.exception.InvalidIDException;
import com.maveric.customerms.exception.InvalidNameException;
import com.maveric.customerms.model.Customer;

import java.util.Map;

public class CommonUtils {

    static void validateName(String name, String errMsg) {
        if (name == null || name.length() < 2 || name.length() > 10)
            throw new InvalidNameException(errMsg);

    }

    public void validateNames(String firstName, String lastName) {

        validateName(firstName, "First Name charecters length should be between 3-10");
        validateName(lastName, "Last Name charecters length should be between 3-10");
    }

    public void checkValidProjectIdOrNot(int pid) {
        if (pid <= 0)
            throw new InvalidIDException("Product Id should be greater than 0");
    }

    public void checkValidEmployeeIdOrNot(int eid) {
        if (eid <= 0)
            throw new InvalidIDException("Employee Id should be greater than 0");
    }

    public void validateProjectName(String projectName) {
        if (projectName.length() < 2 || projectName.length() > 10)
            throw new InvalidNameException("Project Name Should be 2-10 charecters length");
    }

    public void ValidateSearchingInput(String input) {
        if (input.length() < 3)
            throw new InsufficientTextException("Please provide more than 3 charecters");
    }

    public void checkEmptyStoreOrNot(Map<Integer, Customer> store) {
        if (store.size()==0)
            throw new EmptyListException("Customer Store is Empty");
    }
}
