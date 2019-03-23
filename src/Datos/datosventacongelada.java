/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author ZAIR
 */
public class datosventacongelada {
    private Integer idventaCongelada;
    private Integer idCliente;
    private String tipoDoc;
    private String precioAplic;
    private Integer idtrabajador;
    private String preciototal;
    private String fecha;
    private String hora;
    
    public datosventacongelada(Integer idventaCongelada, Integer idCliente, String tipoDoc, String precioAplic, Integer idtrabajador,
    String preciototal, String fecha, String hora){
    this.idventaCongelada=idventaCongelada;
    this.idCliente=idCliente;
    this.tipoDoc=tipoDoc;
    this.precioAplic=precioAplic;
    this.idtrabajador=idtrabajador;
    this.preciototal=preciototal;
    this.fecha=fecha;
    this.hora=hora;
    }
    
    public datosventacongelada(){}
    
    

    public Integer getIdventaCongelada() {
        return idventaCongelada;
    }

    public void setIdventaCongelada(Integer idventaCongelada) {
        this.idventaCongelada = idventaCongelada;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    
    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getPrecioAplic() {
        return precioAplic;
    }

    public void setPrecioAplic(String precioAplic) {
        this.precioAplic = precioAplic;
    }

    public Integer getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(Integer idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public String getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(String preciototal) {
        this.preciototal = preciototal;
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
