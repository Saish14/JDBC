package com.bv.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bv.connection.DBconnect;

public class UserValidation {

	public static boolean validate(int acc_no , String password)
	{
		boolean status = false;
		String sql = "select * from account where acc_no = ? and pass = ?";
		
		Connection con = DBconnect.getConnection();
		try
		{
			PreparedStatement preparedstatement2 = con.prepareStatement(sql);
			
			preparedstatement2.setInt(1 ,  acc_no);
			preparedstatement2.setString(2 ,  "pass");
			ResultSet rs = preparedstatement2.executeQuery();
			
			if(rs.next())
			{
				status = true;
			}
		}
			catch(SQLException e)
			{
				System.out.println(e);
			}	
		
		return status;
	}
	
}
