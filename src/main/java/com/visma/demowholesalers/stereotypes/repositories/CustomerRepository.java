package com.visma.demowholesalers.stereotypes.repositories;

import com.visma.demowholesalers.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Vasif Mustafayev on 2017-05-08 21:45
 * vmustafayev@gmail.com
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByStatus(int status);

}
