package cliente;

import java.util.ArrayList;


public class Libro {
   private String titulo;
   private int serie=0, nopag=0;
   private String editorial;
   private String autor;
   private double precio;
    
    //public articulo(){
    //}
    
    public void setTitulo(String t){
        titulo=t;
    }
    
    public void setserie(int s){
        serie=s;
    }
    
    public void setnopag(int s){
    nopag=s;
    }
    
    public void seteditorial(String e){
    editorial=e;
    }
    
    public void setautor(String a){
    autor=a;
    }
  
    
    public void setprecio(double p){
    precio=p;
    }
    
//------------------------------------------------------------------------------    
    public String getTitulo(){
        return titulo;
    }
    
    public int getserie(){
        return serie;
    }
    
    public int getnopag(){
        return nopag;
    }
    
    public String geteditorial(){
        return editorial;
    }
    
    public String getautor(){
        return autor;
    }
    
    public double getprecio(){
        return precio;
    }
    

    @Override
    public String toString() {
        return titulo + ",  " + editorial + ",   " + autor+ ",    $"+ precio;
    }
    
   
    
}
