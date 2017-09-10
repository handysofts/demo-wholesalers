package com.visma.demowholesalers.stereotypes.components.rebateagreements;

import com.visma.demowholesalers.models.Customer;
import com.visma.demowholesalers.models.Price;
import com.visma.demowholesalers.models.Product;

/**
 * All kind of Rebate Agreements should extend me
 *
 * Created by Vasif Mustafayev on 2017-08-03 15:43
 * vmustafayev@gmail.com
 */
public interface RebateAgreementComponent {

    String REBATE_AGREEMENT_TYPE_FIXED_PERCENTAGE = "rebate-agreement-fixed-percentage";
    String REBATE_AGREEMENT_TYPE_QUANTITY_THRESHOLDS = "rebate-agreement-quantity-thresholds";

    /**
     * Calculate price with discount based on rebate agreement of given customer
     *
     * @param customer
     * @param product
     * @param quantity
     * @return
     */
    Price calculatePriceWithDiscount(Customer customer, Product product, int quantity);

}
