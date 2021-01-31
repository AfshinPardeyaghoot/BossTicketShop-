<%@ page import="entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bus Ticket Booking Service</title>
    <link rel="stylesheet" href="style/search.css" type="text/css">
</head>
<body>
<div class="search_box">
    <div class="serach">
        <form method="get" action="search">
            <label for="selet1">مبدا:</label>
            <select name="origin_city" class="select1" id="selet1">
                <option value="تهران">تهران</option>
                <option value="اردبیل">اردبیل</option>
                <option value="اصفهان">اصفهان</option>
                <option value="تبریز">تبریز</option>
                <option value="لرستان">لرستان</option>
            </select>
            <label for="select2">مقصد:</label>
            <select name="destination_city" class="select2" id="select2">
                <option value="تهران">تهران</option>
                <option value="اردبیل">اردبیل</option>
                <option value="اصفهان">اصفهان</option>
                <option value="تبریز">تبریز</option>
                <option value="لرستان">لرستان</option>
            </select>
            <label for="date">تاریخ:</label>
            <input type="date" class="date" id="date" name="date">
            <input type="submit" class="search_submit" value="جستجو">
        </form>
    </div>
</div>
<% String desCity = (String) request.getAttribute("destination_city");
    String orgCity = (String) request.getAttribute("origin_city");
    String date = (String) request.getAttribute("date");
%>
<div class="show_box">
    <div class="show">
        <table>

            <tr class="th_info" >
                <th> مسیر:<%if (orgCity != null) out.print(orgCity);%>
                    - <%if (desCity != null) out.print(desCity);%></th>
                <th colspan="2"> تاریخ :<% if (date != null) out.print(date);%>  </th>
            </tr>
            <tr class="th_header" >
                <th>ساعت حرکت</th>
                <th> شناسه سفر</th>
                <th> انتخاب </th>
            </tr>
            <%  HttpSession httpSession = request.getSession();
                ArrayList<Book> books =
                    (ArrayList<Book>)httpSession.getAttribute("books");
                int i=0 ;
                if (books != null)
                    for(Book book:books){
                            i++ ;%>
            <tr>
                <td><%=book.getHour()%>:<%=book.getMinute()%></td>
                <td><%=book.getId()%></td>
                <form name="form1" action="confirmServlet" method="post">
                    <td><input type="submit"></td>
                    <input type="hidden" name="btnValue" value="<%=book.getId()%>">
                </form>
            </tr>
            <%}%>

        </table>
    </div>
</div>
</body>
</html>