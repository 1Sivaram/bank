package com.bank.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.ApiLayer;
import myException.CustomException;
import validateclass.Checker;

/**
 * Servlet implementation class Activate
 */
@WebServlet("/Activate")
public class Activate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Activate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ApiLayer logic=(ApiLayer)request.getServletContext().getAttribute("api");
		String data=request.getParameter("customerId");
		try 
		{
			Checker.nullCheck(data);
		}
		catch(CustomException e)
		{
			request.setAttribute("error", e.getMessage());
			RequestDispatcher dispatch=request.getRequestDispatcher("activatecustomer.jsp");
			dispatch.forward(request, response);
		}
			int customerId=Integer.parseInt(data);
			if(request.getParameter("accountId")==null)
			{
				try
				{
				logic.setCustomerState(customerId, true);
				request.setAttribute("CustomerList",logic.getCustomerList(true));
				RequestDispatcher dispatch=request.getRequestDispatcher("activatecustomer.jsp");
				dispatch.forward(request, response);
			}
			catch(CustomException ex)
			{
				ex.printStackTrace();
				request.setAttribute("error", ex.getMessage());
				RequestDispatcher dispatch=request.getRequestDispatcher("activatecustomer.jsp");
				dispatch.forward(request, response);
			}
		}
		else
		{
			int accountId=Integer.parseInt(request.getParameter("accountId"));
			try
			{
				logic.setAccountState(customerId, accountId, true);
				request.setAttribute("AccountList", logic.getAccountList(true));
				RequestDispatcher dispatch=request.getRequestDispatcher("activateaccount.jsp");
				dispatch.forward(request, response);
			}
			catch(CustomException e)
			{
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
				RequestDispatcher dispatch=request.getRequestDispatcher("activateaccount.jsp");
				dispatch.forward(request, response);
			}
		}
	}

}