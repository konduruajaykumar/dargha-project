package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.DevoteeDTO;
import com.nt.service.DevoteeService;
import com.nt.service.DevoteeServiceFactory;

@WebServlet("/moveDevoteeDetails")
public class MoveDevoteeController extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = 0;
		DevoteeService service = null;
		String moveResult = null;
		RequestDispatcher rd = null;

		// get id value from the query string
		id = Integer.parseInt(req.getParameter("id"));
		// get Service class
		service = DevoteeServiceFactory.getInstance();
		// use service class
		try {
			moveResult = service.transferDevotee(id);
			// keep DevoteeDTo in request scope
			req.setAttribute("moveResult", moveResult);
			//req.setAttribute("id", id);
			// forward request to edit_devotee_form.jsp
			rd = req.getRequestDispatcher("/move_devotee_result.jsp");
			rd.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("moveResult", "Id "+ id +" Details are not moved...");
			req.setAttribute("errMsg", e.getMessage());
			rd = req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}