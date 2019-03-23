/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author ZAIR
 */
public class datoscaja {
    private String idcaja;
    private String nombre;
    private String estado;
    private Double dinero;
    
    public datoscaja(String idcaja, String nombre, String estado, Double dinero){
    this.idcaja=idcaja;
    this.nombre=nombre;
    this.estado=estado;
    this.dinero=dinero;
    
    }
    
    public datoscaja(){}

    public String getIdcaja() {
        return idcaja;
    }

    public void setIdcaja(String idcaja) {
        this.idcaja = idcaja;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getDinero() {
        return dinero;
    }

    public void setDinero(Double dinero) {
        this.dinero = dinero;
    }

   
}
