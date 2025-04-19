var returnModal;
var modalTitle;
var fieldNote;
var orderId;
var divReason;
var divMessage;
var firstButton;
var secondButton;
 
$(document).ready(function() {
	returnModal = $("#returnOrderModal");
	modalTitle = $("#returnOrderModalTitle");
	fieldNote = $("#returnNote");
	divReason = $("#divReason");
	divMessage = $("#divMessage");
	firstButton = $("#firstButton");
	secondButton = $("#secondButton");
	
	handleReturnOrderLink();
});

function showReturnModalDialog(link) {
	divMessage.hide();
	divReason.show();
	firstButton.show();	
	secondButton.text("Cancel");
	fieldNote.val("");
	
	orderId = link.attr("orderId");
	modalTitle.text("Return Order ID #" + orderId);	
	returnModal.modal("show");
}

function showMessageModal(message) {
	divReason.hide();
	firstButton.hide();
	secondButton.text("Close");
	divMessage.text(message);
	
	divMessage.show();
}

function handleReturnOrderLink() {
	$(".linkReturnOrder").on("click", function(e) {
		e.preventDefault();
		showReturnModalDialog($(this));
	});	
}

function submitReturnOrderForm() {
	reason = $("input[name='returnReason']:checked").val();
	note = fieldNote.val();
	
	sendReturnOrderRequest(reason, note);
	
	return false;
}
