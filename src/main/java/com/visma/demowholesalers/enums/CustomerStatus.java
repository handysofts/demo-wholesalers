package com.visma.demowholesalers.enums;

public enum CustomerStatus {

    DEACTIVATED(0),
    ACTIVE(1);

	private final int value;
    CustomerStatus(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
