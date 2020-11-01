
package cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;


public class conexionMySQLCliente {
    
    String url="jdbc:mysql://localhost:3306/libreria?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user="root";
    String pass="Dissidia#123";
    
    public Connection Conectar(){
    Connection link= null;
    try{
        link=DriverManager.getConnection(this.url,this.user,this.pass);
       
    } catch (Exception ex){
    
        System.out.println(ex);  
    }
    
    return link;
    }
    
    
    
public void desconectar(java.sql.Connection cn) {

   try{
            cn.close();    
            }
            catch(SQLException ex)
            {
            System.out.println("Error al desconectar"+ex);
            }
  }
      
public int agragarus(String genero, String nombre, String ap, String am,String dir,String calle, String colonia,int cp,int num,String tel,String email, String cont){
   Connection link=null;
   String id1;
   int id2=0;
    try{
        link = DriverManager.getConnection(this.url,this.user,this.pass);
        
        if(link!=null){
        Statement s= link.createStatement();     
        ResultSet id= s.executeQuery("select max(idcliente) as id from cliente");
        id.first();
        id1= id.getString("id");
        id2=Integer.parseInt(id1)+1;
        
        
        String query= "insert into cliente values ("+id2+","+"\""+genero+"\",\""+nombre+"\",\""+ap+"\",\""+am+"\",\""+dir+"\",\""+calle+"\",\""+colonia+"\","+cp+","+num+",\""+tel+"\",\""+email+"\", \""+cont+"\")";
        s.executeLargeUpdate(query);
        
        link.close();
        
        }    
    } catch (Exception ex){
        System.out.println("1"+ex);  
    }  
   return id2;
    }


public boolean validarcontra(String contraseña, String id){
    
    Connection link=null;
    boolean opc = false;
    try{
        link = DriverManager.getConnection(this.url,this.user,this.pass);
        
        if(link!=null){
        Statement s= link.createStatement();     
        ResultSet x= s.executeQuery("select contraseña from cliente where idcliente="+Integer.parseInt(id));
        x.first();
        
        if((x.getString("contraseña")).equals(contraseña)){
            opc=true;
        }
        
        else {
            opc=false;
        }
        
        }
        link.close();
        
    } catch (Exception ex){
        System.out.println("1"+ex);  
    }  

return opc;

}

public String obtenernombre(int id){

   Connection link=null;
   String Nombre="", Ap="", Am="",RTN="";
    try{
        link = DriverManager.getConnection(this.url,this.user,this.pass);
        
        if(link!=null){
        Statement s= link.createStatement();     
        ResultSet nombre= s.executeQuery("select * from cliente where idcliente="+id);
        nombre.first();
        Nombre= nombre.getString("nombre");
        Ap=nombre.getString("ap");
        Am=nombre.getString("am");
        RTN= Nombre+" "+Ap+" "+Am+" ";
        link.close();
        
        }    
    } catch (Exception ex){
        System.out.println("2"+ex);  
    }  
return RTN;
}


public String obtenerdireccion(int id){

   Connection link=null;
   String dir="",calle="",colonia="",cp="",num="", RTN="";
    try{
        link = DriverManager.getConnection(this.url,this.user,this.pass);
        
        if(link!=null){
        Statement s= link.createStatement();     
        ResultSet direc= s.executeQuery("select * from cliente where idcliente="+id);
        direc.first();
        dir= direc.getString("dir");
        calle=direc.getString("calle");
        colonia=direc.getString("colonia");
        cp= direc.getString("CP");
        num= direc.getString("num");
        
        RTN= dir+", "+colonia+",    "+calle+",  NO. "+num+",   C.P."+cp;
        link.close();
        
        }    
    } catch (Exception ex){
        System.out.println(ex);  
    }  
return RTN;
}



public ArrayList obtenerarticulos(){
    Connection link=null;
    ArrayList<Libro> list= new ArrayList<Libro>();
    
    try{
        link = DriverManager.getConnection(this.url,this.user,this.pass);
        
        if(link!=null){
        Statement s= link.createStatement();     
        ResultSet libros= s.executeQuery("select l.*, la.autor from libro l, libaut la where l.numserie= la.numserie order by l.titulo");
        libros.first();
        do{
            Libro a= new Libro();
            a.setserie(libros.getInt("numserie"));
            a.setTitulo(libros.getString("titulo"));
            a.seteditorial(libros.getString("editorial"));
            a.setnopag(libros.getInt("numpag"));
            a.setprecio(libros.getDouble("precio"));
            a.setautor(libros.getString("autor"));
            
            list.add(a);
            
        } while(libros.next());     
        link.close();
        
        }    
    } catch (Exception ex){
        System.out.println(ex);  
    }  
    
   return list; 
}

public ArrayList obtenerarticulosesp (String e, int o){
    Connection link=null;
    ArrayList<Libro> list= new ArrayList<Libro>();
    ResultSet libros= null;
    
    try{
        link = DriverManager.getConnection(this.url,this.user,this.pass);
        
        if(link!=null){
        Statement s= link.createStatement();     
        
        if(o==0)//EDITORIAL
        libros= s.executeQuery("select l.*, la.autor from libro l, libaut la where l.numserie= la.numserie and l.editorial= \""+e+"\"");
        
        if(o==1) //AUTOR
        libros= s.executeQuery("select l.*, la.autor from libro l, libaut la where l.numserie= la.numserie and la.autor= \""+e+"\"");    
        
        if(o==2)//TITULO
        libros= s.executeQuery("select l.*, la.autor from libro l, libaut la where l.numserie= la.numserie and l.titulo= \""+e+"\"");
        
        libros.first();
        
        do{
            Libro a= new Libro();
            a.setserie(libros.getInt("numserie"));
            a.setTitulo(libros.getString("titulo"));
            a.seteditorial(libros.getString("editorial"));
            a.setnopag(libros.getInt("numpag"));
            a.setprecio(libros.getDouble("precio"));
            a.setautor(libros.getString("autor"));            
            list.add(a);   
            
            System.out.println(a.getTitulo());
        } while(libros.next());     
        link.close();
        
        }    
    } catch (Exception ex){
        System.out.println("3"+ex);  
    }  
    
   return list; 
}







public int[] empezartrans (int id, ArrayList ax, String fecha, String hora, Double total, String destino, String notar){
   String folio,trans,codigo;
   int fol,tra,codig;
   Connection link=null;
   int[] dats= new int[3];
    try{
        link = DriverManager.getConnection(this.url,this.user,this.pass);
        
        if(link!=null){
        Statement s= link.createStatement(); //lec
        Statement x= link.createStatement(); //insert
    //------------------------------------------------------ RECUPERAR FOLIO    
        ResultSet fols= s.executeQuery("select max(folio) as folio from ticket");
        fols.first();
        folio= fols.getString("folio");
        fol= Integer.parseInt(folio)+1;
    //                                                       INSERTAR TICKET
        
        String query= "insert into ticket values (" + fol + "," + fecha + "," + hora + "," +null+")";
        x.executeLargeUpdate(query);
        
    //------------------------------------------------- RECUPERAR TRANSACCION
        ResultSet transa= s.executeQuery("select max(numtrans) as numtrans from trans");
        transa.first();
        trans= transa.getString("numtrans");
        tra= Integer.parseInt(trans)+1;
    //                                                      INSERTAR TRANS
    
        query= "insert into trans values ("+tra+","+total+","+id+","+fol+")";
        x.executeLargeUpdate(query);
    
    //-----------------------------------------------       RECUPERAR CODIGO ENVIO
        
        ResultSet coenv= s.executeQuery("select max(codigo) as codigo from envio");
        coenv.first();
        codigo= coenv.getString("codigo");
        codig= Integer.parseInt(codigo)+1;
    //                                                      INSERTAR ENVIO
    
        query= "insert into envio values ("+codig+",\""+destino+"\","+fecha+","+id+")";
        x.executeLargeUpdate(query);
    
    //------------------------------------------------ INSERTAR LIBENV Y LIBCLI
    
        ArrayList<Item> no= ax;
        int serie,cant2=0;
        int cantidad=0;
        for (Item i: no){
        serie=i.getprod().getserie();
        cantidad= i.getcan();
        
        query= "insert into libenv values ("+serie+","+codig+")";
        x.executeLargeUpdate(query);
        
        query= "select * from libcli where numserie="+serie+" and idcliente= "+id;
        ResultSet c= s.executeQuery(query);
        
        if(!c.isBeforeFirst()){
        query= "insert into libcli values ("+cantidad+","+null+","+serie+","+id+")";
        x.executeLargeUpdate(query);
        }
        
         else{
             c.first();
            cant2=c.getInt("cantidad");
            cantidad= cantidad+cant2;
            query= "update libcli set cantidad="+cantidad+" where numserie="+serie+" and idcliente="+id;
            x.executeLargeUpdate(query);
        }

        query="update sulib set numdisponible=numdisponible-"+cantidad+" where numserie="+serie+ " and idsuccursal="+4;
        x.executeLargeUpdate(query);
        
        
        }
    
    //------------------------------------------------------- Enviotran
    
        query= "insert into enviotrans values ("+total+","+codig+","+tra+")";
        x.executeLargeUpdate(query);
        
    //------------------------------------------------------- TransBan
        int iva=16;
        query= "insert into transban values ("+iva+","+notar+","+id+","+fol+")";
        x.executeLargeUpdate(query);
    
            dats[0]=tra;
            dats[1]=codig;
            dats[2]=fol;
        
        link.close();
        
        }    
    } catch (Exception ex){
        System.out.println("2"+ex);  
    }  

    
    return dats;
    
    
}


public String obtenerfecha(){

    Calendar c1 = Calendar.getInstance();
    String dia= Integer.toString(c1.get(Calendar.DATE) );
    String mes= Integer.toString(c1.get(Calendar.MONTH) );
    String ano= Integer.toString(c1.get(Calendar.YEAR) );

    return "\""+ano+"-"+mes+"-"+dia+"\"" ;
    
}



public String obtenerhora(){
    
    Calendar c1 = Calendar.getInstance();
    String hora= Integer.toString(c1.get(Calendar.HOUR_OF_DAY) );
    String minutos= Integer.toString(c1.get(Calendar.MINUTE) );
    String segundos= Integer.toString(c1.get(Calendar.SECOND) );

    return "\""+hora+":"+minutos+":"+segundos+"\"" ;

}





}
