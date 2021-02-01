<%@ page import="entity.Ticket" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/1/2021
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show User All Ticket</title>
    <link rel="stylesheet" type="text/css" href="style/showAllTicket.css">
</head>
<body>
<div class="main">
    <table>
        <tr>
            <th colspan="3" class="th_header">بلیط های خریداری شده </th>
        </tr>
        <tr>
            <th>شناسه بلیط</th>
            <th> تاریخ </th>
            <th>مشاهده</th>
        </tr>
        <%  HttpSession httpSession = request.getSession();
            ArrayList<Ticket> tickets =
                    (ArrayList<Ticket>)httpSession.getAttribute("tickets");
            if (tickets != null)
                for(Ticket ticket:tickets){ ;%>
        <tr>
            <td><%=ticket.getId()%></td>
            <td><%=ticket.getBookId().getDate()%></td>
            <form name="form1" action="ViewTicket" method="get">
                <td><input type="submit" class="btn" value="مشاهده"></td>
                <input type="hidden" name="btnValue" value="<%=ticket.getId()%>">
            </form>
        </tr>
        <%}%>
    </table>
</div>
</body>
</html>
