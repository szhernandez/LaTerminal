/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Datos.datosarticulo;
import Datos.datosdetalle_equipaje;
import Datos.datosdetalleventa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ZAIR
 */
public class logdetalleequipaje {
    private conexion mysql=new conexion();
    private Connection cn=mysql.conectar();
    private String sSql="";
    public Integer totalregistros;
    
    
    
    public DefaultTableModel mostrar(String buscar){
    DefaultTableModel modelo;
    
    String [] titulos = {"idSubventa","idVenta","unidades","Codigo","Descripcion","P. Uni","P. Compra",
                        "impuesto","Subtotal","	observ","fecha","hora","unidades"};
    String [] registro = new String [19];
    totalregistros=0;
    modelo= new DefaultTableModel(null,titulos){
        //Haciendo la tabla no editable
    public boolean isCellEditable(int row, int column) {return false;}};
    
    sSql="select * from detalle_equipaje,articulo where detalle_equipaje.idArt=articulo.idart and detalle_equipaje.idequipaje ='"+buscar+"'";
    
    try {
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
            registro [0]=rs.getString("detalle_equipaje.idSubventa");
            registro [1]=rs.getString("detalle_equipaje.idVenta");
            registro [2]=rs.getString("detalle_equipaje.unidades");
            registro [3]=rs.getString("detalle_equipaje.idArt");
            registro [4]=rs.getString("articulo.descripcion");
            registro [5]=rs.getString("detalle_equipaje.precio");
            registro [6]=rs.getString("detalle_equipaje.precioCompra");
            registro [7]=rs.getString("detalle_equipaje.impuesto");
            registro [8]=rs.getString("detalle_equipaje.subtotal");
            registro [9]=rs.getString("detalle_equipaje.observ");
            registro [10]=rs.getString("detalle_equipaje.fecha");
            registro [11]=rs.getString("detalle_equipaje.hora");
            registro [12]=rs.getString("detalle_equipaje.unidades");//Duplico unidades para saber el numero de unidades maximo a devolver
            totalregistros=totalregistros+1;
            modelo.addRow(registro);
           
            }
           return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar articulo: "+e);
            return null;
        }
    }
        
      public boolean insertar(datosdetalle_equipaje dts){
        sSql="insert into detalle_equipaje(idequipaje,idArt,precio,PrecioCompra,unidades,tiempo,impuesto,"
                + "subtotal,observ,fechainicio,fechafin)"+
                "values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst=cn.prepareStatement(sSql);
           // pst.setInt(1,dts.getIdSubventa());
            pst.setInt(1, dts.getIdEquipaje());
            pst.setString(2, dts.getIdArt());
            pst.setDouble(3, dts.getPrecio());
            pst.setDouble(4, dts.getPrecioCompra());
            pst.setInt(5, dts.getUnidades());
            pst.setDouble(6, dts.getTiempo());
            pst.setDouble(7, dts.getImpuesto());
            pst.setDouble(8, dts.getSubtotal());
            pst.setString(9, dts.getObserv());
            pst.setString(10,dts.getFechainicio());
            pst.setString(11, dts.getFechafin());
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
            
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
      
       public boolean editar(datosdetalle_equipaje dts){
        sSql="update detalle_equipaje set  tiempo=?, subtotal=?, fechafin=? where idequipaje=?";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setDouble(1, dts.getTiempo());
            pst.setDouble(2, dts.getSubtotal());
            pst.setString(3, dts.getFechafin());
            pst.setInt(4, dts.getIdEquipaje());
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
  
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
        public boolean eliminar(datosdetalle_equipaje dts){
        sSql="delete from detalle_equipaje where iddetalle_equipaje=?";

            try {
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1,dts.getIddetalle_equipaje());

            int n=pst.executeUpdate();
            
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
             return false;
        }
    }
        
        
     //Consulta para punto de venta
 
 

 
}
