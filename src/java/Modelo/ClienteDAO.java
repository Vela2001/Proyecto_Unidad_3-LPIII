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
    
    public List Listar(){
       String sql="select * from cliente";
       List<Cliente>lista=new ArrayList<>();
       try {
           con=cn.Conexion();
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
           while (rs.next()){
               Empleado em=new Empleado();
               em.setId(rs.getInt(1));
               em.setDni(rs.getString(2));
               em.setNom(rs.getString(3));
               em.setTel(rs.getString(4));
               em.setEstado(rs.getString(5));
               em.setUser(rs.getString(6));
               lista.add(em);
               
           }  
       } catch(Exception e){
       }
       return lista;
    }
}
