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
public class datoscompra {
    private Integer idcompra;
    private String estado;
    private Double importe;
    private Integer idTrab;
    private Integer idProveedor;
    private String fecha;
    
    
    public datoscompra(Integer idcompra, String estado, Double importe,Integer idTrab, Integer idProveedor, String fecha)
    {
    this.idcompra=idcompra;
    this.estado=estado;
    this.importe=importe;
    this.idTrab=idTrab;
    this.idProveedor=idProveedor;
    this.fecha=fecha;
    }
    
    public datoscompra(){}

    public Integer getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Integer idcompra) {
        this.idcompra = idcompra;
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

    public Integer getIdTrab() {
        return idTrab;
    }

    public void setIdTrab(Integer idTrab) {
        this.idTrab = idTrab;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
