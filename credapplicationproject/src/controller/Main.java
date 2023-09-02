package controller;

import java.sql.SQLException;
import java.util.Scanner;

import dao.LoginDAO;
import dao.ProductDAO;
import model.login;
import model.product;

public class Main {

	private static final int Quantity = 0;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		int choice;
		login l=new login();
		LoginDAO ldao = new LoginDAO();
		product p=new product();
		ProductDAO pdao = new ProductDAO();
		do 
		{
			System.out.println("1. Admin\n2. Agent\n3. Exit\n **************************\n Enter Your Choice");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Admin Login");
				System.out.println("Enter the username");
				String username = sc.next();
				System.out.println("Enter the password");
				String pass = sc.next();
				l.setUsername(username);
				l.setPassword(pass);
				if(username.equals("admin") && pass.equals("Admin@123"))
				{
					System.out.println("Login Successful!");
					int option ;
					do
					{
						System.out.println("1. Add Product\n2. Display product\n3. Update\n4. delete\n5. Logout\n**************************\n Enter Your Choice");
						option=sc.nextInt();
						switch(option)
						{
						case 1:
							System.out.println("Add Product");
							System.out.println("Enter the ProductID");
							int ProductID=sc.nextInt();
							sc.nextLine();
							System.out.println("Enter the productName");
							String productName=sc.nextLine();
							System.out.println("Enter the minimum sell Quantity");
							int minSellQuantity=sc.nextInt();
							System.out.println("Enter the Price");
							int price=sc.nextInt();
							System.out.println("Enter the Quantity");
							int Quantity=sc.nextInt();
							p.setProdid(ProductID);
							p.setProname(productName);
							p.setMinimumsellingQuantity(minSellQuantity);
							p.setPrice(price);
							p.setQuantity(Quantity);
							pdao.addproduct(p);
							System.out.println("Enter the Quantity");
							break;
						case 2:
							System.out.println("Display Product");
							System.out.println("These are the Products");
							pdao.display();
							break;
						case 3:
							System.out.println("Update Product");
							System.out.println("Enter the ProductID");
							int ProductID1=sc.nextInt();
							sc.nextLine();
							System.out.println("Enter the productName");
							String productName1=sc.nextLine();
							System.out.println("Enter the minimum sell Quantity");
							int minSellQuantity1=sc.nextInt();
							System.out.println("Enter the Price");
							int price1=sc.nextInt();
							System.out.println("Enter the Quantity");
							int Quantity1=sc.nextInt();
							p.setProdid(ProductID1);
							p.setProname(productName1);
							p.setMinimumsellingQuantity(minSellQuantity1);
							p.setPrice(price1);
							p.setQuantity(Quantity1);
							pdao.update(p);
							System.out.println("Updated Successfully");
							break;
						case 4:
							System.out.println("Delete Product");
							System.out.println("Enter the ProductID");
							int ProductID2=sc.nextInt();
							p.setProdid(ProductID2);
							pdao.deleteProduct(p);
							System.out.println("Deleted Successfully");
							break;
						case 5:
							System.out.println("Logout");
							break;
						}
					}while(option!=5);
				}
				else
					System.out.println("Incorrect Username/Password");
				break;
			case 2:
				System.out.println("Agent Login");
				System.out.println("Enter the username");
				String username1 = sc.next();
				System.out.println("Enter the password");
				String pass1 = sc.next();
				l.setUsername(username1);
				l.setPassword(pass1);
				if(ldao.checkCredential(l))
				{
					System.out.println("Login Successful!");
					int option ;
					do
					{
						System.out.println("1. Display product\n2. Logout\n **************************\n Enter Your Choice");
						option=sc.nextInt();
						switch(option)
						{
						case 1:
							System.out.println("Display Product");
							System.out.println("These are the Products");
							pdao.display();
							break;
						case 2:
							System.out.println("Logout");
							break;
						}
					}while(option!=2);
				}
				else
					System.out.println("Incorrect Username/Password");
				break;
			case 3:
				System.out.println("Exit");
				break;
			}
		}while(choice!=3);
		sc.close();
	}

}