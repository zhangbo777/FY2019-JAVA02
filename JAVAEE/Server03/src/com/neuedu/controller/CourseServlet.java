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
import com.neuedu.service.ICourse;
import com.neuedu.service.impl.ICourseImpl;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/Course")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String operation=request.getParameter("operation");
		if(operation==null) {
			String responseText=ServiceResponse.createSrByFail(3, "�����ش�").objtostr();
			
			pw.write(responseText);
			pw.close();
			
		}
		ICourse service=ICourseImpl.getinstan();
		
		//string-int 
		try {
			int _operation=Integer.parseInt(operation);
			
		    if(_operation==Adminenum.COURSE_ADD.getOperation()) {//��ӿγ�
		    	
		    	String cid=request.getParameter("cid");
		    	try {
		    		int _cid=Integer.parseInt(cid);
		    		String cname=request.getParameter("cname");
		    		
		    		ServiceResponse serverResponse=service.addcourse(_cid, cname);
		    
		    		pw.write(serverResponse.objtostr());
		    	}catch(NumberFormatException e) {
		    		
		    		String responseText="{\"status\":4,\"msg\":\"operation�������������� \"}";
					pw.write(responseText);
					pw.close();
		    		
		    	}
		    	
		    }else if(_operation==Adminenum.COURSE_DELETE.getOperation()) {//ɾ���γ�
		    	String cid=request.getParameter("cid");
		    	try {
		    		int _cid=Integer.parseInt(cid);
		    		ServiceResponse serverResponse=service.deletecourse(_cid);
		    		pw.write(serverResponse.objtostr());
		    	}catch(NumberFormatException e) {
		    		
		    		String responseText="{\"status\":4,\"msg\":\"operation�������������� \"}";
					pw.write(responseText);
					pw.close();
		    		
		    	}
		    	
		    	
		    }else if(_operation==Adminenum.COURSE_MODI.getOperation()) {//�޸Ŀγ�
		    	
		    	String cid=request.getParameter("cid");
		    	try {
		    		int _cid=Integer.parseInt(cid);
		    		String cname=request.getParameter("cname");
		    		ServiceResponse serverResponse=service.modicourse(_cid, cname);
		    		pw.write(serverResponse.objtostr());
		    	}catch(NumberFormatException e) {
		    		
		    		String responseText="{\"status\":4,\"msg\":\"operation�������������� \"}";
					pw.write(responseText);
					pw.close();
		    		
		    	}
		    	
		    }else if(_operation==Adminenum.COURSE_SEE.getOperation()) {//�鿴�γ�
		    	
		    	ServiceResponse serverResponse=service.seecourse();
		    	pw.write(serverResponse.objtostr());
				pw.close();
		    }
		}catch(NumberFormatException e) {
			 //���ؿͻ�����operation����������
			String responseText="{\"status\":4,\"msg\":\"operation�������������� \"}";
			pw.write(responseText);
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
