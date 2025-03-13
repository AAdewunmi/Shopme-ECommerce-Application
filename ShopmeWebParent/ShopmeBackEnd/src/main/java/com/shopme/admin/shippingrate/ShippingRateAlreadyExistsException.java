package com.shopme.admin.shippingrate;

public class ShippingRateAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1595490428698645906L;

	public ShippingRateAlreadyExistsException(String message) {
		super(message);
	}
}
