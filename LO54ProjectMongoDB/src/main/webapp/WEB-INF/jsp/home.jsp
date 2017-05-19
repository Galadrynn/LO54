<%-- 
    Document   : home
    Created on : 19 mai 2017, 17:02:02
    Author     : Moi
--%>

<%@page import="fr.utbm.entity.Course_Session"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <ul>
        <%
               // Map map = (Map) request.getAttribute("course_sessions");
               //List<Course_Session> list = (List) map.get("course_sessions");
               
               List<Course_Session> list = (List) request.getAttribute("course_sessions");
               for (Course_Session c : list)
                {
        %>
            <li>
                <%= c.getCourseCode() %>
            </li>            
        <%
                }
//                je print le course session
    
        %>
        </ul>
    </body>
</html>
