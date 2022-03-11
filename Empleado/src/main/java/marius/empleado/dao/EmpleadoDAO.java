
package marius.empleado.dao;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import marius.empleado.Entity.Empleado;


public class EmpleadoDAO 
{
    private String mesaje="";
    
    public String agragarEmpleado(Connection con ,Empleado emp){
        PreparedStatement pst=null;
        String sql="INSERT INTO EMPLEADO (idempleado, nombres, apellidos, dni, estado_civil,genero,edad) "
                + "VALUES(?,?,?,?,?,?,?)";//EMPLEADO_SEQ he hecho la sequencia en oracle para ser autoincrementado
        try 
        {
            pst=con.prepareStatement(sql);
             pst.setInt(1, emp.getIdEmpleado());
            pst.setString(2, emp.getNombres());
             pst.setString(3, emp.getApellidos());
              pst.setString(4, emp.getDni());
              pst.setString(5, emp.getEstadoCivil()+"");//le convertimos a char con +""
              pst.setString(6, emp.getGenero()+"");
              pst.setInt(7, emp.getEdad());
              
              mesaje="GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (SQLException e) 
        {
            mesaje="NO SE PUDO GUARDAR CORRECTAMENTE \n " + e.getMessage();
        }
    return mesaje;
    }
     public String modificarEmpleado(Connection con ,Empleado emp){
  PreparedStatement pst=null;
        String sql="UPDATE EMPLEADO SET NOMBRES=?,APELLIDOS=?, DNI=?,ESTADO_CIVIL=?, GENERO=?, EDAD=?"
                + "WHERE IDEMPLEADO=?";//EMPLEADO_SEQ he hecho la sequencia en oracle para ser autoincrementado
        try 
        {
            pst=con.prepareStatement(sql);
            pst.setString(1, emp.getNombres());
             pst.setString(2, emp.getApellidos());
              pst.setString(3, emp.getDni());
              pst.setString(4, emp.getEstadoCivil()+"");//le convertimos a char con +""
              pst.setString(5, emp.getGenero()+"");
              pst.setInt(6, emp.getEdad());
              pst.setInt(7,emp.getIdEmpleado());
              mesaje="MODIFICADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (SQLException e) 
        {
            mesaje="NO SE PUDO MODIFICAR EL REGISTRO \n " + e.getMessage();
        }
    return mesaje;
    
    } public String eliminarEmpleado(Connection con ,int id){
 
        PreparedStatement pst=null;
        String sql="DELETE FROM EMPLEADO WHERE IDEMPLEADO=?";
        try 
        {
            pst=con.prepareStatement(sql);
            
            pst.setInt(1, id);
            
              mesaje="ELIMINADO CORRECTAMENTE";
            pst.execute();
            pst.close();
        } catch (SQLException e) 
        {
            mesaje="NO SE PUDO ELIMINAR EL REGISTRO \n " + e.getMessage();
        }
        
    return mesaje;
    }
     public void listaEmpleado(Connection con , JTable tabla){
         DefaultTableModel model;
         String []columnas={"ID","NOMBRES","APELLIDOS","DNI","GENERO","EDAD","ESTADO CIVIL"};//LAS COLUMNAS QUE VAN A SER R`PREZENTADAS EN LA TABLA
         model= new DefaultTableModel(null,columnas);
         String SQL="Select * FROM EMPLEADO ORDER BY IDEMPLEADO";
         
         String[] filas= new String[7];//nr columnas
         
         Statement st= null;
         ResultSet rs= null;
         try {
             st= con.createStatement();
             rs= st.executeQuery(SQL);
             
             while (rs.next()) {                 
                 for (int i = 0; i < 7; i++) {
                     filas[i] = rs.getString(i+1);
                 }
                 model.addRow(filas);
             }
             tabla.setModel(model);
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "NO SE PUEDE MOSTRAR LA TABLAS");
             
         }
    }
    
    //metodo incrementar id
     public int getMaxID(Connection con){
     int id=0;
     PreparedStatement pst = null;
         ResultSet rs= null;
    
         try {
             pst=con.prepareStatement("SELECT MAX(IDEMPLEADO)+1 as id FROM EMPLEADO");
             rs= pst.executeQuery();
             if (rs.next()) {
                 id= rs.getInt(1);
             }
             rs.close();
             pst.close();
         } catch (SQLException e) {
             System.out.println("ERROR AL MOSTRAR EL ID" +e.getMessage());
         }
     return id;
     }
    
    
    
    
}
