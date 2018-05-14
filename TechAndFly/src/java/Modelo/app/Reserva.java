/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.app;

/**
 *
 * @author Personal
 */
public class Reserva {
    private int cedula;
    private int idVuelo;
    private int sillasReserva;

    public Reserva() {
    }

    public Reserva(int cedula, int idVuelo, int sillasReserva) {
        this.cedula = cedula;
        this.idVuelo = idVuelo;
        this.sillasReserva = sillasReserva;
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
    
}
