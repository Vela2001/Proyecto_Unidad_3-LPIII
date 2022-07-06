/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ProductoDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Producto buscar(int id) {
        Producto p=new Producto();
        String sql="Select * from producto where idproducto="+id;
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
            }
        }
            catch (Exception e) {
            }
        return p;
    }
    
    public int actualizarstock(int id, int stock){
        String sql="update producto set Stock=? where idproducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e){
        }
        return r;
    }
    
    
    public List Listar(){
       String sql="select * from producto";
       List<Producto>lista=new ArrayList<>();
       try {
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
           while (rs.next()){
               Producto p=new Producto();
               p.setId(rs.getInt(1));
               p.setNom(rs.getString(2));
               p.setPrecio(rs.getDouble(3));
               p.setStock(rs.getInt(4));
               p.setEstado(rs.getString(5));
               lista.add(p);
               
           }  
       } catch(Exception e){
       }
       return lista;
    }
    
    public Producto listarId(int id){
        Producto p=new Producto();
        String sql="select * from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
            }
            
        } catch (Exception e) {
            
        }
        return p;
    }
    public int agregar(Producto p){
        
        String sql="insert into producto(Nombres, Precio, Stock, Estado)Values(?,?,?,?)";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.executeUpdate();
        } catch (Exception e){
            
        }
        return r;
    }
    
    public int actualizar(Producto p){
        String sql="update Producto set Nombres=?, Precio=?, Stock=?, Estado=? where IdProducto=?";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
        } catch (Exception e){
            
        }
        return r;
    }
    public void delete(int id){
        String sql="delete from Producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e){
            
        }
    }
}
