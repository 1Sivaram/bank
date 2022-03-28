package com.bank.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import info.AccountInfo;
import logic.ApiLayer;
import myException.CustomException;
import validateclass.Checker;

/**
 * Servlet implementation class TransferMoney
 */
@WebServlet("/TransferMoney")
public class TransferMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferMoney() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String condition="";
		try
		{
			
			ApiLayer logic=(ApiLayer) request.getServletContext().getAttribute("api");
			condition=request.getParameter("data");
			Checker.nullCheck(condition);
			String fromId=request.getParameter("fromAccountId");
			Checker.nullCheck(fromId);
			int fromAccountID=Integer.parseInt(fromId);
			String toId=request.getParameter("toAccountId");
			Checker.nullCheck(toId);
			int toAccountID=Integer.parseInt(toId);
			String data=request.getParameter("amount");
			Checker.nullCheck(data);
			double amount=Double.parseDouble(data);
		//	System.out.println("accId"+fromAccountID);
			int max=logic.getAccountId();
			if(fromAccountID<=max&&toAccountID<=max&&fromAccountID!=toAccountID)
			{
				int fromCustomerId=logic.getCustomerId(fromAccountID);
				int toCustomerId=logic.getCustomerId(toAccountID);
				logic.withdraw(fromCustomerId, fromAccountID, amount);
				logic.deposit(toCustomerId, toAccountID, amount);
			}
			else
			{
				throw new CustomException("Invalid AccountId's");
			}
			
			if(condition.equals("admin"))
			{
				List<AccountInfo> list=logic.getAccountList(true);
				request.setAttribute("AccountList",list);
				RequestDispatcher dispatch=request.getRequestDispatcher("adminhomepage.jsp");
				dispatch.forward(request, response);
			}
			else
			{
				HttpSession session=request.getSession();
				int customerId=(int) session.getAttribute("session");
				Map <Integer,AccountInfo> map=logic.getCustomerAccounts(customerId);
				request.setAttribute("AccountMap",map);
				RequestDispatcher dispatch=request.getRequestDispatcher("userhomepage.jsp");
				dispatch.forward(request, response);
			}
		}
		catch(CustomException e)
		{
			request.setAttribute("error", e.getMessage());
			RequestDispatcher dispatch=request.getRequestDispatcher("transfer.jsp?username="+condition);
			dispatch.forward(request, response);
			e.printStackTrace();
		}
	}

}