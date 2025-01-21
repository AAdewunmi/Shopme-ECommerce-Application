var buttonLoad;
var dropDownCountry;
var buttonAddCountry;
var buttonUpdateCountry;
var buttonDeleteCountry;
var labelCountryName;
var fieldCountryName;
var fieldCountryCode;

$(document).ready(function() {
	buttonLoad = $("#buttonLoadCountries");
	dropDownCountry = $("#dropDownCountries");
	buttonAddCountry = $("#buttonAddCountry");
	buttonUpdateCountry = $("#buttonUpdateCountry");
	buttonDeleteCountry = $("#buttonDeleteCountry");
	labelCountryName = $("#labelCountryName");
	fieldCountryName = $("#fieldCountryName");
	fieldCountryCode = $("#fieldCountryCode");
	
	buttonLoad.click(function() {
		loadCountries();
	});
	
	dropDownCountry.on("change", function() {
		changeFormStateToSelectedCountry();
	});
	
	buttonAddCountry.click(function() {
		if (buttonAddCountry.val() == "Add") {
			addCountry();
		} else {
			changeFormStateToNew();
		}
	});
	
	buttonUpdateCountry.click(function() {
		updateCountry();
	});
	
	buttonDeleteCountry.click(function() {
		deleteCountry();
	});
});