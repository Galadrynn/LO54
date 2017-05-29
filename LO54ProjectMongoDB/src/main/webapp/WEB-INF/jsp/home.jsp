<%-- 
    Document   : home
    Created on : 19 mai 2017, 17:02:02
    Author     : Moi
--%>

<%@page import="fr.utbm.entity.Course"%>
<%@page import="fr.utbm.entity.Course_Session"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>JSP Page</title>
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
          <a class="navbar-brand" href="#">Bootstrap theme</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
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
            <button type="button" class="btn btn-lg btn-primary">S'inscire à un cours</button>
            <button type="button" class="btn btn-lg btn-success">Consulter les affectations</button>
            <button type="button" class="btn btn-lg btn-danger">Info</button>
        </p>
      </div>
      
      
   
      <div class="page-header">
          <h1>Liste des cours :</h1>
      </div>
      
              <div class="col-md-24">
          <table class="table">
            <thead>
              <tr>
                <th>#</th>
                <th>Code</th>
                <th>Titre</th>
              </tr>
            </thead>
            <tbody>
                
                
        <%

               int a = 1;
               List<Course_Session> list = (List) request.getAttribute("course_sessions");
               for (Course_Session c : list)
               //List<Course_Session> list = (List) request.getAttribute("course_sessions");
               //for (Course_Session c : list)
                {
        %>
            <tr>
                <td>
                    <%= a%>
                </td>
                <td>
                    <%= c.getId()%>
                </td>
                <td>
                    <%= c.getCourseCode().getCode() %>
                </td>
            </tr>   
        <%
            a++;
                }
//                je print le course session
    
        %>
                   
               
            </tbody>
          </table>
        </div>
      
      
      
    
        
    </div>
        
    </body>
    <fooer>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </footer>
</html>
