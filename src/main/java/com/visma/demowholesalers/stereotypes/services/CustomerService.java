package com.visma.demowholesalers.stereotypes.services;

import com.visma.demowholesalers.enums.CustomerStatus;
import com.visma.demowholesalers.models.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vasif Mustafayev on 2017-08-02 18:37
 * vmustafayev@gmail.com
 */
@Transactional
public interface CustomerService {


    /**
     * Get all Customers by Status
     *
     * @param status - customer status as active, deactivated and etc
     * @return List of Customers
     */
    List<Customer> getCustomers(CustomerStatus status);

}
