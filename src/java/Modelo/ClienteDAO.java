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
public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Cliente buscar(String dni){
        Cliente c=new Cliente();
        String sql="Select * from cliente where Dni="+dni;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDir(rs.getString(4));
                c.setEs(rs.getString(5))
            }
        } catch (Exception e) {
        }
        return c;
    }
    
    public List Listar(){
       String sql="select * from cliente";
       List<Cliente>lista=new ArrayList<>();
       try {
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
           while (rs.next()){
               Cliente cli=new Cliente();
               cli.setId(rs.getInt(1));
               cli.setDni(rs.getString(2));
               cli.setNom(rs.getString(3));
               cli.setTel(rs.getString(4));
               cli.setEstado(rs.getString(5));
               cli.setUser(rs.getString(6));
               lista.add(cli);
               
           }  
       } catch(Exception e){
       }
       return lista;
    }
}
