/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author User
 */
public class salidas {
    
int idSalida;
String numSalida;
int idCliente;
Date fecha;
double subTotal;
double igv;
double total;

 public salidas() {
     
  }

    public salidas(int idSalida, String numSalida, int idCliente, Date fecha, double subTotal, double igv, double total) {
        this.idSalida = idSalida;
        this.numSalida = numSalida;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.subTotal = subTotal;
        this.igv = igv;
        this.total = total;
    }

    public String getNumSalida() {
        return numSalida;
    }

    public void setNumSalida(String numSalida) {
        this.numSalida = numSalida;
    }


    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

 
}
