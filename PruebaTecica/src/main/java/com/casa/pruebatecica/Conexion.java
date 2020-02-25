/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.casa.pruebatecica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Conexion {

    public Connection obtenerConexion() {
         Connection cnn = null;
        try {
           
            String ip = "localhost", usuario = "system", pass = "admin", port = "1521", sid = "orcle", jdbc = "";
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            
            jdbc = "jdbc:oracle:thin:@" + ip + ":" + port + ":" + sid;
            
            cnn = DriverManager.getConnection(jdbc, usuario, pass);
            
            Statement stmt = cnn.createStatement();
            ResultSet rset = null;
            try {
                rset = stmt.executeQuery("select * from Stok");
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (rset.next()) {
                System.out.println(rset.getString(1));   // Print col 1
            }
            stmt.close();
            
            return cnn;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnn;
    }

    public void cerrarConexion(Connection cnn) {
        try {
            cnn.close();
        } catch (SQLException e) {
        }
    }
}
