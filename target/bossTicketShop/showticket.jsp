<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/1/2021
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ُShow Ticket</title>
    <link rel="stylesheet" type="text/css" href="style/showTicket.css">
</head>
<body>
    <div class="main">
        <%
            String ownerName = (String) request.getAttribute("ownerName");
            String date = (String) request.getAttribute("date");
            String hour = (String) request.getAttribute("hour");
            String minute = (String) request.getAttribute("minute");
            String gender = (String) request.getAttribute("gender");
            String bookId = (String) request.getAttribute("bookid");
            String ticketId = (String) request.getAttribute("ticketid");
            String des_city = (String) request.getAttribute("des-city");
            String org_city = (String) request.getAttribute("org-city");
        %>
        <table>
            <tr>
                <th colspan="2" class="th_header">بلیط اتوبوس</th>
            </tr>
            <tr>
                <th class="title">نام</th>
                <th ><%= ownerName%></th>
            </tr>
            <tr>
                <th class="title">جنسیت</th>
                <th ><%=gender%></th>
            </tr>
            <tr>
                <th class="title">مبدا</th>
                <th ><%=org_city%></th>
            </tr>
            <tr>
                <th class="title">مقصد</th>
                <th><%=des_city%></th>
            </tr>
            <tr>
                <th class="title">تاریخ</th>
                <th><%=date%></th>
            </tr>
            <tr>
                <th class="title">ساعت</th>
                <th><%=hour%>:<%=minute%></th>
            </tr>
            <tr>
                <th class="title">شناسه سفر</th>
                <th><%=bookId%></th>
            </tr>
            <tr>
                <th class="title">شناسه بلیط</th>
                <th><%=ticketId%></th>
            </tr>
            <tr>
                <th  colspan="2" class="th_header"><form action="DeleteTicket" method="get">
                    <input type="submit" class="btn" value="لغو بلیط">
                    <input type="hidden" name="ticket_id" value=<%=ticketId%>>
                </form></th>
            </tr>
        </table>
    </div>
</body>
</html>
