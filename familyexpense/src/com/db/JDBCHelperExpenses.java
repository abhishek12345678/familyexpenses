package com.db;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.model.Expenses;
import com.model.User;

public class JDBCHelperExpenses {
	
	Connection con;
	Statement stmt;
	PreparedStatement pStmt;
	
	
	public JDBCHelperExpenses() {
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
	

	public int add(Expenses expenses){
		
		int i = 0;
		
		try {
			
			String sql = "insert into fe values(null,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, expenses.userEmail);
			pStmt.setString(2, expenses.currentdate);
			//pStmt.setDate(1, new java.sql.Date(expenses.getDate().getTime()));
			pStmt.setLong(3, expenses.food);
			pStmt.setLong(8, expenses.shopping);
			pStmt.setLong(5, expenses.party);
			pStmt.setLong(4, expenses.travel);
			pStmt.setLong(6, expenses.education);
			pStmt.setLong(7, expenses.health);
			pStmt.setLong(9, expenses.Utilities);
			pStmt.setLong(10, expenses.perdayexpenses);
			pStmt.setString(11, expenses.monthly);
			pStmt.setLong(12, expenses.year);
			pStmt.setLong(13, expenses.Amount);
			i =pStmt.executeUpdate();
			
			System.out.println(i+" Row(s) inserted");
			
		} catch (Exception e) {
			System.out.println("Exception "+e);
		}
		
		return i;
	}
public int update(Expenses expenses){
		
		int i = 0;
		
		try {
			
			String sql = "update fe set food=?,shopping=?,party=?,travel=?,education=?,health=?,Utilities=?,perdayexpenses=? where userEmail=? && currentdate=?";
			pStmt = con.prepareStatement(sql);
			
			
			pStmt.setLong(1, expenses.food);
			pStmt.setLong(2, expenses.shopping);
			pStmt.setLong(3, expenses.party);
			pStmt.setLong(4, expenses.travel);
			pStmt.setLong(5, expenses.education);
			pStmt.setLong(6, expenses.health);
			pStmt.setLong(7, expenses.Utilities);
			pStmt.setLong(8, expenses.perdayexpenses);
			pStmt.setString(9, expenses.userEmail);
			pStmt.setString(10, expenses.currentdate);
		
			i =pStmt.executeUpdate();
			
			System.out.println(i+" Row(s) updated");
			
		} catch (Exception e) {
			System.out.println("Exception "+e);
		}
		
		return i;
	}
public ArrayList<Expenses> retrieveUsers(){
		
		ArrayList<Expenses> userList = new ArrayList<Expenses>();
		Expenses expenses = new Expenses();
		try {
			
			String sql = "select perdayexpenses from familyexpenses where userEmail=?";
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, expenses.userEmail);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()){
				
				
				
				//user.userID = rs.getInt(1);
				expenses.perdayexpenses = rs.getInt(1);
				//user.userEmail = rs.getString(3);
				//.userPassword = rs.getString(4);
				
				userList.add(expenses);
			}
			
		} catch (Exception e) {
			System.out.println("Exception "+e);
		}
		
		return userList;
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