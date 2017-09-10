package com.visma.demowholesalers.enums;


import com.visma.demowholesalers.models.MyError;

public enum Errors {
	
	OK (0, "No Error"),

	NOT_FOUND_CUSTOMER(-10, "Customer not found"),
	NOT_FOUND_PRODUCT(-11, "Product not found"),

	NOT_FOUND(-404, "Not found"),
	NOT_IMPLEMENTED(-501, "Not Implemented"),
	
	UNKNOWN_ERROR(-9999, "Unknown error! Please contact contact@moodmusic.today");
	
	
	
	private int code;
	private String text;
	
	Errors(int code, String text){
		this.code = code;
		this.text = text;
	}

	
	public int getCode(){
		return code;
	}
	
	public String getText(){
		return text;
	}
	
	public MyError getValue(){
		return new MyError(code, text);
	}
}
