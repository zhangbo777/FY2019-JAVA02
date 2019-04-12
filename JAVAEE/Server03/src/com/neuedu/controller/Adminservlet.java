package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
import com.neuedu.pojo.ServiceResponse;
import com.neuedu.pojo.Student;
import com.neuedu.service.IAdminService;
import com.neuedu.service.impl.IAdminServiceImpl;

/**
 * Servlet implementation class Adminservlet
 */
@WebServlet("/Adminservlet")
public class Adminservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");*/
		PrintWriter pw = response.getWriter();
		ServletContext servletcontext=request.getServletContext();   //创建全局作用域
		HttpSession session=request.getSession(); 			//会话域
		//session.setMaxInactiveInterval(10);		存活时间  默认半小时
		
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
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			ServiceResponse requsetText = admin.Testup(username, password);
			if(requsetText.isSucess()) {
				session.setAttribute("user", requsetText.getDate());
				
				Cookie username_=new Cookie("username",username);
				username_.setMaxAge(7*24*3600);
				response.addCookie(username_);
				
				Cookie password_=new Cookie("password",password);
				password_.setMaxAge(7*24*3600);
				response.addCookie(password_);
			}
			pw.write(requsetText.objtostr());
			pw.close();
			
		}else if(_operation == Adminenum.ADMIN_REGISTER.getOperation()) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			ServiceResponse ad=admin.Adduser(username, password);
			String responseText=ad.objtostr();
			pw.write(responseText);
			pw.close();
		}else if(_operation == Adminenum.ADMIN_EXIT.getOperation()){
			session.removeAttribute("user");
			
			
		}else if(_operation == Adminenum.ADMIN_STATI.getOperation()){
			Integer total=(Integer)servletcontext.getAttribute("total");
			String ad=ServiceResponse.createSrBySucess("succ", total).objtostr();
			pw.write("当前在线人数："+total);
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

}
