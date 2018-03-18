/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Config.Bandera;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class vPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form vPrincipal
     */
    static String ventana="";
    public vPrincipal() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/img/Titles/IconoLogo.png")).getImage());
        setExtendedState(MAXIMIZED_BOTH);
        LblNombre.setText("Usuario Actual : "+ Bandera.getNombre() + " " + Bandera.getApellido());
        LblNombre.setForeground(Color.red);
        LblRoll.setText(Bandera.getNombreRol() + " ( " + Bandera.getSiglasRol()+" )");
        
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LblNombre = new javax.swing.JLabel();
        LblRoll = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LblNombre.setText("Nombre");

        LblRoll.setText("Roll");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Perfil.png"))); // NOI18N
        jMenuItem1.setText("Mi Perfil");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/arrow-top-left-24.png"))); // NOI18N
        jMenuItem2.setText("Cerrar Sesion");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reply-24.png"))); // NOI18N
        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Movimientos");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Cierre.png"))); // NOI18N
        jMenuItem4.setText("Cierre Sucursales");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Gestionar");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Platos.png"))); // NOI18N
        jMenuItem7.setText("Platos");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Productos.png"))); // NOI18N
        jMenuItem8.setText("Productos");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Proveedores.png"))); // NOI18N
        jMenuItem10.setText("Proveedores");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Sucursales.png"))); // NOI18N
        jMenuItem9.setText("Sucursales");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Usuarios.png"))); // NOI18N
        jMenuItem5.setText("Usuarios");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Consultas");

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Platos.png"))); // NOI18N
        jMenuItem13.setText("Consultar Platos");
        jMenu4.add(jMenuItem13);

        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Productos.png"))); // NOI18N
        jMenuItem14.setText("Consultar Productos");
        jMenu4.add(jMenuItem14);

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Proveedores.png"))); // NOI18N
        jMenuItem11.setText("Consultar Proveedores");
        jMenu4.add(jMenuItem11);

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Sucursales.png"))); // NOI18N
        jMenuItem12.setText("Consultar Sucursales");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem12);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Usuarios.png"))); // NOI18N
        jMenuItem6.setText("Consultar Usuarios");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Configuración");

        jMenuItem15.setText("Tipo Documentos");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem15);

        jMenuItem16.setText("Unidad de Medidas");
        jMenu5.add(jMenuItem16);

        jMenuItem17.setText("Categorias");
        jMenu5.add(jMenuItem17);

        jMenuItem18.setText("Roles");
        jMenu5.add(jMenuItem18);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                .addComponent(LblRoll, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblRoll)
                    .addComponent(LblNombre))
                .addGap(1, 1, 1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        //<editor-fold desc="CERRAR SESION" defaultstate="collapsed">
        int Cs= JOptionPane.showConfirmDialog(null,"Desea Cerrar sesion ?","Cierre de sesion",JOptionPane.YES_NO_OPTION);
           if (Cs== 0) {
               vAcceso vA;
              vA = new view.vAcceso();
               vA.setVisible(true);
               this.dispose();
           }else{}
        //</editor-fold>
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        //<editor-fold desc="SALIR" defaultstate="collapsed">
        int Alerta = JOptionPane.showConfirmDialog(this,"Desea salir de Sistema ?","Salir",JOptionPane.YES_NO_OPTION);

           if (Alerta==0) {
               System.exit(0);
           }
        //</editor-fold>
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //<editor-fold desc="VER PERFIL" defaultstate="collapsed">
        // Item Perfil
         vPerfil vP = new vPerfil();
         if (!ventana.equalsIgnoreCase("Mi Perfil") && !ventana.equalsIgnoreCase("Cambio Contra")) {
            ventana="Mi Perfil";
            
            Escritorio.add(vP);
            Dimension desktopSize = Escritorio.getSize();
            Dimension FrameSize = vP.getSize();
            vP.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            vP.show();             
        }
        else
        {
        JOptionPane.showMessageDialog(null,"LA VENTANA YA SE ENCUENTRA ABIERTA");
        
        }
        //</editor-fold>
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        //<editor-fold desc="CIERRE SUCURSAL" defaultstate="collapsed">
        // Item Perfil
         vCierreSucursal vS = new vCierreSucursal();
         if (!ventana.equalsIgnoreCase("Cierre Sucursal")) {
            ventana="Cierre Sucursal";
            
            Escritorio.add(vS);
            Dimension desktopSize = Escritorio.getSize();
            Dimension FrameSize = vS.getSize();
            vS.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            vS.show();             
        }
        else
        {
        JOptionPane.showMessageDialog(null,"LA VENTANA YA SE ENCUENTRA ABIERTA");
        
        }
        //</editor-fold>
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        //<editor-fold desc="GESTION USUARIOS" defaultstate="collapsed">
         vUsuarios vU = new vUsuarios();
         if (!ventana.equalsIgnoreCase("Gestion Usuarios")) { // && !ventana.equalsIgnoreCase("Cambio Contra")
            ventana="Gestion Usuarios";
            
            Escritorio.add(vU);
            Dimension desktopSize = Escritorio.getSize();
            Dimension FrameSize = vU.getSize();
            vU.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            vU.show();             
        }
        else
        {
        JOptionPane.showMessageDialog(null,"LA VENTANA YA SE ENCUENTRA ABIERTA");
        
        }
        //</editor-fold>
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        //<editor-fold desc="CONSULTAR USUARIOS" defaultstate="collapsed">        
         vConsultarUsuarios vCU = new vConsultarUsuarios();
         if (!ventana.equalsIgnoreCase("Consulta Usuarios")) { // && !ventana.equalsIgnoreCase("Cambio Contra")
            ventana="Consulta Usuarios";
            
            Escritorio.add(vCU);
            Dimension desktopSize = Escritorio.getSize();
            Dimension FrameSize = vCU.getSize();
            vCU.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            vCU.show();             
        }
        else
        {
        JOptionPane.showMessageDialog(null,"LA VENTANA YA SE ENCUENTRA ABIERTA");
        
        }
        //</editor-fold>
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        //<editor-fold desc="VER PRODUCTOS" defaultstate="collapsed">
        // Item Perfil
         vProductos vPD = new vProductos();
         if (!ventana.equalsIgnoreCase("Ver Productos")) { // && !ventana.equalsIgnoreCase("Cambio Contra")
            ventana="Ver Productos";
            
            Escritorio.add(vPD);
            Dimension desktopSize = Escritorio.getSize();
            Dimension FrameSize = vPD.getSize();
            vPD.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            vPD.show();             
        }
        else
        {
        JOptionPane.showMessageDialog(null,"LA VENTANA YA SE ENCUENTRA ABIERTA");
        
        }
        //</editor-fold>
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        //<editor-fold desc="GESTION SUCURSALES" defaultstate="collapsed">
         vSucursales vS = new vSucursales();
         if (!ventana.equalsIgnoreCase("Gestion Sucursal")) {
            ventana="Gestion Sucursal";
            
            Escritorio.add(vS);
            Dimension desktopSize = Escritorio.getSize();
            Dimension FrameSize = vS.getSize();
            vS.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            vS.show();             
        }
        else
        {
        JOptionPane.showMessageDialog(null,"LA VENTANA YA SE ENCUENTRA ABIERTA");
        
        }
        //</editor-fold>
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        //<editor-fold desc="CONSULTAR SUCURSALES" defaultstate="collapsed">
         vConsultarSucursal vCS = new vConsultarSucursal();
         if (!ventana.equalsIgnoreCase("Consultar Sucursal")) {
            ventana="Consultar Sucursal";
            
            Escritorio.add(vCS);
            Dimension desktopSize = Escritorio.getSize();
            Dimension FrameSize = vCS.getSize();
            vCS.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            vCS.show();             
        }
        else
        {
        JOptionPane.showMessageDialog(null,"LA VENTANA YA SE ENCUENTRA ABIERTA");
        
        }
        //</editor-fold>
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        //<editor-fold desc="GESTION PLATOS" defaultstate="collapsed">
         vPlatos vPl = new vPlatos();
         if (!ventana.equalsIgnoreCase("Gestion Platos")) {
            ventana="Gestion Platos";
            
            Escritorio.add(vPl);
            Dimension desktopSize = Escritorio.getSize();
            Dimension FrameSize = vPl.getSize();
            vPl.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            vPl.show();             
        }
        else
        {
        JOptionPane.showMessageDialog(null,"LA VENTANA YA SE ENCUENTRA ABIERTA");
        
        }
        //</editor-fold>
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        //<editor-fold desc="C TIPO DOCUMENTO" defaultstate="collapsed">
         vTipoDocumento vTd = new vTipoDocumento();
         if (!ventana.equalsIgnoreCase("Config Tipo Documento")) {
            ventana="Config Tipo Documento";
            
            Escritorio.add(vTd);
            Dimension desktopSize = Escritorio.getSize();
            Dimension FrameSize = vTd.getSize();
            vTd.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            vTd.show();             
        }
        else
        {
        JOptionPane.showMessageDialog(null,"LA VENTANA YA SE ENCUENTRA ABIERTA");
        
        }
        //</editor-fold>
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane Escritorio;
    private javax.swing.JLabel LblNombre;
    private javax.swing.JLabel LblRoll;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
