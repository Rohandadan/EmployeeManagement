<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Employee details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 20px;
        }
        label {
            display: block;
            margin-bottom: 10px;
        }
        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .error{
        	color:red;
        }
    </style>
</head>
<body>
    <h2>Update Employee Details</h2>
    <form:form action="Update_Employee" method="post" modelAttribute="employee">
    
        <label for="EmployeeId">Id:</label>
        <form:input type="text" path="employeeId"  placeholder="Enter employeeId" />
        <p class="error"/>${ invalid_id }</p> 
		
        <label for="Employeename">Name:</label>
        <form:input type="text" path="employeeName"  placeholder="Enter employeeName" />
        <form:errors path="employeeName" class="error"/> 
		
        <label for="Email">Email Id:</label>
        <form:input type="text" path="email"  placeholder="Enter email" />
		<form:errors path="email" class="error"/> 
		
        <label for="Designation">Designation:</label>
        <form:input type="text" path="designation" placeholder="Enter designation" />
		<form:errors path="designation" class="error"/> 
		
        <label for="Location">Location:</label>
        <form:input type="text" path="location" placeholder="Enter location" />
        <form:errors path="location" class="error"/> 
		
        <label for="ContactNumber">Phone Number:</label>
        <form:input type="text" path="contactNumber" placeholder="Enter contactNumber" />
        <form:errors path="contactNumber" class="error"/> 
		
        <label for="Salary">Salary:</label>
        <form:input type="number" path="salary" placeholder="Enter salary"/>
        <form:errors path="salary" class="error"/> 
		        
        <input type="submit" value="Submit">
    </form:form>
</body>
</html>
