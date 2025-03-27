package com.shopme.checkout.paypal;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.shopme.setting.PaymentSettingBag;
import com.shopme.setting.SettingService;

@Component
public class PayPalService {
	private static final String GET_ORDER_API = "/v2/checkout/orders/";
	
	@Autowired 
	private SettingService settingService;
	
	public boolean validateOrder(String orderId) throws PayPalApiException {
		PayPalOrderResponse orderResponse = getOrderDetails(orderId);
		
		return orderResponse.validate(orderId);
	}
}
