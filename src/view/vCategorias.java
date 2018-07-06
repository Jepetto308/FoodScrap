/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import CAD.CargarCAD;
import CAD.CategoriasCAD;
import CAD.TablasCAD;
import Config.Bandera;
import Config.Validaciones;
import Model.Categorias;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author USUARIO
 */
public class vCategorias extends javax.swing.JInternalFrame {

    /**
     * Creates new form vCategorias
     */
    public vCategorias() {
        initComponents();
        cargarId();
        botonesInicio(false, false, false, true, false, false, false, false);
        mostrarDatos("");
    }
    
    //<editor-fold desc="CARGAR ID" defaultstate="collapsed">
    void cargarId(){
        //Cargar ID
        CargarCAD oCargarCAD = new CargarCAD() ;
        Bandera B = new Bandera("Categorias", "IdCategoria");
        String Ct = oCargarCAD.cargarIds(B);          
        Lbl_Id.setText(Ct);
    }
    //</editor-fold>
    
    //<editor-fold desc="BOTONES INICIO" defaultstate="collapsed">
    void botonesInicio(boolean Ok,boolean id,boolean nombre,boolean nuevo,boolean agregar,boolean modificar,boolean eliminar,boolean cancelar){ 
        
        BtnNuevo.requestFocus();
        LblOk.setVisible(Ok);
        /////
        Lbl_Id.setEnabled(id);
        TxtNombre.setEnabled(nombre);      
        /////
        BtnNuevo.setVisible(nuevo);
        BtnEliminar.setVisible(eliminar);        
        /////
        BtnAgregar.setVisible(agregar);
        BtnModificar.setVisible(modificar);
        BtnCancelar.setVisible(cancelar);      
        buscarSi();        
    }
    //</editor-fold>
    
    //<editor-fold desc="BUSCAR" defaultstate="collapsed">
    void buscarSi(){
        TxtBuscar.setVisible(true);
        LblBuscar.setVisible(true);
    }
    void buscarNo(){
        TxtBuscar.setVisible(false);
        LblBuscar.setVisible(false);
    }
    //</editor-fold>
    
