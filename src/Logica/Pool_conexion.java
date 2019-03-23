/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author ZAIR
 */
public class Pool_conexion {
    public DataSource dataSource;
    public String db = "smartpos_terminal";
    public String url = "jdbc:mysql://localhost/"+db;
    public String user = "root";
    public String pass = "";
    
    public Pool_conexion(){
    inicializaDataSource();
    }
    
    private void inicializaDataSource() {
    BasicDataSource basicDataSource = new BasicDataSource();
    basicDataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
    basicDataSource.setUsername(user);
    basicDataSource.setPassword(pass);
    basicDataSource.setUrl(url);
    basicDataSource.setMaxActive(3);
    dataSource = basicDataSource;
}
}
