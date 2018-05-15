/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.app;

import java.sql.Date;

/**
 *
 * @author Personal
 */
public class Reserva {
    private int cedula;
    private int idVuelo;
    private int sillasReserva;
    private Date fechaReserva;
    private float costo;
    

    public Reserva() {
    }

    public Reserva(int cedula, int idVuelo, int sillasReserva, Date fechaReserva, float costo) {
        this.cedula = cedula;
        this.idVuelo = idVuelo;
        this.sillasReserva = sillasReserva;
        this.fechaReserva = fechaReserva;
        this.costo = costo;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public int getSillasReserva() {
        return sillasReserva;
    }

    public void setSillasReserva(int sillasReserva) {
        this.sillasReserva = sillasReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
    
    
}
