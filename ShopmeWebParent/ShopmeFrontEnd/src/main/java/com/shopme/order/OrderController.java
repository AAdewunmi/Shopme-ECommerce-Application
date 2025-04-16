package com.shopme.order;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shopme.Utility;
import com.shopme.common.entity.Customer;
import com.shopme.common.entity.order.Order;
import com.shopme.customer.CustomerService;

@Controller
public class OrderController {
	
	@Autowired 
	private OrderService orderService;
	@Autowired 
	private CustomerService customerService;
	
	@GetMapping("/orders")
	public String listFirstPage(Model model, HttpServletRequest request) {
		return listOrdersByPage(model, request, 1, "orderTime", "desc", null);
	}

}
