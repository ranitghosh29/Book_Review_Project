package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Bookdao;
import model.Book;
import utility.ConnectionProvider;

public class Bookdaoimpl implements Bookdao{
	Connection con=ConnectionProvider.getConnection();
	
	@Override
	public boolean insertBook(Book b) {
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into book(book_id,title,author,genre,publisher,published_year,description) values(?,?,?,?,?,?,?)");
		    pstmt.setInt(1, b.getBook_id());
			pstmt.setString(2, b.getTitle());
		    pstmt.setString(3, b.getAuthor());
		    pstmt.setString(4, b.getGenre());
		    pstmt.setString(5, b.getPublisher());
		    pstmt.setInt(6, b.getPublished_year());
		    pstmt.setString(7, b.getDescription());
		    pstmt.executeUpdate();
		    return true;
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something went wrong while inserting book data.");
			return false;
		}
		
	}

	
	public Book viewBookById(int id) {
		Book book=new Book();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from book where book_id=?");
		    pstmt.setInt(1,id);
			ResultSet rs=pstmt.executeQuery();
			boolean res=rs.next();
			if(res==false)
			{
				System.out.println("No book with this id.");
			    return null;
			}
			else {
				book.setBook_id(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setGenre(rs.getString(4));
				book.setPublisher(rs.getString(5));
				book.setPublished_year(rs.getInt(6));
				book.setDescription(rs.getString(7));
				
				return book;
			}
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something went wrong while retrieving book data.");
			return null;
		}
		
	}

	
	public List<Book> viewAllBooks() {
		
		List<Book> blist=new ArrayList<Book>();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from book");
		   	ResultSet rs=pstmt.executeQuery();
		  	
			while(rs.next())
			{
			    Book book=new Book();
			    book.setBook_id(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setGenre(rs.getString(4));
				book.setPublisher(rs.getString(5));
				book.setPublished_year(rs.getInt(6));
				book.setDescription(rs.getString(7));
				
				blist.add(book);
			}
			
			if(blist.isEmpty())
			{
				System.out.println("No book in DB");
				return null;
			}
			
			return blist;	
			
			
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something went wrong while retrieving books list.");
			return null;
		}
		 
		
	}

	
	public boolean updateBook(Book b) {
		try {
			PreparedStatement pstmt=con.prepareStatement("update book set title=?,author=?,genre=?,publisher=?,published_year=?,description=? where book_id=?");
			pstmt.setString(1, b.getTitle());
	        pstmt.setString(2, b.getAuthor());
	        pstmt.setString(3, b.getGenre());
	        pstmt.setString(4, b.getPublisher());
	        pstmt.setInt(5, b.getPublished_year());
	        pstmt.setString(6, b.getDescription());
	        pstmt.setInt(7, b.getBook_id());
		    int i=pstmt.executeUpdate();
		    if(i>0)
		      return true;
		    return false;
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something went wrong while updating book data.");
			return false;
		}
		
		
	}

	
	public boolean deleteBook(int id) {
		try {
			PreparedStatement pstmt=con.prepareStatement("delete from book where book_id=?");
		    pstmt.setInt(1,id);
		    int i=pstmt.executeUpdate();
		    if(i>0)
		    	return true;
		    return false;
		}
		catch(SQLException e) {
			System.out.println("Something went wrong while deleting the book data.");
			return false;
		}
		
	}
}
