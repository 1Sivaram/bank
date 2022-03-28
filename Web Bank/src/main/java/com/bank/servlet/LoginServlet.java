package com.bank.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import info.AccountInfo;
import info.UserDetails;
import logic.ApiLayer;
import myException.CustomException;
import validateclass.Checker;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) {
		try {
			ApiLayer logic = new ApiLayer(true);
			config.getServletContext().setAttribute("api", logic);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		if (session != null) 
		{
			session.invalidate();
			RequestDispatcher dispatch = request.getRequestDispatcher("loginpage.jsp");
			dispatch.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		try 
		{
			String uid = request.getParameter("uid");
			Checker.nullCheck(uid);
			int id = Integer.parseInt(uid);
			String password = request.getParameter("Password");
			Checker.nullCheck(password);
			
			ApiLayer logic = (ApiLayer) request.getServletContext().getAttribute("api");
			UserDetails userObj = logic.getUserDetails(id);
			if (userObj != null && password.equals(userObj.getPassword())) 
			{
				if (userObj.getRoleId() == 2) 
				{
					HttpSession session = request.getSession();
					session.setAttribute("session", "session");
					request.setAttribute("AccountList", logic.getAccountList(true));
					RequestDispatcher dispatch = request.getRequestDispatcher("adminhomepage.jsp");
					dispatch.forward(request, response);
				} 
				else 
				{
					int customerId = userObj.getCustomerId();
					HttpSession session = request.getSession();
					session.setAttribute("session", customerId);
					Map<Integer, AccountInfo> map = logic.getCustomerAccounts(customerId);
					request.setAttribute("AccountMap", map);
					RequestDispatcher dispatch = request.getRequestDispatcher("userhomepage.jsp");
					dispatch.forward(request, response);
				}
			} 
			else 
			{
				request.setAttribute("error", "Invalid UserName or Password");
				RequestDispatcher dispatch = request.getRequestDispatcher("loginpage.jsp");
				dispatch.forward(request, response);
			}
		}
		catch (CustomException e)
		{
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher dispatch=request.getRequestDispatcher("loginpage.jsp");
			dispatch.forward(request, response);
		} 
		catch (Exception e) 
		{
			System.out.println("Excepiton");
			RequestDispatcher dispatch = request.getRequestDispatcher("error.jsp");
			dispatch.forward(request, response);
			e.printStackTrace();
		}

	}
	
//	private String toHash(String passwordToHash)
//	{
//	    String generatedPassword ="";
//
//	    try 
//	    {
//	      // Create MessageDigest instance for MD5
//	      MessageDigest md = MessageDigest.getInstance("MD5");
//
//	      // Add password bytes to digest
//	      md.update(passwordToHash.getBytes());
//
//	      // Get the hash's bytes
//	      byte[] bytes = md.digest();
//
//	      // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
//	      StringBuilder sb = new StringBuilder();
//	      for (int i = 0; i < bytes.length; i++) {
//	        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
//	      }
//
//	      // Get complete hashed password in hex format
//	      generatedPassword = sb.toString();
//	    } catch (NoSuchAlgorithmException e) {
//	      e.printStackTrace();
//	    }
//	   // System.out.println(generatedPassword);
//	    return generatedPassword;
//	}
	

}