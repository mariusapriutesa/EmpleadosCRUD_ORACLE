
package marius.empleado.negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import marius.empleado.DB.Conexion;
import marius.empleado.Entity.Empleado;
import marius.empleado.dao.EmpleadoDAO;


public class EmpleadoNegocio {
    private String mensaje="";
    private EmpleadoDAO edao= new EmpleadoDAO();
    
    public String agragarEmpleado(Empleado emp){
       Connection conn =Conexion.getConnection();
        try {
            mensaje= edao.agragarEmpleado(conn, emp);
           // conn.rollback();//mustra un exception
            
            
        } catch (Exception e) {
            mensaje= mensaje+ " "+ e.getMessage();
           // conn.commit();
        }finally{
            try {
                if (conn!= null) {
                    conn.close();
                }
            } catch (Exception e) {
                 mensaje= mensaje+ " "+ e.getMessage();
            }
        
        
        }
    return mensaje;
    }
     public String modificarEmpleado(Empleado emp){

    Connection conn =Conexion.getConnection();
        try {
            mensaje= edao.modificarEmpleado(conn, emp);
           // conn.rollback();//mustra un exception
            
            
        } catch (Exception e) {
            mensaje= mensaje+ " "+ e.getMessage();
           // conn.commit();
        }finally{
            try {
                if (conn!= null) {
                    conn.close();
                }
            } catch (Exception e) {
                 mensaje= mensaje+ " "+ e.getMessage();
            }
        
        
        }
    return mensaje;
    
    } public String eliminarEmpleado(int id){

       Connection conn =Conexion.getConnection();
        try {
            mensaje= edao.eliminarEmpleado(conn, id);
           // conn.rollback();//mustra un exception
            
            
        } catch (Exception e) {
            mensaje= mensaje+ " "+ e.getMessage();
           // conn.commit();
        }finally{
            try {
                if (conn!= null) {
                    conn.close();
                }
            } catch (Exception e) {
                 mensaje= mensaje+ " "+ e.getMessage();
            }
        }
    return mensaje;
    }
     public void listarEmpleado(JTable tabla){
            Connection conn =Conexion.getConnection();
            edao.listaEmpleado(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
    }
     public int getMaxID(){
     
     Connection conn =Conexion.getConnection();
         int id=   edao.getMaxID(conn);//**
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     
        return id;//**
     
     
     
     }
}
