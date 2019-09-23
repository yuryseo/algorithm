package com.ssafy.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.dao.ItemDAOImp;
import com.ssafy.model.dto.Item;
import com.ssafy.model.service.ItemService;
import com.ssafy.model.service.ItemServiceImp;
import com.ssafy.model.service.MemberService;
import com.ssafy.model.service.MemberServiceImp;

@WebServlet("*.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImp();
	private ItemService itemService = new ItemServiceImp();
	private ItemDAOImp dao = new ItemDAOImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "index.jsp";
		String action = request.getServletPath();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			if (action != null) {
				if (action.endsWith("login.do")) {
					url = login(request, response);
				} else if (action.endsWith("logout.do")) {
					url = logout(request, response);
				} else if (action.endsWith("iteminsert.do")) {
					url = insertItem(request, response);
				} else if (action.endsWith("itemdelete.do")) {
					url = removeItem(request, response);
				}else if (action.endsWith("itemlist.do")){
					url = listItem(request, response);
				} else if (action.endsWith("itemlast.do")){
					url = lastItem(request, response);
				}else if (action.endsWith("searchprice.do")){
					url = SearchPrice(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			url = "ErrorHandler.jsp";
		}
		if (url.startsWith("redirect")) {
			response.sendRedirect(url.substring(url.indexOf(":") + 1));
		} else {
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
	



	private String lastItem(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		String id = (String) session.getAttribute("id");
		String name = "";
		if(cookies!=null){
			for(Cookie cookie: cookies){
				if(cookie.getName().equals(id)){
					name = cookie.getValue();
				}
			}
		}
		if(!name.equals("")) {
			Item item = itemService.search(name);
			request.setAttribute("last", item);
		}
		return "lastItem.jsp";
	}
	
	private String SearchPrice(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int price = Integer.parseInt(request.getParameter("price"));
		
		List<Item> item = itemService.searchPrice(price);
		request.setAttribute("item", item);
		System.out.println(price);
		return "ListItem.jsp";
	}
	
	private String listItem(HttpServletRequest request, HttpServletResponse response) {
		List<Item> item =  itemService.searchAll();
		request.setAttribute("item", item);
		return "ListItem.jsp";
	}
	
	private String removeItem(HttpServletRequest request, HttpServletResponse response) {
		
		String name = request.getParameter("name");
		itemService.remove(name);
		
		return "redirect:index.jsp";
	}

	
	private String insertItem(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String desc = request.getParameter("desc");
		Item item = new Item(name, price, desc);
		itemService.add(item);
		
		// 마지막으로 등록한 아이템 쿠키에  저장
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		Cookie cookie = new Cookie(id, name);
		cookie.setMaxAge(1000000000);
		response.addCookie(cookie);
		return "redirect:index.jsp";
	}

	private String logout(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		session.removeAttribute("id");
		return "redirect:index.jsp";
	}

	private String login(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		try {
			memberService.login(id, password);
			HttpSession session = request.getSession();

			session.setAttribute("id", id);
		} catch(Exception e) {
			request.setAttribute("msg", e.getMessage());
		}
		return "redirect:index.jsp";
	}
}
