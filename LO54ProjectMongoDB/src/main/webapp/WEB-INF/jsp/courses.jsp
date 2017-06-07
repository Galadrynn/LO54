<%-- 
    Document   : courses
    Created on : 4 juin 2017, 09:50:21
    Author     : Moi
--%>

<%@page import="fr.utbm.entity.Course"%>
<%@page import="java.util.List"%>
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
        <title>Liste des cours</title>
    </head>
    <body>
        <!-- Fixed navbar -->
        <nav class="navbar navbar-inverse navbar-fixed-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">LO54 - P17</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
              </ul>
            </div><!--/.nav-collapse -->
          </div>
        </nav>
        
      <div class="container theme-showcase" role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>LO54</h1>
        <p>Permet la gestion des étudiants, sessions de cours, ...</p>
        <p>
            <a class='btn btn-lg btn-primary' href='./'>S'inscrire à un cours</a>
            <a class='btn btn-lg btn-success' href='./affectations'>Consulter les affectations</a>
        </p>
      </div>

        <div class="page-header">
            <h1>Liste des cours</h1>
        </div>
        
          <div class="col-md-24">
          <table class="table">
            <thead>
              <tr>
                <th>Code</th>
                <th>Description</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
                
            <c:forEach items="${courses}" var="item">
              
                <tr>
                    <td>
                        <c:out value = "${item.getCode()}"/>
                    </td>
                    <td>
                        <c:out value = "${item.getTitle()}"/>
                    </td>
                    <td>
                         <button class="btn btn-warning" >Voir les sessions</button>
                    </td>
                </tr> 
            </c:forEach>    
                
 
            </tbody>
          </table>
        </div>
        
        
        
      </div>
    </body>
</html>
