var trackRecordCount;

$(document).ready(function() {
	trackRecordCount = $(".hiddenTrackId").length;
	
	$("#trackList").on("click", ".linkRemoveTrack", function(e) {
		e.preventDefault();
		deleteTrack($(this));
		updateTrackCountNumbers();
	});
	
	$("#track").on("click", "#linkAddTrack", function(e) {
		e.preventDefault();
		addNewTrackRecord();
	});
	
	$("#trackList").on("change", ".dropDownStatus", function(e) {
		dropDownList = $(this);
		rowNumber = dropDownList.attr("rowNumber");
		selectedOption = $("option:selected", dropDownList);
		
		defaultNote = selectedOption.attr("defaultDescription");
		$("#trackNote" + rowNumber).text(defaultNote);
	});	
});

function deleteTrack(link) {
	rowNumber = link.attr('rowNumber');
	$("#rowTrack" + rowNumber).remove();
	$("#emptyLine" + rowNumber).remove();	
}

function updateTrackCountNumbers() {
	$(".divCountTrack").each(function (index, element) {
		element.innerHTML = "" + (index + 1);
	});
}

function addNewTrackRecord() {	
	htmlCode = generateTrackCode();	
	$("#trackList").append(htmlCode);
}