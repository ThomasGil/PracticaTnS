/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.app;

import Modelo.app.ReservaDAO;
import Modelo.app.Conexion;
import Modelo.app.PersonaDAO;
import Modelo.app.Reserva;
import Modelo.app.Vuelo;
import Modelo.app.VueloDAO;
import java.sql.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Personal
 */
@Controller
public class ReservasControlador {
    
    private ReservaDAO reservaDAO;
    private PersonaDAO personaDAO;
    private VueloDAO vueloDAO;
    
    public ReservasControlador(){
        Conexion conexion = new Conexion();
        reservaDAO = new ReservaDAO(new JdbcTemplate(conexion.conectar()));
        personaDAO = new PersonaDAO(new JdbcTemplate(conexion.conectar()));
        vueloDAO = new VueloDAO(new JdbcTemplate(conexion.conectar()));
    }
    
    @RequestMapping(value = "/reservas")
    public String resevas(Model model){        
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("consultarReserva", new Reserva());
        return "/reservas";
    }
    
    @RequestMapping(value = "/reservar", method = RequestMethod.POST)
    public String Reservar(Reserva reserva, Model model){
        List persona = personaDAO.validarPersona(reserva.getCedula());
        List vuelo = vueloDAO.buscarVuelo(reserva.getIdVuelo());
        
        
        
        Calendar cal = Calendar.getInstance();
        if( persona.isEmpty() || vuelo.isEmpty()){     
            model.addAttribute("mensajeError","La cedula, su edad o el codigo del vuelo no estan registrados");           
        }
        
        else if (!reservaDAO.validadReserva(reserva.getCedula())){
            model.addAttribute("mensajeError","Ya realizo una reserva hoy");
            }
        else{
            String precioAux = vuelo.get(0).toString().split(",")[5].split("=")[1];
            
            float precio = Float.parseFloat(precioAux.substring(0,precioAux.length()-1));
            reserva.setCosto(precio * reserva.getSillasReserva());
            reserva.setFechaReserva(new Date(cal.getTimeInMillis()));
            reservaDAO.hacerReserva(reserva);
            model.addAttribute("mensajeBien","Reserva realizada con exito");
            List reservas = reservaDAO.consultarReservas(reserva.getCedula());
            model.addAttribute("consultarReservas", reservas);
        }
        
        return "/reservas";
    }
    
    @RequestMapping(value = "/consultarReservas", method = RequestMethod.POST)
    public String consultar(Reserva reserva, Model model){
        List reservas = reservaDAO.consultarReservas(reserva.getCedula());
        if(reservas.size()!= 0){
            model.addAttribute("consultarReservas",reservas);
            model.addAttribute("numReservas", reservas.size());
        }
        else{
            model.addAttribute("mensajeReservas","No ha realizado reservas");
        }
        return "/reservas";
    }
    
    
}
