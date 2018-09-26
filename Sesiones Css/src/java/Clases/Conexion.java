/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.sql.*;


/**
 *
 * @author Alumno
 */
public class Conexion {
    String url;
    String User;
    String Pass;
    Connection con;
    Statement sta;
    ResultSet res;
    
    public Conexion(){
        url="jdbc:mysql://localhost/Usuarios";
        User="root";
        Pass="n0m3l0";
    }
    
    public String Con(String nombre, String contra){
        String ok="No";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, User, Pass);
            sta=con.createStatement();
            
            res=sta.executeQuery("select * from Usuario where Usern='"+nombre+"' and Pass='"+contra+"';");
            if(res.next()){
                ok="Oka";
            }
            else{
                ok="Falso";
            }
        }
        
        catch(Exception e){
            ok=e.getMessage();
            System.out.println(e.getMessage());
        }
         
        return ok;
    }
    
    public String Rol(String Email, String Contra){
        String Rol="No hay rol";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, User, Pass);
            sta=con.createStatement();
            
            res=sta.executeQuery("select * from Usuario where Usern='"+Email+"' and Pass='"+Contra+"';");
            if(res.next()){
                Rol=res.getString("Rol");
            }
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
         
        return Rol;
    }
}
