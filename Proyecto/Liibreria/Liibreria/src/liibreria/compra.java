
package liibreria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;




public class compra extends javax.swing.JFrame {

    int sucursal;
    ArrayList<empleado> emp=null;
    conexionMySQLEmpleado cn= new conexionMySQLEmpleado();

    public compra(int suc) {
       
        sucursal=suc;
        initComponents();
        
        emp=cn.obtenerempleados(sucursal);
        
        if(emp!=null)
        for(empleado e: emp){
        empleados.addItem(e.toString());
        }
        
        else
           System.out.println("ALGOMAL");     
       
        
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
    }
    
   
    public void iniciarlista(){
        
        modelo.clear();
        listaItems.setModel(modelo);
        
        if(listaItems != null){
        for (Item i: listaart){
        modelo.addElement(i.toString());
        }
        }
    }
   
    public double determinarTotal(){   
        double mas=0.0f;
        
        if(listaItems != null){
        for (Item i: listaart){ 
            mas+= i.getprecioItem();
        }      
        } 
        return mas; 
    }
    
    public int obteneridempp(){      
    return emp.get(empleados.getSelectedIndex()).getidem() ;
    
    }
    
    
    
    public void generarpdf(int id, int trans, int folio,int idemp, String empnom, String fecha, String hora) throws FileNotFoundException, DocumentException {
        String ruta="";
        JFileChooser deg= new JFileChooser();
        int option= deg.showSaveDialog(this);
        
        if(option== JFileChooser.APPROVE_OPTION)
        {
            File f= deg.getSelectedFile();
            ruta= f.toString();
            System.out.println(ruta);
        }
        
        
        try{
        FileOutputStream archivo = new FileOutputStream(ruta+".pdf");
        Document documento = new Document();
		PdfWriter.getInstance(documento, archivo);
		documento.open();
                documento.addTitle("TICKET");
                documento.add(new Paragraph("ID del cliente: "+id));
                documento.add(new Paragraph("Nombre del cliente"+cn.obtenernombre(id)));
                documento.add(new Paragraph(" FECHA:  "+fecha) );
                documento.add(new Paragraph(" Hora: "+ hora) );
		documento.add(new Paragraph("Numero de folio: "+folio));
                documento.add(new Paragraph("Numero de transacción: "+trans));
                documento.add(new Paragraph("   ARTICULOS: ") );
                 for (Item i: listaart){
                      documento.add(new Paragraph("Nombre: "+i.getprod().getTitulo()+"\n     Cantidad: "+i.getcan()) );
                      documento.add(new Paragraph("\tPrecio:"+(i.getcan()*i.getprod().getprecio())) );
                  }
                
                 documento.add(new Paragraph("Total: "+ determinarTotal() ) );
                
                
		documento.close();
        }
        catch(Exception e){
            System.out.println(e);
    }
     
		
    
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        empleados = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        buscart = new javax.swing.JTextField();
        agregart = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        pagar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        metodos = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaItems = new javax.swing.JList<>();
        eliminarart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lao UI", 1, 20)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liibreria/raheda.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Id cliente");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Empleado");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Articulo");

        agregart.setText("Agregar");
        agregart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregartActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Articulos");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Total:");

        total.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        total.setText("\"\"");

        pagar.setText("PAGAR");
        pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagarActionPerformed(evt);
            }
        });

        cancelar.setText("CANCELAR");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Método de pago:");

        metodos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta" }));

        jScrollPane2.setViewportView(listaItems);

        eliminarart.setText("Eliminar");
        eliminarart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(buscart, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(agregart))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(metodos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 75, Short.MAX_VALUE)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(empleados, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(pagar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cancelar)
                                .addGap(109, 109, 109))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(eliminarart)
                                .addGap(54, 54, 54))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(128, 128, 128))))
            .addGroup(layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(empleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregart))
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(eliminarart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(total)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(metodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pagar)
                    .addComponent(cancelar))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarActionPerformed
     
        String gio= metodos.getSelectedItem().toString();
        String id= cliente.getText();
        String notarj=null;
        int [] xxx =new int[3];
        if(gio.equals("Tarjeta")){
         notarj=    JOptionPane.showInputDialog(null, "COMPRA","Ingresa Numero de tarjeta", DISPOSE_ON_CLOSE);
        }
        
        String fecha= cn.obtenerfecha();
        String hora=cn.obtenerhora();
        int idemp= obteneridempp();
        String nombreem= emp.get(empleados.getSelectedIndex()).getnom()+emp.get(empleados.getSelectedIndex()).getapp() ;
        
        if(id!=null){
        xxx=cn.empezartrans(Integer.parseInt(id),listaart,fecha,hora,determinarTotal(), null, notarj,idemp,sucursal);
        
            try {
                generarpdf(Integer.parseInt(id),xxx[0],xxx[1],idemp,nombreem,fecha,hora);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(compra.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(compra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.dispose();
        
    }//GEN-LAST:event_pagarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void agregartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregartActionPerformed
        
        int serie= Integer.parseInt(buscart.getText());
        String cant= JOptionPane.showInputDialog(null,"¿Cuántos articulos desea comprar?" ,"CANTIDAD" , DISPOSE_ON_CLOSE);
        
        Libro ar= cn.obtenerarticulo(serie);
        
        if(cant!=null && ar!=null){
            
                listaart.add(new Item(ar,Integer.parseInt(cant)));
                iniciarlista();
                total.setText(String.valueOf(determinarTotal()));
        
        }
        
        else{
        JOptionPane.showMessageDialog(null, "ALGO SALIÓ MAL. INTENTA DE NUEVO","ADVERTENCIA",0);
        }      
        buscart.setText("");
        
    }//GEN-LAST:event_agregartActionPerformed

    private void eliminarartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarartActionPerformed
      
        int inde= listaItems.getSelectedIndex();
      
        if(inde>=0){
        listaart.remove(inde);
        iniciarlista();
        total.setText(String.valueOf(determinarTotal()));
        }
    }//GEN-LAST:event_eliminarartActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregart;
    private javax.swing.JTextField buscart;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField cliente;
    private javax.swing.JButton eliminarart;
    private javax.swing.JComboBox<String> empleados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaItems;
    private javax.swing.JComboBox<String> metodos;
    private javax.swing.JButton pagar;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
 
//    conexionMySQL cn= new conexionMySQL();
    ArrayList<Item> listaart= new ArrayList<Item>();
    DefaultListModel<String> modelo = new DefaultListModel();
    

}
