package com.visma.demowholesalers.stereotypes.repositories;

import com.visma.demowholesalers.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Vasif Mustafayev on 2017-05-08 21:45
 * vmustafayev@gmail.com
 */
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByStatus(int status);

}
