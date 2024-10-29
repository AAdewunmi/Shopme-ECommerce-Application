package com.shopme.admin.user;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shopme.admin.FileUploadUtil;
import com.shopme.admin.security.ShopmeUserDetails;
import com.shopme.admin.user.UserService;
import com.shopme.common.entity.User;

@Controller
public class AccountController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/account")
	public String viewDetails(@AuthenticationPrincipal ShopmeUserDetails loggedUser,
			Model model) {
		String email = loggedUser.getUsername();
		User user = service.getByEmail(email);
		model.addAttribute("user", user);
		
		return "account_form";
		
	}

}
