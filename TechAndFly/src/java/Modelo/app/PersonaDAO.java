/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.app;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Personal
 */
public class PersonaDAO {
    
    private JdbcTemplate template;
    
    public PersonaDAO(JdbcTemplate template){
        this.template = template;
    }
    
    public List buscarPersona(int cedula){
        String sqlQuerry = "SELECT * FROM personas WHERE cedula = "+cedula+"";
        List persona = template.queryForList(sqlQuerry);
        return persona;
    }
    
    public void registraPersona(Persona persona){
        String sqlQuerry = "INSERT INTO personas (cedula,nombre_completo,fecha_nacimiento)" 
                + " VALUES ("+persona.getCedula()+",'"+persona.getNombreCompleto()+"','"
                + persona.getFechaNacimiento()+ "')";
        
        template.update(sqlQuerry);
    }
    
}
