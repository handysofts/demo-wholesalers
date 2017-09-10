package com.visma.demowholesalers.models.api;

import com.visma.demowholesalers.models.MyError;
import com.visma.demowholesalers.models.Price;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Vasif Mustafayev on 2017-08-03 15:59
 * vmustafayev@gmail.com
 */
@Getter
@Setter
@ToString(callSuper = true)
public class Res4CalculatePrice extends Res {

    private Price price;

    public Res4CalculatePrice(MyError error) {
        super(error);
    }
}
