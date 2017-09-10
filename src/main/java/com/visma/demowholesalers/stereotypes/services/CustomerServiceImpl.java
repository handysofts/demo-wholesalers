package com.visma.demowholesalers.stereotypes.services;

import com.visma.demowholesalers.enums.CustomerStatus;
import com.visma.demowholesalers.models.Customer;
import com.visma.demowholesalers.stereotypes.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vasif Mustafayev on 2017-08-02 18:38
 * vmustafayev@gmail.com
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }



    @Override
    @Transactional(readOnly = true)
    public List<Customer> getCustomers(CustomerStatus status) {
        return customerRepository.findByStatus(status.getValue());
    }

}
