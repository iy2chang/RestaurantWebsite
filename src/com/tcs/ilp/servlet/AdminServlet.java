package com.tcs.ilp.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.tcs.ilp.bean.Admin;
import com.tcs.ilp.bean.Bill;
import com.tcs.ilp.bean.Menu;
import com.tcs.ilp.bean.Order;
import com.tcs.ilp.dao.AdminDao;
import com.tcs.ilp.dao.MenuDao;
import com.tcs.ilp.dao.OrderDAO;


/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("doPost");
		HttpSession session = request.getSession(true);

		String page = request.getParameter("page");
		if (page.equals("adminLogin"))
		{
			String user = request.getParameter("username").trim();
			String password = request.getParameter("password").trim();
			System.out.println(user + " " + password);
			if(request.getParameter("submit") != null){
				Admin a = new Admin();
				a.setAdmin_id(user);
				a.setAdmin_password(password);
				AdminDao ad = new AdminDao();
				a = ad.adminLoginCheck(a);
				if(a.isValid()){

					session.setAttribute("username", user);
					System.out.println("you have logged in");
					RequestDispatcher rd = request.getRequestDispatcher("/Jsp/admin_page.jsp");
					rd.forward(request, response);
				}
				else{
					System.out.println("wrong logged in");
					RequestDispatcher rd = request.getRequestDispatcher("/Jsp/adminLoginFail.jsp");
					rd.forward(request, response);
				}
			}	

		}


		if (page.equals("adminLogout")){
			request.getSession(false).removeAttribute("username");

			request.getSession(false).invalidate();

			//	RequestDispatcher rd = request.getRequestDispatcher("Jsp/admin_login.jsp");
			//rd.forward(request, response);
			response.sendRedirect("Jsp/admin_login.jsp");
		}

		else if (page.equals("addMenu"))
		{

			String menuCategory = request.getParameter("MenuCategory");
			String menuItem = request.getParameter("MenuItem");
			String menuDescription = request.getParameter("MenuDescription");
			String price = request.getParameter("MenuPrice");

			double menuPrice = Double.parseDouble(price);

			ArrayList <Menu> menulist = new ArrayList<Menu>();

			Menu menu = new Menu(menuCategory, menuItem, menuDescription, menuPrice);

			MenuDao menudao = new MenuDao();
			int addedMenuItem = menudao.addMenu(menu);




			if(addedMenuItem >= 1){

				menulist = menudao.viewAllMenu();

				request.setAttribute("list", menulist);

				RequestDispatcher rd = request.getRequestDispatcher("Jsp/adminViewMenuItem.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("Jsp/adminUnsuccessfulMenuAddition.jsp");
				rd.forward(request, response);
			}

		}

		else if (page.equals("deleteMenu")) {


			String menuItem = request.getParameter("MenuItem");


			MenuDao menudao = new MenuDao();
			int deletedAccount = menudao.deleteMenu(menuItem);


			if(deletedAccount >= 0){
				RequestDispatcher rd = request.getRequestDispatcher("Jsp/adminSuccessfulDelete.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("Jsp/adminUnuccessfulDelete.jsp");
				rd.forward(request, response);
			}


		}

		else if (page.equals("updateMenu")) {

			String menuItem = request.getParameter("MenuItem");


			MenuDao menudao = new MenuDao();
			Menu menu = menudao.viewMenu(menuItem);

			request.setAttribute("category", menu.getCategory());
			request.setAttribute("item", menu.getItem());
			request.setAttribute("description", menu.getDescription());
			request.setAttribute("price", menu.getPrice());



			RequestDispatcher rd = request.getRequestDispatcher("Jsp/adminUpdateMenuDetails.jsp");
			rd.forward(request, response);

		}

		else if (page.equals("updateMenuDetails")) {

			String menuItem = request.getParameter("MenuItem");
			String menuCategory = request.getParameter("MenuCategory");
			String menuDescription = request.getParameter("MenuDescription");
			String price = request.getParameter("MenuPrice");

			double menuPrice = Double.parseDouble(price);

			MenuDao menudao = new MenuDao();
			Menu menu = new Menu(menuCategory, menuItem, menuDescription, menuPrice);

			int updateMenu = menudao.updateMenu(menu);


			if(updateMenu >= 1){
				RequestDispatcher rd = request.getRequestDispatcher("Jsp/adminSuccessfulUpdate.jsp");
				rd.forward(request, response);

			}

			else {
				RequestDispatcher rd = request.getRequestDispatcher("Jsp/adminUnuccessfulUpdate.jsp");
				rd.forward(request, response);
			}

		}

		else if (page.equals("viewallMenu")) {

			ArrayList <Menu> menulist = new ArrayList<Menu>();

			MenuDao menudao = new MenuDao();

			menulist = menudao.viewAllMenu();

			request.setAttribute("list", menulist);

			RequestDispatcher rd = request.getRequestDispatcher("Jsp/adminViewMenuItem.jsp");
			rd.forward(request, response);
		}

		else if (page.equals("viewOrders")){
			System.out.println("view orders clicekd");
			ArrayList <Order> orderList = new ArrayList<Order>();

			String sort = request.getParameter("sort");
			/*	String area = request.getParameter("area");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String orderNumber = request.getParameter("orderNumber");*/

			//Order allOrders = new Order();

			OrderDAO od = new OrderDAO();
			orderList = od.getAllOrders(sort);

			request.setAttribute("allOrders", orderList);
			RequestDispatcher rd = request.getRequestDispatcher("Jsp/adminViewAllOrderDisplay.jsp");
			rd.forward(request, response);
			for(Order s: orderList){
				System.out.println("qual: " +s.getQuantity());
				System.out.println("addr: " + s.getAddress());
				System.out.println("deli: " + s.getDeliveryDate());
				System.out.println("pay: " + s.getPaymentType());
				System.out.println("price: " + s.getPrice());
				System.out.println("orderId: " + s.getOrderId());
				System.out.println("userId: " + s.getUserId());
				System.out.println("customer: " + s.getCustomerName());
			}
		}	

		else if(page.equals("viewOrderCustomer")){
			System.out.println("view Order Customer clicked");
			String name = request.getParameter("CustomerName");
			System.out.println("name: " + name);
			ArrayList <Order> orderList = new ArrayList<Order>();
			OrderDAO od = new OrderDAO();
			orderList = od.getCustomerOrders(name);
			request.setAttribute("customerOrders", orderList);
			RequestDispatcher rd = request.getRequestDispatcher("Jsp/adminViewCustomerOrderResult.jsp");
			rd.forward(request, response);
			for(Order s: orderList){
				System.out.println("qual: " +s.getQuantity());
				System.out.println("addr: " + s.getAddress());
				System.out.println("deli: " + s.getDeliveryDate());
				System.out.println("pay: " + s.getPaymentType());
				System.out.println("price: " + s.getPrice());
				System.out.println("orderId: " + s.getOrderId());
				System.out.println("userId: " + s.getUserId());
				System.out.println("customer: " + s.getCustomerName());
			}
		}

		else if(page.equals("generateOrderCustomer")){
			System.out.println("generate order clicked");
			String name = request.getParameter("CustomerName");
			String address = request.getParameter("DeliveryAddress");
			long c = Long.parseLong(request.getParameter("CellNumber"));

			String menu = request.getParameter("MenuItem");
			String quantity = request.getParameter("Quantity");
			String strDate = request.getParameter("DeliveryDate");
			DateFormat formater;
			Date date = null;
			formater = new SimpleDateFormat("M/dd/yyyy");

			java.util.Date d = null;
			try {
				d = formater.parse(strDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			date = new Date(d.getTime());

			Order o = new Order();
			o.setCustomerName(name);
			o.setAddress(address);
			o.setCellNumber(c);
			o.setQuantity(menu+quantity);
			o.setDeliveryDate(date);						
			OrderDAO od = new OrderDAO();
			System.out.print(od.generateOrder(o));
			request.setAttribute("generateOrders", o);
			RequestDispatcher rd = request.getRequestDispatcher("Jsp/adminGenerateOrderView.jsp");
			rd.forward(request, response);
		}

		else if(page.equals("genBill")){
			System.out.println("generate bill clicked");
			int name = Integer.parseInt(request.getParameter("name"));
			OrderDAO od = new OrderDAO();
			Order o;
			o = od.generateBill(name);
			Bill b = od.getBill(o.getOrderId());
			// check today's date
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date today = new java.util.Date();
			
			String now = dateFormat.format(today).toString();
			
			request.setAttribute("currentDate", now);
			request.setAttribute("bill", b);
			System.out.println("today: " + now);
			
			System.out.println("sql date: " + b.getDelivery_date().toString());
			if(!(b.getDelivery_date().toString().equals(now))){
				System.out.println("delivery:" + b.getDelivery_date());
				RequestDispatcher rd = 
						request.getRequestDispatcher("Jsp/adminGenerateBillFail.jsp");
				rd.forward(request, response);
			}
			else{
				RequestDispatcher rd = 
						request.getRequestDispatcher("Jsp/adminGenerateBillView.jsp");
				rd.forward(request, response);
				System.out.print("quantity: " + b.getQuantity());
				System.out.print("delivery address: " + b.getDelivery_address() );
				System.out.print("delivery date: " + b.getDelivery_date());
				System.out.print("payment type: " + b.getPayment_type() );
				System.out.print("price " + b.getPrice());
				System.out.print("order id: " + b.getOrders_id());
				System.out.print("user id: " + b.getUser_id());
				System.out.print("customer name: " + b.getCustomer_name());
				System.out.print("customer address: " + b.getAddress());
				System.out.print("zip code: " + b.getZipCode());
				System.out.print("land mark: " + b.getLandMark());
				System.out.print("cell number: " + b.getCell_number());
				System.out.print("email: " + b.getEmail());
			}

		}

	}
}


