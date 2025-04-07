var productDetailCount;

$(document).ready(function() {
	productDetailCount = $(".hiddenProductId").length;
	
	$("#products").on("click", "#linkAddProduct", function(e) {
		e.preventDefault();
		link = $(this);
		url = link.attr("href");
		
		$("#addProductModal").on("shown.bs.modal", function() {
			$(this).find("iframe").attr("src", url);
		});
		
		$("#addProductModal").modal();
	})
});

function addProduct(productId, productName) {
	getShippingCost(productId);	
}

function getShippingCost(productId) {
	selectedCountry = $("#country option:selected");
	countryId = selectedCountry.val();
	
	state = $("#state").val();
	if (state.length == 0) {
		state = $("#city").val();		
	}
	
	requestUrl = contextPath + "get_shipping_cost";
	params = {productId: productId, countryId: countryId, state: state};
	
	$.ajax({
		type: 'POST',
		url: requestUrl,
		beforeSend: function(xhr) {
			xhr.setRequestHeader(csrfHeaderName, csrfValue);
		},
		data: params		
	}).done(function(shippingCost) {
		getProductInfo(productId, shippingCost);
	}).fail(function(err) {
		showWarningModal(err.responseJSON.message);
		shippingCost = 0.0;
		getProductInfo(productId, shippingCost);
	}).always(function() {
		$("#addProductModal").modal("hide");
	});		
}