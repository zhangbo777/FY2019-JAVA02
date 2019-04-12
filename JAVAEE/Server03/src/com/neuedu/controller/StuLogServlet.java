package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.enumeration.Adminenum;
import com.neuedu.pojo.Admin;
import com.neuedu.pojo.Course;
import com.neuedu.pojo.ServiceResponse;
import com.neuedu.service.IAdminService;
import com.neuedu.service.impl.IAdminServiceImpl;

/**
 * Servlet implementation class StuLogServlet
 */
@WebServlet("/StuLogServlet")
public class StuLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuLogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		ServletContext servletcontext=request.getServletContext();   
		//session.setMaxInactiveInterval(10);	
		
		IAdminService admin = new IAdminServiceImpl();
		
		String operation = request.getParameter("operation");
		
		try {
			if(operation == null) {
				String responseText =ServiceResponse.createSrByFail(3,"operation不能为空").objtostr();
				pw.write(responseText);
				pw.close();
		}
		int _operation =Integer.parseInt(operation);
		if(_operation == Adminenum.ADMIN_LOGIN.getOperation()) {
			
			String _username = request.getParameter("username");
			int username =Integer.parseInt(_username);
			String password = request.getParameter("password");
			ServiceResponse requsetText = admin.Testup1(username, password);
			if(requsetText.isSucess()) {
				HttpSession session = request.getSession();
				System.out.println(session.getId());
				session.setAttribute("student", requsetText.getDate());
				session.setAttribute("cart",new ArrayList<Course>());
			}
			pw.write(requsetText.objtostr());
			pw.close();
			
			
		}else if(_operation == Adminenum.ADMIN_REGISTER.getOperation()) {
			String _username = request.getParameter("username");
			int username =Integer.parseInt(_username);
			String password = request.getParameter("newpassword");
			ServiceResponse ad=admin.Modipas(username, password);
			String responseText=ad.objtostr();
			pw.write(responseText);
			pw.close();
		}else {
			//返回客户端，必须输入数字
			String responseText =ServiceResponse.createSrByFail(11,"请输入相应的数字").objtostr();
			pw.write(responseText);
			pw.close();
		}
		}
		catch(NumberFormatException e) {
			ServiceResponse responseText=ServiceResponse.createSrByFail(10, "operation参数必须是数字");
			pw.write(responseText.objtostr());
			pw.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
