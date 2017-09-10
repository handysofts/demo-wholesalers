package com.visma.demowholesalers.models;


import com.visma.demowholesalers.enums.Errors;

public class MyError {
	
	private int code;
	private String message;
	
	public MyError(Errors err){
		super();
		this.code = err.getCode();
		this.message = err.getText();
	}

	public MyError(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	@Override
	public String toString() {
		return "Error [code=" + code + ", message=" + message + "]";
	}
	
}
