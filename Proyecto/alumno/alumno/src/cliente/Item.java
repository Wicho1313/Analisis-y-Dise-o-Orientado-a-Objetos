package cliente;

public class Item {

    private Libro ar;
    private int cant;
    private double precioItem;

public Item (Libro a,int c){
ar = a;
cant=c;
}
//gets
public Libro getprod(){
return ar;
}
public int getcan(){
return cant;
}
//sets
public void setcant(int c){
cant=c;
}

    @Override
    public String toString() {
        return  ar.getTitulo() + "  Cantidad:" + cant +"    Precio Unitario:"+ ar.getprecio();
    }


}
