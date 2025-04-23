package com.shopme.admin.report;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.admin.order.OrderRepository;
import com.shopme.common.entity.order.Order;

@Service
public class MasterOrderReportService extends AbstractReportService{
	
@Autowired private OrderRepository repo;

	
	protected List<ReportItem> getReportDataByDateRangeInternal(Date startTime, Date endTime, ReportType reportType) {
		List<Order> listOrders = repo.findByOrderTimeBetween(startTime, endTime);
		printRawData(listOrders);
		
		List<ReportItem> listReportItems = createReportData(startTime, endTime, reportType);
		
		System.out.println();
		
		calculateSalesForReportData(listOrders, listReportItems);
		
		printReportData(listReportItems);
		
		return listReportItems;
	}

}
