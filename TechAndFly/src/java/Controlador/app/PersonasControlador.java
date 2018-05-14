/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.app;

import Modelo.app.Conexion;
import Modelo.app.Persona;
import Modelo.app.PersonaDAO;
import Modelo.app.Reserva;
import java.util.List;
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
public class PersonasControlador {
    private PersonaDAO personaDAO;
    
    public PersonasControlador(){
        Conexion conexion = new Conexion();
        this.personaDAO = new PersonaDAO( new JdbcTemplate(conexion.conectar()));
    }
    
    @RequestMapping("/personas")
    public String personas(Model model){
        model.addAttribute("persona", new Persona());
        return "personas";
    }
    
    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    public String Registrar(Persona persona, Model model){
        if(personaDAO.buscarPersona(persona.getCedula()).size() != 0){
            model.addAttribute("mensajeError", "Ya hay un usuario con esa cedula");
        }
        else{
            personaDAO.registraPersona(persona);
            model.addAttribute("mensajeBien", "El Registro se ha realizado con EXITO");
        }
        return "personas";
    }
}
