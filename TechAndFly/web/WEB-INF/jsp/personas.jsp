<%-- 
    Document   : personas
    Created on : 14/05/2018, 02:00:16 PM
    Author     : Personal
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personas - Tech and Fly</title>
    </head>
    <body>
        <div class = "contenedor">
            <div>
                <h2>Realizar registro</h2>
                <p>Para realizar su registro porfavor llene los siguientes campos </p>
                <p style="color: red">${mensajeError}</p>
                <p style="color: green">${mensajeBien}</p>
            </div>
            <div>
                <form:form modelAttribute="persona" action="registrar">
                <form:label path="cedula"> cedula </form:label>
                <form:input path="cedula" />
                <form:label path="nombreCompleto"> Nombre Completo </form:label>
                <form:input path="nombreCompleto" />
                <form:label path="fechaNacimiento"> Fecha de Nacimiento </form:label>
                <form:input path="fechaNacimiento" type="Date"/>

                <input type="submit" value="Registrar">
                </form:form>
            </div>
        </div>
        <div>
            <p>Para ver los vuelos disponibler presione <a href="vuelos"> ver vuelos </a></p>
            <p>Para ver reservas hechas <a href="reservas"> ver reservas </a></p>
            <p>Para ver volver al inicio <a href="home"> ver reservas </a></p>
        </div>
    </body>
</html>
