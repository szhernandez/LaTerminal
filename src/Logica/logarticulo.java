/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.datosarticulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ZAIR
 */
public class logarticulo {
     //private conexion mysql=new conexion();
    Pool_conexion metodospool = new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    
    
    //Codigo para datos de tabla, creando tabla
    //La funcion buscar, recupera todos los datos de la tabla cientes
    public DefaultTableModel mostrar(String buscar){
    DefaultTableModel modelo;
    String [] titulos = {"ID","Descripcion","Marca","Tipo","Impuesto","Precio Compra",
                        "P. Max","Precio 2","Precio 3","Precio 4","Precio 5",
                        "Imagen","Existencia","StockMin","StockMax","Observaciones","Fecha","Hora","Peso"};
    String [] registro = new String [19];
    totalregistros=0;
    modelo= new DefaultTableModel(null,titulos){
        //Haciendo la tabla no editable
    public boolean isCellEditable(int row, int column) {return false;}};
    try {
        cn = metodospool.dataSource.getConnection();
        sSql="select * from articulo where descripcion like'%"+buscar+"%' or idArt like'%"+buscar+"%' order by idArt";
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
            registro [0]=rs.getString("idArt");
            registro [1]=rs.getString("descripcion");
            registro [2]=rs.getString("marca");
            registro [3]=rs.getString("tipo");
            registro [4]=rs.getString("impuesto");
            registro [5]=rs.getString("precioCompra");
            registro [6]=rs.getString("precioVenta1");
            registro [7]=rs.getString("precioVenta2");
            registro [8]=rs.getString("precioVenta3");
            registro [9]=rs.getString("precioVenta4");
            registro [10]=rs.getString("precioVenta5");
            registro [11]=rs.getString("imagen");
            registro [12]=rs.getString("Existencia");
            registro [13]=rs.getString("stockMin");
            registro [14]=rs.getString("stockMax");
            registro [15]=rs.getString("observaciones");
            registro [16]=rs.getString("fecha");
            registro [17]=rs.getString("hora");
            registro [18]=rs.getString("peso");
            totalregistros=totalregistros+1;
            modelo.addRow(registro);
            }
           return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar articulo: "+e);
            return null;
        }finally{
        try {
            cn.close();

            } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
      
    public boolean insertar(datosarticulo dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="insert into articulo(idArt,descripcion,marca,tipo,impuesto,precioCompra,precioVenta1,precioVenta2,precioVenta3,precioVenta4,precioVenta5,"
                + "imagen,Existencia,stockMin,stockMax,observaciones,fecha,hora,peso)"+
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1,dts.getIdArt());
            pst.setString(2, dts.getDescripcion());
            pst.setString(3, dts.getMarca());
            pst.setString(4, dts.getTipo());
            pst.setString(5, dts.getImpuesto());
            pst.setDouble(6, dts.getPrecioCompra());
            pst.setDouble(7, dts.getPrecioVenta1());
            pst.setDouble(8, dts.getPrecioVenta2());
            pst.setDouble(9, dts.getPrecioVenta3());
            pst.setDouble(10, dts.getPrecioVenta4());
            pst.setDouble(11, dts.getPrecioVenta5());
            pst.setString(12, dts.getImagen());
            pst.setDouble(13, dts.getExistencia());
            pst.setDouble(14, dts.getStockMin());
            pst.setDouble(15, dts.getStockMax());
            pst.setString(16, dts.getObservaciones());
            pst.setString(17, dts.getFecha());
            pst.setString(18, dts.getHora());
            pst.setDouble(19, dts.getPeso());
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error al insertar articulo"+ e);
            return false;
        }finally{
        try {
            cn.close();

            } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
      
    public boolean editar(datosarticulo dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update articulo set  descripcion=?, marca=?, tipo=?,impuesto=?,precioCompra=?,"
                + "precioVenta1=?,precioVenta2=?,precioVenta3=?,precioVenta4=?,precioVenta5=?,"
                + "imagen=?, Existencia=?, stockMin=?,stockMax=?,observaciones=?,fecha=?,hora=?,peso=?"+
                   "where idArt=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1, dts.getDescripcion());
            pst.setString(2, dts.getMarca());
            pst.setString(3, dts.getTipo());
            pst.setString(4, dts.getImpuesto());
            pst.setDouble(5, dts.getPrecioCompra());
            pst.setDouble(6, dts.getPrecioVenta1());
            pst.setDouble(7, dts.getPrecioVenta2());
            pst.setDouble(8, dts.getPrecioVenta3());
            pst.setDouble(9, dts.getPrecioVenta4());
            pst.setDouble(10, dts.getPrecioVenta5());
            pst.setString(11,dts.getImagen());
            pst.setDouble(12,dts.getExistencia());
            pst.setDouble(13,dts.getStockMin());
            pst.setDouble(14,dts.getStockMax());
            pst.setString(15,dts.getObservaciones());
            pst.setString(16,dts.getFecha());
            pst.setString(17,dts.getHora());
            pst.setDouble(18,dts.getPeso());
            pst.setString(19,dts.getIdArt());
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
        }finally{
        try {
            cn.close();

            } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public boolean eliminar(datosarticulo dts){
       try {
           cn = metodospool.dataSource.getConnection();
            sSql="delete from articulo where idArt=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1,dts.getIdArt());
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
        }finally{
        try {
            cn.close();

            } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //Consulta para punto de venta
    public String [] mostrarselectivo(String buscar){
   
    String [] registro = new String [19];
    totalregistros=0;
    datosarticulo datos = new datosarticulo();
    try {
        cn = metodospool.dataSource.getConnection();
        sSql="select * from articulo where idArt ='"+buscar+"'";
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
           registro [0]=rs.getString("idArt");
            registro [1]=rs.getString("descripcion");
            registro [2]=rs.getString("marca");
            registro [3]=rs.getString("tipo");
            registro [4]=rs.getString("impuesto");
            registro [5]=rs.getString("precioCompra");
            registro [6]=rs.getString("precioVenta1");
            registro [7]=rs.getString("precioVenta2");
            registro [8]=rs.getString("precioVenta3");
            registro [9]=rs.getString("precioVenta4");
            registro [10]=rs.getString("precioVenta5");
            registro [11]=rs.getString("imagen");
            registro [12]=rs.getString("Existencia");
            registro [13]=rs.getString("stockMin");
            registro [14]=rs.getString("stockMax");
            registro [15]=rs.getString("observaciones");
            registro [16]=rs.getString("fecha");
            registro [17]=rs.getString("hora");
            registro [18]=rs.getString("peso");
            totalregistros=totalregistros+1;
            }
           return registro;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar articulo seleccionado en venta: "+e);
            return null;
        }finally{
        try {
            cn.close();

            } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
  
 
  public void existenciasupdate(Double cantidad, String idart){
          
      try {
          cn = metodospool.dataSource.getConnection();
           sSql="update articulo set Existencia=? where idArt=?";
           PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setDouble(1, cantidad);
            pst.setString(2,idart);
            int n=pst.executeUpdate();
      } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error al actualizar existencia "+e);
      }finally{
        try {
            cn.close();

            } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);
            }
        }
  }
  public void existenciasuma(Double cantidad, String idart){
        try {
           cn = metodospool.dataSource.getConnection();
           sSql="update articulo set Existencia=Existencia+? where idArt=?";
           PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setDouble(1, cantidad);
            pst.setString(2,idart);
               int n=pst.executeUpdate();
      } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error al sumar existencia "+e);
      }finally{
        try {
            cn.close();

            } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);
            }
        }
  }
  public void existenciaresta(Double cantidad, String idart){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update articulo set Existencia=Existencia-? where idArt=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setDouble(1, cantidad);
            pst.setString(2,idart);
            int n=pst.executeUpdate();
      } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error al sumar existencia "+e);
      }finally{
        try {
            cn.close();

            } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);
            }
        }
  }
  public  void actualizarpreciocompra(datosarticulo dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update articulo set precioCompra=? where idArt=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setDouble(1, dts.getPrecioCompra());
            pst.setString(2,dts.getIdArt());
            int n=pst.executeUpdate();
      } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error al actualizar precio de compra logart"+e);
      }finally{
        try {
            cn.close();

            } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);
            }
        }
  }
  public void actualizarprecioventa(datosarticulo dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update articulo set precioVenta1=?,precioVenta2=?,precioVenta3=?,precioVenta4=?,precioVenta5=? where idArt=?"; 
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setDouble(1, dts.getPrecioVenta1());
            pst.setDouble(2, dts.getPrecioVenta2());
            pst.setDouble(3, dts.getPrecioVenta3());
            pst.setDouble(4, dts.getPrecioVenta4());
            pst.setDouble(5, dts.getPrecioVenta5());
            pst.setString(6,dts.getIdArt());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Lo hise");
      } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error al actualizar precios de venta logart"+e);
      }finally{
        try {
            cn.close();

            } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);
            }
        }
  }
  //Se utiliza para cuando pasa el recolector de basura
    public void finalize() throws SQLException{
        cn.close();
    }
}
