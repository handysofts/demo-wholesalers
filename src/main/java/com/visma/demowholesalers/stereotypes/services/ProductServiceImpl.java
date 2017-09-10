package com.visma.demowholesalers.stereotypes.services;

import com.visma.demowholesalers.enums.Errors;
import com.visma.demowholesalers.enums.ProductStatus;
import com.visma.demowholesalers.exceptions.IncorrectRequestException;
import com.visma.demowholesalers.models.Customer;
import com.visma.demowholesalers.models.Price;
import com.visma.demowholesalers.models.Product;
import com.visma.demowholesalers.stereotypes.components.rebateagreements.RebateAgreementComponent;
import com.visma.demowholesalers.stereotypes.repositories.CustomerRepository;
import com.visma.demowholesalers.stereotypes.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Vasif Mustafayev on 2017-08-02 19:13
 * vmustafayev@gmail.com
 */
@Service
public class ProductServiceImpl implements ProductService {
    private Logger logger = LoggerFactory.getLogger(ProductService.class);

    private final ApplicationContext applicationContext;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ApplicationContext applicationContext, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.applicationContext = applicationContext;
        this.customerRepository = customerRepository;
    }




    @Override
    public List<Product> getProducts(ProductStatus status) {
        return productRepository.findByStatus(status.getValue());
    }




    @Override
    public Price calculatePrice(long customerId, long productId, int quantity) {
        logger.info("Calculate Price for product {} bought quantity is {} by customer {}", productId, quantity, customerId);

        Customer customer = customerRepository.findOne(customerId);
        if (customer == null)
            throw new IncorrectRequestException(Errors.NOT_FOUND_CUSTOMER);

        Product product = productRepository.findOne(productId);
        if (product == null)
            throw new IncorrectRequestException(Errors.NOT_FOUND_PRODUCT);

        if(logger.isDebugEnabled())
            logger.debug("Calculate Price of {} <= {}", product, customer);




        try
        {
            RebateAgreementComponent rebateAgreementComponent = applicationContext.getBean(customer.getRebateAgreement().getName(), RebateAgreementComponent.class);
            Price price = rebateAgreementComponent.calculatePriceWithDiscount(customer, product, quantity);
            price.setProduct(product);

            return price;
        } catch (Exception e){
            logger.error("Failed to get price using agreement", e);

            Price price = new Price();
            price.setProduct(product);
            price.setTotal(BigDecimal.valueOf(quantity).multiply(product.getPrice()));
            return price;
        }
    }

}
