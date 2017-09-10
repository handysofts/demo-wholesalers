package com.visma.demowholesalers.enums;

public enum ProductStatus {

    DEACTIVATED(0),
    ACTIVE(1);

	private final int value;
    ProductStatus(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
