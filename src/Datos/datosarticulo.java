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
public class datosarticulo {
    private String idArt;
    private String descripcion;
    private String marca;
    private String tipo;
    private String impuesto;
    private Double precioCompra;
    private Double precioVenta1;
    private Double precioVenta2;
    private Double precioVenta3;
    private Double precioVenta4;
    private Double precioVenta5;
    private String imagen;
    private Double Existencia;
    private Double stockMin;
    private Double stockMax;
    private String observaciones;
    private String fecha;
    private String hora;
    private Double peso;
    
    public datosarticulo(String idArt, String descripcion, String marca,String tipo, String impuesto, Double precioCompra, 
            Double precioVenta1,Double precioVenta2,Double precioVenta3,Double precioVenta4,Double precioVenta5,
            String imagen,Double Existencia,Double stockMin,Double stockMax,String observaciones,String fecha,String hora,
            Double peso){
    this.idArt=idArt;
    this.descripcion=descripcion;
    this.marca=marca;
    this.tipo=tipo;
    this.impuesto=impuesto;
    this.precioCompra=precioCompra;
    this.precioVenta1=precioVenta1;
    this.precioVenta2=precioVenta2;
    this.precioVenta3=precioVenta3;
    this.precioVenta4=precioVenta4;
    this.precioVenta5=precioVenta5;
    this.imagen=imagen; 
     this.Existencia=Existencia;
    this.stockMin=stockMin;
    this.stockMax=stockMax;
    this.observaciones=observaciones;
    this.fecha=fecha;
    this.hora=hora; 
    this.peso=peso; 
    }
    
    public datosarticulo(){}

    public String getIdArt() {
        return idArt;
    }

    public void setIdArt(String idArt) {
        this.idArt = idArt;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta1() {
        return precioVenta1;
    }

    public void setPrecioVenta1(Double precioVenta1) {
        this.precioVenta1 = precioVenta1;
    }

    public Double getPrecioVenta2() {
        return precioVenta2;
    }

    public void setPrecioVenta2(Double precioVenta2) {
        this.precioVenta2 = precioVenta2;
    }

    public Double getPrecioVenta3() {
        return precioVenta3;
    }

    public void setPrecioVenta3(Double precioVenta3) {
        this.precioVenta3 = precioVenta3;
    }

    public Double getPrecioVenta4() {
        return precioVenta4;
    }

    public void setPrecioVenta4(Double precioVenta4) {
        this.precioVenta4 = precioVenta4;
    }

    public Double getPrecioVenta5() {
        return precioVenta5;
    }

    public void setPrecioVenta5(Double precioVenta5) {
        this.precioVenta5 = precioVenta5;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getExistencia() {
        return Existencia;
    }

    public void setExistencia(Double Existencia) {
        this.Existencia = Existencia;
    }

    public Double getStockMin() {
        return stockMin;
    }

    public void setStockMin(Double stockMin) {
        this.stockMin = stockMin;
    }

    public Double getStockMax() {
        return stockMax;
    }

    public void setStockMax(Double stockMax) {
        this.stockMax = stockMax;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    

}
