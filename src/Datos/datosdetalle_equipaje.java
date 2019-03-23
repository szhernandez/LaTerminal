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
public class datosdetalle_equipaje {
    private Integer iddetalle_equipaje;
    private Integer idEquipaje;
    private String idArt;
    private Double precio;
    private Double precioCompra;
    private Integer unidades;
    private Double tiempo;
    private Double impuesto;
    private Double subtotal;
    private String observ;
    private String  fechainicio;
    private String fechafin;
    
    public datosdetalle_equipaje(Integer iddetalle_equipaje, Integer idEquipaje, String idArt,Double precio, Double precioCompra, Integer unidades,
     Double tiempo,Double impuesto,Double subtotal,String observ,String fechainicio, String fechafin){
    this.iddetalle_equipaje=iddetalle_equipaje;
    this.idEquipaje=idEquipaje;
    this.idArt=idArt;
    this.precio=precio;
    this.precioCompra=precioCompra;
    this.unidades=unidades;
    this.tiempo=tiempo;
    this.impuesto=impuesto;
    this.subtotal=subtotal;
    this.observ=observ;
    this.fechainicio=fechainicio;
    this.fechafin=fechafin;
    
    }
    
    public datosdetalle_equipaje(){}

    public Integer getIddetalle_equipaje() {
        return iddetalle_equipaje;
    }

    public void setIddetalle_equipaje(Integer iddetalle_equipaje) {
        this.iddetalle_equipaje = iddetalle_equipaje;
    }

    public Integer getIdEquipaje() {
        return idEquipaje;
    }

    public void setIdEquipaje(Integer idEquipaje) {
        this.idEquipaje = idEquipaje;
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

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Double getTiempo() {
        return tiempo;
    }

    public void setTiempo(Double tiempo) {
        this.tiempo = tiempo;
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

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }
    
}
