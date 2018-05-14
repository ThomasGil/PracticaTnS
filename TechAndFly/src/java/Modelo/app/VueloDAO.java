/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.app;

import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Personal
 */
public class VueloDAO {
    
    private JdbcTemplate template;
    
    public VueloDAO(JdbcTemplate template){
        this.template = template;
    }
    
    public List<VueloDAO> obtenerVuelos(){
        
        String sqlQuerry = "SELECT * FROM vuelos WHERE fecha >= CURDATE()";
        List vuelos = template.queryForList(sqlQuerry);
        
        return vuelos;
    }
    
    public List buscarVuelo(int idVuelo){
        String sqlQuerry = "SELECT * FROM vuelos WHERE idVuelo = "+idVuelo+"";
        List vuelo = template.queryForList(sqlQuerry);
        return vuelo;
    }
    
}
