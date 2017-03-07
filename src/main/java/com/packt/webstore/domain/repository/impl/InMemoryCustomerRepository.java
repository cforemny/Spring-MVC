package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.repository.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cyprian on 2017-03-04.
 */
@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private List<Customer> listOfCustomers = new ArrayList<Customer>();

    public InMemoryCustomerRepository() {

        Customer customer = new Customer("C1234", "Jan", "krakow", "P1234");
        Customer customer1 = new Customer("C1235", "Zbyszek", "warszawa", "P1234");
        Customer customer2 = new Customer("C1236", "Monika", "zakliczyn", "P1235");

        listOfCustomers.add(customer);
        listOfCustomers.add(customer1);
        listOfCustomers.add(customer2);
    }

    public List<Customer> getAllCustomers() {
        return listOfCustomers;
    }
}
