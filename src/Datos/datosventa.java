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
public class datosventa {
    private Integer idVenta;
    private String estado;
    private Double importe;
    private Double pago;
    private String fecha;
    private String hora;
    private Integer idCliente;
    private Integer idTrab;
    private String idCaja;
    
    public datosventa(Integer idVenta, String estado, Double importe,Double pago, String fecha, String hora,
    Integer idCliente,Integer idTrab,String idCaja){
    this.idVenta=idVenta;
    this.estado=estado;
    this.importe=importe;
    this.pago=pago;
    this.fecha=fecha;
    this.hora=hora;
    this.idCliente=idCliente;
    this.idTrab=idTrab;
    this.idCaja=idCaja;
    
    }
    
    public datosventa(){}

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getPago() {
        return pago;
    }

    public void setPago(Double pago) {
        this.pago = pago;
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

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdTrab() {
        return idTrab;
    }

    public void setIdTrab(Integer idTrab) {
        this.idTrab = idTrab;
    }

    public String getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(String idCaja) {
        this.idCaja = idCaja;
    }


}
