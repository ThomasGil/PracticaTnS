/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.app;

import Modelo.app.Conexion;
import Modelo.app.Reserva;
import Modelo.app.Vuelo;
import Modelo.app.VueloDAO;
import java.time.Instant;
import java.util.Calendar;
import java.util.List;
import java.util.Date;
import java.util.Iterator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Personal
 */

@Controller
public class VuelosControlador {
    
    private VueloDAO vueloDAO;
    
    public VuelosControlador(){
        Conexion conexion = new Conexion();
        this.vueloDAO = new VueloDAO(new JdbcTemplate(conexion.conectar()));
    }
    
    @RequestMapping(value = "/vuelos")
    public String vuelos(Model model){ 
        model.addAttribute("vuelo", new Vuelo());
        return "/vuelos";
    }
    
    @RequestMapping(value = "/consultarVuelos", method = RequestMethod.POST)
    public String Reservar(Vuelo vuelo, Model model){
        List vuelos = vueloDAO.buscarVuelo(vuelo.getOrigen(),vuelo.getDestino());    
        model.addAttribute("vuelos", vuelos);
        return "vuelos";
    }
    
    
    public double multiplicador(){
        double multiplicador = 1;
        Calendar date = Calendar.getInstance();
        int dia = date.get(Calendar.DAY_OF_WEEK);
        int hora = date.get(Calendar.HOUR_OF_DAY);
        
        if(1 == dia || dia > 6){
            multiplicador = multiplicador * 1.1;
        }
        
        if(hora >= 12){
            multiplicador = multiplicador * 1.05;
        }
        else{
            multiplicador = multiplicador * 1.07;
        }
        
        return multiplicador;
    }
}
