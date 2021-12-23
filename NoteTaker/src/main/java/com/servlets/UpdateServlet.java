package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Note;
import com.helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try
	{
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		Session s=FactoryProvider.getFactory().openSession();
		Transaction tx=s.beginTransaction();
		 int id=Integer.parseInt(request.getParameter("noteId").trim());
		Note note=(Note)s.get(Note.class,id);
	note.setTitle(title);
	note.setContent(content);
	note.setAddedDate(new Date());
	

	    tx.commit();	
		s.close();
		
		response.sendRedirect("all_notes.jsp");
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	
	
	}

}
