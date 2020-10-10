package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.service.DevoteeService;
import com.nt.service.DevoteeServiceFactory;

@WebServlet("/success_percentage_calc")
public class SucessPercentageCalculationServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		DevoteeService service = null;
		float successPercentage = 0.0f;
		// create DevoteeServiceImpl class obj
		service = DevoteeServiceFactory.getInstance();
		// use service
		try {
			successPercentage = service.calculateSuccessDevoteesPercentage();
			// set the values to req scope
			req.setAttribute("successPercentage", successPercentage);
			// forward req to to display the reg details
			RequestDispatcher rd = req.getRequestDispatcher("/success_percentage_calculation.jsp");
			rd.forward(req, res);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
			return;
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
