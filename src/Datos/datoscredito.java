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
public class datoscredito {
    private Integer idcliente;
    private Double saldo;
     private Double limite;
    private String fecha;
   
    public datoscredito(Integer idcliente,Double saldo,Double limite,String fecha){
    this.idcliente=idcliente;
    this.saldo=saldo;
    this.limite=limite;
    this.fecha=fecha;
    
    }
    
    public datoscredito(){}

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
   public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

 

   

   
}
