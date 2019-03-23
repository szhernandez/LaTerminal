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
public class datosproveedor {
    private int idProveedor;
    private String nombre;
    private String direccion;
    private String tel1;
    private String tel2;
    private String correo;
    private String representante;
    
    public datosproveedor(int idProveedor, String nombre, String direccion, String tel1, String tel2, String correo, String representante){
    this.idProveedor=idProveedor;
    this.nombre=nombre;
    this.direccion=direccion;
    this.tel1=tel1;
    this.tel2=tel2;
    this.correo=correo;
    this.representante=representante; 
    }
    
    public datosproveedor(){}

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }
    
    
    
    
    
    
}
