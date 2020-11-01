
package liibreria;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;


public class conexionMySQLEmpleado {
    
    String url="jdbc:mysql://localhost:3306/libreria?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user="root";
    String pass="Dissidia#123";
    
    

public int agragarus(String genero, String nombre, String ap, String am,String dir,String calle, String colonia,int cp,int num,String tel,String email,String cont){
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

public boolean validarcontra(String contraseña, String idsuc){
    
    Connection link=null;
    boolean opc = false;
    try{
        link = DriverManager.getConnection(this.url,this.user,this.pass);
        
        if(link!=null){
        Statement s= link.createStatement();     
        ResultSet x= s.executeQuery("select contra from succursal where idSuccursal="+Integer.parseInt(idsuc));
        x.first();
        
        if((x.getString("contra")).equals(contraseña)){
            opc=true;
        }
        
        else {
            opc=false;
        }
        
        }
        link.close();
        
    } catch (Exception ex){
        System.out.println(ex);  
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

public Libro obtenerarticulo(int serie){
    Connection link=null;
    Libro a=null;
    
    try{
        link = DriverManager.getConnection(this.url,this.user,this.pass);
        
        if(link!=null){
        Statement s= link.createStatement();     
        ResultSet articulo= s.executeQuery("select l.* , la.autor from libro l ,libaut la where l.numserie="+serie+" and l.numserie=la.numserie");
        articulo.first();
//        if(Libro.isBeforeFirst()){
            a=new Libro();
            a.setserie(articulo.getInt("numserie"));
            a.setTitulo(articulo.getString("titulo"));
            a.seteditorial(articulo.getString("editorial"));
            a.setnopag(articulo.getInt("numpag"));
            a.setprecio(articulo.getDouble("precio"));
            a.setautor(articulo.getString("autor"));
            
//            }
            
//            else
                
            
        link.close();
        
        }    
    } catch (Exception ex){
        System.out.println("4"+ex);  
        a=null;
    }  
    
   return a; 
}

public ArrayList obtenerempleados(int sucursal){
    Connection link=null;
    ArrayList <empleado> emps= new ArrayList<empleado>();
    
    try{
        link = DriverManager.getConnection(this.url,this.user,this.pass);
        
        if(link!=null){
        Statement s= link.createStatement();     
        ResultSet empleado= s.executeQuery("select *  from empleado where idsuccursal="+sucursal);
        empleado.first();
        
        while(empleado.next()){
            empleado e= new empleado();
            e.setidem(empleado.getInt("idEmpleado"));
            e.setnom(empleado.getString("nombre"));
            e.setapp(empleado.getString("Appaterno"));
            e.setapm(empleado.getString("Apmaterno"));
            e.setpuesto(empleado.getString("puesto"));
            e.setsucursal(empleado.getInt("idsuccursal"));        
            emps.add(e);
        
        }
 
        link.close();
        
        }    
    } catch (Exception ex){
        System.out.println("4"+ex);  
    }  
    
   return emps; 
}

public int[] empezartrans (int id, ArrayList ax, String fecha, String hora, Double total, String destino, String notar, int idemp, int sucursal){
   String folio,trans;
   int fol,tra;
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
        
        String query= "insert into ticket values (" + fol + "," + fecha + "," + hora + "," +idemp+")";
        x.executeLargeUpdate(query);
        
    //------------------------------------------------- RECUPERAR TRANSACCION
        ResultSet transa= s.executeQuery("select max(numtrans) as numtrans from trans");
        transa.first();
        trans= transa.getString("numtrans");
        tra= Integer.parseInt(trans)+1;
    //                                                      INSERTAR TRANS
    
        query= "insert into trans values ("+tra+","+total+","+id+","+fol+")";
        x.executeLargeUpdate(query);
    
    
    //------------------------------------------------ INSERTAR  Y LIBCLI
    
        ArrayList<Item> no= ax;
        int serie;
        int cantidad=0, cant2=0;
        
        for (Item i: no){
        serie=i.getprod().getserie();
        cantidad= i.getcan();
        
        query= "select * from libcli where numserie="+serie+" and idcliente= "+id;
        ResultSet c= s.executeQuery(query);
       
        if(!c.isBeforeFirst()){
        query= "insert into libcli values ("+cantidad+","+null+","+serie+","+id+")";
        x.executeLargeUpdate(query);
        }
        
        else{
             c.first();
            cant2=c.getInt("cantidad");
            System.out.println(cantidad+"   "+cant2);
            cantidad= cantidad+cant2;
            query= "update libcli set cantidad="+cantidad+" where numserie="+serie+" and idcliente="+id;
            x.executeLargeUpdate(query);
        }
        
        query="update sulib set numdisponible=numdisponible-"+cantidad+" where numserie="+serie+ " and idsuccursal="+sucursal;
        x.executeLargeUpdate(query);
            
        }
    
        
    //------------------------------------------------------- TransBan
        int iva=16;
        if(notar!=null){
        query= "insert into transban values ("+iva+","+notar+","+id+","+fol+")";
        x.executeLargeUpdate(query);
    
        }
 
            dats[0]=tra;
            dats[1]=fol;
        
        link.close();
        
        }    
    } catch (Exception ex){
        System.out.println("2"+ex);  
    }  

    
    return dats;
    
    
}
public void altaart(int numserie, String editorial, int pags, String[] aut, String [] gen, String titulo, double precio, String suc, String cant ){

    Connection link=null;
    String query="";
    
    
    try{
        link = DriverManager.getConnection(this.url,this.user,this.pass);
        
        Statement x= link.createStatement();     
        query="insert into libro values ("+numserie+",\""+editorial+"\",\""+titulo +"\","+pags+","+precio + ")";
        x.executeLargeUpdate(query);
        
        for(int i=0; i<aut.length; i++){
            if(aut[i].length()>0){
            query="insert into libaut values (\""+aut[i]+"\","+numserie+ ")";
            x.executeLargeUpdate(query);
            }
        }
        
        
         for(int o=0; o<gen.length; o++){
             if(gen[o].length()>0){
                System.out.println("aqui");
            query="insert into libgen values (\""+gen[o]+"\","+numserie+ ")";
            x.executeLargeUpdate(query);
            
             }
         
             else
                System.out.println("Algomal");
        }
         
       
          query="insert into sulib values ("+Integer.parseInt(suc)+","+numserie+ ","+Integer.parseInt(cant)+")";
           x.executeLargeUpdate(query);
 
        link.close();
        
            
    } catch (Exception ex){
        System.out.println("45"+ex);  
    }  
    


}

public void eliminarart(int serie){

 Connection link=null;
    String query="";
    
    try{
        link = DriverManager.getConnection(this.url,this.user,this.pass);
        
        Statement x= link.createStatement();     
        query="delete from libro where numserie="+serie;
        x.executeLargeUpdate(query);
       
        link.close();
        
            
    } catch (Exception ex){
        System.out.println(ex);  
    }  

}

public void eliminausu(int id){
 Connection link=null;
    String query="";
    
    try{
        link = DriverManager.getConnection(this.url,this.user,this.pass);
        
        Statement x= link.createStatement();     
        query="delete from cliente where idcliente="+id;
        x.executeLargeUpdate(query);
       
        link.close();
        
            
    } catch (Exception ex){
        System.out.println(ex);  
    }  

}

public void editarart(int id, int opc, String nuevo){
 Connection link=null;
    String query="";
    
    try{
        link = DriverManager.getConnection(this.url,this.user,this.pass);
        
        Statement x= link.createStatement(); 
        
        if(opc==0)//titulo
        query="update libro set titulo=\""+nuevo+"\" where numserie="+id;
        
        if(opc==1)//editorial
        query="update libro set editorial=\""+nuevo+"\" where numserie="+id;
        
        if(opc==2)//numpags
        query="update libro set numpag="+Integer.parseInt(nuevo)+" where numserie="+id;
       
        if(opc==3)//numpags
        query="update libro set precio="+Double.parseDouble(nuevo)+" where numserie="+id;
        
        
        x.executeLargeUpdate(query);
       
        link.close();
        
            
    } catch (Exception ex){
        System.out.println(ex);  
    }  

}


public void editarartst(int id, int opc, int sucu){
 Connection link=null;
    String query="";
    
    try{
        link = DriverManager.getConnection(this.url,this.user,this.pass);
        
        Statement x= link.createStatement();     
        query="update sulib set numdisponible="+opc+" where numserie="+id+ " and idsuccursal="+sucu;
        x.executeLargeUpdate(query);       
        link.close();       
            
    } catch (Exception ex){
        System.out.println(ex);  
    }  

}


public void editarusu(int id, int opc, String nuevo){
 Connection link=null;
    String query="";
    
    try{
        link = DriverManager.getConnection(this.url,this.user,this.pass);
        
        Statement x= link.createStatement(); 
        
        switch (opc)
        {
            case 0:     //nom
              query="update cliente set nombre=\""+nuevo+"\" where idcliente="+id;
               break;
           
            case 1:     //ap
              query="update cliente set ap=\""+nuevo+"\" where idcliente="+id;
                break;
          
            case 2:     //am
              query="update cliente set am=\""+nuevo+"\" where idcliente="+id;
                break; 
                
            case 3://edo
             query="update cliente set dir=\""+nuevo+"\" where idcliente="+id;
                 break;
            
            case 4:
                query="update cliente set colonia=\""+nuevo+"\" where idcliente="+id;
                break;
                
            case 5:
                query="update cliente set cp="+Integer.parseInt(nuevo)+" where idcliente="+id;
                break;
            case 6:
                query="update cliente set tel=\""+nuevo+"\" where idcliente="+id;
                break;
            case 7:
                query="update cliente set email=\""+nuevo+"\" where idcliente="+id;
                break;
            
        }
        
        x.executeLargeUpdate(query);
       
        link.close();
        
            
    } catch (Exception ex){
        System.out.println(ex);  
    }  

}

public ArrayList obtenerarticulos(String idsuc){
    Connection link=null;
    ArrayList<Libro> list= new ArrayList<Libro>();
    
    try{
        link = DriverManager.getConnection(this.url,this.user,this.pass);
        
        if(link!=null){
        Statement s= link.createStatement();     
        ResultSet libros= s.executeQuery("select l.numserie,l.titulo,sl.numdisponible  from libro l, succursal s, sulib sl"
                + " where l.numserie= sl.numserie and sl.idsuccursal=s.idsuccursal and s.idsuccursal="+Integer.parseInt(idsuc)
                + " order by l.titulo");
        libros.first();
        do{
            Libro a= new Libro();
            a.setserie(libros.getInt("numserie"));
            a.setTitulo(libros.getString("titulo"));
            a.setst(libros.getInt("numdisponible"));
       
            
            list.add(a);
            
        } while(libros.next());     
        link.close();
        
        }    
    } catch (Exception ex){
        System.out.println(ex);  
    }  
    
   return list; 
}

public ArrayList<cliente> obtenerClientes(){
    Connection link=null;
    ArrayList <cliente> client= new ArrayList<cliente>();
    
    try{
        link = DriverManager.getConnection(this.url,this.user,this.pass);
        
        if(link!=null){
        Statement s= link.createStatement();     
        ResultSet cliente= s.executeQuery("select *  from cliente");
        cliente.first();
        
        while(cliente.next()){
            cliente c= new cliente();
            c.setidCliente(cliente.getInt("idCliente"));
            c.setGenero(cliente.getString("Genero"));
            c.setNombre(cliente.getString("nombre"));
            c.setap(cliente.getString("ap"));
            c.setam(cliente.getString("am"));
            c.setDir(cliente.getString("dir"));
            c.setCalle(cliente.getString("calle"));        
            c.setColonia(cliente.getString("colonia"));
            c.setCP(cliente.getInt("CP"));
            c.setNumero(cliente.getInt("num"));
            c.setTel(cliente.getString("Tel"));
            c.setEMail(cliente.getString("email"));
            c.setContra(cliente.getString("contraseña"));
            client.add(c);
        }
 
        link.close();
        
        }    
    } catch (Exception ex){
        System.out.println("4"+ex);  
    }  
    
   return client;
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
