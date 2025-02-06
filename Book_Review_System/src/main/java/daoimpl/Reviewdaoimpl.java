package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Reviewdao;
import model.Review;
import utility.ConnectionProvider;

public class Reviewdaoimpl implements Reviewdao{
	Connection con=ConnectionProvider.getConnection();
	
	@Override
	public boolean insertReview(Review r) {
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into review(review_id,book_id,user_id,review_text,rating) values(?,?,?,?,?)");
		    pstmt.setInt(1, r.getReview_id());
			pstmt.setInt(2, r.getBook_id());
		    pstmt.setInt(3, r.getUser_id());
		    pstmt.setString(4, r.getReview_text());
		    pstmt.setInt(5, r.getRating());
		    pstmt.executeUpdate();
		    return true;
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something went wrong while adding review.");
			return false;
		}
	}

	@Override
	public Review viewReviewById(int id) {
		 Review review =new Review();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from review where review_id=?");
		    pstmt.setInt(1,id);
			ResultSet rs=pstmt.executeQuery();
			boolean res=rs.next();
			if(res==false)
			{
				System.out.println("No review from this id.");
			    return null;
			}
			else {
				review.setReview_id(rs.getInt(1));
				review.setBook_id(rs.getInt(2));
				review.setUser_id(rs.getInt(3));
				review.setReview_text(rs.getString(4));
				review.setRating(rs.getInt(5));
				return review;
			}
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something went wrong while viewing review.");
			return null;
		}
		
	}

	@Override
	public List<Review> viewAllReviews() {
		List<Review> rlist=new ArrayList<Review>();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from review");
		   	ResultSet rs=pstmt.executeQuery();
		  	
			while(rs.next())
			{
			    Review review=new Review();
				review.setReview_id(rs.getInt(1));
				review.setBook_id(rs.getInt(2));
				review.setUser_id(rs.getInt(3));
				review.setReview_text(rs.getString(4));
				review.setRating(rs.getInt(5));
				rlist.add(review);
			}
			
			if(rlist.isEmpty())
			{
				System.out.println("No reviews present in system");
				return null;
			}
			
			return rlist;	
			
			
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something went wrong while viewing reviews list.");
			return null;
		}
		 
	}

}
