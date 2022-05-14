<%-- 
    Document   : searchPage
    Created on : Mar 12, 2022, 12:32:38 PM
    Author     : PHT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/site.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Searching Plants</h1>
        <hr/>
        <form action="MainController">
            Enter the plant name: 
            <input type="text" name="searchText" value="${searchText==null?"rose":searchText}"/>
            <input type="submit" name="op" value="Search"/>            
        </form>
        <hr/>
        <c:if test="${not empty list}">
            <table>
                <tr>
                    <th class="text-right">Id</th>
                    <th class="text-left">Name</th>
                    <th class="text-right">Price</th>
                    <th class="text-left">Image</th>
                    <th class="text-left">Category</th>
                    <th class="text-left">Status</th>
                    <th class="text-left">Update</th>
                </tr>
                <c:forEach var="plant" items="${list}">
                    <tr>
                        <td class="text-right">${plant.id}</td>
                        <td class="text-left">${plant.name}</td>
                        <td class="text-right">${plant.price}</td>
                        <td class="text-left"><img src="products/${plant.imgPath}" width="100" height="60"/></td>
                        <td class="text-left">${plant.category.name}</td>
                        <td class="text-left">${plant.status==0?"Inactive":"Active"}</td>
                        <td class="text-left"><a href="MainController?op=UpdateForm&id=${plant.id}">Update</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
