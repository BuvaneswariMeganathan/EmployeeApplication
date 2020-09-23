package com.employee.details;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDaoImpl implements EmployeeDao {

	public Connection getConnection()  {
		Connection con = null;
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/employee","root","password");
		}catch(Exception e){ System.out.println(e);}
		return con;
		
	}
	@Override
	public boolean select(String tableName) {
		try{  
			Connection con = getConnection();
			Statement stmt=con.createStatement();  
			String sqlQuery = "select * from "+tableName;
			
			ResultSet rs=stmt.executeQuery(sqlQuery);  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4));
			con.close();
			return true;
			}catch(Exception e){ System.out.println(e);}
		return false;
		
	}

	@Override
	public boolean search(String tableName,String empNameSearch) {
		try{  
			Connection con = getConnection();
			Statement stmt=con.createStatement();  
			String searchQuery = "select * from "+tableName+" where emp_name = '"+empNameSearch+"'";
			ResultSet rs=stmt.executeQuery(searchQuery);  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4));
			con.close();
			return true;
			}catch(Exception e){ System.out.println(e);}
		return false;
		
	}

	@Override
	public boolean modify(String tableName, EmployeeEntity empEntity) {
		try {
		Connection con = getConnection();
        String updateSql = "Update " +tableName+ " set emp_email = ?, emp_salary = ? where emp_name = ?";
        PreparedStatement pstmt = con.prepareStatement(updateSql);
        pstmt.setString(1, empEntity.getEmp_email());
        pstmt.setInt(2, empEntity.getEmp_salary());
        pstmt.setString(3, empEntity.getEmp_name());
        int rowUpdate = pstmt.executeUpdate();
        if (rowUpdate > 0)
        {
        	return true;
        }
	}catch(Exception e){ System.out.println(e);}
		return false;
	}

	@Override
	public boolean insert(String tableName, EmployeeEntity empEntity) {
		try {
		 Connection con = getConnection();
		 String sql = "INSERT INTO "+tableName+" (emp_id, emp_name, emp_email, emp_salary) VALUES (?, ?, ?, ?)";
         PreparedStatement statement = con.prepareStatement(sql);
         statement.setInt(1, empEntity.getEmp_id());
         statement.setString(2, empEntity.getEmp_name());
         statement.setString(3, empEntity.getEmp_email());
         statement.setInt(4, empEntity.getEmp_salary());

         int rowsInserted = statement.executeUpdate();
         if (rowsInserted > 0)
         {
              return true;
         }
	}catch(Exception e){ System.out.println(e);}
		return false;
	}

	@Override
	public boolean delete(String tableName, int empId) {
		try{  
		Connection con = getConnection();
		String deleteQuery = "DELETE FROM "+tableName+" WHERE emp_id=?";
        PreparedStatement statement = con.prepareStatement(deleteQuery);
        statement.setInt(1, empId);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0)
        {
             
             return true;
        }}catch(Exception e){ System.out.println(e);}
		return false;
	}

}
