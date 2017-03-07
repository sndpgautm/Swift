<%-- 
    Document   : index.jsp
    Created on : Mar 7, 2017, 10:10:27 PM
    Author     : Rocke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Swift</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link type="text/css" rel="stylesheet" href="css/styles.css">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
        <link type="text/css" rel="stylesheet" href="css/Navigation-Clean1.css">
        <link href='http://fonts.googleapis.com/css?family=Short+Stack' rel='stylesheet' type='text/css'>

    </head>
    <body>
        <% if (session.getAttribute("username") == null) {
                response.sendRedirect("login.html");
            }
        %>

        <header>
            <nav id="header-nav" class="navbar navbar-default">
                <div class="container">
                    <div class="navbar-header">
                        <a href="menu.jsp" class="pull-left visible-md visible-lg">
                            <div id="logo-img"></div>

                        </a>

                        <div class="navbar-brand">
                            <a href="menu.jsp"><h1>Swift Web Application</h1></a>
                            <div id="sublogo">
                                <img src="images/restaurant.ico" height="65" width="65" alt="Swift logo">
                                <span>A restaurant app</span>
                            </div>

                        </div>
                        <button id="navbarToggle" type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#collapsable-nav" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div><!-- navbar-header-->

                    <div id="collapsable-nav" class="collapse navbar-collapse">
                        <ul id="nav-list" class="nav navbar-nav navbar-right">
                            <li id="navMenuButton">
                                <a href="menu.jsp">
                                    <span class="glyphicon glyphicon-cutlery"></span><br class="hidden-xs">Menu</a>
                            </li>
                            <li>
                                <a id="takeOrder" href="order.jsp">
                                    <span class="glyphicon glyphicon-pencil"></span><br class="hidden-xs">Take order</a>
                            </li>
                            <li>
<<<<<<< HEAD:web/index.html
                                <a href="orders.html">
                                    <span class="glyphicon glyphicon-log-out"></span><br class="hidden-xs">Logout</a>
=======
                                <a href="logout">
                                    <span class="glyphicon glyphicon-log-out"></span><br class="hidden-xs">Log Out</a>
>>>>>>> cd51ca63ae081ecd51c75d4deaad47ea4416d81d:web/order.jsp
                            </li>
                        </ul>
                    </div>
                </div><!-- .container -->
            </nav><!-- #header-nav -->
        </header>

        <table id="newTasks">
            
            <tr><td>Table No.</td><td><input type="text" id="table" value="" /></td></tr>
            
            <tr><td>Status</td><td><input type="text" id="status" value="" /></td></tr>
            <tr><td>Orders</td><td><input type="text" placeholder="Dish No." inputmode="numeric" id="orders" value="" name="dishNo[]"/></td></tr>
            <tr id="delafter"><td colspan="2"><a class="deleteButton" id="delete" title="">Refresh</a></td></tr>
        </table>
        
        
        
        
        <input type="button" class="btn" id="addNew" value="Add Order" /><br>
        <input type="button" class="btn" id="add-dish-no" value="Add dish Number"/>
        <ul class="sticky_notes">

        </ul>
        

        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
    </body>

</html>