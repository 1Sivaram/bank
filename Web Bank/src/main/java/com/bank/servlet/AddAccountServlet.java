package com.bank.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.AccountInfo;
import logic.ApiLayer;
import myException.CustomException;
import validateclass.Checker;

/**
 * Servlet implementation class AddAccountServlet
 */
@WebServlet("/AddAccountServlet")
public class AddAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAccountServlet() {
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
		try
		{
			AccountInfo accountObj=new AccountInfo();
			String data=request.getParameter("customerId");
			Checker.nullCheck(data);
			int customerId=Integer.parseInt(data);
			String amount=request.getParameter("bankBalance");
			Checker.nullCheck(amount);
			double balance=Double.parseDouble(amount);
			String branch=request.getParameter("branchName");
			Checker.nullCheck(branch);
			accountObj.setCustomerId(customerId);
			accountObj.setBankBalance(balance);
			accountObj.setBranchName(branch);
			
			ApiLayer logic=(ApiLayer) request.getServletContext().getAttribute("api");
			if(request.getParameter("accountId")==null)
			{
				logic.putAccountDetails(accountObj);
			}
			else
			{
				int accountId=Integer.parseInt(request.getParameter("accountId"));
				accountObj.setAccountId(accountId);
				if(customerId<=logic.getCustomerId())
				{
					logic.updateAccountDetails(accountId,accountObj);
				}
				else
				{
					throw new CustomException("No Account found for this CustomerId");
				}
			}
			request.setAttribute("AccountList",logic.getAccountList(true));
			RequestDispatcher dispatch=request.getRequestDispatcher("adminhomepage.jsp");
			dispatch.forward(request, response);
		}
		catch (CustomException e) 
		{
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher dispatch=request.getRequestDispatcher("addaccount.jsp");
			dispatch.forward(request, response);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

}