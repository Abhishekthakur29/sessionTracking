package com.abhiTech.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abhiTech.dao.StudentDao;
import com.abhiTech.dto.Student;
import com.abhiTech.factory.StudentFactory;

@WebServlet("/create")
public class StudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RequestDispatcher requestDispatcher;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		Student student = new Student();
		student.setId(Integer.parseInt(id));
		student.setName(name);
		student.setEmail(email);
		student.setAddress(address);
		student.setPhone(phone);
		
		StudentDao studentDao = StudentFactory.getInstance();
		
		String save = studentDao.save(student);
		
		if(save.equals("success")) {
			requestDispatcher = request.getRequestDispatcher("./success.html");
			requestDispatcher.forward(request, response);
		}else{
			requestDispatcher = request.getRequestDispatcher("./failure.html");
			requestDispatcher.forward(request, response);
		}
	}

}
