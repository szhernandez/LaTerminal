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
public class datosdetallecompra {
    private Integer idSubCompra;
    private Integer idCompra;
    private String idArt;
    private Integer unidades;
    private Double precio;
    private Double impuesto;
    
    public datosdetallecompra(Integer idSubCompra, Integer idCompra, String idArt,Integer unidades, Double precio, Double impuesto){
    this.idSubCompra=idSubCompra;
    this.idCompra=idCompra;
    this.idArt=idArt;
    this.unidades=unidades;
    this.precio=precio;
    this.impuesto=impuesto;
    }
    
    public datosdetallecompra(){}

    public Integer getIdSubCompra() {
        return idSubCompra;
    }

    public void setIdSubCompra(Integer idSubCompra) {
        this.idSubCompra = idSubCompra;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdArt() {
        return idArt;
    }

    public void setIdArt(String idArt) {
        this.idArt = idArt;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    
}
