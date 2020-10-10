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

@WebServlet("/editDevoteeDetails")
public class EditController extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = 0;
		DevoteeService service = null;
		DevoteeDTO dto = null;
		RequestDispatcher rd = null;

		// get id value from the query string
		id = Integer.parseInt(req.getParameter("id"));
		// get Service class
		service = DevoteeServiceFactory.getInstance();
		// use service class
		try {
			dto = service.searchDevoteeById(id);
			// keep DevoteeDTo in request scope
			req.setAttribute("devoteeById", dto);
			// forward request to edit_devotee_form.jsp
			rd = req.getRequestDispatcher("/edit_devotee_form.jsp");
			rd.include(req, res);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			rd = req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
