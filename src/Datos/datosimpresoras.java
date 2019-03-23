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
public class datosimpresoras {
    private String idcaja;
    private String impresora_tickets;
    private String impresora_notas;
    private String impresora_etiquetas;
    
    public datosimpresoras(String idcaja,String impresora_tickets, String impresora_notas,String impresora_etiquetas){
    this.idcaja=idcaja;
   
    this.impresora_tickets=impresora_tickets;
    this.impresora_notas=impresora_notas;
    this.impresora_etiquetas=impresora_etiquetas;
    }
    
    public datosimpresoras(){}

    public String getIdcaja() {
        return idcaja;
    }

    public void setIdcaja(String idcaja) {
        this.idcaja = idcaja;
    }

    public String getImpresora_tickets() {
        return impresora_tickets;
    }

    public void setImpresora_tickets(String impresora_tickets) {
        this.impresora_tickets = impresora_tickets;
    }

    public String getImpresora_notas() {
        return impresora_notas;
    }

    public void setImpresora_notas(String impresora_notas) {
        this.impresora_notas = impresora_notas;
    }

    public String getImpresora_etiquetas() {
        return impresora_etiquetas;
    }

    public void setImpresora_etiquetas(String impresora_etiquetas) {
        this.impresora_etiquetas = impresora_etiquetas;
    }

   
}
