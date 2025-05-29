/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Clientes;
import modelo.conexion;
import modelo.entradas;
import modelo.proveedor;
/**
 *
 * @author User
 */
public class DaoProveedor {
     Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insertar(proveedor pro){
        
        String SQL="insert into proveedor (nombre, apellido, documento, RazonS, direccion, telefono, correo) VALUES (?, ?, ?, ?, ?, ?, ?)";
       try {
            con = cn.conectar();
            ps = con.prepareStatement(SQL);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getApellido());
            ps.setString(3, pro.getDocumento());
            ps.setString(4, pro.getRazonS());
            ps.setString(5, pro.getDireccion());
            ps.setString(6, pro.getTelefono());
            ps.setString(7, pro.getCorreo());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }
    }
    
    public List<proveedor> listarProveedor() {
      List<proveedor> listaProveedor = new ArrayList<>();
       String consultaSQL = "SELECT * FROM proveedor";
        try{
          con=(Connection) cn.conectar();
          ps=con.prepareStatement(consultaSQL);
          rs=ps.executeQuery();
          
          while(rs.next()){
            proveedor pro = new proveedor();
            pro.setIdProveedor(rs.getInt(1));  
            pro.setNombre(rs.getString(2));         
            pro.setApellido(rs.getString(3));
            pro.setDocumento(rs.getString(4));
            pro.setRazonS(rs.getString(5));
            pro.setDireccion(rs.getString(6));
            pro.setTelefono(rs.getString(7));
            pro.setCorreo(rs.getString(8));
           listaProveedor.add(pro);

          }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return listaProveedor; 
        
    }
    
    
    
    public boolean editar(proveedor pro) {
    String SQL = "update proveedor set nombre=?, apellido=?, documento=?," +
            "RazonS=?, direccion=?, telefono=?, correo=? where idproveedor=?";
    try {
        con = cn.conectar();
        ps = con.prepareStatement(SQL);
        
        ps.setString(1, pro.getNombre());
        ps.setString(2, pro.getApellido());
        ps.setString(3, pro.getDocumento());
        ps.setString(4, pro.getRazonS());
        ps.setString(5, pro.getDireccion());
        ps.setString(6, pro.getTelefono());
        ps.setString(7, pro.getCorreo());
        ps.setInt(8, pro.getIdProveedor());
        int n = ps.executeUpdate();
        if (n != 0) {
            return true;
        } else {
            return false;
        }
    } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);
        return false;
    }
   }
    
    public boolean eliminar(proveedor pro) {
    String SQL = "delete from proveedor where idproveedor=?";
    try {
        con = cn.conectar();
        ps = con.prepareStatement(SQL);
        
        ps.setInt(1, pro.getIdProveedor());
        int filasAfectadas = ps.executeUpdate();
         return filasAfectadas > 0;
         
    } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);
        return false;
    }
}
    
    
    public boolean buscar(proveedor pro) {
    String SQL = "select * from proveedor where idproveedor=?";
    
    try {
        con = cn.conectar();
        ps = con.prepareStatement(SQL);
        ps.setInt(1, pro.getIdProveedor());
        
        rs = ps.executeQuery();
        if (rs.next()) {
            pro.setIdProveedor(rs.getInt(1));
            pro.setNombre(rs.getString(2));
            pro.setApellido(rs.getString(3));
            pro.setDocumento(rs.getString(4));
            pro.setRazonS(rs.getString(5));
            pro.setDireccion(rs.getString(6));
            pro.setTelefono(rs.getString(7));
            pro.setCorreo(rs.getString(8));
            return true;
        } else {
            return false;
        }
    } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);
        return false;
    }
        }
    
    
    
    public boolean buscarDocumento(proveedor pro) {
    String SQL = "select * from proveedor where documento=?";
    
    try {
        con = cn.conectar();
        ps = con.prepareStatement(SQL);
        ps.setString(1, pro.getDocumento());
        
        rs = ps.executeQuery();
        if (rs.next()) {
            pro.setIdProveedor(rs.getInt(1));
            pro.setNombre(rs.getString(2));
            pro.setApellido(rs.getString(3));
            pro.setDocumento(rs.getString(4));
            pro.setRazonS(rs.getString(5));
            pro.setDireccion(rs.getString(6));
            pro.setTelefono(rs.getString(7));
            pro.setCorreo(rs.getString(8));
            return true;
        } else {
            return false;
        }
    } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);
        return false;
    }
        }
    
    }
    
           
    

