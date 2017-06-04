<%-- 
    Document   : affectations
    Created on : 4 juin 2017, 10:42:27
    Author     : Moi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Liste des affectations</title>
    </head>
    <body>
        
        <div class="page-header">
            <h1>Liste des affectations</h1>
        </div>
        
          <div class="col-md-24">
          <table class="table">
            <thead>
              <tr>
                <th>Nom</th>
                <th>Description</th>
              </tr>
            </thead>
            <tbody>
                
            <c:forEach items="${clientList}" var="item">
              
                <tr>
                    <td>
                        <c:out value = "${item.getLastName()}"/>
                    </td>
                    <td>
                        <c:out value = "${item.getTitle()}"/>
                    </td>
                </tr> 
            </c:forEach>    
                
 
            </tbody>
          </table>
        </div>
        
        
    </body>
</html>
