package dao;

import java.util.List;

import model.Book;

public interface Bookdao {
	
	boolean insertBook(Book b);
	Book viewBookById(int id);
	List<Book> viewAllBooks();
	boolean updateBook(Book b);
	boolean deleteBook(int id);

}
