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
public class ReservaDAO {
    
    private JdbcTemplate template;
    
    public ReservaDAO(JdbcTemplate template){
        this.template = template;
    }
    public void hacerReserva(Reserva reserva){
        String sqlQuerry = "INSERT INTO reservas "
                    + "(cedula,idVuelo,sillas_reserva,fecha_reserva,costo) "
                    + "VALUES ("+reserva.getCedula()+","+reserva.getIdVuelo()+","
                    + reserva.getSillasReserva()+ ",'"+reserva.getFechaReserva()+"',"
                    + reserva.getCosto()+ ")";
        template.update(sqlQuerry);
    }
    
    public List consultarReservas(int cedula){
        String sqlQuerry = "SELECT * FROM reservas WHERE cedula = "+cedula+"";
        List reservas  = template.queryForList(sqlQuerry);
        
        return reservas;
    }
    
    public boolean validadReserva(int cedula){
        
        String sqlQuerry = "SELECT * FROM reservas WHERE cedula = "+cedula
                +" AND fecha_reserva = CURDATE()";
        List siReservo = template.queryForList(sqlQuerry);
        
        return siReservo.isEmpty();
    }
}
