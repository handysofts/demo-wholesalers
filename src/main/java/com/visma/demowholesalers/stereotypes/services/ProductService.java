package com.visma.demowholesalers.stereotypes.services;

import com.visma.demowholesalers.enums.ProductStatus;
import com.visma.demowholesalers.models.Price;
import com.visma.demowholesalers.models.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vasif Mustafayev on 2017-08-02 19:10
 * vmustafayev@gmail.com
 */
@Transactional
public interface ProductService {

    /**
     * Get all products by status.
     *
     * @param status - product status as active, deactivated and etc
     * @return List of Products
     */
    List<Product> getProducts(ProductStatus status);

    /**
     * Calculate discount based on rebate agreement for customer
     *
     * @param customerId - customer id
     * @param productId - Product id
     * @param quantity - quantity of purchased product
     * @return
     */
    Price calculatePrice(long customerId, long productId, int quantity);

}
