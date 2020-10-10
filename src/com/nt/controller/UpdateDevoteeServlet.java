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

@WebServlet("/updateDevoteeDetails")
public class UpdateDevoteeServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		DevoteeService service = null;
		DevoteeDTO dto = null;
		RequestDispatcher rd = null;
		int id = 0;
		String visitStatus = null, status = null;
		boolean flag = false;

		// read id,visitStatus,status from edit form
		id = Integer.parseInt(req.getParameter("id"));
		visitStatus = req.getParameter("visitStatus");
		status = req.getParameter("status");
		// get Service class
		service = DevoteeServiceFactory.getInstance();
		// use service class
		try {
			service.updateDevotee(id, visitStatus, status);
			flag = true;
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			rd = req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
		} finally {
			if (flag == true) {
				req.setAttribute("updateResult", "Updated Sucessfully...");
				rd = req.getRequestDispatcher("/update_devotee_result.jsp");
				rd.forward(req, res);
			} else {
				req.setAttribute("updateResult", "Updatation failed...");
				rd = req.getRequestDispatcher("/update_devotee_result.jsp");
				rd.forward(req, res);
			}
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
