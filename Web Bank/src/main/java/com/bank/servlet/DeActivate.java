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
 * Servlet implementation class DeActivate
 */
@WebServlet("/DeActivate")
public class DeActivate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeActivate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ApiLayer logic=(ApiLayer)request.getServletContext().getAttribute("api");
		String id=request.getParameter("customerId");
		try 
		{
			Checker.nullCheck(id);
		} 
		catch (CustomException e1) 
		{
			e1.printStackTrace();
		}
		int customerId=Integer.parseInt(id);
		if(request.getParameter("accountId")==null)
		{
			try
			{
				logic.setCustomerState(customerId, false);
				request.setAttribute("CustomerList",logic.getCustomerList(true));
				RequestDispatcher dispatch=request.getRequestDispatcher("customerdetails.jsp");
				dispatch.forward(request, response);
			}
			catch(CustomException ex)
			{
				ex.printStackTrace();
				request.setAttribute("error", ex.getMessage());
				RequestDispatcher dispatch=request.getRequestDispatcher("customerdetails.jsp");
				dispatch.forward(request, response);
			}
		}
		else
		{
			int accountId=Integer.parseInt(request.getParameter("accountId"));
			try
			{
				logic.setAccountState(customerId, accountId, false);
				request.setAttribute("AccountList", logic.getAccountList(true));
				RequestDispatcher dispatch=request.getRequestDispatcher("adminhomepage.jsp");
				dispatch.forward(request, response);
			}
			catch(CustomException e)
			{
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
				RequestDispatcher dispatch=request.getRequestDispatcher("adminhomepage.jsp");
				dispatch.forward(request, response);
			}
		}
	}
}