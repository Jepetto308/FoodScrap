/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import CAD.CargarCAD;
import CAD.TablasCAD;
import Config.Bandera;
import Config.Validaciones;
import Model.Gastos;
import Model.Platos;
import Model.Sucursales;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author USUARIO
 */
public class vCierreSucursal extends javax.swing.JInternalFrame {

    /**
     * Creates new form vCierreSucursal
     */
    private Map fritos = new HashMap();
    Map mapGastos = new HashMap();

    public vCierreSucursal() {
        initComponents();
        
//        this.Lbl_ValorFritos.setText(""+totalFritos); 
        
        cargarCombos();
        LblFecha.setText("");
        botonesInicio(false, false, true, false, false, false, false);

        llenarFritos();
        mostrarDatos("");
    }

    //<editor-fold desc="CARGAR FECHA" defaultstate="collapsed">    
    void cargarFecha() {
        Date d = new Date();
        LblFecha.setText(d.getDate() + "/" + (d.getMonth() + 1) + "/" + (d.getYear() + 1900));//                         
    }
    //</editor-fold>

    //<editor-fold desc="CARGAR COMBOS" defaultstate="collapsed">    
    void cargarCombos() {
        CargarCAD oCargarCAD = new CargarCAD();
        Bandera B = new Bandera("Productos", "IdProducto");
        String P = oCargarCAD.cargarIds(B);
        LblNumFactura.setText(P);

        //Combo Sucursal
        List ListaComboS = oCargarCAD.CargarSucursal();
        CbxSucursal.removeAllItems();
        for (int i = 0; i < ListaComboS.size(); i++) {
            Sucursales Sc = (Sucursales) ListaComboS.get(i);
            CbxSucursal.addItem(Sc.getNombre());
        }
//                         
    }
    //</editor-fold>

    //<editor-fold desc="BOTONES INICIO" defaultstate="collapsed">
    void botonesInicio(boolean Ok, boolean datos, boolean nuevo, boolean Agregar, boolean modificar, boolean eliminar, boolean cancelar) {
        CbxSucursal.setSelectedIndex(0);
        CbxSucursal.requestFocus();
        LblOk.setVisible(Ok);
        /////
        LblNumFactura.setEnabled(datos);
        CbxSucursal.setEnabled(datos);
//        TabPrincipal.setEnabled(datos);
        ///
        TxtPapaSale.setEnabled(datos);
        TxtPapaDevuelve.setEnabled(datos);
        TxtBaseMonedas.setEnabled(datos);
        TxtBaseBilletes.setEnabled(datos);
        ///
        TxtTotalNeto.setEnabled(datos);
        TxtTotalBruto.setEnabled(datos);
        TxtNetoExistente.setEnabled(datos);
        TxtAlcancia.setEnabled(datos);
        Lbl_Resta.setEnabled(datos);

        /////
        BtnNuevo.setVisible(nuevo);
        /////
        BtnAgregar.setVisible(Agregar);
        BtnModificar.setVisible(modificar);
        BtnEliminar.setVisible(eliminar);
        BtnCancelar.setVisible(cancelar);
    }
    
    void gastosInicio() {
        TxtDescripcionGasto.setText("");
        TxtValorGasto.setText("");
    }
    //</editor-fold>

