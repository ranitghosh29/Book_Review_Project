package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Review {
	
	private int review_id;
	private int book_id;
	private int user_id;
	private String review_text;
	private int rating;
}
