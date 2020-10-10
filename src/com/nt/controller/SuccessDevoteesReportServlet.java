package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.bo.DevoteeSuccessBO;
import com.nt.dto.DevoteeDTO;

import com.nt.service.DevoteeService;
import com.nt.service.DevoteeServiceFactory;

@WebServlet("/successDevoteeReport")
public class SuccessDevoteesReportServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int pageNo = 0;
		DevoteeService service = null;
		List<DevoteeDTO> listDTO = null;
		int pageCount = 0;
		RequestDispatcher rd = null;
		res.setContentType("text/html");
		// read pageNo
		pageNo = Integer.parseInt(req.getParameter("pageNo"));
		// get Service class
		service = DevoteeServiceFactory.getInstance();
		// use service class
		try {
			listDTO = service.getSuccessReportData(pageNo);
		} catch (Exception e) {
			e.printStackTrace();

		}
		// get PageCount
		try {
			pageCount = service.getPageCount(DevoteeSuccessBO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// keep ListDTO in request scope
		req.setAttribute("reportData", listDTO);
		req.setAttribute("pageCount", pageCount);
		// forward request to report.jsp
		rd = req.getRequestDispatcher("/success_devotee_report.jsp");
		rd.forward(req, res);
	}// doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}// doPost(-,-)
}// class