    //<editor-fold desc="HABILITAR CAMPOS" defaultstate="collapsed">
    void habilitarCampos(int sucursal, boolean datos, boolean nuevo, boolean Agregar, boolean modificar, boolean eliminar, boolean cancelar) {
        CbxSucursal.setSelectedIndex(sucursal);
        CbxSucursal.requestFocus();
        /////
        LblNumFactura.setEnabled(datos);
        CbxSucursal.setEnabled(datos);
        TabPrincipal.setEnabled(datos);
        ///
        TxtPapaSale.setEnabled(datos);
        TxtPapaDevuelve.setEnabled(datos);
        TxtBaseMonedas.setEnabled(datos);
        TxtBaseBilletes.setEnabled(datos);
        ///
        TxtTotalNeto.setEnabled(datos);
        TxtTotalBruto.setEnabled(datos);
        TxtNetoExistente.setEnabled(datos);
        TxtAlcancia.setEnabled(datos);
        Lbl_Resta.setEnabled(datos);

        /////
        BtnNuevo.setVisible(nuevo);
        /////
        BtnAgregar.setVisible(Agregar);
        BtnModificar.setVisible(modificar);
        BtnEliminar.setVisible(eliminar);
        BtnCancelar.setVisible(cancelar);

        buscarNo();
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
        TblCierreSucursales.setModel(ModelTable.getTablaProductos(Valor));
        TableColumnModel columnModel = TblCierreSucursales.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(100);
//            ocultarFilas(0);
        }

    }
    //</editor-fold>

    //<editor-fold desc="LLENAR FRITOS" defaultstate="collapsed">    
    private void llenarFritos() {
        int index = 0, y = 0;
        
        CargarCAD oCargarCAD = new CargarCAD();        
        List ListaPlatos = oCargarCAD.CargarPlatos();
        
        while (index < ListaPlatos.size()) {
            componenteFritos jpc = new componenteFritos(index);
            Platos oPlatoDetalle = (Platos) ListaPlatos.get(index);

            jpc.LblCodigo.setText(oPlatoDetalle.getCodigoPlato());
            jpc.lblNombre.setText(oPlatoDetalle.getNombre() + "");
            jpc.lblValor.setText("" + oPlatoDetalle.getValor());
            jpc.txtValorUnitario.setText("" + oPlatoDetalle.getValor());
            jpc.LblSeccion.setText(oPlatoDetalle.getSeccion());
            // damos valores a X,Y,Ancho,Alto
            jpc.setBounds(0, y, 265, 35);

            jPanel5.add(jpc);//se añade al jpanel
            jPanel5.updateUI();// Se actualiza el panel para refrescar los elementos
            //se añade al MAP
            this.fritos.put("plato" + index, jpc);
            index++;
            y = y + 35;
        }
    }
    //</editor-fold>

    //<editor-fold desc="lIMPIAR CAMPOS" defaultstate="collapsed">
    public void limpiarCampos() {
        LblOk.setVisible(false);
        ////
        //Tab Principal
        //-- JP_Gastos
        TxtDescripcionGasto.setText("");
        TxtValorGasto.setText("");
        Lbl_ItemGastos.setText("");
        Lbl_ValorGastos.setText("");

        //-- JP_Platos Vendidos
        componenteFritos oJP_Fritos = new componenteFritos(0);
        oJP_Fritos.txtCantidad.setText("");
        Lbl_ItemFritos.setText("");
        Lbl_ValorFritos.setText("");

        ///    
        TxtPapaSale.setText("");
        TxtPapaDevuelve.setText("");
        //-
        TxtBaseMonedas.setText("");
        TxtBaseBilletes.setText("");
        //-
        TxtTotalNeto.setText("");
        TxtTotalBruto.setText("");
        TxtNetoExistente.setText("");
        TxtAlcancia.setText("");
        Lbl_Resta.setText("");

//        cargarId();
    }

    //</editor-fold>
    
    //<editor-fold desc="LLENAR GASTOS" defaultstate="collapsed">
    void llenarGasto(Gastos G) {
        G.setIdFactura(Integer.parseInt(LblNumFactura.getText()));
        G.setDescripcion(TxtDescripcionGasto.getText());
        if (TxtValorGasto.getText() == null || TxtValorGasto.getText().equalsIgnoreCase("")) {
            double c = 0;
            G.setValor(c);
        } else {
            G.setValor(Double.parseDouble(TxtValorGasto.getText()));
        }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        LblNumFactura = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LblFecha = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        CbxSucursal = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        TabPrincipal = new javax.swing.JTabbedPane();
        JP_Gastos = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        TxtDescripcionGasto = new javax.swing.JTextField();
        TxtValorGasto = new javax.swing.JTextField();
        BtnAgregarGasto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblGastos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        Lbl_ItemGastos = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Lbl_ValorGastos = new javax.swing.JLabel();
        JP_Platos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        Lbl_ItemFritos = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Lbl_ValorFritos = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        TxtPapaDevuelve = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtPapaSale = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        TxtBaseBilletes = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        TxtBaseMonedas = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        TxtTotalBruto = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        TxtTotalNeto = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        TxtNetoExistente = new javax.swing.JTextField();
        TxtAlcancia = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Lbl_Resta = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        LblBuscar = new javax.swing.JLabel();
        TxtBuscar = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        TblCierreSucursales = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        BtnNuevo = new javax.swing.JButton();
        BtnAgregar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        LblOk = new javax.swing.JLabel();

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Titles/CierreSucursales.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel2.setText("N° Factura :");

        LblNumFactura.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        LblNumFactura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblNumFactura.setText("00001");

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Fecha :");

        LblFecha.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        LblFecha.setForeground(new java.awt.Color(255, 0, 0));
        LblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        CbxSucursal.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        CbxSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CbxSucursal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CbxSucursalItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel6.setText("Negocio/Sucursal :");

        TabPrincipal.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N

        JP_Gastos.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TxtDescripcionGasto.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtDescripcionGasto.setForeground(new java.awt.Color(255, 0, 0));
        TxtDescripcionGasto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtDescripcionGasto.setToolTipText("Descripción");

        TxtValorGasto.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtValorGasto.setForeground(new java.awt.Color(255, 0, 0));
        TxtValorGasto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtValorGasto.setToolTipText("Valor");
        TxtValorGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtValorGastoActionPerformed(evt);
            }
        });
        TxtValorGasto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtValorGastoKeyTyped(evt);
            }
        });

        BtnAgregarGasto.setBackground(new java.awt.Color(255, 153, 0));
        BtnAgregarGasto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Agregar.png"))); // NOI18N
        BtnAgregarGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarGastoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TxtDescripcionGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtValorGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnAgregarGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtDescripcionGasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(BtnAgregarGasto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(TxtValorGasto, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TblGastos.setBackground(new java.awt.Color(255, 255, 255));
        TblGastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripcón", "Valor"
            }
        ));
        TblGastos.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jScrollPane1.setViewportView(TblGastos);

        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel8.setText("Cant Items :");

        Lbl_ItemGastos.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        Lbl_ItemGastos.setForeground(new java.awt.Color(255, 0, 0));
        Lbl_ItemGastos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel10.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel10.setText("Valor Total :");

        Lbl_ValorGastos.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        Lbl_ValorGastos.setForeground(new java.awt.Color(255, 0, 0));
        Lbl_ValorGastos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout JP_GastosLayout = new javax.swing.GroupLayout(JP_Gastos);
        JP_Gastos.setLayout(JP_GastosLayout);
        JP_GastosLayout.setHorizontalGroup(
            JP_GastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_GastosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_GastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(JP_GastosLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Lbl_ItemGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Lbl_ValorGastos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JP_GastosLayout.setVerticalGroup(
            JP_GastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_GastosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_GastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lbl_ItemGastos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lbl_ValorGastos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabPrincipal.addTab("Gastos", JP_Gastos);

        JP_Platos.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane3.setToolTipText("");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel5);

        jLabel13.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel13.setText("Cant Items :");

        Lbl_ItemFritos.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        Lbl_ItemFritos.setForeground(new java.awt.Color(255, 0, 0));
        Lbl_ItemFritos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel15.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel15.setText("Valor Total :");

        Lbl_ValorFritos.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        Lbl_ValorFritos.setForeground(new java.awt.Color(255, 0, 0));
        Lbl_ValorFritos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_ValorFritos.setText("0.00");
        Lbl_ValorFritos.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                Lbl_ValorFritosInputMethodTextChanged(evt);
            }
        });

        javax.swing.GroupLayout JP_PlatosLayout = new javax.swing.GroupLayout(JP_Platos);
        JP_Platos.setLayout(JP_PlatosLayout);
        JP_PlatosLayout.setHorizontalGroup(
            JP_PlatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_PlatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_PlatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(JP_PlatosLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Lbl_ItemFritos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Lbl_ValorFritos, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JP_PlatosLayout.setVerticalGroup(
            JP_PlatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_PlatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_PlatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lbl_ItemFritos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lbl_ValorFritos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        TabPrincipal.addTab("Platos Vendidos", JP_Platos);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PAPA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Agency FB", 1, 14))); // NOI18N

        TxtPapaDevuelve.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtPapaDevuelve.setForeground(new java.awt.Color(255, 0, 0));
        TxtPapaDevuelve.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel16.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Devuelve :");

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Sale :");

        TxtPapaSale.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtPapaSale.setForeground(new java.awt.Color(255, 0, 0));
        TxtPapaSale.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16))
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtPapaDevuelve)
                    .addComponent(TxtPapaSale, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TxtPapaSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(TxtPapaDevuelve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BASE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Agency FB", 1, 14))); // NOI18N

        TxtBaseBilletes.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtBaseBilletes.setForeground(new java.awt.Color(255, 0, 0));
        TxtBaseBilletes.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel17.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Billetes :");

        jLabel18.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Monedas :");

        TxtBaseMonedas.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtBaseMonedas.setForeground(new java.awt.Color(255, 0, 0));
        TxtBaseMonedas.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtBaseMonedas, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(TxtBaseBilletes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(TxtBaseMonedas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(TxtBaseBilletes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Total Bruto :");

        TxtTotalBruto.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtTotalBruto.setForeground(new java.awt.Color(255, 0, 0));
        TxtTotalBruto.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel19.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Total Neto :");

        TxtTotalNeto.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtTotalNeto.setForeground(new java.awt.Color(255, 0, 0));
        TxtTotalNeto.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel20.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Neto Existente :");

        TxtNetoExistente.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtNetoExistente.setForeground(new java.awt.Color(255, 0, 0));
        TxtNetoExistente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        TxtAlcancia.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        TxtAlcancia.setForeground(new java.awt.Color(255, 0, 0));
        TxtAlcancia.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel23.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Alcancia :");

        jLabel21.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Resta :");

        Lbl_Resta.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        Lbl_Resta.setForeground(new java.awt.Color(255, 0, 0));
        Lbl_Resta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Resta.setText("000000");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Lbl_Resta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator5)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TxtTotalNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtNetoExistente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(TxtAlcancia, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(TxtTotalBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(TxtTotalNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(TxtTotalBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(TxtNetoExistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(TxtAlcancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lbl_Resta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21))
                .addContainerGap())
        );

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

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

        TblCierreSucursales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TblCierreSucursales.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TblCierreSucursales.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jScrollPane4.setViewportView(TblCierreSucursales);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        BtnNuevo.setBackground(new java.awt.Color(255, 153, 0));
        BtnNuevo.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        BtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nuevo.png"))); // NOI18N
        BtnNuevo.setToolTipText("Nuevo");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
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
        BtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Modificar.png"))); // NOI18N
        BtnModificar.setToolTipText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnEliminar.setBackground(new java.awt.Color(255, 153, 0));
        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Eliminar.png"))); // NOI18N
        BtnEliminar.setToolTipText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnCancelar.setBackground(new java.awt.Color(255, 153, 0));
        BtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Cancelar.png"))); // NOI18N
        BtnCancelar.setToolTipText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        LblOk.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        LblOk.setForeground(new java.awt.Color(0, 153, 51));
        LblOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Titles/Ok.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TabPrincipal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LblNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CbxSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LblOk)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LblBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LblNumFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(LblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CbxSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TabPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LblOk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        TabPrincipal.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        vPrincipal.ventana = "";
    }//GEN-LAST:event_formInternalFrameClosing

    private void TxtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyPressed
        if (evt.getKeyCode() == 10) {
            LblOk.setVisible(false);
            mostrarDatos(TxtBuscar.getText());
        }
    }//GEN-LAST:event_TxtBuscarKeyPressed

    private void TxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyReleased
        LblOk.setVisible(false);
        mostrarDatos(TxtBuscar.getText());
    }//GEN-LAST:event_TxtBuscarKeyReleased

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        //<editor-fold desc="NUEVO" defaultstate="collapsed">
        limpiarCampos();
        mostrarDatos("");
        cargarFecha();
        botonesInicio(false, true, false, true, false, false, true);
        buscarNo();
        //</editor-fold>
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        //<editor-fold desc="GUARDAR" defaultstate="collapsed">
        // Btn Guardar
        Map rsp = new HashMap();
        Proveedores P = new Proveedores();
        llenarProveedor(P);

        rsp.put("Proveedor", P);

        Validaciones V = new Validaciones();
        V.validarCamposProveedores(rsp);

        if (rsp.containsKey("Mensaje")) {
            JOptionPane.showMessageDialog(null, rsp.get("Mensaje"));
            //            rsp.get("campo");
            //            String Focus = (String)rsp.get("campo");
            //            System.out.println(""+Focus);
        } else {

            boolean guardar = ProveedoresCAD.guardar(P);

            if (!guardar) {
                limpiarCampos();
                JOptionPane.showMessageDialog(null, Bandera.getRespuesta());
                TxtNit.requestFocus();
            } else {
                limpiarCampos();
                LblOk.setText(Bandera.getRespuesta());
                mostrarDatos("");
                botonesInicio(true, false, true, false, false, false, false);
                buscarSi();
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        //<editor-fold desc="MODIFICAR" defaultstate="collapsed">
        // Btn Modificar
        Map rsp = new HashMap();
        Proveedores P = new Proveedores();
        llenarProveedor(P);

        rsp.put("Proveedor", P);

        Validaciones V = new Validaciones();
        V.validarCamposProveedores(rsp);

        if (rsp.containsKey("Mensaje")) {
            JOptionPane.showMessageDialog(null, rsp.get("Mensaje"));
            //            rsp.get("campo");
            //            String Focus = (String)rsp.get("campo");
            //            System.out.println(""+Focus);
        } else {

            boolean Modificar = ProveedoresCAD.modificar(P);

            if (!Modificar) {
                JOptionPane.showMessageDialog(null, Bandera.getRespuesta());
                limpiarCampos();
                mostrarDatos("");
                botonesInicio(false, false, true, false, false, false, false);
            } else {
                limpiarCampos();
                botonesInicio(false, false, true, false, false, false, false);
                mostrarDatos(P.getNombre());
                LblOk.setText(Bandera.getRespuesta());
                LblOk.setVisible(true);
                buscarSi();
                Bandera.setRespuesta("");
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        //<editor-fold desc="ELIMINAR" defaultstate="collapsed">
        if (Lbl_IdProveedor.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No se puede Eliminar el Proveedor\nNo se encuentra el Codigo\nVerifique que tenga conexion con la BD");
        } else {
            // Btn Eliminar
            String Codigo = Lbl_IdProveedor.getText();

            Proveedores Pr = new Proveedores();
            Pr.setCodigo(Codigo);

            boolean Eliminar = ProveedoresCAD.eliminar(Pr);

            if (!Eliminar) {
                JOptionPane.showMessageDialog(null, Bandera.getRespuesta());
                limpiarCampos();
                mostrarDatos("");
                botonesInicio(false, false, true, false, false, false, false);
            } else {
                limpiarCampos();
                botonesInicio(false, false, true, false, false, false, false);
                mostrarDatos("");
                LblOk.setText(Bandera.getRespuesta());
                LblOk.setVisible(true);
                buscarSi();
                Bandera.setRespuesta("");
            }
        }
        //</editor-fold>
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        //<editor-fold desc="CANCELAR" defaultstate="collapsed">
        mostrarDatos("");
        limpiarCampos();
        buscarSi();
        botonesInicio(false, false, true, false, false, false, false);
        //</editor-fold>
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void CbxSucursalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CbxSucursalItemStateChanged
        if (CbxSucursal.getSelectedIndex() > 0) {
            limpiarCampos();
        }
    }//GEN-LAST:event_CbxSucursalItemStateChanged

    private void BtnAgregarGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarGastoActionPerformed
        //<editor-fold desc="AGREGAR" defaultstate="collapsed">
        int g = 0;
        Map rsp = new HashMap();
        Gastos G = new Gastos();
        llenarGasto(G);

        rsp.put("Gasto", G);

        Validaciones V = new Validaciones();
        V.validarCamposGastos(rsp);

        if (rsp.containsKey("Mensaje")) {
            JOptionPane.showMessageDialog(null, rsp.get("Mensaje"));
            //            rsp.get("campo");
            //            String Focus = (String)rsp.get("campo");
            //            System.out.println(""+Focus);
        } else {

            DefaultTableModel modelo = (DefaultTableModel) TblGastos.getModel();

            Object[] fila = new Object[2];
            fila[0] = TxtDescripcionGasto.getText();
            fila[1] = TxtValorGasto.getText();

            int Seleccion = TblGastos.getSelectedRow();

            if (mapGastos.containsKey(fila[0]) && Seleccion < 0) {
                JOptionPane.showMessageDialog(null, "El Gasto: " + fila[0] + " ya existe en la tabla.");
                gastosInicio();
                return;
            } else if ("".equals(fila[0])) {
                JOptionPane.showMessageDialog(null, "El Gasto necesita una descripcion.");
                gastosInicio();
                return;
            } else if (mapGastos.containsKey(fila[0]) && Seleccion >= 0) {
                String W = TblGastos.getValueAt(Seleccion, 0).toString();
                if (W.equals(fila[0])) {
                    modelo.removeRow(Seleccion);
                    JOptionPane.showMessageDialog(null, "Se ha modificado el Gasto");
                    mapGastos.put(fila[0], fila[0]);
                    gastosInicio();
                } else {
                    JOptionPane.showMessageDialog(null, "El Gasto: " + fila[0] + " ya existe en la tabla.");
                    gastosInicio();
                    return;
                }
            } ////
            else {
                mapGastos.put(fila[0], fila[0]);
            }

            modelo.addRow(fila);
            TblGastos.setModel(modelo);
            g = 1;

        }
        if (g == 1) {
            LblOk.setText("Se agrego el Gasto");
            LblOk.setVisible(true);
            gastosInicio();
            g = 0;
        } else {
            JOptionPane.showMessageDialog(null, "El Gasto no se puedo agregar");
        }
        gastos();
        //</editor-fold>
    }//GEN-LAST:event_BtnAgregarGastoActionPerformed

    private void TxtValorGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtValorGastoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtValorGastoActionPerformed

    private void TxtValorGastoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtValorGastoKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_TxtValorGastoKeyTyped

    private void Lbl_ValorFritosInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_Lbl_ValorFritosInputMethodTextChanged
        
    }//GEN-LAST:event_Lbl_ValorFritosInputMethodTextChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnAgregarGasto;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JComboBox<String> CbxSucursal;
    private javax.swing.JPanel JP_Gastos;
    private javax.swing.JPanel JP_Platos;
    private javax.swing.JLabel LblBuscar;
    private javax.swing.JLabel LblFecha;
    private javax.swing.JLabel LblNumFactura;
    private javax.swing.JLabel LblOk;
    private javax.swing.JLabel Lbl_ItemFritos;
    private javax.swing.JLabel Lbl_ItemGastos;
    private javax.swing.JLabel Lbl_Resta;
    public javax.swing.JLabel Lbl_ValorFritos;
    private javax.swing.JLabel Lbl_ValorGastos;
    private javax.swing.JTabbedPane TabPrincipal;
    private javax.swing.JTable TblCierreSucursales;
    private javax.swing.JTable TblGastos;
    private javax.swing.JTextField TxtAlcancia;
    private javax.swing.JTextField TxtBaseBilletes;
    private javax.swing.JTextField TxtBaseMonedas;
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.JTextField TxtDescripcionGasto;
    private javax.swing.JTextField TxtNetoExistente;
    private javax.swing.JTextField TxtPapaDevuelve;
    private javax.swing.JTextField TxtPapaSale;
    private javax.swing.JTextField TxtTotalBruto;
    private javax.swing.JTextField TxtTotalNeto;
    private javax.swing.JTextField TxtValorGasto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables

    
    void gastos(){
        double totalGastos = 0;
        int Items = 0 ;
        
        int filas = TblGastos.getRowCount();
        for (int i = 0; i < filas; i++) {
            Items = filas;
            totalGastos = totalGastos + Integer.parseInt(TblGastos.getValueAt(i, 1).toString());
        }        
        Lbl_ItemGastos.setText(""+Items);                
        Lbl_ValorGastos.setText(""+totalGastos);
    }
    
    void platosVendidos(){
        
        //se recorre el MAP
        int CantPlatosVendidos = 0;
        Iterator it = this.fritos.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            //se recupera el componente
            componenteFritos oComponenteFritos = ((componenteFritos) entry.getValue());
            //mostramos resultado
            CantPlatosVendidos = CantPlatosVendidos + (Integer.parseInt(oComponenteFritos.txtCantidad.getText()));
//            JOptionPane.showMessageDialog(null, "Producto: "+oComponenteFritos.lblNombre.getText()+"\n"+
//                    "Cantidad: "+oComponenteFritos.txtCantidad.getText()+"\n"+
//                    "Valor Total: "+oComponenteFritos.lblValor.getText());
        }
        
        this.Lbl_ItemFritos.setText(""+CantPlatosVendidos);        
    }
}
