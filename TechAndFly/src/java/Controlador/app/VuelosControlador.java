/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.app;

import Modelo.app.Conexion;
import Modelo.app.VueloDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Personal
 */

@Controller
public class VuelosControlador {
    
    private VueloDAO vuelo;
    
    public VuelosControlador(){
        Conexion conexion = new Conexion();
        this.vuelo = new VueloDAO(new JdbcTemplate(conexion.conectar()));
    }
    
    @RequestMapping(value = "/vuelos", method = RequestMethod.GET)
    public String vuelos(Model model){        
        model.addAttribute("vuelos", vuelo.obtenerVuelos());
        
        return "/vuelos";
    }
    
}
