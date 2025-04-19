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