    //<editor-fold desc="MOSTRAR DATOS" defaultstate="collapsed">
    void mostrarDatos(String Valor){        
        TablasCAD ModelTable = new TablasCAD();         
        TblCategorias.setModel(ModelTable.getTablaCategorias(Valor));      
        TableColumnModel columnModel = TblCategorias.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
        columnModel.getColumn(i).setPreferredWidth(100);
        }
        
    }       
    //</editor-fold>
    
    //<editor-fold desc="LIMPIAR CAMPOS" defaultstate="collapsed">
    public void limpiarCampos(){
        TxtNombre.setText("");
        TxtBuscar.setText("");
        mostrarDatos("");
    }
    //</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopM_Tabla = new javax.swing.JPopupMenu();
        MnModificar = new javax.swing.JMenuItem();
        MnEliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Lbl_Id = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        BtnAgregar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        BtnNuevo = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        LblOk = new javax.swing.JLabel();
        TxtBuscar = new javax.swing.JTextField();
        LblBuscar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblCategorias = new javax.swing.JTable();

        MnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Modificar.png"))); // NOI18N
        MnModificar.setText("Modificar");
        MnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnModificarActionPerformed(evt);
            }
        });
        PopM_Tabla.add(MnModificar);

        MnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Eliminar.png"))); // NOI18N
        MnEliminar.setText("Eliminar");
        MnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnEliminarActionPerformed(evt);
            }
        });
        PopM_Tabla.add(MnEliminar);

        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Agency FB", 1, 16))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Id Cat :");

        Lbl_Id.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        Lbl_Id.setForeground(new java.awt.Color(255, 0, 0));
        Lbl_Id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Id.setText("...");

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Nombre de Categoria :");

        TxtNombre.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtNombre.setForeground(new java.awt.Color(255, 0, 0));
        TxtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lbl_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Lbl_Id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Titles/TipoCategorias.png"))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnAgregar.setBackground(new java.awt.Color(255, 153, 0));
        BtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Guardar.png"))); // NOI18N
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });
        jPanel5.add(BtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 11, 32, -1));

        BtnEliminar.setBackground(new java.awt.Color(255, 153, 0));
        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Eliminar.png"))); // NOI18N
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });
        jPanel5.add(BtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 11, 32, -1));

        BtnCancelar.setBackground(new java.awt.Color(255, 153, 0));
        BtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Cancelar.png"))); // NOI18N
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });
        jPanel5.add(BtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 11, 32, -1));

        BtnNuevo.setBackground(new java.awt.Color(255, 153, 0));
        BtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nuevo.png"))); // NOI18N
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });
        jPanel5.add(BtnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 11, 32, -1));

        BtnModificar.setBackground(new java.awt.Color(255, 153, 0));
        BtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Modificar.png"))); // NOI18N
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });
        jPanel5.add(BtnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 11, 32, -1));

        LblOk.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        LblOk.setForeground(new java.awt.Color(0, 153, 51));
        LblOk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Titles/Ok.png"))); // NOI18N
        LblOk.setToolTipText("Operacion Exitosa");

        TxtBuscar.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtBuscar.setForeground(new java.awt.Color(255, 0, 0));
        TxtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscarKeyReleased(evt);
            }
        });

        LblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Buscar.png"))); // NOI18N

        TblCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TblCategorias.setComponentPopupMenu(PopM_Tabla);
        TblCategorias.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jScrollPane1.setViewportView(TblCategorias);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(LblBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtBuscar)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblOk))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtBuscar)
                    .addComponent(LblBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        //<editor-fold desc="GUARDAR" defaultstate="collapsed">
        // Btn Guardar
        Map rsp = new HashMap();
        Categorias Ct = new Categorias();
        
        Ct.setCodigo(Lbl_Id.getText());
        Ct.setNombre(TxtNombre.getText());
        
        rsp.put("Categorias",Ct);
        
        Validaciones V = new Validaciones();
        V.validarCamposCategorias(rsp);
        
        if (rsp.containsKey("Mensaje")) {
            JOptionPane.showMessageDialog(null,rsp.get("Mensaje"));
//            rsp.get("campo");
//            String Focus = (String)rsp.get("campo");
//            System.out.println(""+Focus);
        }else{
            
            if (Lbl_Id.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No se puede Guardar la Categoria\nEl Campo 'ID' se encuentra vacio\nVerifique que tenga conexion con la BD");

            } else {
                boolean guardar = CategoriasCAD.guardar(Ct);

                    if(!guardar){
                        limpiarCampos();
                        mostrarDatos("");
                        cargarId();
                        JOptionPane.showMessageDialog(null,Bandera.getRespuesta());
                        TxtNombre.requestFocus();
                    }else{ 
                        limpiarCampos();
                        botonesInicio(true, false, false, true, false, false, false, false);
                        LblOk.setText(Bandera.getRespuesta());
                        cargarId();
                        mostrarDatos("");
                    }
                }
            }
        //</editor-fold>
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        //<editor-fold desc="ELIMINAR" defaultstate="collapsed">
        if (Lbl_Id.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No se puede Eliminar la Categoria\nEl Campo 'ID' se encuentra vacio\nVerifique que tenga conexion con la BD");
            TxtNombre.requestFocus();
        }else{
            // Btn Eliminar
            String Codigo = Lbl_Id.getText();
            
            Categorias Ct = new Categorias();
            Ct.setCodigo(Codigo);

            boolean Eliminar = CategoriasCAD.eliminar(Ct);

                    if(!Eliminar){                                                
                        limpiarCampos();
                        mostrarDatos("");                        
                        botonesInicio(false,false,false,true,false,false,false,false);
                        cargarId();
                        JOptionPane.showMessageDialog(null,Bandera.getRespuesta());
                    }else{ 
                        limpiarCampos();                        
                        LblOk.setText(Bandera.getRespuesta());
                        botonesInicio(true,false,false,true,false,false,false,false);
                        cargarId();
                        mostrarDatos("");
                    }            
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        //<editor-fold desc="CANCELAR" defaultstate="collapsed">
        limpiarCampos();
        botonesInicio(false, false, false, true, false, false, false, false);
        cargarId();
        mostrarDatos("");
        //</editor-fold>
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        //<editor-fold desc="NUEVO" defaultstate="collapsed">
        botonesInicio(false, true, true, false, true, false, false, true);
        cargarId();
        buscarNo();
        limpiarCampos();
        TxtNombre.requestFocus();
        //</editor-fold>
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        //<editor-fold desc="MODIFICAR" defaultstate="collapsed">
        //Boton Modificar
        Map rsp = new HashMap();
        Categorias Ct = new Categorias();
        
        Ct.setCodigo(Lbl_Id.getText());
        Ct.setNombre(TxtNombre.getText());       
        
        rsp.put("Categorias",Ct);
        
        Validaciones V = new Validaciones();
        V.validarCamposCategorias(rsp);
        
        if (rsp.containsKey("Mensaje")) {
            JOptionPane.showMessageDialog(null,rsp.get("Mensaje"));
//            rsp.get("campo");
//            String Focus = (String)rsp.get("campo");
//            System.out.println(""+Focus);
        }else{
            
            if (Lbl_Id.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null,"No se encuentra el ID '"+Lbl_Id.getText()+"' en la BD");
                } else {
                boolean Modificar = CategoriasCAD.modificar(Ct);

                    if(!Modificar){                        
                        JOptionPane.showMessageDialog(null,Bandera.getRespuesta());
                        limpiarCampos();
                        mostrarDatos("");                        
                        botonesInicio(false, false, false, true, false, false, false, false);
                        cargarId();
                    }else{ 
                        limpiarCampos();
                        botonesInicio(true, false, false, true, false, false, false, false);
                        mostrarDatos("");
                        cargarId();
                        LblOk.setText(Bandera.getRespuesta());
                        LblOk.setVisible(true);
                    }
                }
            }
        //</editor-fold>
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void TxtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyPressed
        if(evt.getKeyCode()==10){
            mostrarDatos(TxtBuscar.getText());
        }
    }//GEN-LAST:event_TxtBuscarKeyPressed

    private void TxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyReleased
        mostrarDatos(TxtBuscar.getText());
    }//GEN-LAST:event_TxtBuscarKeyReleased

    private void MnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnModificarActionPerformed
        //<editor-fold desc="MENU MODIFICAR" defaultstate="collapsed">
        //Seleccion fila modificar
        Seleccion();
        botonesInicio(false, false, true, false, false, true, false, true);
        TxtNombre.requestFocus();
        buscarNo();
        //</editor-fold>
    }//GEN-LAST:event_MnModificarActionPerformed

    private void MnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnEliminarActionPerformed
        //<editor-fold desc="MENU ELIMINAR" defaultstate="collapsed">
        //Seleccion fila Eliminar
        Seleccion();
        botonesInicio(false, false, false, false, false, false, true, true);
        buscarNo();
        //</editor-fold>
    }//GEN-LAST:event_MnEliminarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        vPrincipal.ventana = "";
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JLabel LblBuscar;
    private javax.swing.JLabel LblOk;
    private javax.swing.JLabel Lbl_Id;
    private javax.swing.JMenuItem MnEliminar;
    private javax.swing.JMenuItem MnModificar;
    private javax.swing.JPopupMenu PopM_Tabla;
    public javax.swing.JTable TblCategorias;
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    void Seleccion(){
        int fila=TblCategorias.getSelectedRow();
        if (fila >= 0) {            
            Lbl_Id.setText(TblCategorias.getValueAt(fila, 0).toString());
            TxtNombre.setText(TblCategorias.getValueAt(fila, 1).toString());                      
        }else{
            JOptionPane.showMessageDialog(null,"No se ha seleccionado ninguna Unidad de Medida de la tabla");
        }
    }
}
