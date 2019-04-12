package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.neuedu.enumeration.Adminenum;
import com.neuedu.pojo.ServiceResponse;
import com.neuedu.service.IAdminService;
import com.neuedu.service.impl.IAdminServiceImpl;

/**
 * Servlet implementation class studentservlet
 */
@WebServlet("/student")
public class studentservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentservlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		String operation=request.getParameter("operation");
		if(operation==null) {
			String responseText="{\"status\":3,\"msg\":\"operation必须传递参数\"}";
			pw.write(responseText);
			pw.close();
		}
		try {
			int _operation=Integer.parseInt(operation);
			
			if(_operation==1) {//查看全部学生
				IAdminService adc=IAdminServiceImpl.getuservice();
				ServiceResponse ad=adc.seeall();
				pw.write(ad.objtostr());
				pw.close();
		
			}else if(_operation==2){//查看某个学生
				
				IAdminService adc=IAdminServiceImpl.getuservice();
				String idd = request.getParameter("id");
				System.out.println(idd);
				int id = Integer.parseInt(idd);
				ServiceResponse ad=adc.seeone(id);
				pw.write(ad.objtostr());
				pw.close();
				
			}else if(_operation==3) {//添加学生
				IAdminService adc=IAdminServiceImpl.getuservice();
				String _id=request.getParameter("id");
				int id =Integer.parseInt(_id);
				String name=request.getParameter("name");
				String sex=request.getParameter("sex");
				String _age=request.getParameter("age");
				int age =Integer.parseInt(_age);
				String _class=request.getParameter("class");
				String address=request.getParameter("address");
				String phone=request.getParameter("phone");
				String email=request.getParameter("email");
				String _score=request.getParameter("score");
				int score =Integer.parseInt(_score);
				ServiceResponse ad=adc.addstudent(id, name, sex, age, _class, address, phone, email, score);
				pw.write(ad.objtostr());
				pw.close();
				
			}else if(_operation==4) {//删除学生
				IAdminService adc=IAdminServiceImpl.getuservice();
				String _id=request.getParameter("id");
				int id =Integer.parseInt(_id);
				ServiceResponse ad=adc.delestudent(id);
				pw.write(ad.objtostr());
				pw.close();
			}else if(_operation==5) {
				IAdminService adc=IAdminServiceImpl.getuservice();
				String _id=request.getParameter("id");
				String name=request.getParameter("name");
				int id =Integer.parseInt(_id);
				ServiceResponse ad=adc.Modistudent(id,name);
				pw.write(ad.objtostr());
				pw.close();
				
			}
		}catch(NumberFormatException c) {
			String responseText="{\"status\":4,\"msg\":\"operation不能传非数字\"}";
			pw.write(responseText);
			pw.close();
		} 
	}

}
