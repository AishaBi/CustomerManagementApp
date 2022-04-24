package main;



import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.List;

import dao.CustomerManagementDAO;
import pojo.Customer;
import dbutil.DBUtil;

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
				System.out.println("Invalid option, try again!\n");
				break;
			}
			
		}while(!option.equals("5"));
		
	}
	
	public static void addCustomer() throws Exception {
		//takes user input and stores in string: customerId, customerName, customerNo
		System.out.println("------------------------------------------------");
        System.out.println("Enter Customer ID:");
        System.out.println("------------------------------------------------");
        String customerId = br.readLine();
        System.out.println("------------------------------------------------");
        System.out.println("Name:");
        System.out.println("------------------------------------------------");
        String customerName = br.readLine();
        System.out.println("------------------------------------------------");
        System.out.println("No:");
        System.out.println("------------------------------------------------");
        int customerNo = Integer.parseInt(br.readLine());
		
        //store user input (strings) in a customer variable
        Customer customer = new Customer(customerId, customerName, customerNo);
        int status = dao.addCustomer(customer);
        
	}
	
	public static void viewCustomers() {
        
      //get customers from dao getallCustomers() method , store in Customer type customertList
        List<Customer> customerList = dao.getAllCustomers();
        for(Customer customer: customerList)
        {
            //display product one by one
            displayCustomer(customer);
        }
        System.out.println("-----------------------------------------------");
        System.out.println("\n");
        
	}
	

	public static void updateCustomer() throws Exception {
		//user enters customer id of customer to update, then can enter new name and new no
		
        System.out.println("------------------------------------------------");
        System.out.println("Enter Customer Id:");
        System.out.println("------------------------------------------------");
        String customerId = br.readLine();
        System.out.println("------------------------------------------------");
        System.out.println("Enter New CustomerName:");
        System.out.println("------------------------------------------------");
        String customerName = br.readLine();
        System.out.println("------------------------------------------------");
        System.out.println("Enter New Customer Tel No:");
        System.out.println("------------------------------------------------");
        int customerNo = Integer.parseInt(br.readLine());
        
        //store user input into Customer
        
        Customer customer = new Customer(customerId, customerName,customerNo);
        
        int status = dao.updateCustomer(customer);
        if(status ==1 )
        {
            System.out.println("Update successfull");
        }
        else
        {
            System.out.println("ERROR, did not update");
        }
        System.out.println("\n");

	    }
	

	public static void deleteCustomer() throws Exception {
		
		System.out.println("------------------------------------------------");
        System.out.println("Enter CustomerID:");
        System.out.println("------------------------------------------------");
        String customerId = br.readLine();
        int status = dao.deleteCustomer(customerId);
        if(status == 1 )
        {
            System.out.println("Customer deleted");
        }
        else
        {
            System.out.println("ERROR, did not delete2");
        }
        System.out.println("\n");
		
	}

	public static void displayCustomer(Customer customer)

	{
		System.out.println("Customer ID: "+ customer.getCustomerId());
	    System.out.println("Customer Name: "+ customer.getCustomerName());
	    System.out.println("Customer No: "+ customer.getCustomerNo());
	    System.out.println("\n");
	}
}
