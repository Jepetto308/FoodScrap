/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import CAD.CargarCAD;
import CAD.SucursalesCAD;
import CAD.TablasCAD;
import Config.Bandera;
import Config.Validaciones;
import Model.Sucursales;
import Model.Zonas;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author USUARIO
 */
public class vSucursales extends javax.swing.JInternalFrame {

    /**
     * Creates new form vSucursales
     */
    public vSucursales() {
        initComponents();
        botonesInicio(false, false, true, false, false, false, false);
        cargarCombos();
        mostrarDatos("");
        cargarId();
    }

    //<editor-fold desc="CARGAR COMBOS" defaultstate="collapsed">    
    void cargarCombos() {
        //Combo Zonas
        CargarCAD oCargarCAD = new CargarCAD();
        List ListaComboZ = oCargarCAD.CargarZona();

        CbxZona.removeAllItems();
        for (int i = 0; i < ListaComboZ.size(); i++) {
            Zonas Zn = (Zonas) ListaComboZ.get(i);
            if (CbxZona.getSelectedIndex() != 0) {
                CbxZona.addItem(Zn.getNombre());
            } else {
                CbxZona.addItem("Comuna " + Zn.getComuna() + " (" + Zn.getNombre() + ")");
            }
        }
    }

    void cargarId() {
        //Cargar ID
        CargarCAD oCargarCAD = new CargarCAD();
        Bandera B = new Bandera("Sucursales", "Id_Sucursal");
        String P = oCargarCAD.cargarIds(B);
        Lbl_IdSucursal.setText(P);
    }
    //</editor-fold>

    //<editor-fold desc="BOTONES INICIO" defaultstate="collapsed">
    void botonesInicio(boolean Ok, boolean datos, boolean nuevo, boolean Agregar, boolean modificar, boolean eliminar, boolean cancelar) {
        BtnNuevo.requestFocus();
        LblOk.setVisible(Ok);
        /////
        Lbl_IdSucursal.setEnabled(datos);
        TxtNombre.setEnabled(datos);
        TxtDireccion.setEnabled(datos);
        CbxZona.setEnabled(datos);
        TxtTelefono.setEnabled(datos);
        /////
        BtnNuevo.setVisible(nuevo);
        /////
        BtnAgregar.setVisible(Agregar);
        BtnModificar.setVisible(modificar);
        BtnEliminar.setVisible(eliminar);
        BtnCancelar.setVisible(cancelar);
    }
    //</editor-fold>

    //<editor-fold desc="lIMPIAR CAMPOS" defaultstate="collapsed">
    public void limpiarCampos() {
        LblOk.setVisible(false);
        ////
        TxtNombre.setText("");
        TxtDireccion.setText("");
        CbxZona.setSelectedIndex(0);
        TxtTelefono.setText("");
        
        cargarId();
    }
    //</editor-fold>       

    //<editor-fold desc="BUSCAR" defaultstate="collapsed">
    void buscarSi() {
        TxtBuscar.setVisible(true);
        LblBuscar.setVisible(true);
    }

    void buscarNo() {
        TxtBuscar.setVisible(false);
        LblBuscar.setVisible(false);
    }
    //</editor-fold>   

