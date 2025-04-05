var fieldProductCost;
var fieldSubtotal;
var fieldShippingCost;
var fieldTax;
var fieldTotal;

$(document).ready(function() {
	
	fieldProductCost = $("#productCost");
	fieldSubtotal = $("#subtotal");
	fieldShippingCost = $("#shippingCost");
	fieldTax = $("#tax");
	fieldTotal = $("#total");
	
	formatOrderAmounts();
	formatProductAmounts();
	
	$("#productList").on("change", ".quantity-input", function(e) {
		updateSubtotalWhenQuantityChanged($(this));
		updateOrderAmounts();
	});
	
	$("#productList").on("change", ".price-input", function(e) {
		updateSubtotalWhenPriceChanged($(this));
		updateOrderAmounts();
	});	
	
	$("#productList").on("change", ".cost-input", function(e) {
		updateOrderAmounts();
	});
	
	$("#productList").on("change", ".ship-input", function(e) {
		updateOrderAmounts();
	});			
});