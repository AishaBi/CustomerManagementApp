# Java-CLI-CRUD-App
Customer management app using the CLI for user interaction, Java programming language, MySQL database, Maven to build and JUnit for testing

System needs to be able to :

- add customer to system
- view all customers in system
- update customer in system
- delete customer in system

File structure:

src:

    - main/CustomerManagementApplication.java 
    //main app code

    - dao/CustomerManagementDAO.java 
    //DAO (data access object) This holds classes which interact with the database

    - dbutil/DBUtil.java 
    //classes for database connection 

    - pojo/Customer.java 
    //POJO (plain old java object) This holds classes which hold the customer data
