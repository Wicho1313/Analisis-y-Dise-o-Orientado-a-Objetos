package liibreria;


public class empleado {
  
    private int idempleado, sucursal;
    private String nombre,app,apm,puesto;
    
    
    public void setidem(int id){
    idempleado=id;
    }
    
    public void setsucursal(int suc){
    sucursal=suc;
    }
    
    public void setnom(String i){
    nombre=i;
    }
    
    public void setapp(String i){
    app=i;
    }
    
    public void setapm(String i){
    apm=i;
    }
    
    public void setpuesto(String i){
    puesto=i;
    }
    
//--------------------------------------------------    
    
    
    public int getidem(){
    return idempleado;
    }
    
    public int getsucursal(){
    return sucursal;
    }
    
    public String getnom(){
    return nombre;
    }
    
    public String getapp(){
     return app;
    }
    
    public String getapm(){
     return apm;
    }
    
    public String getpuesto(){
     return puesto;
    }

    @Override
    public String toString() {
        return  nombre +" " +app ;
    }
    
}
