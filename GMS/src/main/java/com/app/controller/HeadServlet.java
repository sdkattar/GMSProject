package com.app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.HeadDao;
import com.app.model.Head;

@WebServlet("/")
public class HeadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HeadDao dao;   
 

    public void init() {
        dao = new HeadDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        String action = request.getServletPath();

    	        try {
    	            switch (action) {
    	                case "/new":
    	                    showNewForm(request, response);
    	                    break;
    	                case "/insert":
    	                    insertHead(request, response);
    	                    break;
    	                case "/delete":
    	                    deleteHead(request, response);
    	                    break;
    	                case "/edit":
    	                    showEditForm(request, response);
    	                    break;
    	                case "/update":
    	                    updateHead(request, response);
    	                    break;
    	                default:
    	                    listHead(request, response);
    	                    break;
    	            }
    	        } catch (SQLException ex) {
    	            throw new ServletException(ex);
    	        }
    	    }

    private void listHead(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    	        String role = "HEAD";
				List <Head> listHead = dao.selectAllHeads(role);
    	        request.setAttribute("listHead", listHead);
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("headList.jsp");
    	        dispatcher.forward(request, response);
    	    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("addHead.jsp");
    	        dispatcher.forward(request, response);
    	    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, ServletException, IOException {
    	        int userid = Integer.parseInt(request.getParameter("userid"));
    	        Head existingHead = dao.selectHead(userid);
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("addHead.jsp");
    	        request.setAttribute("head", existingHead);
    	        dispatcher.forward(request, response);

    	    }
    private void insertHead(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException {
    	        String name = request.getParameter("name");
    	        String email = request.getParameter("email");
    	        String phone = request.getParameter("phone");
//    	        String password = request.getParameter("password");
   	        String role = request.getParameter("role");
    	        Head newHead = new Head(name, email, phone,role);
    	        dao.registerHead(newHead);
    	        response.sendRedirect("list");
    	    }
    
    private void updateHead(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int userid = Integer.parseInt(request.getParameter("userid"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        Head head = new Head(userid, name, email, phone);
        dao.updateHead(head);
        response.sendRedirect("list");
    }
    
    private void deleteHead(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException {
    	        int userid = Integer.parseInt(request.getParameter("userid"));
    	        dao.deleteHead(userid);
    	        response.sendRedirect("list");

    	}
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
