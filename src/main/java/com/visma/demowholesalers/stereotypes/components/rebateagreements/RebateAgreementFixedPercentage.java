package com.visma.demowholesalers.stereotypes.components.rebateagreements;

import com.visma.demowholesalers.models.Customer;
import com.visma.demowholesalers.models.Price;
import com.visma.demowholesalers.models.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static com.visma.demowholesalers.stereotypes.components.rebateagreements.RebateAgreementComponent.REBATE_AGREEMENT_TYPE_FIXED_PERCENTAGE;

/**
 * Created by Vasif Mustafayev on 2017-08-03 16:10
 * vmustafayev@gmail.com
 */
@Component(value = REBATE_AGREEMENT_TYPE_FIXED_PERCENTAGE)
public class RebateAgreementFixedPercentage implements RebateAgreementComponent {

    @Override
    public Price calculatePriceWithDiscount(Customer customer, Product product, int quantity) {
        Price price = new Price();
        BigDecimal percentage = new BigDecimal(customer.getRebateAgreement().getDetails().stream().filter(ad -> ad.getKey().equals("percentage")).findFirst().get().getValue());
        price.setDiscount(product.getPrice().multiply(percentage).divide(new BigDecimal(100)));
        price.setTotal(BigDecimal.valueOf(quantity).multiply(product.getPrice().subtract(price.getDiscount())));

        return price;
    }

}
