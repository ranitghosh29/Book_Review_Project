package dao;

import java.util.List;

import model.Review;

public interface Reviewdao {
	
	boolean insertReview(Review r);
	Review viewReviewById(int id);
	List<Review> viewAllReviews();
}
