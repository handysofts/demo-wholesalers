package com.visma.demowholesalers.stereotypes.controllers.api;

import com.visma.demowholesalers.enums.Errors;
import com.visma.demowholesalers.models.MyError;
import com.visma.demowholesalers.models.api.Res;
import com.visma.demowholesalers.models.api.Res4CalculatePrice;
import com.visma.demowholesalers.stereotypes.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vasif Mustafayev on 2017-08-02 21:16
 * vmustafayev@gmail.com
 */
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }





    /**
     * Calculate price regarding customer, product and quantity.<br>
     *     Customer agreement will be used for discount
     *
     * @param request
     * @param customerId - customer's id from db
     * @param productId - product id from db
     * @param quantity - quantity of purchased products
     * @return
     */
    @GetMapping(value = "/price/calculation/customer/{customerId}/product/{productId}/quantity/{quantity}")
    public Res calculatePrice(HttpServletRequest request,
                              @PathVariable long customerId,
                              @PathVariable long productId,
                              @PathVariable int quantity) {

        Res4CalculatePrice res = new Res4CalculatePrice(new MyError(Errors.OK));
        res.setPrice(productService.calculatePrice(customerId, productId, quantity));

        return res;
    }

}
