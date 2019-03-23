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
public class datosmovimientos_caja {
    private Integer idmovimiento;
    private Double Monto;
    private String Concepto;
    private String Fecha;
    private Integer IdTrab;
    private String idcaja;
    
   
    
    public datosmovimientos_caja(Integer idmovimiento, Double Monto, String Concepto, String Fecha, Integer IdTrab,String idcaja){
    this.idmovimiento=idmovimiento;
    this.Monto=Monto;
    this.Concepto=Concepto;
    this.Fecha=Fecha;
    this.IdTrab=IdTrab;
    this.idcaja=idcaja;
    }
    
    public datosmovimientos_caja(){}

    public Integer getIdmovimiento() {
        return idmovimiento;
    }

    public void setIdmovimiento(Integer idmovimiento) {
        this.idmovimiento = idmovimiento;
    }

    public Double getMonto() {
        return Monto;
    }

    public void setMonto(Double Monto) {
        this.Monto = Monto;
    }

    public String getConcepto() {
        return Concepto;
    }

    public void setConcepto(String Concepto) {
        this.Concepto = Concepto;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public Integer getIdTrab() {
        return IdTrab;
    }

    public void setIdTrab(Integer IdTrab) {
        this.IdTrab = IdTrab;
    }

    public String getIdcaja() {
        return idcaja;
    }

    public void setIdcaja(String idcaja) {
        this.idcaja = idcaja;
    }

    

   
}
