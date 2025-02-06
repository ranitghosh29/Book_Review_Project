package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Userdao;
import model.User;
import utility.ConnectionProvider;


public class Userdaoimpl implements Userdao{
	Connection con=ConnectionProvider.getConnection();

	@Override
	public boolean insertUser(User u) {
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into user(user_id,username,email,password,bio) values(?,?,?,?,?)");
		    pstmt.setInt(1, u.getUser_id());
			pstmt.setString(2, u.getUsername());
		    pstmt.setString(3, u.getEmail());
		    pstmt.setString(4, u.getPassword());
		    pstmt.setString(5, u.getBio());
		    pstmt.executeUpdate();
		    return true;
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something went wrong while inserting record.");
			return false;
		}
	}

	@Override
	public User viewUserById(int id) {
		User user=new User();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from user where user_id=?");
		    pstmt.setInt(1,id);
			ResultSet rs=pstmt.executeQuery();
			boolean res=rs.next();
			if(res==false)
			{
				System.out.println("No user with this id.");
			    return null;
			}
			else {
				user.setUser_id(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setBio(rs.getString(5));
				return user;
			}
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something went wrong while retrieving record.");
			return null;
		}
	}

	@Override
	public List<User> viewAllUsers() {
		List<User> ulist=new ArrayList<User>();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from user");
		   	ResultSet rs=pstmt.executeQuery();
		  	
			while(rs.next())
			{
			    User user=new User();
				user.setUser_id(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setBio(rs.getString(5));
				ulist.add(user);
			}
			
			if(ulist.isEmpty())
			{
				System.out.println("No user in DB");
				return null;
			}
			
			return ulist;	
			
			
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something went wrong while retrieving users list.");
			return null;
		}
		 
		
	}

	@Override
	public boolean updateUser(User u) {
		try {
			PreparedStatement pstmt=con.prepareStatement("update user set username=?,email=?,password=?,bio=? where user_id=?");
		    pstmt.setString(1,u.getUsername() );
			pstmt.setString(2, u.getEmail());
		    pstmt.setString(3, u.getPassword());
		    pstmt.setString(4, u.getBio());
		    pstmt.setInt(5, u.getUser_id());
		    int i=pstmt.executeUpdate();
		    if(i>0)
		      return true;
		    return false;
		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println("Something went wrong while updating user.");
			return false;
		}
		
	}

	@Override
	public boolean deleteUser(int id) {
		try {
			PreparedStatement pstmt=con.prepareStatement("delete from user where user_id=?");
		    pstmt.setInt(1,id);
		    int i=pstmt.executeUpdate();
		    if(i>0)
		    	return true;
		    return false;
		}
		catch(SQLException e) {
			System.out.println("Something went wrong while deleting the user.");
			return false;
		}
		
	}
}
	

