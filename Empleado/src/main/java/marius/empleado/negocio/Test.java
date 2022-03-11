
package marius.empleado.negocio;

import marius.empleado.Entity.Empleado;


public class Test {
    EmpleadoNegocio enegocio= new EmpleadoNegocio();
    Empleado emp= new Empleado();
    String mensaje="";
    
    public void insertar(){
    
//    emp.setNombres("Marius");
//    emp.setApellidos("Apriutesa");
//    emp.setDni("012345678");
//    emp.setEstadoCivil('S');
//    emp.setGenero('M');
//    emp.setEdad(21);
 emp.setNombres("Catalin");
    emp.setApellidos("Apriutes");
    emp.setDni("01234557809");
    emp.setEstadoCivil('C');
    emp.setGenero('F');
    emp.setEdad(23);
    mensaje= enegocio.agragarEmpleado(emp);
        System.out.println(mensaje);
    }
    public void modificar(){
    emp.setIdEmpleado(2);
    emp.setNombres("CatalinModificado");
    emp.setApellidos("Apriutes");
    emp.setDni("0123455789");
    emp.setEstadoCivil('C');
    emp.setGenero('F');
    emp.setEdad(23);
    mensaje= enegocio.modificarEmpleado(emp);
        System.out.println(mensaje);
    }
     public void eliminar(){
   
    mensaje= enegocio.eliminarEmpleado(5);
        System.out.println(mensaje);
    }
    public static void main(String[] args) {
        Test test=new Test();
        //test.insertar();
        test.eliminar();
    }
    
}
