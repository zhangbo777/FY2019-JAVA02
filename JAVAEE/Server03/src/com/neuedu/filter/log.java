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

/**
 * Servlet Filter implementation class log
 */
@WebFilter({"/student","/Course"})
public class log implements Filter {

    /**
     * Default constructor. 
     */
    public log() {
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
		Admin admin=(Admin)session.getAttribute("user");
		if(admin==null) {
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
