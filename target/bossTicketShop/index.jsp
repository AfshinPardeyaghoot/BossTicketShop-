<%--
  Created by Afshin Pardeyaghoot.
  Date: 1/24/2021
  Time: 5:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bus Ticket Booking Service</title>
    <link rel="stylesheet" href="style/index.css" type="text/css">
</head>
<body>
<div class="main">
    <div class="login_frame">
        <div class="login_title">
            ورود به سامانه
        </div>
        <br>
        <div class="login_form">
            <form action="login" method="post">
                <input type="text" placeholder="نام کاربری" name="username">
                <br>
                <input type="password" placeholder="رمز عبور" name="password">
                <br>
                <input type="submit" class="submit_input" value="ورود">
                <br>
            </form>
        </div>
        <br>
        <div class="sign_up_frame">
            <div class="sign_up">
                <a href="">ساختن حساب کاربری</a>
            </div>
            <div class="forget_password">
                <a href="">فراموشی رمز عبور</a>
            </div>
        </div>
    </div>
    <div class="welcome_frame">
        <div class="welcome_content">
            سامانه ی فروش بلیط اتوبوس
        </div>
    </div>
</div>
</body>
</html>
