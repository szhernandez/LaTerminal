/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Datos.datosarticulo;
import Datos.datosdetalleventa;
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
public class logdetalleventa {
    //private conexion mysql=new conexion();
    Pool_conexion metodospool = new Pool_conexion();
    private Connection cn = null;
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
    try {
        cn = metodospool.dataSource.getConnection();
        sSql="select * from detalleventa,articulo where detalleventa.idArt=articulo.idart and detalleventa.idventa ='"+buscar+"'";
    
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
            registro [0]=rs.getString("detalleventa.idSubventa");
            registro [1]=rs.getString("detalleventa.idVenta");
            registro [2]=rs.getString("detalleventa.unidades");
            registro [3]=rs.getString("detalleventa.idArt");
            registro [4]=rs.getString("articulo.descripcion");
            registro [5]=rs.getString("detalleventa.precio");
            registro [6]=rs.getString("detalleventa.precioCompra");
            registro [7]=rs.getString("detalleventa.impuesto");
            registro [8]=rs.getString("detalleventa.subtotal");
            registro [9]=rs.getString("detalleventa.observ");
            registro [10]=rs.getString("detalleventa.fecha");
            registro [11]=rs.getString("detalleventa.hora");
            registro [12]=rs.getString("detalleventa.unidades");//Duplico unidades para saber el numero de unidades maximo a devolver
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
        
    public boolean insertar(datosdetalleventa dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="insert into detalleventa(idVenta,idArt,precio,PrecioCompra,unidades,impuesto,"
                + "subtotal,observ,fecha,hora)"+
                "values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
           // pst.setInt(1,dts.getIdSubventa());
            pst.setInt(1, dts.getIdVenta());
            pst.setString(2, dts.getIdArt());
            pst.setDouble(3, dts.getPrecio());
            pst.setDouble(4, dts.getPrecioCompra());
            pst.setInt(5, dts.getUnidades());
            pst.setDouble(6, dts.getImpuesto());
            pst.setDouble(7, dts.getSubtotal());
            pst.setString(8, dts.getObserv());
            pst.setString(9,dts.getFecha());
            pst.setString(10, dts.getHora());
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
      
       public boolean editar(datosdetalleventa dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update detalleventa set  unidades=?, subtotal=?, fecha=?,hora=? where idSubventa=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1, dts.getUnidades());
            pst.setDouble(2, dts.getSubtotal());
            pst.setString(3, dts.getFecha());
            pst.setString(4, dts.getHora());
            pst.setDouble(5, dts.getIdSubventa());
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
        public boolean eliminar(datosdetalleventa dts){
        
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="delete from detalleventa where idSubventa=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1,dts.getIdSubventa());
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
        //Se utiliza para cuando pasa el recolector de basura
    public void finalize() throws SQLException{
        cn.close();
    }
}
