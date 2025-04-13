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