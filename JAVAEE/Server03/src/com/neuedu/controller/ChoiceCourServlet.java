package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.neuedu.pojo.Course;
import com.neuedu.pojo.ServiceResponse;
import com.neuedu.pojo.Student;
import com.neuedu.service.ChoiceCourse;
import com.neuedu.service.impl.ChoiseCourseImpl;

/**
 * Servlet implementation class ChoiceCourServlet
 */
@WebServlet("/ChoiceCourServlet")
public class ChoiceCourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChoiceCourServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Student stu=(Student)session.getAttribute("Student");
		List<Course> li =(List)session.getAttribute("cart");
		
		PrintWriter pw=response.getWriter();
		String operation=request.getParameter("operation");
		if(operation==null) {
			String responseText=ServiceResponse.createSrByFail(3, "参数必传").objtostr();
			
			pw.write(responseText);
			pw.close();
			
		}
		
		
		int _operation=Integer.parseInt(operation);
		if(_operation==1) {//选课
			 
			try {
				//学生选课
			 	ChoiceCourse service=new ChoiseCourseImpl();
				 
			 	 String cid=request.getParameter("cid");
				 ServiceResponse serverResponse= service.choiseCourse(Integer.parseInt(cid), li);
				
				pw.write(serverResponse.objtostr());
			}catch(NumberFormatException e) {
				ServiceResponse responseText=ServiceResponse.createSrByFail(10, "请输入数字格式的课程编号");
				pw.write(responseText.objtostr());
				pw.close();
			}
		}else if(_operation==2) {//查看学生选择的课程
			
			String responseText=ServiceResponse.createSrBySucess("succ", li).objtostr();
			pw.write(responseText);
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
