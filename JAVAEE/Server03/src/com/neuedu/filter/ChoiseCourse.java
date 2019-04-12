package com.neuedu.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.neuedu.pojo.Admin;
import com.neuedu.pojo.ServiceResponse;
import com.neuedu.pojo.Student;

/**
 * Servlet Filter implementation class ChoiseCourse
 */
@WebFilter("/ChoiceCourServlet")
public class ChoiseCourse implements Filter {

    /**
     * Default constructor. 
     */
    public ChoiseCourse() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpServletRequest _request=(HttpServletRequest)request;
		
		PrintWriter pw=response.getWriter();
		HttpSession session=_request.getSession(); 
		System.out.println(session.getId());
		Student stu=(Student)session.getAttribute("student");
		if(stu==null) {
			String responseText=ServiceResponse.createSrByFail(1,"Î´µÇÂ¼").objtostr();
			pw.write(responseText);
			pw.close();
			return;
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
