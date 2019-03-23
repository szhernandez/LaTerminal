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
public class datostrabajador {
    private int idTrab;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String domicilio;
    private String usuario;
    private String contrasena;
    private String rol;
    private String estado;
    private String comision;

    public datostrabajador(int idTrab, String nombre, String apellidos, String telefono, String domicilio, String usuario, String contrasena, String rol, String estado, String comision) {
        this.idTrab = idTrab;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
        this.estado = estado;
        this.comision = comision;
    }

    public datostrabajador() {  
    }

    public int getIdTrab() {
        return idTrab;
    }

    public void setIdTrab(int idTrab) {
        this.idTrab = idTrab;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contraseña) {
        this.contrasena = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComision() {
        return comision;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }
}
