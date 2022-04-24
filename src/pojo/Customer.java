package pojo;
//pojo is plain old java object and holds classes that contain the customer data
//need to call this class in main program to provide the data

public class Customer {
	
	String customerId;
	String customerName;
	int customerNo;
	
	//default contructor
	public Customer() {
		
	}
	
	//add values to constructor
	public Customer(String customerId, String customerName, int customerNo) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerNo = customerNo;
		
	}
	
	//getters and setters for Customer
	

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String  customerName) {
        this.customerName = customerName;
    }

    public int getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }
	
    //join strings together to display customer info

    @Override
    public String toString(){
        return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerNo=" + customerNo + "]";
    }
    
}
