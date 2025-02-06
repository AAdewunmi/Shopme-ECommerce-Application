package com.shopme.common.exception;

public class CustomerNotFoundException extends Exception{
	private static final long serialVersionUID = -6204849569505726641L;

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