    //<editor-fold desc="MOSTRAR DATOS" defaultstate="collapsed">
    void mostrarDatos(String Valor) {
        TablasCAD ModelTable = new TablasCAD();
        TblConsultarSucursal.setModel(ModelTable.getTablaSucursales(Valor));
        TableColumnModel columnModel = TblConsultarSucursal.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(100);
        }

    }
    //</editor-fold>

    //<editor-fold desc="HABILITAR CAMPOS" defaultstate="collapsed">
    void habilitarCampos(boolean datos, boolean nuevo, boolean guardar, boolean modificar, boolean eliminar, boolean cancelar) {
        TxtNombre.setEnabled(datos);
        TxtTelefono.setEnabled(datos);
        TxtDireccion.setEnabled(datos);
        CbxZona.setEnabled(datos);
        /// 
        BtnNuevo.setVisible(nuevo);
        BtnAgregar.setVisible(guardar);
        BtnModificar.setVisible(modificar);
        BtnEliminar.setVisible(eliminar);
        BtnCancelar.setVisible(cancelar);

        buscarNo();
    }
    //</editor-fold>

    //<editor-fold desc="LLENAR SUCURSAL" defaultstate="collapsed">
    void llenarsSucursal(Sucursales S) {
        S.setCodigo(Lbl_IdSucursal.getText());
        S.setNombre(TxtNombre.getText());
        S.setTelefono(TxtTelefono.getText());
        S.setDireccion(TxtDireccion.getText());
        S.setZona(CbxZona.getSelectedIndex());
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
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        Lbl_IdSucursal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CbxZona = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        TxtTelefono = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblConsultarSucursal = new javax.swing.JTable();
        LblOk = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BtnEliminar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        BtnAgregar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnNuevo = new javax.swing.JButton();
        LblBuscar = new javax.swing.JLabel();
        TxtBuscar = new javax.swing.JTextField();

        MnModificar.setText("Modificar");
        MnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnModificarActionPerformed(evt);
            }
        });
        PopM_Tabla.add(MnModificar);

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
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Titles/GSucursales.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Lbl_IdSucursal.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        Lbl_IdSucursal.setForeground(new java.awt.Color(255, 0, 0));
        Lbl_IdSucursal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel3.setText("ID Sucursal :");

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nombre ");

        TxtNombre.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtNombre.setForeground(new java.awt.Color(255, 0, 0));
        TxtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Dirección");

        TxtDireccion.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtDireccion.setForeground(new java.awt.Color(255, 0, 0));
        TxtDireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Zona");

        CbxZona.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        CbxZona.setForeground(new java.awt.Color(255, 0, 0));
        CbxZona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..." }));

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Telefono");

        TxtTelefono.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtTelefono.setForeground(new java.awt.Color(255, 0, 0));
        TxtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Lbl_IdSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtDireccion))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(CbxZona, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtTelefono)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_IdSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(CbxZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TblConsultarSucursal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TblConsultarSucursal.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TblConsultarSucursal.setComponentPopupMenu(PopM_Tabla);
        TblConsultarSucursal.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jScrollPane1.setViewportView(TblConsultarSucursal);

        LblOk.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        LblOk.setForeground(new java.awt.Color(0, 153, 51));
        LblOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Titles/Ok.png"))); // NOI18N
        LblOk.setToolTipText("Operación Exitosa");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        BtnEliminar.setBackground(new java.awt.Color(255, 153, 0));
        BtnEliminar.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Eliminar.png"))); // NOI18N
        BtnEliminar.setToolTipText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnCancelar.setBackground(new java.awt.Color(255, 153, 0));
        BtnCancelar.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        BtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Cancelar.png"))); // NOI18N
        BtnCancelar.setToolTipText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        BtnAgregar.setBackground(new java.awt.Color(255, 153, 0));
        BtnAgregar.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        BtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Guardar.png"))); // NOI18N
        BtnAgregar.setToolTipText("Guardar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        BtnModificar.setBackground(new java.awt.Color(255, 153, 0));
        BtnModificar.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        BtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Modificar.png"))); // NOI18N
        BtnModificar.setToolTipText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnNuevo.setBackground(new java.awt.Color(255, 153, 0));
        BtnNuevo.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        BtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nuevo.png"))); // NOI18N
        BtnNuevo.setToolTipText("Nuevo");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        LblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Buscar.png"))); // NOI18N

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(LblBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LblOk)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblOk)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        vPrincipal.ventana = "";
    }//GEN-LAST:event_formInternalFrameClosing

    private void TxtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyPressed
        if (evt.getKeyCode() == 10) {
            mostrarDatos(TxtBuscar.getText());
        }
    }//GEN-LAST:event_TxtBuscarKeyPressed

    private void TxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyReleased
        mostrarDatos(TxtBuscar.getText());
    }//GEN-LAST:event_TxtBuscarKeyReleased

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        //<editor-fold desc="NUEVO" defaultstate="collapsed">
        cargarId();
        botonesInicio(false, true, false, true, false, false, true);
        buscarNo();
        mostrarDatos("");
        //</editor-fold>
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        //<editor-fold desc="GUARDAR" defaultstate="collapsed">
        // Btn Guardar
        Map rsp = new HashMap();
        Sucursales S = new Sucursales();

        S.setCodigo(Lbl_IdSucursal.getText());
        S.setNombre(TxtNombre.getText());
        S.setDireccion(TxtDireccion.getText());
        S.setZona(CbxZona.getSelectedIndex());
        S.setTelefono(TxtTelefono.getText());

        rsp.put("Sucursal", S);

        Validaciones V = new Validaciones();
        V.validarCamposSucursales(rsp);

        if (rsp.containsKey("Mensaje")) {
            JOptionPane.showMessageDialog(null, rsp.get("Mensaje"));
            //            rsp.get("campo");
            //            String Focus = (String)rsp.get("campo");
            //            System.out.println(""+Focus);
        } else {

            boolean guardar = SucursalesCAD.guardar(S);

            if (!guardar) {
                limpiarCampos();
                JOptionPane.showMessageDialog(null, Bandera.getRespuesta());
                TxtNombre.requestFocus();
            } else {
                limpiarCampos();
                cargarId();
                mostrarDatos("");
                botonesInicio(true, false, true, false, false, false, false);
                LblOk.setText(Bandera.getRespuesta());
                LblOk.setVisible(true);
                buscarSi();
                Bandera.setRespuesta("");

            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        //<editor-fold desc="MODIFICAR" defaultstate="collapsed">
        // Btn Modificar
        Map rsp = new HashMap();
        Sucursales S = new Sucursales();
        llenarsSucursal(S);
        rsp.put("Sucursal", S);

        Validaciones AU = new Validaciones();
        AU.validarCamposSucursales(rsp);

        if (rsp.containsKey("Mensaje")) {
            JOptionPane.showMessageDialog(null, rsp.get("Mensaje"));
            //            rsp.get("campo");
            //            String Focus = (String)rsp.get("campo");
            //            System.out.println(""+Focus);
        } else {
            boolean Modificar = SucursalesCAD.modificar(S);

            if (!Modificar) {
                JOptionPane.showMessageDialog(null, Bandera.getRespuesta());
                limpiarCampos();
                mostrarDatos("");
                // botonesInicio();
            } else {
                limpiarCampos();
                botonesInicio(true, false, true, false, false, false, false);
                cargarId();
                buscarSi();
                mostrarDatos(S.getNombre());
                LblOk.setText(Bandera.getRespuesta());
                LblOk.setVisible(true);
                Bandera.setRespuesta("");
                
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        //<editor-fold desc="ELIMINAR" defaultstate="collapsed">
        if (Lbl_IdSucursal.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No se puede Eliminar la Sucursal\nNo se encuentra el Codigo\nVerifique que tenga conexion con la BD");
        } else {
            // Btn Eliminar
            String Codigo = Lbl_IdSucursal.getText();

            Sucursales Su = new Sucursales();
            Su.setCodigo(Codigo);

            boolean Eliminar = SucursalesCAD.eliminar(Su);

            if (!Eliminar) {
                JOptionPane.showMessageDialog(null, Bandera.getRespuesta());
                limpiarCampos();
                mostrarDatos("");
                //botonesInicio();
            } else {
                limpiarCampos();
                botonesInicio(true, false, true, false, false, false, false);
                buscarSi();
                mostrarDatos("");
                LblOk.setText(Bandera.getRespuesta());
                LblOk.setVisible(true);                
                Bandera.setRespuesta("");
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        //<editor-fold desc="CANCELAR" defaultstate="collapsed">
        limpiarCampos();
        cargarId();
        botonesInicio(false, false, true, false, false, false, false);
        mostrarDatos("");
        buscarSi();
        TxtBuscar.requestFocus();
        //</editor-fold>
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void MnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnModificarActionPerformed
        //<editor-fold desc="MENU MODIFICAR" defaultstate="collapsed">
        //Seleccion fila modificar
        if (Seleccion()) {
            habilitarCampos(true, false, false, true, false, true);
        }
        //</editor-fold>
    }//GEN-LAST:event_MnModificarActionPerformed

    private void MnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnEliminarActionPerformed
        //<editor-fold desc="MENU ELIMINAR" defaultstate="collapsed">
        //Seleccion fila Eliminar
        if (Seleccion()) {
            habilitarCampos(false, false, false, false, true, true);
        }
        //</editor-fold>
    }//GEN-LAST:event_MnEliminarActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        LblOk.setVisible(false);
        mostrarDatos("");
    }//GEN-LAST:event_jPanel1MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JComboBox<String> CbxZona;
    private javax.swing.JLabel LblBuscar;
    private javax.swing.JLabel LblOk;
    private javax.swing.JLabel Lbl_IdSucursal;
    private javax.swing.JMenuItem MnEliminar;
    private javax.swing.JMenuItem MnModificar;
    private javax.swing.JPopupMenu PopM_Tabla;
    private javax.swing.JTable TblConsultarSucursal;
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.JTextField TxtDireccion;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

    public boolean Seleccion() {

        int fila = TblConsultarSucursal.getSelectedRow();
        if (fila >= 0) {

            Lbl_IdSucursal.setText(TblConsultarSucursal.getValueAt(fila, 0).toString());
            TxtNombre.setText(TblConsultarSucursal.getValueAt(fila, 1).toString());
            TxtDireccion.setText(TblConsultarSucursal.getValueAt(fila, 2).toString());
            CbxZona.setSelectedIndex(Integer.parseInt(TblConsultarSucursal.getValueAt(fila, 3).toString()));
            TxtTelefono.setText(TblConsultarSucursal.getValueAt(fila, 4).toString());

            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningunaa Sucursal de la tabla");
            buscarSi();
            return false;

        }
    }
}
