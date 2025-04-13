var iconNames = {
	'PICKED':'fa-people-carry',
	'SHIPPING':'fa-shipping-fast',
	'DELIVERED':'fa-box-open',
	'RETURNED':'fa-undo'	
};

var confirmText;  
var confirmModalDialog;
var yesButton;
var noButton;

$(document).ready(function() {
	confirmText = $("#confirmText");
	confirmModalDialog = $("#confirmModal");
	yesButton = $("#yesButton");
	noButton = $("#noButton");
	
	$(".linkUpdateStatus").on("click", function(e) {
		e.preventDefault();
		link = $(this);
		showUpdateConfirmModal(link);
	});
	
	addEventHandlerForYesButton();
});

function addEventHandlerForYesButton() {
	yesButton.click(function(e) {
		e.preventDefault();
		sendRequestToUpdateOrderStatus($(this));
	});
}

function sendRequestToUpdateOrderStatus(button) {
	requestURL = button.attr("href");
	
	$.ajax({
		type: 'POST',
		url: requestURL,
		beforeSend: function(xhr) {
			xhr.setRequestHeader(csrfHeaderName, csrfValue);
		}
	}).done(function(response) {
		showMessageModal("Order updated successfully");
		updateStatusIconColor(response.orderId, response.status);
		
		console.log(response);
	}).fail(function(err) {
		showMessageModal("Error updating order status");
	})
}

function updateStatusIconColor(orderId, status) {
	link = $("#link" + status + orderId);
	link.replaceWith("<i class='fas " + iconNames[status] + " fa-2x icon-green'></i>");
}