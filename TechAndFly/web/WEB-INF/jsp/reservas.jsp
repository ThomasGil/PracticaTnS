<%-- 
    Document   : reservas
    Created on : 13/05/2018, 11:14:41 AM
    Author     : Personal
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservas - Tech and Fly</title>
    </head>
    <body>
        <div class = "contenedor">
            <div>
                <h2>Hacer Reseras</h2>
                <p>Para realizar una reserva porfavor llene los siguientes campos </p>
                <p style="color: red">${mensajeError}</p>
                <p style="color: green">${mensajeBien}</p>
            </div>
            <div>
                <form:form modelAttribute="reserva" action="reservar">
                <form:label path="cedula"> cedula </form:label>
                <form:input path="cedula" />
                <form:label path="idVuelo"> codigo vuelo </form:label>
                <form:input path="idVuelo" />
                <form:label path="sillasReserva"> Sillas a reservar </form:label>
                <form:input path="sillasReserva" type="number"/>

                <input type="submit" value="Reservar">
                </form:form>
            </div>
            <div>
                <p>Si no sabe el codigo del vuelo puede consultarlos <a href="vuelos">aqui</a></p>
                <p>Si no esta registrado puede hacerlo <a href="personas">aqui</a></p>
            </div>
        </div>
        <br/>
        <div class = "contenedor">
            <div>
                <h2> Consultar Reservas </h2>
                <p> Para consultar reservas realizadas porfavor ingrese su cedula </p>
            </div>
            <div>
                <div>
                    <form:form modelAttribute="reserva" action="consultarReservas">
                    <form:label path="cedula"> cedula </form:label>
                    <form:input path="cedula" />
                    <input type="submit" value="Consultar">
                    </form:form>
                </div>
            </div>
            <div>
                <p style="color: red">${mensajeReservas}</p>
            </div>
            <table style="border: black; border-width: 1">
                <thead>
                    <tr>
                        <th> Codigo Reserva </th>
                        <th> Cedula </th>
                        <th> Codigo Vuelo </th>
                        <th> Sillas Reservadas </th>
                        <th> Fecha Reserva </th>
                        <th> Costo Reserva </th>
                    </tr>
                </thead>

                <c:forEach items="${consultarReservas}" var="reserva">
                    <tr>
                        <td> <c:out value="${reserva.idReserva}"/> </td>
                        <td> <c:out value="${reserva.cedula}"/> </td>
                        <td> <c:out value="${reserva.idVuelo}"/> </td>
                        <td> <c:out value="${reserva.sillas_reserva}"/> </td>
                        <td> <c:out value="${reserva.fecha_reserva}"/> </td>
                        <td> <c:out value="${reserva.costo}"/> </td>
                        
                    </tr>
                </c:forEach>
            </table>
            <p> total reserevas : ${numReservas}</p>
        </div>
        <div>
            <p>Para ver los vuelos disponibler presione <a href="vuelos"> ver vuelos </a></p>
            <p>Para registrarse ir a <a href="personas"> registro </a></p>
            <p>Para ver volver al inicio <a href="/TechAndFly"> home </a></p>
        </div>
        <div>
            <p name ="multiplicador" style="visibility: hidden"> ${multiplicador} </p>
        </div>
    </body>
    
</html>
