<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Created</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .message-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            text-align: center;
        }
        h1 {
            color: #333;
        }
        button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin-top: 20px;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="message-container">
    
        <h1>Employee Successfully Displayed!</h1>
        <p>Employee Name is ${ employee.employeeName }</p>
        <p>Email is ${ employee.email }</p>
        <p>Designation is ${employee.designation}</p>
        <p>Location is ${employee.location } </p>
        <p>Contact Number is ${employee.contactNumber } </p>
        <p>Employee salary is ${employee.salary } </p>
        <h3>Thank you!</h3>
        <button onclick="goToMainMenu()">Go Back to Main Menu</button>
    </div>

    <script>
        function goToMainMenu() {
            // Redirect to the main menu page
            location.href = "/Home";
        }
    </script>
</body>
</html>
