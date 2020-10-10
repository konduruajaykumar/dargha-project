package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.DevoteeDTO;
import com.nt.error.NotPossibleToGiveMedicineAtThisTimeException;
import com.nt.service.DevoteeService;
import com.nt.service.DevoteeServiceFactory;
import com.nt.service.DevoteeServiceImpl;

@WebServlet({ "/devoteeRegisterController" })
public class DevoteeController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		DevoteeService service = null;
		LocalDate visitDate = null;
		String result = null;
		DevoteeDTO dto = null;
		int differenceBetweenPdateAndFdate = 0, differenceBetweenPdateAndVdate = 0, differenceBetweenPdateAndRdate = 0;
		LocalDate pregDate = null, firstDate = null, registeredDate = null;

		// create DevoteeServiceImpl class obj
		service = DevoteeServiceFactory.getInstance();
		// System.out.println("FirstDate:" + req.getParameter("firstDate"));

		// read pdate from form
		pregDate = LocalDate.parse(req.getParameter("pDate"));
		firstDate = LocalDate.parse(req.getParameter("firstDate"));

		// calculate the visiting date using given LMP date and firstDate
		try {
			visitDate = service.calculateVisitDate(pregDate);
			System.out.println("visitDate::" + visitDate);
			
			differenceBetweenPdateAndFdate = service.calculateDays(pregDate, firstDate);
			try {
				// if differenceBetweenPdateAndFdate date is less than 70 days
				if (differenceBetweenPdateAndFdate < 70 && differenceBetweenPdateAndFdate >= 60) {
					registeredDate = firstDate;
					System.out.println("registeredDate:: " + registeredDate);
					differenceBetweenPdateAndRdate = differenceBetweenPdateAndFdate;
					firstDate = service.addMoreDaysToPregnancyDateToGetFirstDate(differenceBetweenPdateAndFdate,
							firstDate);
					differenceBetweenPdateAndFdate = service.calculateDays(pregDate, firstDate);

				} else if (differenceBetweenPdateAndFdate > 101) {
					try {
						throw new NotPossibleToGiveMedicineAtThisTimeException(
								"It is too late, now it is not possible to give medicine at this time. Better luck next time! ");
					} catch (NotPossibleToGiveMedicineAtThisTimeException e) {
						System.out.println("Hey Iam here...");
						e.printStackTrace();
						req.setAttribute("regDeniedMsg",
								"It is too late, medicine is given from 70 days to 101 days only, But it is now "
										+ differenceBetweenPdateAndFdate + " days.");
						req.setAttribute("errMsg", e.getMessage());
						RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
						rd.forward(req, res);
						return;
					}

				} else if (differenceBetweenPdateAndFdate < 60) {
					try {
						throw new NotPossibleToGiveMedicineAtThisTimeException(
								"It is too Early, now it is not possible to give medicine at this time.");
					} catch (NotPossibleToGiveMedicineAtThisTimeException e) {
						System.out.println("Hey Iam here...");
						e.printStackTrace();
						req.setAttribute("regDeniedMsg",
								"It is too Early, medicine is given from 70 days to 101 days only, But it is now "
										+ differenceBetweenPdateAndFdate + " days.");
						req.setAttribute("errMsg", e.getMessage());
						RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
						rd.forward(req, res);
						return;
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("errMsg", e.getMessage());
				RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
				rd.forward(req, res);
				return;
			}
			//edited on 29 oct 2018
			//1 day is added becoz we are also including LMP happened date also.
			differenceBetweenPdateAndVdate = service.calculateDays(pregDate, visitDate);
			
			// additional condition to give one more time extra medicine who are came in b/w 95 to 101 days
			if (differenceBetweenPdateAndFdate >= 95 && differenceBetweenPdateAndFdate <= 101
					&& differenceBetweenPdateAndVdate >= 95 && differenceBetweenPdateAndVdate <= 101) {
				System.out.println("------------------------------------------------------------------");
				System.out.println("I am in additional condition");
				visitDate = visitDate.plusDays(7);
				differenceBetweenPdateAndVdate = differenceBetweenPdateAndVdate + 7;
				System.out.println("visitDate::" + visitDate);
				System.out.println("differenceBetweenPdateAndVdate:: " + differenceBetweenPdateAndVdate);
				System.out.println("------------------------------------------------------------------");
				
			}
			System.out.println("firstDate:: " + firstDate);
			System.out.println("visitDate::" + visitDate);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e);
			RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
			return;
		}

		// setting values to dto class and calling service method
		try {

			dto = new DevoteeDTO();
			dto.setName(req.getParameter("name"));
			dto.setHusbandName(req.getParameter("husbandName"));
			dto.setMobileNo(Long.parseLong(req.getParameter("mobileNo")));
			dto.setVillage(req.getParameter("village"));
			dto.setMandal(req.getParameter("mandal"));
			dto.setDistrict(req.getParameter("district"));
			dto.setChildNo(Byte.parseByte(req.getParameter("childNo")));
			dto.setPregnancyDate(pregDate);
			dto.setRegisteredDate(registeredDate);
			dto.setFirstDate(firstDate);
			dto.setVisitDate(visitDate);
			dto.setDaysBetweenPdateAndFdate((short) differenceBetweenPdateAndFdate);
			dto.setDaysBetweenPdateAndVdate((short) differenceBetweenPdateAndVdate);
			dto.setDaysBetweenPdateAndRdate((short) differenceBetweenPdateAndRdate);
			dto.setVisitStatus(req.getParameter("visitStatus"));
			dto.setStatus(req.getParameter("status"));
			dto.setOtherDetails(req.getParameter("otherDetails"));
		} catch (Exception e) {
			req.setAttribute("errMsg", e.getMessage());
			RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
			return;
		}

		try {
			// calling service method to regiser the devotee details and get the
			// result
			result = service.register(dto);
			dto.setId(Integer.parseInt(result));
			// set the values to req scope
			req.setAttribute("result", result);
			req.setAttribute("dto", dto);
			/*
			 * req.setAttribute("visitDate", visitDate);
			 * req.setAttribute("firstDate", firstDate);
			 * req.setAttribute("registeredDate", registeredDate);
			 * req.setAttribute("differenceBetweenPdateAndFdate",
			 * differenceBetweenPdateAndFdate);
			 * req.setAttribute("differenceBetweenPdateAndVdate",
			 * differenceBetweenPdateAndVdate);
			 * req.setAttribute("differenceBetweenPdateAndRdate",
			 * differenceBetweenPdateAndRdate);
			 */
			// forward req to to display the reg details
			RequestDispatcher rd = req.getRequestDispatcher("/registration_result.jsp");
			rd.forward(req, res);
		} catch (Exception e) {
			req.setAttribute("errMsg", e.getMessage());
			req.setAttribute("regFailMsg", "Registration Failed...");
			RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
			return;
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req, res);
	}

}
