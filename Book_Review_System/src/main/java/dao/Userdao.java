package dao;

import java.util.List;

import model.User;

public interface Userdao {
	
	boolean insertUser(User u);
	User viewUserById(int id);
	List<User> viewAllUsers();
	boolean updateUser(User u);
	boolean deleteUser(int id);
}
