package com.visma.demowholesalers.exceptions;


import com.visma.demowholesalers.enums.Errors;

/**
 * My Custom exception which contains error code and text
 */
public class IncorrectRequestException extends RuntimeException {

	private Errors err;

	public IncorrectRequestException(Errors err){
		super(err.getText());
		this.err = err;
	}

	public Errors getErr() {
		return err;
	}
	
}
