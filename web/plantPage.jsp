<%-- 
    Document   : plantPage
    Created on : Mar 12, 2022, 3:44:11 PM
    Author     : PHT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Information of the plant</h1>
        <hr/>
        <form action="MainController">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id" value="${plant.id}" style="width:300px;"/></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" value="${plant.name}" style="width:300px;"/></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="price" value="${plant.price}" style="width:300px;"/></td>
                </tr>
                <tr>
                    <td>Image path</td>
                    <td><input type="text" name="imgPath" value="${plant.imgPath}" style="width:300px;"/></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input type="text" name="description" value="${plant.description}" style="width:300px;"/></td>
                </tr>
                <tr>
                    <td>Category name</td>
                    <td><input type="text" name="category" value="${plant.category.name}" style="width:300px;"/></td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td>
                        <select name="status" style="width:300px;">
                            <option value="0" ${plant.status==0?"selected":""}>Inactive</option>
                            <option value="1" ${plant.status==1?"selected":""}>Active</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" name="op" value="Update"/></td>
                    <td></td>
                </tr>
            </table>
        </form>
    </body>
</html>
