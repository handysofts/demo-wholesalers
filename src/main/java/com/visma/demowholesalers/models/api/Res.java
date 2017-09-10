package com.visma.demowholesalers.models.api;

import com.visma.demowholesalers.models.MyError;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Res implements Serializable {

    private MyError error;

    public Res(MyError error) {
        super();
        this.error = error;
    }

}
