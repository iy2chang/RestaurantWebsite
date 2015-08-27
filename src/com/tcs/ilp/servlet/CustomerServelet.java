package com.tcs.ilp.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.ilp.bean.CreditCard;
import com.tcs.ilp.bean.Customer;
import com.tcs.ilp.bean.Menu;
import com.tcs.ilp.bean.CustomerCredentials;
import com.tcs.ilp.bean.Order;
import com.tcs.ilp.dao.CreditCardDAO;
import com.tcs.ilp.dao.CustomerDAO;
import com.tcs.ilp.dao.MenuDao;
import com.tcs.ilp.dao.OrderDAO;
import com.tcs.ilp.dao.UserPassDao;
import com.tcs.ilp.service.GenerateOrder;
import com.tcs.ilp.service.PasswordGenerator;
import com.tcs.ilp.service.UserNameGenerator;

/**
 * Servlet implementation class CustomerServelet
 */
public class CustomerServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type= request.getParameter("page");
		HttpSession session = request.getSession();
		//session.setAttribute("object", obj);
		System.out.println(type);
		if(type.equalsIgnoreCase("viewMenu"))
		{
			//System.out.println("hello");
			
			
			CustomerDAO cu= new CustomerDAO();
			Customer cus=cu.viewCustomer((String)session.getAttribute("user"));
			
			MenuDao mn=new MenuDao();
			ArrayList <Menu> ls= new ArrayList<Menu>();
			ls=mn.viewAllMenu();
			if(ls.isEmpty())
			{
				RequestDispatcher rd = request.getRequestDispatcher("/Jsp/UserMenuFailure.jsp");
				rd.forward(request, response);
			}
			else
			{	request.setAttribute("customer", cus);
				session.setAttribute("list", ls);
				System.out.println(ls.get(0).toString());
				RequestDispatcher rd = request.getRequestDispatcher("/Jsp/viewMenu.jsp");
				rd.forward(request, response);
			}
			
		}
		
		if(type.equalsIgnoreCase("payment"))
		{
			System.out.println("hello placing order");
//			MenuDao mn=new MenuDao();
//			ArrayList <Menu> ls= new ArrayList<Menu>();
//			ls=mn.viewAllMenu();
			String expDate = request.getParameter("expMonth")+"/"+request.getParameter("expYear");
			String oid = (String)session.getAttribute("user_ID"); //request.getParameter("")
			CreditCard cc = new CreditCard(Long.parseLong(request.getParameter("cardNumber")), request.getParameter("cardType"), request.getParameter("name"), request.getParameter("issuer"), expDate, request.getParameter("cvv"), oid);
			CreditCardDAO ccd = new CreditCardDAO();
			int ret = ccd.addCreditCard(cc);
			if(ret <= 0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/Jsp/NewFile.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/Jsp/Welcome.jsp");
				rd.forward(request, response);
			}
			
		}
		
		if(type.equalsIgnoreCase("viewOrders"))
		{
			System.out.println("hello");
			OrderDAO mn=new OrderDAO();
			ArrayList<Order> lsl= new ArrayList<Order>();
			lsl=mn.viewSelectedOrders((String)session.getAttribute("user"));
			System.out.println(lsl.toString());
			System.out.println(session.getAttribute("user"));
			if(lsl.isEmpty())
			{
				RequestDispatcher rd = request.getRequestDispatcher("/Jsp/NoUserOrders.jsp");
				rd.forward(request, response);
			}
			else
			{
				session.setAttribute("deleted","Just Viewing") ;
				request.setAttribute("list", lsl);
				System.out.println(lsl.get(0).toString());
				RequestDispatcher rd = request.getRequestDispatcher("/Jsp/viewOrder.jsp");
				rd.forward(request, response);
			}
			
		}
		if (type.equalsIgnoreCase("customerLogout")){
			request.getSession(false).removeAttribute("user");

			request.getSession(false).invalidate();

			
			response.sendRedirect("Jsp/UserLoginFail.jsp");
		}
		
		if(type.equalsIgnoreCase("deleteupdateOrder"))
		{
			String val= request.getParameter("Command");
			OrderDAO mn=new OrderDAO();
		     if(val.equals("Delete"))
				{
			System.out.println("hello deleting now");
			
			ArrayList<Order> lsl= new ArrayList<Order>();
			int ls=mn.deleteOrder(Integer.parseInt(request.getParameter("oid")));
			System.out.println(request.getParameter("oid"));
			if(ls==0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/Jsp/NoOrder.jsp");
				rd.forward(request, response);
			}
			else
			{
				lsl=mn.viewSelectedOrders((String)session.getAttribute("user"));
				//System.out.println(session.getAttribute("user"));
				if(lsl.isEmpty())
				{
					RequestDispatcher rd = request.getRequestDispatcher("/Jsp/NewFile.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("list", lsl);
					System.out.println(lsl.get(0).toString());
					session.setAttribute("deleted","Order Deleted") ;
//					response.sendRedirect("jsp/viewOrder.jsp");
					RequestDispatcher rd = request.getRequestDispatcher("/Jsp/viewOrder.jsp");
					rd.forward(request, response);
				     // alert("Order Deleted");
				}
				
				
			}
				}
		else
		{
			System.out.println("hello updating now");
			Order ls=mn.getOrder(Integer.parseInt(request.getParameter("oid")));
			if(ls.getOrderId()>0)
			{
				request.setAttribute("ord", ls);
			RequestDispatcher rd = request.getRequestDispatcher("/Jsp/UserOrderUpdate.jsp");
			rd.forward(request, response);
			
		}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/Jsp/UserOrderUpdateFail.jsp");
				rd.forward(request, response);
			}
		}
		}
		
		if(type.equalsIgnoreCase("ulogin"))
		{
			System.out.println("inside");
	UserPassDao up=new UserPassDao();
	String un=request.getParameter("username");
	String pass=request.getParameter("password");
	CustomerCredentials cc=new CustomerCredentials(un,pass);
	//request.setAttribute("user",un);
	int result=up.checkPassword(cc);
	//System.out.println(result);
	if(result==0)
	{
		RequestDispatcher rd = request.getRequestDispatcher("/Jsp/UserLoginFail.jsp");
		rd.forward(request, response);
	}
	else
	{ session.setAttribute("user", un);
	
		RequestDispatcher rd = request.getRequestDispatcher("/Jsp/Welcome.jsp");
		rd.forward(request, response);
	}
	
		}
		//System.out.println(type);
		
		
		if(type.equalsIgnoreCase("registeruser"))
		{
			CustomerDAO up=new CustomerDAO();
			//String um=request.getParameter("email");
	String fn=request.getParameter("name");
	String add =request.getParameter("address");
	String zip=request.getParameter("zipcode");

	Long nu =Long.parseLong(request.getParameter("phonenumber"));

	

	String email=request.getParameter("email");
	String landmark =request.getParameter("Landmark");
	
	Customer cs=new Customer(email,fn,add,zip,email,nu,landmark);
	cs.setId(UserNameGenerator.GenerateUserName(cs));
	int result=up.addCustomer(cs);
	
	
	if(result==0)
	{
		RequestDispatcher rd = request.getRequestDispatcher("../Jsp/UserAddFail.jsp");
		rd.forward(request, response);
	}
	else
	{
		
		UserPassDao upp=new UserPassDao();
		String un=cs.getId();
		String pass2=PasswordGenerator.generatePassword();
		System.out.println(pass2);
		CustomerCredentials cc=new CustomerCredentials(un,pass2);
		upp.addCustomerCredentails(cc);
		request.setAttribute("username", cc);
		RequestDispatcher rd = request.getRequestDispatcher("/Jsp/NewRegisteredCustomer.jsp");
		rd.forward(request, response);
	}
	
		}
		//System.out.println(type);
		
		
	
		if(type.equalsIgnoreCase("updateCustomer"))
			
			
		{
			System.out.println(type);
			Customer cst=(Customer)session.getAttribute("customer");
			String name = cst.getName();
			String address = request.getParameter("address");
			String zip = cst.getZip();
			String landmark = cst.getLandmark();
			long cellnumber = Long.parseLong(request.getParameter("cellnumber"));
			String email = cst.getEmail();
			String un=(String)session.getAttribute("user");
			//double menuPrice = Double.parseDouble(price);

			CustomerDAO cust = new CustomerDAO();
			Customer c = new Customer(un, name, address, zip,landmark,cellnumber,email);

			int updateMenu = cust.updateCustomer(c);


			if(updateMenu >= 1){
				RequestDispatcher rd = request.getRequestDispatcher("Jsp/UserUpdateSuccess.jsp");
				rd.forward(request, response);

			}
			
			else {
				RequestDispatcher rd = request.getRequestDispatcher("Jsp/UserUpdateFail.jsp");
				rd.forward(request, response);
			}

		}
		
		if(type.equalsIgnoreCase("updateInfo"))
		{
			CustomerDAO cust = new CustomerDAO();
			Customer c= cust.viewCustomer((String)session.getAttribute("user"));
			if(c.getId().length()>0)
			{
				session.setAttribute("customer",c) ;
			request.setAttribute("cust", c);
			RequestDispatcher rd = request.getRequestDispatcher("/Jsp/UpdateCustomerInformation.jsp");
			rd.forward(request, response);
			
		}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/Jsp/UserUpdateFail.jsp");
				rd.forward(request, response);
			}
		}
		if(type.equalsIgnoreCase("updateOrderInfo"))
		{
			System.out.println("made it here");
			//long cellNumber = Long.parseLong(request.getParameter("cellNumber"));
			String customerName = request.getParameter("customerName");
			double price = Double.parseDouble(request.getParameter("price"));
			String quantity = request.getParameter("quantity");
			String address = (request.getParameter("address"));
			int orderId = Integer.parseInt(request.getParameter("orderId"));
			String paymentType=request.getParameter("paymentType");
			String s = request.getParameter("deliveryDate");
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date parsed = null;
			try {
				parsed = format.parse(s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        java.sql.Date sqldate = new java.sql.Date(parsed.getTime());
			Order temp= new Order((String)session.getAttribute("user"),customerName,price,quantity,address,orderId,paymentType,sqldate);
			OrderDAO ord = new OrderDAO();
			int h = ord.updateOrder(temp);
			System.out.println(h);
			if(h>0)
			{
		//	request.setAttribute("orde", c);
			RequestDispatcher rd = request.getRequestDispatcher("/Jsp/UpdateOrderSuccess.jsp");
			rd.forward(request, response);
			
		}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/Jsp/UserUpdateFail.jsp");
				rd.forward(request, response);
			}
		}
		
		if (type.equalsIgnoreCase("addOrder"))
		{
			@SuppressWarnings("unchecked")
			ArrayList<Menu> m =  (ArrayList<Menu>) session.getAttribute("list");
			//System.out.println(m);
			int z = m.size();
			int q[] = new int[z];
			String tmp = "";
			for (int i = 0; i < m.size(); i++)
			{
				tmp = request.getParameter("quantity"+i);
				if (tmp.isEmpty())
					q[i]=0;
				else
				{
					Integer temp = Integer.parseInt(tmp);
					q[i] = temp.intValue();
				}
			}
			CustomerDAO cust = new CustomerDAO();
			Customer c= cust.viewCustomer((String)session.getAttribute("user"));
			Order o = GenerateOrder.makeOrder(m, c, q, request.getParameter("address"), request.getParameter("paymentType"), request.getParameter("deliverydate"));
			OrderDAO odao = new OrderDAO();
			
			int ret = odao.generateOrder(o);
			if (ret == 0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("Jsp/adminUnuccessfulUpdate.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = null;
//				odao.getOrder(c.getName())
				session.setAttribute("user_ID", o.getUserId());
				if (request.getParameter("paymentType").equalsIgnoreCase("Card"))
				rd = request.getRequestDispatcher("Jsp/paymentInformation.jsp");
				else
					rd = request.getRequestDispatcher("Jsp/NewFile.jsp");
				rd.forward(request, response);
			}
		}
	}
}
