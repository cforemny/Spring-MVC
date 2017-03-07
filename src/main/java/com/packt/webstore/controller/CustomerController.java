package com.packt.webstore.controller;

import com.packt.webstore.domain.repository.CustomerRepository;
import com.packt.webstore.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Cyprian on 2017-03-04.
 */
@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/customers")
    public String list(Model model){

        model.addAttribute("customers", customerRepository.getAllCustomers());

        return "customers";
    }
}
