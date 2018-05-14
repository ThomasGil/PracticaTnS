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
import Modelo.app.VueloDAO;
import java.util.List;
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
        model.addAttribute("consulta", new ConsultaReserva());
        return "/reservas";
    }
    
    @RequestMapping(value = "/reservar", method = RequestMethod.POST)
    public String Reservar(Reserva reserva, Model model){
        
        if(     personaDAO.buscarPersona(reserva.getCedula()).size() == 0 ||
                vueloDAO.buscarVuelo(reserva.getIdVuelo()).size() == 0){
            
            model.addAttribute("mensajeError","La cedula o el codigo del vuelo no estan registrados");           
        }
        else{
            reservaDAO.hacerReserva(reserva.getCedula(), reserva.getIdVuelo(), reserva.getSillasReserva());
            model.addAttribute("mensajeBien","La Reserva se realizo con exito");
            List reservas = reservaDAO.consultarReservas(reserva.getCedula());
            model.addAttribute("consultarReservas", reservas);
        }
        return "/reservas";
    }
    
    @RequestMapping(value = "/consultar", method = RequestMethod.POST)
    public String consultar(ConsultaReserva consulta, Model model){
        model.addAttribute("mensajeBien","bien");
        return "/reservas";
    }
    
    public class ConsultaReserva{
        private int cedulaReserva;

        public ConsultaReserva() {
        }
        
        public int getCedulaReserva() {
            return cedulaReserva;
        }

        public void setCedulaReserva(int cedulaReserva) {
            this.cedulaReserva = cedulaReserva;
        }
        
    }
    
}
