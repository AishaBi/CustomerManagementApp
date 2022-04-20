package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import dao.CustomerManagementDAO;
import pojo.Customer;

public class CustomerManagementApplication {
	
	//read user input
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	//call dao (data access object) methods
	static CustomerManagementDAO dao = new CustomerManagementDAO();

	public static void main(String[] args) throws Exception {
		
		String option = "";
		
		do
		{
			System.out.println("1. Add Customer");
			System.out.println("2. View All Customers ");
			System.out.println("3. Update Customer");
			System.out.println("4. Delete Customer");
			System.out.println("5. Exit");
			System.out.println("----------------------");
			System.out.println("Please enter an option");
			System.out.println("----------------------");
			option = br.readLine();
			System.out.println("\n");
			
			switch(option) 
			{
			
			case "1":
				addCustomer();
				break;
			case "2":
				viewCustomers();
				break;
			case "3":
				updateCustomer();
				break;
			case "4":
				deleteCustomer();
				break;
			case "5":
				System.out.println("----------------------");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid option, try again!");
				break;
			}
			
		}while(!option.equals("5"));
		
	}
	
	public static void addCustomer() {
		
	}
	
	public static void viewCustomers() {
		
	}

	public static void updateCustomer() {
	
	}

	public static void deleteCustomer() {
	
	}

}
