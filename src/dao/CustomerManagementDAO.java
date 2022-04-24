package dao;
//dao stands for data access object
//this class holds the methods which will interact with the database, extract info/add info/delete info in database

import java.sql.*;
import java.util.*;

import java.sql.DriverManager;
import static java.sql.DriverManager.registerDriver;
import java.sql.Driver;
import dbutil.DBUtil;
import pojo.Customer;

public class CustomerManagementDAO {
	
	//list to store the getAllCustomers method
	public List<Customer> getAllCustomers()
	{
		List<Customer> customerList = new ArrayList<Customer>();
		
		try
		{
			//jdbc - database connection 
			//https://www.codejava.net/java-se/jdbc/jdbc-tutorial-sql-insert-select-update-and-delete-examples
			Connection conn = DBUtil.getConnection(); //this method is in DBUtil.java
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM customer");
			while(rs.next())
            {
                Customer customer = new Customer(rs.getString("customerId"), rs.getString("customerName"), rs.getInt("customerNo"));
                customerList.add(customer);
            }
			
            DBUtil.closeConnection(conn);  //close connection to database
			
		}
		catch(Exception e)
		{
           e.printStackTrace();
        }

        return customerList;
	}
	
	
	
	//addCustomer , query
	public int addCustomer(Customer customer)
	{
		//status = 1 if success , if not displays error
		int status = 0;
		try
		{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO customer VALUES(?,?,?)");
			//parameters of query since more than 1
			ps.setString(1, customer.getCustomerId());
			ps.setString(2, customer.getCustomerName());
			ps.setInt(3, customer.getCustomerNo());
			status = ps.executeUpdate(); // if this statement is success, status changes to 1
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	
	//Update Customer
	public int updateCustomer(Customer customer)
	{
		int status = 0;
		try
		{
		    Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE customer SET customerName=?, customerNo=? WHERE customerId=?");
            //set parameters of query here but using the values for the customer object
            ps.setString(1, customer.getCustomerName());
            ps.setInt(2,  customer.getCustomerNo());
            ps.setString(3,  customer.getCustomerId());
            status = ps.executeUpdate();  //  if this statement is success, status changes to 1
            
            if(status != 0) {
            	System.out.println("Database was connected and inserted");
            }
			
		}catch(Exception e)
		{
            e.printStackTrace();
        }
		
        return status;
	}
	
	//delete Customer
	 public int deleteCustomer(String customerId)
	    {
	        int status = 0;
	        try
	        {
	            Connection conn = DBUtil.getConnection();
	            PreparedStatement ps = conn.prepareStatement("DELETE FROM customer where customerId = ?");
	            ps.setString(1, customerId);
	            status = ps.executeUpdate();  //if successful status should return 1

	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        return status;
	    }
	 

}
