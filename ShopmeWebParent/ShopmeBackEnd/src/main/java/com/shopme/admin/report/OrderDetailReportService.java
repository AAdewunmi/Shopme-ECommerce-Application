package com.shopme.admin.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.admin.order.OrderDetailRepository;
import com.shopme.common.entity.order.OrderDetail;

@Service
public class OrderDetailReportService extends AbstractReportService {
	
@Autowired private OrderDetailRepository repo;
	
	@Override
	protected List<ReportItem> getReportDataByDateRangeInternal(
			Date startDate, Date endDate, ReportType reportType) {
		List<OrderDetail> listOrderDetails = null;
		
		if (reportType.equals(ReportType.CATEGORY)) {
			listOrderDetails = repo.findWithCategoryAndTimeBetween(startDate, endDate);
		} else if (reportType.equals(ReportType.PRODUCT)) {
			listOrderDetails = repo.findWithProductAndTimeBetween(startDate, endDate);
		}
		
		//printRawData(listOrderDetails);
		
		List<ReportItem> listReportItems = new ArrayList<>();
		
		for (OrderDetail detail : listOrderDetails) {
			String identifier = "";
			
			if (reportType.equals(ReportType.CATEGORY)) {
				identifier = detail.getProduct().getCategory().getName();
			} else if (reportType.equals(ReportType.PRODUCT)) {
				identifier = detail.getProduct().getShortName();
			}
			
			ReportItem reportItem = new ReportItem(identifier);
			
			float grossSales = detail.getSubtotal() + detail.getShippingCost();
			float netSales = detail.getSubtotal() - detail.getProductCost();
			
			int itemIndex = listReportItems.indexOf(reportItem);
			
			if (itemIndex >= 0) {
				reportItem = listReportItems.get(itemIndex);
				reportItem.addGrossSales(grossSales);
				reportItem.addNetSales(netSales);
				reportItem.increaseProductsCount(detail.getQuantity());
			} else {
				listReportItems.add(new ReportItem(identifier, grossSales, netSales, detail.getQuantity()));
			}
		}
		
		//printReportData(listReportItems);
		
		return listReportItems;
	}

}
