

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/productSearch.do")
public class productSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     //String productnum, int price, String description) {
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String productnum =  request.getParameter("productnum");
		String price =  request.getParameter("price");
		String description =  request.getParameter("description");
		
		try {
			request.setAttribute("productnum", productnum);
			request.setAttribute("price", price);
			request.setAttribute("description", description);
			
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			
		}
		request.getRequestDispatcher("productsearch.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
