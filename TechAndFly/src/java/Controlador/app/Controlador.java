/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.app;

import Modelo.app.Conexion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Personal
 */
@Controller
public class Controlador {
    
    private JdbcTemplate template;
    
    public Controlador(){
        Conexion conexion = new Conexion();
        this.template = new JdbcTemplate(conexion.conexion());
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)  
    public String index(){
        return "index";
    }
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("ejemplo", "vuelo1");
        return "home";
    }
}
