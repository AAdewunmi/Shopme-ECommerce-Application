package com.shopme.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.shopme.setting.SettingService;

@Controller
public class ForgotPasswordController {
	@Autowired 
	private CustomerService customerService;
	
	@Autowired 
	private SettingService settingService;
	
	@GetMapping("/forgot_password")
	public String showRequestForm() {
		return "customer/forgot_password_form";
	}
}
