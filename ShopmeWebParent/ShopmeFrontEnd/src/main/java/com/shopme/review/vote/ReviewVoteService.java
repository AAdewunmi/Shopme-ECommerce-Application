package com.shopme.review.vote;

import java.util.List;
import java.util.NoSuchElementException;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.common.entity.Customer;
import com.shopme.common.entity.Review;
import com.shopme.common.entity.ReviewVote;
import com.shopme.review.ReviewRepository;

@Service
@Transactional
public class ReviewVoteService {
	
	@Autowired private ReviewRepository reviewRepo;
	@Autowired private ReviewVoteRepository voteRepo;
	
	public VoteResult undoVote(ReviewVote vote, Integer reviewId, VoteType voteType) {
		voteRepo.delete(vote);
		reviewRepo.updateVoteCount(reviewId);
		Integer voteCount = reviewRepo.getVoteCount(reviewId);
		
		return VoteResult.success("You have unvoted " + voteType + " that review.", voteCount);
		
	}
}
