package com.visma.demowholesalers.stereotypes.components.rebateagreements;

import com.visma.demowholesalers.models.Customer;
import com.visma.demowholesalers.models.Price;
import com.visma.demowholesalers.models.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static com.visma.demowholesalers.stereotypes.components.rebateagreements.RebateAgreementComponent.REBATE_AGREEMENT_TYPE_QUANTITY_THRESHOLDS;

/**
 * Created by Vasif Mustafayev on 2017-08-03 16:10
 * vmustafayev@gmail.com
 */
@Component(value = REBATE_AGREEMENT_TYPE_QUANTITY_THRESHOLDS)
public class RebateAgreementQuantityThreshold implements RebateAgreementComponent {

    @Override
    public Price calculatePriceWithDiscount(Customer customer, Product product, int quantity) {
        Price price = new Price();

        BigDecimal discount = new BigDecimal(customer.getRebateAgreement().getDetails().stream().filter(ad -> {
            String[] ranges = ad.getKey().split(",");
            return quantity >= Integer.valueOf(ranges[0]) && quantity < Integer.valueOf(ranges[1]);
        }).findFirst().get().getValue());

        price.setDiscount(discount);
        price.setTotal(BigDecimal.valueOf(quantity).multiply(product.getPrice()).subtract(price.getDiscount()));

        return price;
    }

}
