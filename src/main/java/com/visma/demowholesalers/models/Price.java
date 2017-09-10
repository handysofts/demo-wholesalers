package com.visma.demowholesalers.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.visma.demowholesalers.serializers.BigDecimalValueSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Vasif Mustafayev on 2017-08-03 15:26
 * vmustafayev@gmail.com
 */
@Getter
@Setter
@ToString
public class Price implements Serializable {

    private Product product;

    @JsonSerialize(using = BigDecimalValueSerializer.class)
    private BigDecimal discount = BigDecimal.ZERO;

    @JsonSerialize(using = BigDecimalValueSerializer.class)
    private BigDecimal total;

}
