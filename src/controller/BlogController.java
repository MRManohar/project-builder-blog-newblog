package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Blog;
import model.User;




@WebServlet(urlPatterns= {"/blog"})
public class BlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BlogController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String blogDetails = request.getParameter("selectedAnswers");
		String[] blogData = blogDetails.split(",");
		String blogTitle = blogData[0];
		String blogDescription = blogData[1];
		LocalDate blodDate = LocalDate.now();
		
		
		Blog blog = new Blog(blogTitle,blogDescription,blodDate);
		blog.setBlogTitle(blogTitle);
		blog.setBlogDescription(blogDescription);
		blog.setDate(blodDate);
		
		System.out.println("Blog Title: "+blog.getBlogTitle());
		System.out.println("Blog Description: "+blog.getBlogDescription());
		System.out.println("Posted on: "+blog.getDate());
		
		
		if(blog!=null) {
			request.setAttribute("blog", blog);
			User user = null;
			request.setAttribute("user",user);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
			rd.forward(request, response);
		}	
	}

}
