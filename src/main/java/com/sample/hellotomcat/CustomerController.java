package com.sample.hellotomcat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
    @PostMapping("/customers")
    public Customer create(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @GetMapping("/customers")
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
}
