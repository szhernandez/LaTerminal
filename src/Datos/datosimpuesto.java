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
public class datosimpuesto {
    private String idImpuesto;
    private String descripcion;
    private Double valor;
   
    
    public datosimpuesto(String idImpuesto, String descripcion, Double valor){
    this.idImpuesto=idImpuesto;
    this.descripcion=descripcion;
    this.valor=valor;
    }
    
    public datosimpuesto(){}

    public String getIdImpuesto() {
        return idImpuesto;
    }

    public void setIdImpuesto(String idImpuesto) {
        this.idImpuesto = idImpuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

   
    
    
    
    
    
    
}
