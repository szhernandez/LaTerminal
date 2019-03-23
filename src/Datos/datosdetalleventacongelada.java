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
public class datosdetalleventacongelada {
    private Integer iddetalleVentaCongelada;
    private Integer idVentaCongelada;
    private Integer unidades;
    private String idart;
    private String pUnitario;
    private String importe;
    private String observaciones;
    private String impuesto;
    private String fecha;
    private String hora;
   
    public datosdetalleventacongelada(Integer iddetalleVentaCongelada, Integer idVentaCongelada, Integer unidades,String idart, String pUnitario,
    String importe,String observaciones,String impuesto,String fecha, String hora){
    this.iddetalleVentaCongelada=iddetalleVentaCongelada;
    this.idVentaCongelada=idVentaCongelada;
    this.unidades=unidades;
    this.idart=idart;
    this.pUnitario=pUnitario;
    this.importe=importe;
    this.observaciones=observaciones;
    this.impuesto=impuesto;
    this.fecha=fecha;
    this.hora=hora;
    
    }
    
    public datosdetalleventacongelada(){}

    public String getIdart() {
        return idart;
    }

    public void setIdart(String idart) {
        this.idart = idart;
    }

    
    public Integer getIddetalleVentaCongelada() {
        return iddetalleVentaCongelada;
    }

    public void setIddetalleVentaCongelada(Integer iddetalleVentaCongelada) {
        this.iddetalleVentaCongelada = iddetalleVentaCongelada;
    }

    public Integer getIdVentaCongelada() {
        return idVentaCongelada;
    }

    public void setIdVentaCongelada(Integer idVentaCongelada) {
        this.idVentaCongelada = idVentaCongelada;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public String getCodigo() {
        return idart;
    }

    public void setCodigo(String codigo) {
        this.idart = codigo;
    }

    public String getpUnitario() {
        return pUnitario;
    }

    public void setpUnitario(String pUnitario) {
        this.pUnitario = pUnitario;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
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
