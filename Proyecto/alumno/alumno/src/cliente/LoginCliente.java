
package cliente;
import java.sql.*;
import javax.swing.JOptionPane;

public class LoginCliente {

   
    public static void main(String[] args) {
      
         conexionMySQLCliente mysql= new conexionMySQLCliente();
     java.sql.Connection cn= mysql.Conectar();
   
     if(cn!=null){
           // System.out.println("CONECTADO");
                mysql.desconectar(cn);
        new Inicio().setVisible(true);
    }
        
     else {
     JOptionPane.showMessageDialog(null, "ERROR AL CONECTAR CON LA BASE DE DATOS","COMPRA LIBROS",0);
         
     }
    
       
    }
    
    
    
    
}
