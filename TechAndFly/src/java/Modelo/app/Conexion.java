/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.app;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Personal
 */
public class Conexion {
    
    public DriverManagerDataSource conectar(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3305/tech_and_fly");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        
        return dataSource;
    }
}
