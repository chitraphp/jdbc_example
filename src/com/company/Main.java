package com.company;

import com.mysql.cj.protocol.Resultset;
import p1.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/veracity","root","chitra@kal19");
        Statement statement = connection.createStatement();
        //int result = statement.executeUpdate("insert into employee values (10,'chitra',10000)");
        ResultSet resultset = statement.executeQuery("select * from employee");
        List<Employee> employeeList = new ArrayList<>();
        while(resultset.next()){
            int id = resultset.getInt("id");
            String name = resultset.getString("name");
            int salary = resultset.getInt("salary");
            employeeList.add(new Employee(id,name,salary));
        }
        display(employeeList);
        //System.out.println(result+"successfull");
        connection.close();
    }
    public static void display(List<Employee> list){
        System.out.println("Id"+"  "+"Name"+"  "+"Salary");
        for (Employee employee:list) {
            System.out.println(employee.getId()+" "+employee.getName()+"  "+employee.getSalary());
        }

    }
}
