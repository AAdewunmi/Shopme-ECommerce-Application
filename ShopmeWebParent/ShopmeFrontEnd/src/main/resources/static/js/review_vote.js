$(document).ready(function() {
	$(".linkVoteReview").on("click", function(e) {
		e.preventDefault();
		voteReview($(this));
	});
});

function voteReview(currentLink) {
	requestURL = currentLink.attr("href");

	$.ajax({
		type: "POST",
		url: requestURL,
		beforeSend: function(xhr) {
			xhr.setRequestHeader(csrfHeaderName, csrfValue);
		}
	}).done(function(voteResult) {
		console.log(voteResult);
		
		if (voteResult.successful) {
			$("#modalDialog").on("hide.bs.modal", function(e) {
				updateVoteCountAndIcons(currentLink, voteResult);
			});
		}
		
		showModalDialog("Vote Review", voteResult.message);
		
	}).fail(function() {
		showErrorModal("Error voting review.");
	});	
}