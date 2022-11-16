package com.abhiTech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abhiTech.dto.Student;
import com.abhiTech.utility.JdbcUtility;

public class StudentDaoImpl implements StudentDao {

	private PreparedStatement prepareStatement;

	@Override
	public String save(Student student) {
		try {
			Connection connection = JdbcUtility.getInstance();
			if (connection != null) {
				String INSERT_SQL_QUERY = "insert into studentS(id,name,address,email,phone) values(?,?,?,?,?)";
				prepareStatement = connection.prepareStatement(INSERT_SQL_QUERY);
			}
			if (prepareStatement != null) {
				prepareStatement.setInt(1, student.getId());
				prepareStatement.setString(2, student.getName());
				prepareStatement.setString(3, student.getAddress());
				prepareStatement.setString(4, student.getEmail());
				prepareStatement.setString(5, student.getPhone());
			}
			int rowSet = prepareStatement.executeUpdate();

			if (rowSet > 0) {
				return "success";
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return "failure";
	}

}
