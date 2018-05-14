<%-- 
    Document   : vuelos
    Created on : 14/05/2018, 10:34:02 AM
    Author     : Personal
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vuelos - Tech and Fly </title>
    </head>
    <body>
        <div></div>
        <table>
            <thead>
                <tr>
                    <th> Codigo </th>
                    <th> Origen </th>
                    <th> Destino </th>
                    <th> Fecha </th>
                    <th> Puestos </th>
                </tr>
            </thead>
            
            <c:forEach items="${vuelos}" var="vuelo">
                <tr>
                    <td> <c:out value="${vuelo.idVuelo}"/> </td>
                    <td> <c:out value="${vuelo.origen}"/> </td>
                    <td> <c:out value="${vuelo.destino}"/> </td>
                    <td> <c:out value="${vuelo.fecha}"/> </td>
                    <td> <c:out value="${vuelo.numero_sillas}"/> </td>
                </tr>
            </c:forEach>
        </table>
        <a href="/TechAndFly/reservas"> hacer reserva </a>
        <div>
            <p>Para registrarse ir a <a href="personas"> registro </a></p>
            <p>Para ver reservas hechas <a href="reservas"> ver reservas </a></p>
            <p>Para ver volver al inicio <a href="home"> ver reservas </a></p>
        </div>
    </body>
</html>
