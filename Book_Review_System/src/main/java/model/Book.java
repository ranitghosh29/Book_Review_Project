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

public class Book {
	
	private int book_id;
	private String title;
	private String author;
	private String genre;
	private String publisher;
	private int published_year;
	private String description;
	
	
}
