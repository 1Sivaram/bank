package com.bank.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.CustomerInfo;
import logic.ApiLayer;
import myException.CustomException;
import validateclass.Checker;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			CustomerInfo customerObj=new CustomerInfo();
			String data=request.getParameter("mobile");
			Checker.nullCheck(data);
			long mobile=Long.parseLong(data);
			String name=request.getParameter("customerName");
			Checker.nullCheck(name);
			String address=request.getParameter("address");
			Checker.nullCheck(address);
			customerObj.setCustomerName(name);
			customerObj.setAddress(address);
			customerObj.setMobile(mobile);
			ApiLayer logic=(ApiLayer) request.getServletContext().getAttribute("api");
			
			if(request.getParameter("customerId")==null)
			{
				logic.putCustomerDetails(customerObj);
			}
			else
			{
				int customerId=Integer.parseInt(request.getParameter("customerId"));
				customerObj.setCustomerId(customerId);
				logic.updateCustomerDetails(customerId,customerObj);
			}
			request.setAttribute("CustomerList",logic.getCustomerList(true));
			RequestDispatcher dispatch=request.getRequestDispatcher("customerdetails.jsp");
			dispatch.forward(request, response);
		}
		catch (CustomException e) 
		{
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher dispatch=request.getRequestDispatcher("addcustomer.jsp");
			dispatch.forward(request, response);;
		}
	}

}