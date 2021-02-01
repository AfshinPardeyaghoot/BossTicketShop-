<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 1/31/2021
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm form</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style/confirmOrder.css">
</head>
<body>
    <div class="confirm-title">
        تکمیل خرید
    </div>
    <div class="confirm-form">
        <form action="buyTicket" method="post">
            <input type="text" name="ownerName" class="owner-name" id="name" placeholder="نام خانوادگی"><br>
            <div class="gender" id="gender">
                <label for="gender">جنسیت</label>
                <label for="male">مزد</label>
                <input type="radio" name="gender" value="male" id="male"><br>
                <label for="female">زن</label>
                <input type="radio" name="gender" value="female" id="female"><br>
            </div>
            <input type="submit" value="تکمیل خرید" class="btn">
        </form>
    </div>
</body>
</html>
