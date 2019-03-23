/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Time;
import java.text.SimpleDateFormat;


/**
 *
 * @author ZAIR
 */
public class datosdetalleventa {
    private Integer idSubventa;
    private Integer idVenta;
    private String idArt;
    private Double precio;
    private Double precioCompra;
    private Integer unidades;
    private Double impuesto;
    private Double subtotal;
    private String observ;
    private String  fecha;
    private String hora;
    
    public datosdetalleventa(Integer idSubventa, Integer idVenta, String idArt,Double precio, Double precioCompra, Integer unidades,
    Double impuesto,Double subtotal,String observ,String fecha, String hora){
    this.idSubventa=idSubventa;
    this.idVenta=idVenta;
    this.idArt=idArt;
    this.precio=precio;
    this.precioCompra=precioCompra;
    this.unidades=unidades;
    this.impuesto=impuesto;
    this.subtotal=subtotal;
    this.observ=observ;
    this.fecha=fecha;
    this.hora=hora;
    
    }
    
    public datosdetalleventa(){}

    public Integer getIdSubventa() {
        return idSubventa;
    }

    public void setIdSubventa(Integer idSubventa) {
        this.idSubventa = idSubventa;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdArt() {
        return idArt;
    }

    public void setIdArt(String idArt) {
        this.idArt = idArt;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioBase) {
        this.precioCompra = precioBase;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }



   

   
   
    
}
