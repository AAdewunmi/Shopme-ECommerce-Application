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