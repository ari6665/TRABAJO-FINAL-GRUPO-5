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
public class entradas {
    int idEntrada;
    String nomProd;
    int stock;
    int idCategoria;
    Date fecha;
    int idProveedor;
    double precioE;
    double precioV;
    double total;

    public entradas() {
    }

    public entradas(int idEntrada, String nomProd, int stock, int idCategoria, Date fecha, int idProveedor, double precioE, double precioV, double total) {
        this.idEntrada = idEntrada;
        this.nomProd = nomProd;
        this.stock = stock;
        this.idCategoria = idCategoria;
        this.fecha = fecha;
        this.idProveedor = idProveedor;
        this.precioE = precioE;
        this.precioV = precioV;
        this.total = total;
    }

    
    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public double getPrecioE() {
        return precioE;
    }

    public void setPrecioE(double precioE) {
        this.precioE = precioE;
    }

    public double getPrecioV() {
        return precioV;
    }

    public void setPrecioV(double precioV) {
        this.precioV = precioV;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
   }

