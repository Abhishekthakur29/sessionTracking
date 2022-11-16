package com.abhiTech.factory;

import com.abhiTech.dao.StudentDao;
import com.abhiTech.dao.StudentDaoImpl;

public class StudentFactory {
	private static StudentDao studentDao;

	private StudentFactory() {

	}

	public static StudentDao getInstance() {
		if (studentDao == null) {
			studentDao = new StudentDaoImpl();
		}
		return studentDao;
	}
}
