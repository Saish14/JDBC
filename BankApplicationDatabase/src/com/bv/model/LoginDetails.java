package com.bv.model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bv.connection.DBconnect;

public class LoginDetails {

	public void getDetails()
	{
		try {
		String sql = "select * from LoginDetails where acc_no = ?";
		Connection connection = DBconnect.getConnection();
		
		PreparedStatement preparedstatement  = connection.prepareStatement(sql);
		
		preparedstatement.setInt(1, 102);
		
		ResultSet resultset = preparedstatement.executeQuery();
		
		System.out.println(resultset);
		
		while(resultset.next())
		{
			System.out.println(resultset.getInt("ACC_NO") + " " +resultset.getString("USERNAME") + " " +resultset.getString("PASSWORD"));
		}
		
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
}
