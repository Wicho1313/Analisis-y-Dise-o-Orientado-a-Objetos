
package cliente;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class carrito extends javax.swing.JFrame {

    ArrayList<Item> listaitem= null;
    String idu="";
    
    public carrito(ArrayList a, String id) {
        initComponents();
        listaitem=a;
        idu=id;
        iniciarlist();
        this.getContentPane().setBackground(Color.decode("#CAE9FC"));
        this.setResizable(false);
    }

    public void iniciarlist(){
        listitem.setModel(modelo);
        modelo.clear();
        if(listaitem!=null){
        for (Item i: listaitem){
        modelo.addElement(i.toString());
        }
        }
    
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        compra = new javax.swing.JButton();
        regresa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listitem = new javax.swing.JList<>();
        quitara = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Artículos en carrito");

        compra.setText("COMPRAR");
        compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compraActionPerformed(evt);
            }
        });

        regresa.setText("REGRESAR");
        regresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresaActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listitem);

        quitara.setText("Modificar articulo");
        quitara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitaraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(compra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(regresa))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(quitara)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(quitara)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compra)
                    .addComponent(regresa))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void compraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compraActionPerformed
        
        if(!listaitem.isEmpty())
        new comprafinal(listaitem,idu).setVisible(true);
        
    }//GEN-LAST:event_compraActionPerformed

    private void regresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresaActionPerformed
      this.dispose();
    }//GEN-LAST:event_regresaActionPerformed

    private void quitaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitaraActionPerformed

        String oco="";
        int a= listitem.getSelectedIndex();
        String opcion= JOptionPane.showInputDialog(null,"Selecciona\n 1-.Retirar todos los articulos"
                + "\n2.-Disminuir la cantidad de articulos \n3.-Aumentar la cantidad de articulos \n","MODIFICAR", DISPOSE_ON_CLOSE);
        
        if(opcion!=null){
        if(opcion.equals("1")){
            listaitem.remove(a);
            JOptionPane.showMessageDialog(null,"¡LISTO!","QUITAR ITEM " , HEIGHT);
        }
        
        else if (opcion.equals("2")){
            oco= JOptionPane.showInputDialog(null,"¿Cuántos de este articulo desas remover?","DISMINUIR", DISPOSE_ON_CLOSE);
            
            if(oco!=null && Integer.parseInt(oco)>0 && Integer.parseInt(oco)<listaitem.get(a).getcan())
            listaitem.get(a).setcant(listaitem.get(a).getcan()-Integer.parseInt(oco));
            
            else
              JOptionPane.showMessageDialog(null,"Ingresa un número valido", "QUITAR ITEM ", HEIGHT);  
            
        }
        
        else if (opcion.equals("3")){
            oco= JOptionPane.showInputDialog(null,"¿Cuántos de este articulo desas agregar?","Agregar", DISPOSE_ON_CLOSE);
            
            if(oco!=null && Integer.parseInt(oco)>0)
            listaitem.get(a).setcant(listaitem.get(a).getcan()+ Integer.parseInt(oco));
            
            else
              JOptionPane.showMessageDialog(null,"AGREGAR ARTICULO", "Ingresa un número valido", HEIGHT);  
            
        }
        
        }

        iniciarlist();

    }//GEN-LAST:event_quitaraActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton compra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listitem;
    private javax.swing.JButton quitara;
    private javax.swing.JButton regresa;
    // End of variables declaration//GEN-END:variables

    DefaultListModel<String> modelo = new DefaultListModel();

}
