/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.conexion;
import modelo.productos;

/**
 *
 * @author User
 */
public class DaoProductos {
    
    public boolean insertar(productos p){
        
         Connection con;
         conexion cn=new conexion();
         PreparedStatement ps;
         ResultSet rs;
        
       String SQL = "insert into productos (nombre, stock, idCategoria, fecha, idproveedor, precioV) VALUES (?, ?, ?, ?, ?, ?)";

      
       try {
            con = cn.conectar();
            ps = con.prepareStatement(SQL);
            ps.setString(1, p.getNomProd());
            ps.setInt(2, p.getStock());
            ps.setInt(3, p.getIdCategoria());
            ps.setDate(4, p.getFecha());
            ps.setInt(5, p.getIdproveedor());      
            ps.setDouble(6, p.getPrecioV());
            
            return ps.executeUpdate() > 0;
         } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            return false;
        }
    }
   }
    
