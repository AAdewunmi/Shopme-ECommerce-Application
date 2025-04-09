$(document).ready(function() {
	$("#productList").on("click", ".linkRemove", function(e) {
		e.preventDefault();
		
		if (doesOrderHaveOnlyOneProduct()) {
			showWarningModal("Could not remove product. The order must have eat least one product.");
		} else {
			removeProduct($(this));		
			updateOrderAmounts();	
		}
	});
});