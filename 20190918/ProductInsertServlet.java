/*
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductInsert.do")
public class ProductInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductMgrImpl mgr = new ProductMgrImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productnum =  request.getParameter("productnum");
		int price =  Integer.parseInt(request.getParameter("price"));
		String description =  request.getParameter("description");
		
		Product product = new Product(productnum, price, description);
	
		try {
			mgr.add(product);
			response.sendRedirect("productSearch.do?productnum="+productnum);
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("productSearch.jsp");
			
		}
	}
	
}
*/