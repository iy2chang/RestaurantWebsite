package com.tcs.ilp.dao;





import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.tcs.ilp.bean.Menu;
import com.tcs.ilp.util.ConnectionFactory;
import com.tcs.ilp.util.QueryConstants;


public class MenuDao {

	private Connection con=null;


	public  int addMenu(Menu menu){
		int numberOfMenusAdded=0;
		try{
			con= ConnectionFactory.CreateConnection();
			PreparedStatement pst=con.prepareStatement(QueryConstants.M_ADD);
			pst.setString(1, menu.getCategory());
			pst.setString(2, menu.getItem());
			pst.setString(3,menu.getDescription());
			pst.setDouble(4, menu.getPrice());


			numberOfMenusAdded=pst.executeUpdate();

			System.out.println("Number of rows added in the system: "+numberOfMenusAdded);
			con.commit();	
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			if(con!=null){
				try{
					con.close();
				}catch (SQLException e){
					e.printStackTrace();
				}

			}
		}

		return numberOfMenusAdded;

	}



	public int updateMenu(Menu menu)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try{

			con= ConnectionFactory.CreateConnection();

			pstmt = con.prepareStatement(QueryConstants.M_UPDATE);
			pstmt.setString(1, menu.getDescription());
			pstmt.setDouble(2,menu.getPrice());
			pstmt.setString(3, menu.getItem());

			count = pstmt.executeUpdate();
			System.out.println(count);
			con.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(con != null)
				try {
					con.close();
					if(pstmt!=null)
						pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
		return count;
	}


	public Menu viewMenu(String item)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Menu menu=null;

		try{
			con= ConnectionFactory.CreateConnection();


			pstmt = con.prepareStatement(QueryConstants.M_VIEW);

			pstmt.setString(1,item);
			rs = pstmt.executeQuery();
			rs.next();
			menu=new Menu(rs.getString(1),rs.getString(2), rs.getString(3), rs.getFloat(4));
			con.commit();



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{

			try {
				if(con != null)
					con.close();
				if(pstmt!=null)
					pstmt.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return menu;
	}





	public int deleteMenu(String item)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		int ret = -10;

		try{ 
			con= ConnectionFactory.CreateConnection();


			pstmt = con.prepareStatement(QueryConstants.M_DELETE);

			pstmt.setString(1,item);
			ret = pstmt.executeUpdate();

			con.commit();
			System.out.println("Successfully Deleted");


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{

			try {
				if(con != null)
					con.close();
				if(pstmt!=null)
					pstmt.close();
				return ret;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return ret;

	}



	public  ArrayList<Menu> viewAllMenu()
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Menu> amenu = new ArrayList<Menu>();
		Menu menu = null;

		try
		{
			con= ConnectionFactory.CreateConnection();	
			pstmt = con.prepareStatement(QueryConstants.M_VIEWALL);
			rs = pstmt.executeQuery();
			if (!rs.isBeforeFirst())
				System.out.println("EoT");
			else
				while (rs.next())
				{
					menu=new Menu(rs.getString(1),rs.getString(2), rs.getString(3), rs.getFloat(4));
					amenu.add(menu);
				}
			return amenu;
		}
		catch (SQLException sqle)
		{
			System.out.println(sqle.toString());
			sqle.printStackTrace();
		}
		finally{
			if (con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
}







