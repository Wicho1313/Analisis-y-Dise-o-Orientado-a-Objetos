package liibreria;

public class Item {

    private Libro ar;
    private int cant;
    private double precioItem;

public Item (Libro a,int c){
ar = a;
cant=c;
precioItem= cant*ar.getprecio();
}
//gets
public Libro getprod(){
return ar;
}
public int getcan(){
return cant;
}

public double getprecioItem(){
return  (ar.getprecio()* cant )  ;
}

//sets
public void setcant(int c){
cant=c;
}

    @Override
    public String toString() {
        return  ar.getTitulo() + "  Cantidad: " + cant +"    Precio: "+ precioItem;
    }


}
