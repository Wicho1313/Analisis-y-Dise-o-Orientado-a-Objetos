
package liibreria;

import java.awt.Color;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class Inventario extends javax.swing.JFrame {

    String idsuc="";
   
    public Inventario(String id) {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        idsuc=id;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aa = new javax.swing.JButton();
        ea = new javax.swing.JButton();
        ela = new javax.swing.JButton();
        au = new javax.swing.JButton();
        elu = new javax.swing.JButton();
        eu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        salir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        aa.setText("Agregar articulo");
        aa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aaActionPerformed(evt);
            }
        });

        ea.setText("Editar Articulo");
        ea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eaActionPerformed(evt);
            }
        });

        ela.setText("Eliminar articulo");
        ela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elaActionPerformed(evt);
            }
        });

        au.setText("Agregar Usuario");
        au.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                auActionPerformed(evt);
            }
        });

        elu.setText("Eliminar usuario");
        elu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eluActionPerformed(evt);
            }
        });

        eu.setText("Editar usuario");
        eu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                euActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lao UI", 1, 20)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/liibreria/raheda.png"))); // NOI18N

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        jButton1.setText("Ver libros");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ver usuarios");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aa, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(ela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(elu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(au, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aa, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(au, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ela, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ea, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aaActionPerformed
       new agreart(idsuc).setVisible(true);
       
    }//GEN-LAST:event_aaActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void auActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auActionPerformed
      new datosC().setVisible(true);
    }//GEN-LAST:event_auActionPerformed

    private void elaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elaActionPerformed
       
        String id= JOptionPane.showInputDialog(null,"Ingresa numserie" ,"Eliminar articulo", DISPOSE_ON_CLOSE);
        cn.eliminarart(Integer.parseInt(id));
        
    }//GEN-LAST:event_elaActionPerformed

    private void eluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eluActionPerformed
       String id= JOptionPane.showInputDialog(null,"Ingresa idcliente" ,"Eliminar cliente", DISPOSE_ON_CLOSE);
       cn.eliminausu(Integer.parseInt(id));
             
    }//GEN-LAST:event_eluActionPerformed

    private void eaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eaActionPerformed
        
         String id= JOptionPane.showInputDialog(null,"Ingresa numserie" ,"Editar articulo", DISPOSE_ON_CLOSE);
         String nuevo="";
         Object[] menu = { "titulo", "editorial", "numpags","precio"};
         Object selectedValue;
         
         selectedValue = JOptionPane.showInputDialog(null,
            "Editar: ", "Editar articulo",
            JOptionPane.INFORMATION_MESSAGE, null,
            menu, menu[0]);
        
        if(selectedValue==menu[0])
        { //editar titulo
            nuevo=JOptionPane.showInputDialog(null,"Ingresa nuevo titulo" ,"Editar articulo", DISPOSE_ON_CLOSE);
            cn.editarart(Integer.parseInt(id),0,nuevo);
        }
        if(selectedValue==menu[1])
        {   //editar editorial
            nuevo=JOptionPane.showInputDialog(null,"Ingresa nueva editorial" ,"Editar articulo", DISPOSE_ON_CLOSE);
            cn.editarart(Integer.parseInt(id),1,nuevo);
        }
        if(selectedValue==menu[2])
        {   //editar numpags
            nuevo=JOptionPane.showInputDialog(null,"Ingresa nuevo numero de paginas" ,"Editar articulo", DISPOSE_ON_CLOSE);
            cn.editarart(Integer.parseInt(id),2,nuevo);
        }    
        if(selectedValue==menu[3])
        {    //editar precio
            nuevo=JOptionPane.showInputDialog(null,"Ingresa nuevo precio" ,"Editar articulo", DISPOSE_ON_CLOSE);
            cn.editarart(Integer.parseInt(id),3,nuevo);
        }
        
        
        
        
    }//GEN-LAST:event_eaActionPerformed

    private void euActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_euActionPerformed
       
        
         String id= JOptionPane.showInputDialog(null,"Ingresa ID de usuario" ,"Editar articulo", DISPOSE_ON_CLOSE);
         String nuevo="";
         Object[] menu = {"Nombre","Apellido paterno", "Apellido materno","Estado","Colonia","C.P.","Telefono", "Email"};
         Object selectedValue;
         
         selectedValue = JOptionPane.showInputDialog(null,
            "Editar: ", "Editar cliente",
            JOptionPane.INFORMATION_MESSAGE, null,
            menu, menu[0]);
        
        if(selectedValue==menu[0])
        { //editar Nombre
            nuevo=JOptionPane.showInputDialog(null,"Ingresa nuevo nombre" ,"Editar usuario", DISPOSE_ON_CLOSE);
            cn.editarusu(Integer.parseInt(id),0 , nuevo);
        }
        else if(selectedValue==menu[1])
        {   //editar Apellido
            nuevo=JOptionPane.showInputDialog(null,"Ingresa nuevo apellido paterno" ,"Editar usuario", DISPOSE_ON_CLOSE);
            cn.editarusu(Integer.parseInt(id),1,nuevo);
        }
        else if(selectedValue==menu[2])
        {   //editar Apellido m
            nuevo=JOptionPane.showInputDialog(null,"Ingresa nuevo apellido materno" ,"Editar usuario", DISPOSE_ON_CLOSE);
            cn.editarusu(Integer.parseInt(id),2,nuevo);
        }    
        else if(selectedValue==menu[3])
        {    //editar Estado
            nuevo=JOptionPane.showInputDialog(null,"Ingresa nuevo estado" ,"Editar usuario", DISPOSE_ON_CLOSE);
            cn.editarusu(Integer.parseInt(id),3,nuevo);
        }
        
        else if(selectedValue==menu[4])
        {    //editar colonia
            nuevo=JOptionPane.showInputDialog(null,"Ingresa nueva colonia" ,"Editar usuario", DISPOSE_ON_CLOSE);
            cn.editarusu(Integer.parseInt(id),4,nuevo);
        }
        
        else if(selectedValue==menu[5])
        {    //editar C.P.
            nuevo=JOptionPane.showInputDialog(null,"Ingresa nuevo C.P." ,"Editar usuario", DISPOSE_ON_CLOSE);
            cn.editarusu(Integer.parseInt(id),5,nuevo);
        }
        
        else if(selectedValue==menu[6])
        {    //editar telefono
            nuevo=JOptionPane.showInputDialog(null,"Ingresa nuevo telefono" ,"Editar usuario", DISPOSE_ON_CLOSE);
            cn.editarusu(Integer.parseInt(id),6,nuevo);
        }
        
        else if(selectedValue==menu[7])
        {    //editar Email
            nuevo=JOptionPane.showInputDialog(null,"Ingresa nuevo email" ,"Editar usuario", DISPOSE_ON_CLOSE);
            cn.editarusu(Integer.parseInt(id),7,nuevo);
        }
                 
    }//GEN-LAST:event_euActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                new verlibs(idsuc).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //new verlibs(idsuc).setVisible(true);
          new verUsuarios().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aa;
    private javax.swing.JButton au;
    private javax.swing.JButton ea;
    private javax.swing.JButton ela;
    private javax.swing.JButton elu;
    private javax.swing.JButton eu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables

    conexionMySQLEmpleado cn= new conexionMySQLEmpleado();
}
