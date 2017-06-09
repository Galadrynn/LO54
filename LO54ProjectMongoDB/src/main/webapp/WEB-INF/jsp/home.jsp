<%-- 
    Document   : home
    Created on : 19 mai 2017, 17:02:02
    Author     : Moi
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="fr.utbm.entity.Course"%>
<%@page import="fr.utbm.entity.Course_Session"%>
<%@page import="fr.utbm.entity.Location"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
            <a class='btn btn-lg btn-primary' href='./courses'>Consulter les cours</a>
            <a class='btn btn-lg btn-success' href='./affectations'>Consulter les affectations</a>
        </p>
      </div>
      
      
      
        <div class="page-header">
            <h1>Liste des cours sessions :</h1>
        
            <label>Description : <input type='text' id='desc'/></label>
            <label>Date : <input type="text" id='date'/></label>
            <label>Lieu : </label><select id='loc'>
                <option value="null">Lieu</option>
                <c:forEach items="${locations}" var="l">
                    <option value="<c:out value = "${l.getId()}"/>"><c:out value = "${l.getCity()}"/></option>
                </c:forEach>    
            </select>
      </div>
   
        <div class="col-md-24">
          <table class="table">
            <thead>
              <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Date début</th>
                <th>Date fin</th>
                <th>Lieu</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
                
                
        <%
               SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        %>
         <c:forEach items="${course_sessions}" var="cs">
            <tr>
                <td>
                    <c:out value = "${cs.getId()}"/>
                </td>
                <td>
                     <c:out value = "${cs.getCourseCode().getCode()}"/>
                </td>
                <td>
                    <c:out value = "${cs.getCourseCode().getTitle()}"/>
                </td>
                <td>
                    <fmt:formatDate value="${cs.getStartDate()}" pattern="dd-MM-yyyy" />
                </td>
                <td>
                     <fmt:formatDate value="${cs.getEndDate()}" pattern="dd-MM-yyyy" />
                </td>
                <td>
                    <c:out value = "${cs.getLocationId().getCity()}"/>
                </td>
                <td>
                    <button class="btn btn-warning subscribe" id='<c:out value = "${cs.getId()}"/>'>S'inscrire</button>
                </td>
            </tr>   
        </c:forEach>    
                   
               
            </tbody>
          </table>
        </div>

          
 <!-- MODAL ADD CLIENT ============================================================ -->
  <div class="modal fade" id="addExhibitorSuccess" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header bg-primary">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Inscription à une UV</h4>
        </div>
        <div class="modal-body">
                             <form id="add-exhibitor" data-parsley-validate class="form-horizontal form-label-left">

                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Prénom <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="first-name" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Nom <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="last-name" name="last-name" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="address">Adresse <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="address" name="address" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="phone">Téléphone <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="phone" name="phone" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">Email <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="email" class="date-picker form-control col-md-7 col-xs-12" required="required" type="email">
                        </div>
                      </div>
                      <input id="idCs" style="display:none" type="text">
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                            <button class="btn btn-primary" type="reset">Réinitialiser le formulaire</button>
                            <button id='submit' name="submit" type="submit" class="btn btn-success">S'inscrire</button>
                        </div>
                      </div>

                    </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
        </div>
      </div>
    </div>
  </div>
 
  <!-- MODAL SUCESS ADD CLIENT ============================================================ -->
  <div class="modal fade" id="addSuccess" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header bg-primary">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Succès inscription</h4>
        </div>
        <div class="modal-body">
            <p>Vous avez été inscris !</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
        </div>
      </div>
    </div>
  </div>

        
        
       <script type="text/javascript">
           
           $( "#date" ).datepicker({dateFormat: 'dd-mm-yy'});
           
           function refresh(){
                var desc = $('#desc').val();
                var date = $('#date').val();
                var loc = $('#loc').val();
                
                $.ajax({
                    type: "POST",
                    url: "filterCoursesResults",
                    data: {desc: desc, date: date, loc: loc},
                    dataType:'JSON',
                    //dataType: "html",
                    success: function(res){
                        //alert('suceess');
                        $('tbody').empty();
                        if(res.val !=0 ){
                            for(var i=0; i<res.val.length; i++){
                                $("tbody").append("<tr><td>"+res.val[i].Id+"</td><td>"+res.val[i].Code+"</td><td>"+res.val[i].Desc+"</td><td>"+res.val[i].StartDate+"</td><td>"+res.val[i].EndDate+"</td><td>"+res.val[i].Location+"</td><td><button class='btn btn-warning subscribe' id='"+res.val[i].Id+"'>S'inscrire</button></tr>");
                            }
                        }
                        //Subscribe client to a sessionCourse
                        $( ".subscribe" ).click(function() {
                            $('#addExhibitorSuccess').modal('show');
                            $('#idCs').val(this.id);
                        }); 
                    },
                    error: function (data) {
                        console.log('fail');
                    }
               }); 
           }
            
            // If input change
             $('#desc ').on('input',function(e){
                 refresh();
            });
            
            // If select change
            $( "#loc" ).change(function() {
                refresh();
            });
            
            // If Date change
            $( "#date" ).change(function() {
                refresh();
            });
            
            //Subscribe client to a sessionCourse
            $( ".subscribe" ).click(function() {
                $('#addExhibitorSuccess').modal('show');
                $('#idCs').val(this.id);
            }); 
            
            $("#submit").click(function(event) {
                event.preventDefault();
                var idReq = $('#idCs').val();
                var first_name = $('#first-name').val();
                var last_name = $('#last-name').val();
                var address = $('#address').val();
                var phone = $('#phone').val();
                var email = $('#email').val();
                
                
                $.ajax({
                    type: "POST",
                    url: "ServletRegisterClient",
                    data: {idReq: idReq, first_name: first_name, last_name: last_name, address: address, phone: phone, email: email},
                    dataType:'JSON',
                    success: function(res){
                         $('#addSuccess').modal('show');
                    },
                    error: function (data) {

                    }
               }); 
                
                $('#addExhibitorSuccess').modal('hide');
            });
           
       </script>    
    
        
    </div>
        
    </body>
    <fooer>

    </footer>
</html>
