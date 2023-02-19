<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.invalidate();
    request.getRequestDispatcher("index.jsp").forward(request, response);
%>