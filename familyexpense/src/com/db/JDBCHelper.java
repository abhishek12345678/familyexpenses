package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.Expenses;
import com.model.User;

public class JDBCHelper {
	
	Connection con;
	
	Statement stmt;
	PreparedStatement pStmt;
	

	public JDBCHelper() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("--Driver Loaded--");
		} catch (Exception e) {
			System.out.println("Exception "+e);
		}
	}
	
	public void openConnection(){
		try {
			String url = "jdbc:mysql://localhost/familyexpensesdb";
			String user = "root";
			String password = "";
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("--Connection Opened--");
			
		} catch (Exception e) {
			System.out.println("Exception "+e);
		}
	}
	public int forget(User user) {
		int rs = 0;
		
		try {
			String sql="update users set userPassword=?  where userEmail=? && userSecurityQuestion=?" ;
			//String sql="insert into user  ";
			
			pStmt = con.prepareStatement(sql);
			
			pStmt.setString(1, user.userPassword);
			pStmt.setString(2, user.userEmail);
			pStmt.setString(3, user.userSecurityQuestion);
			 rs = pStmt.executeUpdate();
			 System.out.println(rs+" Row(s) inserted");
				
			//check = rs.next();
		}catch(Exception e) {
			System.out.println("Exception "+e);
		}
		return rs;
	}
	public int accountforget(User user) {
		int rs = 0;
		
		try {
			String sql="update users set userName=? ,userPhone=?,userSecurityQuestion=? where userEmail=? " ;
			//String sql="insert into user  ";
			
			pStmt = con.prepareStatement(sql);
			
			pStmt.setString(1, user.userName);
			pStmt.setString(2, user.userPhone);
			pStmt.setString(3, user.userSecurityQuestion);
			pStmt.setString(4, user.userEmail);
			 rs = pStmt.executeUpdate();
			 System.out.println(rs+" Row(s) inserted");
				
			//check = rs.next();
		}catch(Exception e) {
			System.out.println("Exception "+e);
		}
		return rs;
	}
	public int registerUser(User user){
		
		int i = 0;
		
		try {
			
			String sql = "insert into users values(?,?,?,?,?)";
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, user.userEmail);
			pStmt.setString(2, user.userName);
			pStmt.setString(3,user.userPassword);
			pStmt.setString(4, user.userPhone);
			pStmt.setString(5, user.userSecurityQuestion);
			
			i = pStmt.executeUpdate();
			
			System.out.println(i+" Row(s) inserted");
			
		} catch (Exception e) {
			System.out.println("Exception "+e);
		}
		
		return i;
	}
	public int estimated(User user){
		
		int i = 0;
		
		try {
			
			String sql = "insert into estimatedamount values(?,?,?,?)";
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, user.userEmail);
			pStmt.setString(2,"jan");
			pStmt.setLong(3,2018);
			pStmt.setLong(4, 0);
		
			
			i = pStmt.executeUpdate();
			
			System.out.println(i+" Row(s) inserted in estimated amount");
			
		} catch (Exception e) {
			System.out.println("Exception "+e);
		}
		
		return i;
	}
public int insertestimated(Expenses expenses){
		
		int i = 0;
		
		try {
			
			String sql = "update estimatedamount set monthly=?,year=?,Amount=? where userEmail=?";
			pStmt = con.prepareStatement(sql);
			
			pStmt.setString(1,expenses.monthly);
			pStmt.setLong(2,expenses.year);
			pStmt.setLong(3, expenses.Amount);
			pStmt.setString(4, expenses.userEmail);
			
			i = pStmt.executeUpdate();
			
			System.out.println(i+" Row(s) updated in estimated amount");
			
		} catch (Exception e) {
			System.out.println("Exception "+e);
		}
		
		return i;
		
	}

public int updatestimed(Expenses expenses){
	
	int i = 0;
	
	try {
		
		String sql = "update fe set Amount=? where userEmail=?  && monthly=? && year=?";
		pStmt = con.prepareStatement(sql);
		
		pStmt.setLong(1,expenses.Amount);
		pStmt.setString(2, expenses.userEmail);
		pStmt.setString(3, expenses.monthly);
		pStmt.setLong(4, expenses.year);
		
		i = pStmt.executeUpdate();
		
		System.out.println(i+" Row(s) updated in estimated amount");
		
	} catch (Exception e) {
		System.out.println("Exception "+e);
	}
	
	return i;
}

	public ArrayList<User> retrieveUsers(){
		
		ArrayList<User> userList = new ArrayList<User>();
		
		try {
			
			String sql = "select * from users";
			pStmt = con.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()){
				
				User user = new User();
				
				//user.userID = rs.getInt(1);
				user.userName = rs.getString(2);
				user.userEmail = rs.getString(3);
				user.userPassword = rs.getString(4);
				
				userList.add(user);
			}
			
		} catch (Exception e) {
			System.out.println("Exception "+e);
		}
		
		return userList;
	}
public ArrayList<Expenses> retrieverecords(){
	Expenses expenses = new Expenses();
	int i=0;
		ArrayList<Expenses> expenseslist = new ArrayList<Expenses>();
		
		try {
			
			String sql = "select * from fe where userEmail=? && monthly=? && currentdate=?";
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, expenses.userEmail);
			pStmt.setString(2,expenses.monthly);
			pStmt.setString(3,expenses.currentdate);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()){
				
			
				expenses.food = rs.getInt(1);
				expenses.shopping = rs.getInt(2);
				expenses.party = rs.getInt(3);
				expenses.travel = rs.getInt(4);
				expenses.education = rs.getInt(5);
				expenses.travel = rs.getInt(6);
				expenses.health = rs.getInt(7);
				expenses.Utilities = rs.getInt(8);
				expenses.perdayexpenses = rs.getInt(9);
				
				expenseslist.add(expenses);
				

				System.out.println(i+" Row(s) all rows are selected");
			}
			
		} catch (Exception e) {
			System.out.println("Exception "+e);
		}
		
		return expenseslist;
	}
	public boolean loginUser(User user){
		
		boolean check = false;
		
		try {
			
			String sql = "select userName from users where userEmail = ? and userPassword = ?";
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, user.userEmail);
			pStmt.setString(2, user.userPassword);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				
				check=true;
				
			}
			
			System.out.println(check);
			
			
		} catch (Exception e) {
			System.out.println("Exception "+e);
		}
		
		return check;
	}
	

	public void closeConnection(){
		try {
			con.close();
			System.out.println("--Connection Closed--");
		} catch (Exception e) {
			System.out.println("Exception "+e);
		}
	}

}