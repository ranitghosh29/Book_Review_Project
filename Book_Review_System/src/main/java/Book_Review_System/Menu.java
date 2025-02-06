package Book_Review_System;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import model.Book;
import dao.Bookdao;
import daoimpl.Bookdaoimpl;

import model.User;
import dao.Userdao;
import daoimpl.Userdaoimpl;

import model.Review;
import dao.Reviewdao;
import daoimpl.Reviewdaoimpl;

public class Menu {

	void displayMainMenu() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Project Menu :");
		System.out.println("1. Book :");
		System.out.println("2. User :");
		System.out.println("3. Review :");
		System.out.println("4. Exit :");

		System.out.println("Please Enter your Choice :");
		int mainchoice = Integer.parseInt(br.readLine());

		switch (mainchoice) {
		case 1:
			displayBookMenu();
			break;
		case 2:
			displayUserMenu();
			break;
		case 3:
			displayReviewMenu();
			break;
		case 4:
			System.exit(0);
			break;
		default: {
			System.out.println("Please enter a valid choice :");
			System.out.println("Please Enter your Choice :");
			mainchoice = Integer.parseInt(br.readLine());
		}
		}
	}

	private void displayBookMenu() throws NumberFormatException, IOException {

		Bookdao bdao = new Bookdaoimpl();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char exitchoice;
		do {
			System.out.println("Book Menu :");
			System.out.println("1. Create Book :");
			System.out.println("2. View Book :");
			System.out.println("3. View All Books :");
			System.out.println("4. Update Book :");
			System.out.println("5. Delete Book :");

			System.out.println("6. Return to Main Menu   :");

			System.out.println("Please Enter your Choice :");
			int bchoice = Integer.parseInt(br.readLine());

			switch (bchoice) {

			case 1: {

				System.out.println("Enter a book Id :");
				int book_id = Integer.parseInt(br.readLine());
				System.out.println("Enter book name :");
				String title = br.readLine();
				System.out.println("Enter author name");
				String author = br.readLine();
				System.out.println("Enter genre");
				String genre = br.readLine();
				System.out.println("Enter the publisher");
				String publisher = br.readLine();
				System.out.println("Enter published year :");
				int published_year = Integer.parseInt(br.readLine());
				System.out.println("Give description :");
				String description = br.readLine();

				Book book = new Book(book_id, title, author, genre, publisher, published_year, description);

				boolean res = bdao.insertBook(book);
				if (res)
					System.out.println("Book Created");
				else
					System.out.println("Somethong went wrong");
				break;
			}

			case 2: {
				System.out.println("Enter Book Id :");
				int book_id = Integer.parseInt(br.readLine());
				Book book = bdao.viewBookById(book_id);
				if (book == null) {
					System.out.println("Book with this id does not exist :");
					break;
				}
				System.out.println("Book Details:");
			    System.out.println("ID             : " + book.getBook_id());
			    System.out.println("Title          : " + book.getTitle());
			    System.out.println("Author         : " + book.getAuthor());
			    System.out.println("Genre          : " + book.getGenre());
			    System.out.println("Publisher      : " + book.getPublisher());
			    System.out.println("Published Year : " + book.getPublished_year());
			    System.out.println("Description    : " + book.getDescription());
				break;
			}
			case 3: {
				List<Book> booklist = bdao.viewAllBooks();
				if (booklist == null) {
					System.out.println("There is no book stored in system :");
					break;
				}
				System.out.println("Book List:");
				for (Book b : booklist) {
					System.out.println("--------------------------");
					System.out.println("ID             : " + b.getBook_id());
			        System.out.println("Title          : " + b.getTitle());
			        System.out.println("Author         : " + b.getAuthor());
			        System.out.println("Genre          : " + b.getGenre());
			        System.out.println("Publisher      : " + b.getPublisher());
			        System.out.println("Published Year : " + b.getPublished_year());
			        System.out.println("Description    : " + b.getDescription());
				}
				
				break;
			}

			case 4: {
				System.out.println("Enter Book Id :");
				int book_id = Integer.parseInt(br.readLine());
				Book book = bdao.viewBookById(book_id);
				if (book == null) {
					System.out.println("Book with this id does not exist :");
					break;
				}
				System.out.println("Enter book name :");
				String title = br.readLine();
				System.out.println("Enter author name");
				String author = br.readLine();
				System.out.println("Enter genre");
				String genre = br.readLine();
				System.out.println("Enter the publisher");
				String publisher = br.readLine();
				System.out.println("Enter published year :");
				int published_year = Integer.parseInt(br.readLine());
				System.out.println("Give description :");
				String description = br.readLine();

				book = new Book(book_id, title, author, genre, publisher, published_year, description);
				boolean res = bdao.updateBook(book);
				if (res)
					System.out.println("Book Updated");
				else
					System.out.println("Somethong went wrong");
				break;

			}
			case 5: {
				System.out.println("Enter Book Id :");
				int book_id = Integer.parseInt(br.readLine());
				Book book = bdao.viewBookById(book_id);
				if (book == null) {
					System.out.println("Book with this id does not exist :");
					break;
				}
				boolean res = bdao.deleteBook(book_id);
				if (res)
					System.out.println("Book Deleted");
				else
					System.out.println("Somethong went wrong");
				break;
			}

			case 6: {
				displayMainMenu();
				break;
			}

			default: {
				System.out.println("Please enter a valid choice :");
				System.out.println("Please Enter your Choice :");
				bchoice = Integer.parseInt(br.readLine());
			}

			}
			System.out.println("Do you want to continue (y/n):");
			exitchoice = br.readLine().charAt(0);
		} while (exitchoice == 'y' || exitchoice == 'Y');

	}

	private void displayUserMenu() throws NumberFormatException, IOException {

		Userdao udao = new Userdaoimpl();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char exitchoice;
		do {
			System.out.println("User Menu :");
			System.out.println("1. Create User :");
			System.out.println("2. View User :");
			System.out.println("3. View All Users :");
			System.out.println("4. Update User :");
			System.out.println("5. Delete User :");

			System.out.println("6. Return to Main Menu   :");

			System.out.println("Please Enter your Choice :");
			int uchoice = Integer.parseInt(br.readLine());

			switch (uchoice) {

			case 1: {

				System.out.println("Enter User Id :");
				int user_id = Integer.parseInt(br.readLine());
				System.out.println("Enter User Name :");
				String username = br.readLine();
				System.out.println("Enter Email");
				String email = br.readLine();
				System.out.println("Enter Password :");
				String password = br.readLine();
				System.out.println("Add Bio :");
				String bio = br.readLine();

				User user = new User(user_id, username, email, password, bio);

				boolean res = udao.insertUser(user);
				if (res)
					System.out.println("User Created");
				else
					System.out.println("Somethong went wrong");
				break;
			}
			case 2: {
				System.out.println("Enter User Id :");
				int user_id = Integer.parseInt(br.readLine());
				User user = udao.viewUserById(user_id);
				if (user == null) {
					System.out.println("User with this id does not exist :");
					break;
				}
				System.out.println("User Details:");
			    System.out.printf("User Id         : %d\n", user.getUser_id());
			    System.out.printf("Username        : %s\n", user.getUsername());
			    System.out.printf("Email           : %s\n", user.getEmail());
			    System.out.printf("Password        : %s\n", user.getPassword());
			    System.out.printf("Bio             : %s\n", user.getBio());
				break;
			}
			case 3: {
				List<User> userlist = udao.viewAllUsers();
				if (userlist == null) {
					System.out.println("There is no user stored in system :");
					break;
				}
				System.out.println("User Details:");
				for (User u : userlist) {
					System.out.println("--------------------------");
				    System.out.printf("User Id         : %d\n", u.getUser_id());
				    System.out.printf("Username        : %s\n", u.getUsername());
				    System.out.printf("Email           : %s\n", u.getEmail());
				    System.out.printf("Password        : %s\n", u.getPassword());
				    System.out.printf("Bio             : %s\n", u.getBio());
				}
				break;
			}
			case 4: {
				System.out.println("Enter User Id :");
				int user_id = Integer.parseInt(br.readLine());
				User user = udao.viewUserById(user_id);
				if (user == null) {
					System.out.println("user with this id does not exist :");
					break;
				}
				System.out.println("Enter User Name :");
				String username = br.readLine();
				System.out.println("Enter Email");
				String email = br.readLine();
				System.out.println("Enter Password :");
				String password = br.readLine();
				System.out.println("Add Bio :");
				String bio = br.readLine();

				user = new User(user_id, username, email, password, bio);
				boolean res = udao.updateUser(user);
				if (res)
					System.out.println("User Updated");
				else
					System.out.println("Somethong went wrong");
				break;

			}
			case 5: {
				System.out.println("Enter User Id :");
				int user_id = Integer.parseInt(br.readLine());
				User user = udao.viewUserById(user_id);
				if (user == null) {
					System.out.println("User with this id does not exist :");
					break;
				}
				boolean res = udao.deleteUser(user_id);
				if (res)
					System.out.println("User Deleted");
				else
					System.out.println("Somethong went wrong");
				break;
			}
			case 6: {
				displayMainMenu();
				break;
			}

			default: {
				System.out.println("Please enter a valid choice :");
				System.out.println("Please Enter your Choice :");
				uchoice = Integer.parseInt(br.readLine());
			}

			}
			System.out.println("Do you want to continue (y/n):");
			exitchoice = br.readLine().charAt(0);
		} while (exitchoice == 'y' || exitchoice == 'Y');

	}

	private void displayReviewMenu() throws NumberFormatException, IOException {

		Reviewdao rdao = new Reviewdaoimpl();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char exitchoice;
		do {
			System.out.println("Review Menu :");
			System.out.println("1. Give Review :");
			System.out.println("2. View Review :");
			System.out.println("3. View All Reviews :");

			System.out.println("4. Return to Main Menu   :");

			System.out.println("Please Enter your Choice :");
			int rchoice = Integer.parseInt(br.readLine());

			switch (rchoice) {

			case 1: {

				System.out.println("Enter a unique id for your review  :");
				int review_id = Integer.parseInt(br.readLine());
				System.out.println("Enter book id you want to give review :");
				int book_id = Integer.parseInt(br.readLine());
				System.out.println("Enter your user id :");
				int user_id = Integer.parseInt(br.readLine());
				System.out.println("Enter your reviews :");
				String review_text = br.readLine();
				System.out.println("Enter the rating out of 5 :");
				int rating = Integer.parseInt(br.readLine());

				Review review = new Review(review_id, book_id, user_id, review_text, rating);

				boolean res = rdao.insertReview(review);
				if (res)
					System.out.println("Your reviews are added");
				else
					System.out.println("Somethong went wrong");
				break;
			}
			case 2: {
				System.out.println("Enter your review id :");
				int review_id = Integer.parseInt(br.readLine());
				Review review = rdao.viewReviewById(review_id);
				if (review == null) {
					System.out.println("Review with this id does not exist :");
					break;
				}
				System.out.println("Review Details:");
			    System.out.printf("Review Id       : %d\n", review.getReview_id());
			    System.out.printf("Book Id         : %d\n", review.getBook_id());
			    System.out.printf("User Id         : %d\n", review.getUser_id());
			    System.out.printf("Review Text     : %s\n", review.getReview_text());
			    System.out.printf("Rating          : %d\n", review.getRating());
				break;
			}
			case 3: {
				List<Review> reviewlist = rdao.viewAllReviews();
				if (reviewlist == null) {
					System.out.println("There are no reviews for any books :");
					break;
				}
				System.out.println("Review Details:");
				for (Review r : reviewlist) {
					System.out.println("--------------------------");
				    System.out.printf("Review Id       : %d\n", r.getReview_id());
				    System.out.printf("Book Id         : %d\n", r.getBook_id());
				    System.out.printf("User Id         : %d\n", r.getUser_id());
				    System.out.printf("Review Text     : %s\n", r.getReview_text());
				    System.out.printf("Rating          : %d\n", r.getRating());
				}
				break;
			}
			case 4: {
				displayMainMenu();
				break;
			}
			default: {
				System.out.println("Please enter a valid choice :");
				System.out.println("Please Enter your Choice :");
				rchoice = Integer.parseInt(br.readLine());
			}

			}
			System.out.println("Do you want to continue (y/n):");
			exitchoice = br.readLine().charAt(0);
		} while (exitchoice == 'y' || exitchoice == 'Y');
	}
}
