package com.nt.controller;

import java.io.IOException;
import java.time.LocalDate;
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

@WebServlet("/searchRegisteredDevotee")
public class SearchRegisteredDevoteeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String submitValue = req.getParameter("search");

		if (submitValue.equalsIgnoreCase("Search By Date")) {
			DevoteeService service = null;
			List<DevoteeDTO> listDTO = null;
			LocalDate fromDate = null, toDate = null;
			RequestDispatcher rd = null;
			String fieldType = null;
			res.setContentType("text/html");
			// read dates
			fieldType = req.getParameter("fieldType");
			fromDate = LocalDate.parse(req.getParameter("fromDate"));
			toDate = LocalDate.parse(req.getParameter("toDate"));
			// get Service class
			service = DevoteeServiceFactory.getInstance();
			// use service class
			try {
				listDTO = service.searchDevoteesByDate(fieldType, fromDate, toDate);
			} catch (Exception e) {
				e.printStackTrace();

			}

			// keep ListDTO in request scope
			req.setAttribute("reportData", listDTO);

			// forward request to report.jsp
			rd = req.getRequestDispatcher("/report.jsp");
			rd.forward(req, res);

		} else if (submitValue.equalsIgnoreCase("Search")) {
			DevoteeService service = null;
			List<DevoteeDTO> listDTO = null;
			RequestDispatcher rd = null;
			String fieldType = null, fieldValue = null;

			// read fieldValue
			fieldType = req.getParameter("fieldType");
			fieldValue = req.getParameter("fieldValue");

			// get Service class
			service = DevoteeServiceFactory.getInstance();
			// use service class
			try {
				listDTO = service.searchDevoteesByStringData(fieldType, fieldValue);
			} catch (Exception e) {
				e.printStackTrace();

			}

			// keep ListDTO in request scope
			req.setAttribute("reportData", listDTO);

			// forward request to report.jsp
			rd = req.getRequestDispatcher("/report.jsp");
			rd.forward(req, res);
		}  else if (submitValue.equalsIgnoreCase("Print")) {
			DevoteeService service = null;
			DevoteeDTO dto = null;
			RequestDispatcher rd = null;
			int fieldValue;

			// read fieldValue
			fieldValue = Integer.parseInt(req.getParameter("fieldValue"));

			// get Service class
			service = DevoteeServiceFactory.getInstance();
			// use service class
			try {
				dto = service.searchDevoteeById(fieldValue);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// keep ListDTO in request scope
			req.setAttribute("dto", dto);

			// forward request to print.jsp
			rd = req.getRequestDispatcher("/registration_result.jsp");
			rd.forward(req, res);
		} else if (submitValue.equalsIgnoreCase("Search By Id or Mobile No")) {
			DevoteeService service = null;
			DevoteeDTO dto = null;
			RequestDispatcher rd = null;
			String fieldValue = null;;
			String fieldType = null;

			// read fieldValue
			fieldValue = req.getParameter("fieldValue");
			fieldType = req.getParameter("fieldType");
			// get Service class
			service = DevoteeServiceFactory.getInstance();
			// use service class
			try {
				dto = service.searchDevoteesByMobileNoOrId(fieldType, fieldValue);
			} catch (Exception e) {
				e.printStackTrace();

			}

			// keep ListDTO in request scope
			req.setAttribute("reportData", dto);

			// forward request to report.jsp
			rd = req.getRequestDispatcher("/report_by_id.jsp");
			rd.forward(req, res);

		} else if (submitValue.equalsIgnoreCase("Search By Mobile Number")) {
			DevoteeService service = null;
			DevoteeDTO dto = null;
			RequestDispatcher rd = null;
			String fieldValue;
			String fieldType = "mobileNo";

			// read fieldValue
			fieldValue = req.getParameter("fieldValue");

			// get Service class
			service = DevoteeServiceFactory.getInstance();
			// use service class
			try {
				dto = service.searchDevoteesByMobile(fieldType, fieldValue);
			} catch (Exception e) {
				e.printStackTrace();

			}

			// keep ListDTO in request scope
			req.setAttribute("reportData", dto);

			// forward request to report.jsp
			rd = req.getRequestDispatcher("/report_by_id.jsp");
			rd.forward(req, res);
		}
	}// doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}// doPost(-,-)
}// class
