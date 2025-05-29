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
import modelo.detalleSalida;

/**
 *
 * @author User
 */
public class DaoDetaSalida {
    
  Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insertar(int idSalida, int idEntrada, int cant, double importe){
        
        String SQL="insert into detallesalida (id, idSalida, idEndtrada, cantidad, importe) VALUES ("+idSalida+","+","+idEntrada+","+cant+","+importe+")";
       try {
            con = cn.conectar();
            ps = con.prepareStatement(SQL);
            return ps.executeUpdate() > 0;
         } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            return false;
        }
   }  
    
}
