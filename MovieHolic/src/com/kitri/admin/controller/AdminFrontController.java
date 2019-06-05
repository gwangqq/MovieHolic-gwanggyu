package com.kitri.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.util.MoveUrl;

@WebServlet("/admin")
public class AdminFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getParameter("act");
		String notify = request.getParameter("notify");
		String path = "/page/admin/management.jsp";
		
//		System.out.println( " notify = " + notify);
//		System.out.println( " act = " + act);
		
		
		
		
		

		if ("notify".equals(notify) && "alllist".equals(act)) { // 다른 페이지에서 management 들어올때.
			
			int cnt = 1; 
			path = AdminController.getAdminController().NFandAll(request, response,cnt);
			MoveUrl.forward(request, response, path);
			
		} else if ("notify".equals(notify)) {
			
			path = AdminController.getAdminController().NFselectByList(request, response);
			MoveUrl.forward(request, response, path);
			
		} else if ("alllist".equals(act)) {
			
			int cnt = 1;
			path = AdminController.getAdminController().selectByUserList(request, response, cnt);
			MoveUrl.forward(request, response, path);

		} else if ("inactiveList".equals(act)) {
			
			int cnt = 2;
			path = AdminController.getAdminController().selectByUserList(request, response, cnt);
			MoveUrl.forward(request, response, path);

		} else if ("unsubscribelist".equals(act)) {

			int cnt = 3;
			path = AdminController.getAdminController().selectByUserList(request, response, cnt);
			MoveUrl.forward(request, response, path);
			
		}  else {
			
			int cnt = 4;
			path = AdminController.getAdminController().selectByUserList(request, response, cnt);
			MoveUrl.forward(request, response, path);
			
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("management에서 FrontController post로 들어옴.");

		doGet(request, response);
	}

}
