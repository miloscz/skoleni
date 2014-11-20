package cz.unicorn.mongo.rest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.gridfs.GridFSDBFile;
import com.sun.jersey.spi.dispatch.RequestDispatcher;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/candidate/getImage")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DbUtil util = DBConnect.getInstance();
		String id = request.getParameter("id");
		
		GridFSDBFile image = util.getImage(id);
		if (image != null) {
		
		InputStream input = image.getInputStream();
		OutputStream output =  response.getOutputStream();
		  
		byte[] buffer = new byte[1024]; // Adjust if you want
	    int bytesRead;
	    while ((bytesRead = input.read(buffer)) != -1)
	    {
	        output.write(buffer, 0, bytesRead);
	    }
		}
		try {
	    javax.servlet.RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
		}
		catch (Exception e) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		
		
		
	}

}
