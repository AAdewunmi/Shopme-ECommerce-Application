var buttonLoad4States;
var dropDownCountry4States;
var dropDownStates;
var buttonAddState;
var buttonUpdateState;
var buttonDeleteState;
var labelStateName;
var fieldStateName;

$(document).ready(function() {
	buttonLoad4States = $("#buttonLoadCountriesForStates");
	dropDownCountry4States = $("#dropDownCountriesForStates");
	dropDownStates = $("#dropDownStates");
	buttonAddState = $("#buttonAddState");
	buttonUpdateState = $("#buttonUpdateState");
	buttonDeleteState = $("#buttonDeleteState");
	labelStateName = $("#labelStateName");
	fieldStateName = $("#fieldStateName");
	
	buttonLoad4States.click(function() {
		loadCountries4States();
	});
	
	dropDownCountry4States.on("change", function() {
		loadStates4Country();
	});

	dropDownStates.on("change", function() {
		changeFormStateToSelectedState();
	});
		
	buttonAddState.click(function() {
		if (buttonAddState.val() == "Add") {
			addState();
		} else {
			changeFormStateToNew();
		}
	});
	
	buttonUpdateState.click(function() {
		updateState();
	});
	
	buttonDeleteState.click(function() {
		deleteState();
	});
});