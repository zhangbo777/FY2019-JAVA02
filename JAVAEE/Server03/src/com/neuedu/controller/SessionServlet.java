package com.neuedu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.pojo.ServiceResponse;
import com.neuedu.service.IAdminService;
import com.neuedu.service.impl.IAdminServiceImpl;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		String JESSIONID=session.getId();
		Cookie[] cookies=request.getCookies();
		String username=null;
		String password=null;
		if(cookies!=null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie=cookies[i];
				String cookie_user=cookie.getName();
				String cookie_pas=cookie.getValue();
				if(cookie_user.equals("username")) {
					username=cookie_pas;
				}
				if(cookie_user.equals("password")) {
					password=cookie_pas;
				}
			}
		}
		if(username!=null&&password!=null) {
			IAdminService ser=IAdminServiceImpl.getuservice();
			ServiceResponse server1=ser.Testup(username,password);
			response.getWriter().write(server1.objtostr());
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
