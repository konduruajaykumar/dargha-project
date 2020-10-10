package com.nt.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.GenericFilter;

//@WebFilter(value="/*")
@WebFilter({ "/devoteeRegisterController", "/register.jsp" })
public class DoublePostingFilter extends GenericFilter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest hreq = null;
		HttpSession ses = null;
		int serverToken = 0, clientToken = 0;

		// general settings
		res.setContentType("text/html");
		// converting ServletRequest to HttpServletRequest
		hreq = ((HttpServletRequest) req);

		if (hreq.getMethod().equalsIgnoreCase("get")) {

			ses = hreq.getSession(true);
			ses.setAttribute("sToken", new Random(10000).nextInt());
			chain.doFilter(req, res);

		} else {
			ses = hreq.getSession(false);
			// read server token
			serverToken = (int) ses.getAttribute("sToken");
			// read client token
			clientToken = Integer.parseInt(req.getParameter("clientToken"));
			if (serverToken == clientToken) {
				ses.setAttribute("sToken", new Random(1000).nextInt());
				chain.doFilter(req, res);

			} else {
				System.out.println("Double Posting problem.........");
				RequestDispatcher rd = req.getRequestDispatcher("double_posting.jsp");
				rd.include(req, res);
			}

		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
