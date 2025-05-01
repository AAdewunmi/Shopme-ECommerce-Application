$(document).ready(function() {
	$(".linkVoteReview").on("click", function(e) {
		e.preventDefault();
		voteReview($(this));
	});
});