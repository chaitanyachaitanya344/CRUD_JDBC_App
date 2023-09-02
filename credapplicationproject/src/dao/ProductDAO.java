package dao;

import java.sql.*;

import connectionmanager.ConnectionManager;
import model.product;

public class ProductDAO {
		public void addproduct(product p) throws ClassNotFoundException, SQLException
		{
			ConnectionManager cm = new ConnectionManager();
			Connection con = cm.establishConnection();
		
		
			String que = "insert into Product(prodId,prodName,MinimumSellQuantity,Price,Quantity) values(?,?,?,?,?)";
			//prepared statement it takes input from run time.
			PreparedStatement ps = con.prepareStatement(que);
			ps.setInt(1, p.getProdid());
			ps.setString(2, p.getProname());
			ps.setInt(3, p.getMinimumsellingQuantity());
			ps.setInt(4, p.getPrice());
			ps.setInt(5, p.getQuantity());
			ps.executeUpdate();
			cm.closeConnection();
			
			
		
		}
		public void display() throws ClassNotFoundException, SQLException
		{
			//1. jdbc connecton
			ConnectionManager cm = new ConnectionManager();
			Connection con = cm.establishConnection();
			
			//2. create the statement
			Statement st=con.createStatement();
			
			//3. write and execute the query
			ResultSet rt = st.executeQuery("select * from product");     //Query execution it is important
			
			//5. check the Username and password ....two user names 
			//login.java and login.table
			while(rt.next())
			{
				System.out.println(rt.getInt("prodId")+" | "+rt.getString("prodName")+" | "+rt.getInt("MinimumSellQuantity")+" | "+rt.getInt("Price")+" | "+rt.getInt("Quantity"));
			}	
			cm.closeConnection();
		}
		
		public void update(product p) throws ClassNotFoundException, SQLException
		{
			ConnectionManager cm = new ConnectionManager();
			Connection con = cm.establishConnection();
			
			String que = "update product set prodName=?,MinimumSellingPrice=?,";
			PreparedStatement ps = con.prepareStatement(que);
			ps.setString(1, p.getProname());
			ps.setInt(2, p.getMinimumsellingQuantity());
			ps.setInt(3, p.getPrice());
			ps.setInt(4, p.getQuantity());
			ps.setInt(5, p.getProdid());
			ps.executeUpdate();
			cm.closeConnection();
			
		}
		public void deleteProduct(product p) throws ClassNotFoundException, SQLException
		{
			ConnectionManager cm = new ConnectionManager();
			Connection con = cm.establishConnection();
			
			String que = "delete from product where prodId=?";
			PreparedStatement ps = con.prepareStatement(que);	
			ps.setInt(1, p.getProdid());
			ps.executeUpdate();
			cm.closeConnection();
			
		}
		
	
			
			}
	

