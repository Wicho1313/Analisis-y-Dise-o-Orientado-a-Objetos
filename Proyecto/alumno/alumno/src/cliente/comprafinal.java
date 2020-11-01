
package cliente;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class comprafinal extends javax.swing.JFrame {

    ArrayList<Item> comprafinal;
    double total1=0.0f, totalt=0.0f;
    String idusu="";
    int d=1;
    public comprafinal(ArrayList finalf, String idusuario ) {
        idusu=idusuario;
        initComponents();
         this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        datos.setText(cn.obtenernombre(Integer.parseInt(idusuario)));
        datos2.setText(cn.obtenerdireccion(Integer.parseInt(idusuario)));
        comprafinal=finalf;
        mostart.setText(Articulos());
        mostart.setEditable(false);
        total1=precioart();
        precioart.setText(String.valueOf(total1));
        
    }
    
    public String Articulos(){    
        String XX="";
        
         for (Item i: comprafinal){
        XX=XX+ "Nombre:"+ i.getprod().getTitulo()+"\nCantidad:"+i.getcan()+ "\nPrecio: "+ i.getprod().getprecio()*i.getcan()+ "\n\n";
        }
         
    return XX;
    }
    
    
    public double precioart(){
    
       double XX=0.00f;
        
         for (Item i: comprafinal){
        XX=XX+ i.getprod().getprecio()* i.getcan();
        }
    return XX;
          
    }
    
    
    public void generarpdf(int id, int trans, int folio, int envio, String direnv, String fecha, String hora) throws FileNotFoundException, DocumentException {
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
                documento.add(new Paragraph("Nombre del cliente: "+cn.obtenernombre(id)));
                documento.add(new Paragraph(" FECHA:  "+fecha) );
                documento.add(new Paragraph(" Hora: "+ hora) );
		documento.add(new Paragraph("Numero de folio: "+folio));
                documento.add(new Paragraph("Numero de transacción: "+trans));
                documento.add(new Paragraph("Numero de envio: "+envio));
                documento.add(new Paragraph("ARTICULOS: ") );
                 for (Item i: comprafinal){
                      documento.add(new Paragraph("Nombre: "+i.getprod().getTitulo()+"\n     Cantidad: "+i.getcan()) );
                      documento.add(new Paragraph("\tPrecio unitario:"+(i.getprod().getprecio())) );
                  }
                
                 documento.add(new Paragraph("Total: "+ totalt ) );
                
                
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
        datos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        direnv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        precioart = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        precioenv = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        confirmar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        tipoenv = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        mostart = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tarf = new javax.swing.JTextField();
        datos2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("DATOS");

        jLabel3.setText("Dirección de envio");

        jLabel4.setText("Artículos");

        jLabel5.setText("Precio de articulos:");

        jLabel7.setText("Precio de envio: ");

        jLabel9.setText("TOTAL:");

        confirmar.setText("Confirmar");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jLabel11.setText("Tipo de envio");

        tipoenv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "sin envio", "Envio" }));
        tipoenv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoenvActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(mostart);

        jLabel2.setText("Si deseas utilizar la dirección ya proporcionada deja en blanco.");

        jLabel6.setText("No tarjeta");

        tarf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tarf, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tipoenv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(precioart, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel9))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(precioenv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(confirmar))
                                .addGap(75, 75, 75)
                                .addComponent(cancelar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(direnv, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datos, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(231, 231, 231)
                                .addComponent(jLabel11))
                            .addComponent(datos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 46, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(datos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datos2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(direnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tarf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoenv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(precioart, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(precioenv, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmar)
                    .addComponent(cancelar))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        String notarj;
        String direcenv= direnv.getText();
        int[] ar= new int[3];
        
        if(direcenv.length()==0)
            direcenv=cn.obtenerdireccion(Integer.parseInt(idusu));
        
        notarj=tarf.getText();
        String fecha= cn.obtenerfecha();
        String hora= cn.obtenerhora();
        
        if(notarj.length()!=0){
        ar= cn.empezartrans(Integer.parseInt(idusu),comprafinal, fecha, hora, totalt,direcenv, notarj);
        
       
            try {
                generarpdf(Integer.parseInt(idusu),ar[0],ar[2],ar[1], direcenv, fecha, hora);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(comprafinal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(comprafinal.class.getName()).log(Level.SEVERE, null, ex);
            }
          
          
          
          this.dispose();
        }
        
    }//GEN-LAST:event_confirmarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void tipoenvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoenvActionPerformed
        String gio= tipoenv.getSelectedItem().toString();
        double precio=0;
        if (gio.equals("sin envio")){
        precioenv.setText("$0");
        precio=0;
        }
        else {
        precioenv.setText("$300");
        precio=300;
        }
        totalt=total1+precio;
        jLabel10.setText(String.valueOf(precio+total1));
        
    }//GEN-LAST:event_tipoenvActionPerformed

    private void tarfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tarfActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JButton confirmar;
    private javax.swing.JLabel datos;
    private javax.swing.JLabel datos2;
    private javax.swing.JTextField direnv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane mostart;
    private javax.swing.JLabel precioart;
    private javax.swing.JLabel precioenv;
    private javax.swing.JTextField tarf;
    private javax.swing.JComboBox<String> tipoenv;
    // End of variables declaration//GEN-END:variables

    conexionMySQLCliente cn= new conexionMySQLCliente();



}
