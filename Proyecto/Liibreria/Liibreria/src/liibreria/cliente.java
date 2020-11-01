/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liibreria;

/**
 *
 * @author Wicho
 */
public class cliente {

    private int idCliente, num,CP;
    private String Genero, Nombre,ap,am,dir, calle,colonia,email,Tel,contraseña;
    
    public void setidCliente(int id){
    idCliente=id;
    }
    public void setGenero(String i){
        Genero=i;
    }
    public void setNombre(String i){
    Nombre=i;
    }
    
    public void setap(String i){
    ap=i;
    }
    
    public void setam(String i){
    am=i;
    }

    public void setDir(String i){
        dir=i;
    }
    public void setCalle (String i){
        calle=i;
    }
    public void setColonia(String i){
        colonia=i;
    }
    public void setCP(int i){
        CP=i;
    }
    public void setNumero(int i){
        num=i;
    }
    public void setTel(String i){
        Tel=i;
    }
    public void setEMail(String i){
        email=i;
    }
    public void setContra(String i){
        contraseña=i;
    }
//--------------------------------------------------    
    
    public int getIDcliente(){
    return idCliente;
    }
    
    public String getGenero(){
    return Genero;
    }
    
    public String getNombre(){
    return Nombre;
    }
    
    public String getap(){
     return ap;
    }
    
    public String getam(){
     return am;
    }
    
    public String getDir(){
     return dir;
    }
    
    public String getCalle(){
        return calle;
    }
    public String getColonia(){
        return colonia;
    }
    
    public int getCP(){
        return CP;
    }
    
    public int getNumero(){
        return num;
    }
    
    public String getTel(){
        return Tel;
    }
    
    public String getEMail(){
        return email;
    }
    
    public String getContraseña(){
        return contraseña;
    }
    @Override
    public String toString() {
        return  idCliente+""+Genero+""+Nombre +" " +ap+""+am+""+dir+""+calle+""+colonia+""+CP+""+num+""+Tel+""+email+""+contraseña ;
    }

}
