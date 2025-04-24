package com.shopme.admin.report;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.shopme.admin.setting.SettingsService;
import com.shopme.common.entity.setting.Setting;

@Controller
public class ReportController {
	
@Autowired private SettingsService settingService;
	
	@GetMapping("/reports")
	public String viewSalesReportHome(HttpServletRequest request) {
		loadCurrencySetting(request);
		return "reports/reports";
	}

}
