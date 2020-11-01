
package cliente;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class comp1 extends javax.swing.JFrame {
        
    String idu;
   
    public comp1(String id) {
        
        initComponents();
        obtenerinf(id);
        this.setResizable(false);
    }

    public void obtenerinf(String id){
        idu=id;
        nombre.setText(cn.obtenernombre(Integer.parseInt(id)));
    }
    
    public void art(){
        
        modelo.clear();
        listaarticulos.setModel(modelo);
        if(lista!=null){
        for (Libro a: lista){
        modelo.addElement(a.toString());
        }
        }
        
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        carritox = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaarticulos = new javax.swing.JList<>();
        agregar = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        opc = new javax.swing.JComboBox<>();
        sub = new javax.swing.JTextField();
        most = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("BIENVENIDO");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Nombre");

        nombre.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N

        carritox.setBackground(new java.awt.Color(255, 255, 255));
        carritox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/imagenes/CARRo.png"))); // NOI18N
        carritox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carritoxActionPerformed(evt);
            }
        });

        listaarticulos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        listaarticulos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        listaarticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listaarticulosMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listaarticulosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(listaarticulos);

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        cancel.setText("Cancelar");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Articulos");

        opc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        opc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Editorial", "Autor", "Titulo" }));
        opc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcActionPerformed(evt);
            }
        });

        most.setText("mostrar");
        most.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/imagenes/raheda.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(agregar)
                .addGap(80, 80, 80)
                .addComponent(cancel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(opc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(36, 36, 36)
                                .addComponent(sub, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(most))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(carritox, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(carritox, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(opc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(most))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar)
                    .addComponent(cancel))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carritoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carritoxActionPerformed
        if(!lisit.isEmpty())
        new carrito(lisit,idu).setVisible(true);  
    }//GEN-LAST:event_carritoxActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void listaarticulosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaarticulosMouseEntered

           
    }//GEN-LAST:event_listaarticulosMouseEntered

    private void listaarticulosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaarticulosMousePressed
       // System.out.print(listaarticulos.getSelectedIndex());
       
    }//GEN-LAST:event_listaarticulosMousePressed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        
         int a= listaarticulos.getSelectedIndex();
         String cant= JOptionPane.showInputDialog(null,"CANTIDAD", "¿Cuántos articulos desea comprar?", DISPOSE_ON_CLOSE);
         
         if(cant!=null && Integer.parseInt(cant)>0 )
         lisit.add(new Item(lista.get(a),Integer.parseInt(cant)));
         else
             JOptionPane.showMessageDialog(null,"Ingresa un numero valido","COMPRA", HEIGHT);
         
    }//GEN-LAST:event_agregarActionPerformed

    private void mostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostActionPerformed
        
        String opcion= opc.getSelectedItem().toString();
        String no="";
        
        if(opcion.equals("Todos")){
        lista=cn.obtenerarticulos();
        art();
        }
        
        else if(opcion.equals("Editorial")){
        
            no=sub.getText();
            lista=cn.obtenerarticulosesp(no,0);
            
            art();
        }
        
        else if(opcion.equals("Autor")){
        
            no=sub.getText();
            lista=cn.obtenerarticulosesp(no,1);
            
            art();         
        }
        
        else if(opcion.equals("Titulo")){
        
            no=sub.getText();
            lista=cn.obtenerarticulosesp(no,2);
            
            art();     
        }
        
        
        
    }//GEN-LAST:event_mostActionPerformed

    private void opcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton cancel;
    private javax.swing.JButton carritox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaarticulos;
    private javax.swing.JButton most;
    private javax.swing.JLabel nombre;
    private javax.swing.JComboBox<String> opc;
    private javax.swing.JTextField sub;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JLabel alerta;

    DefaultListModel<String> modelo = new DefaultListModel();
    conexionMySQLCliente cn= new conexionMySQLCliente();
    ArrayList<Libro> lista = new ArrayList<Libro>();
    ArrayList<Item> lisit= new ArrayList<Item>();
    
}
