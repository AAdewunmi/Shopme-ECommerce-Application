decimalSeparator = decimalPointType == 'COMMA' ? ',' : '.';
thousandsSeparator = thousandsPointType == 'COMMA' ? ',' : '.'; 

$(document).ready(function() {
	$(".linkMinus").on("click", function(evt) {
		evt.preventDefault();
		decreaseQuantity($(this));
	});
	
	$(".linkPlus").on("click", function(evt) {
		evt.preventDefault();
		increaseQuantity($(this));
	});
	
	$(".linkRemove").on("click", function(evt) {
		evt.preventDefault();
		removeProduct($(this));
	});		
});