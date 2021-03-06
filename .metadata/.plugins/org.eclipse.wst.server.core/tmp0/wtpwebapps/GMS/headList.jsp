<%@page import="com.app.model.Head"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored="false" %>
    <%@ page import="java.util.List"  %>
    
        <html>

        <head>
            <title>Grivence mgmt sys</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark bg-info">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> Grievance Management System </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">HOD</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">List of Heads</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
     New Head</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                  
                  		
                  			
                            <c:forEach var="head" items='${listHead}'>

                                <tr>
                                    <td>
                                        <c:out value="${head.userid}" />
                                    </td>
                                    <td>
                                        <c:out value="${head.name}" />
                                    </td>
                                    <td>
                                        <c:out value="${head.email}" />
                                    </td>
                                    <td>
                                        <c:out value="${head.phone}" />
                                    </td>
                                    <td><a href="edit?userid=<c:out value='${head.userid}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?userid=<c:out value='${head.userid}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>