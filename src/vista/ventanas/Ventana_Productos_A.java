/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ventanas;

/**
 *
 * @author Kevin
 */
public class Ventana_Productos_A extends javax.swing.JInternalFrame {

    /**
     * Creates new form Ventana_Productos
     */
    public Ventana_Productos_A() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgProductoA = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        cmbFabric = new javax.swing.JComboBox<>();
        lblImagen = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        pnlOp = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        spnCantidad = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtProblema = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescrip = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        pnlGeneral = new javax.swing.JPanel();
        pnlOpciones = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnNuevoP = new javax.swing.JButton();
        btnEditarP = new javax.swing.JButton();
        btnEliminarP = new javax.swing.JButton();
        btnImprimirA = new javax.swing.JButton();
        btnActualizarA = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();

        dlgProductoA.setTitle("Administrador");
        dlgProductoA.setResizable(false);
        dlgProductoA.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fabricante:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nombres:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Modelo:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Descripcion:");

        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtNombre.setPreferredSize(new java.awt.Dimension(160, 25));

        txtModelo.setBorder(null);
        txtModelo.setPreferredSize(new java.awt.Dimension(160, 25));

        cmbFabric.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE" }));

        lblImagen.setBackground(new java.awt.Color(166, 58, 58));
        lblImagen.setOpaque(true);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Foto");

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8_search_64px.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);

        pnlOp.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlOp.setOpaque(false);
        pnlOp.setLayout(new java.awt.GridLayout(1, 3));

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8_save_64px.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        pnlOp.add(btnGuardar);

        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8_edit_file_64px.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setBorderPainted(false);
        btnModificar.setContentAreaFilled(false);
        pnlOp.add(btnModificar);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8_cancel_64px.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        pnlOp.add(btnCancelar);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Cantidad:");

        spnCantidad.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        txtProblema.setColumns(20);
        txtProblema.setRows(5);
        jScrollPane2.setViewportView(txtProblema);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Problema:");

        txtCosto.setBorder(null);
        txtCosto.setPreferredSize(new java.awt.Dimension(160, 25));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Detalle:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Costo:");

        txtDescrip.setColumns(20);
        txtDescrip.setRows(5);
        jScrollPane3.setViewportView(txtDescrip);

        txtDetalle.setColumns(20);
        txtDetalle.setRows(5);
        jScrollPane4.setViewportView(txtDetalle);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(27, 27, 27)
                        .addComponent(cmbFabric, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addGap(147, 147, 147))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3)
                                    .addComponent(jScrollPane4))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(50, 50, 50))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(pnlOp, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbFabric, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel22))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblImagen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(pnlOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        dlgProductoA.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 620));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/068107f58d5f340ef44be46c4e8e0dfd.jpg"))); // NOI18N
        dlgProductoA.getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 630));

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mant. Productos a Reparar");

        pnlGeneral.setBackground(new java.awt.Color(102, 102, 102));

        pnlOpciones.setBackground(new java.awt.Color(152, 48, 48));
        pnlOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlOpciones.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar:");

        btnNuevoP.setBackground(new java.awt.Color(94, 33, 41));
        btnNuevoP.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnNuevoP.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8_new_16px.png"))); // NOI18N
        btnNuevoP.setText("Nuevo Producto");

        btnEditarP.setBackground(new java.awt.Color(94, 33, 41));
        btnEditarP.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnEditarP.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8_edit_16px.png"))); // NOI18N
        btnEditarP.setText("Editar Producto");

        btnEliminarP.setBackground(new java.awt.Color(94, 33, 41));
        btnEliminarP.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnEliminarP.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8_delete_16px.png"))); // NOI18N
        btnEliminarP.setText("Elminar Producto");

        btnImprimirA.setBackground(new java.awt.Color(94, 33, 41));
        btnImprimirA.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnImprimirA.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimirA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8_print_48px.png"))); // NOI18N
        btnImprimirA.setText("Imprimir");
        btnImprimirA.setBorder(null);

        btnActualizarA.setBackground(new java.awt.Color(94, 33, 41));
        btnActualizarA.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnActualizarA.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8_update_16px.png"))); // NOI18N
        btnActualizarA.setText("    Actualizar");
        btnActualizarA.setBorderPainted(false);

        javax.swing.GroupLayout pnlOpcionesLayout = new javax.swing.GroupLayout(pnlOpciones);
        pnlOpciones.setLayout(pnlOpcionesLayout);
        pnlOpcionesLayout.setHorizontalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOpcionesLayout.createSequentialGroup()
                        .addComponent(btnNuevoP)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarP))
                    .addGroup(pnlOpcionesLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminarP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizarA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addComponent(btnImprimirA, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlOpcionesLayout.setVerticalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOpcionesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevoP)
                            .addComponent(btnEditarP)
                            .addComponent(btnEliminarP)))
                    .addComponent(btnImprimirA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Numero de filas:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("0");

        tblProducto.setBackground(new java.awt.Color(94, 33, 41));
        tblProducto.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tblProducto.setForeground(new java.awt.Color(255, 255, 255));
        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "FABRICANTE", "MODELO", "DESCRPCION", "CANTIDAD", "PROBLEMA", "DETALLE", "COSTO", "FOTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProducto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlGeneralLayout = new javax.swing.GroupLayout(pnlGeneral);
        pnlGeneral.setLayout(pnlGeneralLayout);
        pnlGeneralLayout.setHorizontalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlGeneralLayout.setVerticalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarA;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditarP;
    private javax.swing.JButton btnEliminarP;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimirA;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevoP;
    private javax.swing.JComboBox<String> cmbFabric;
    private javax.swing.JDialog dlgProductoA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JPanel pnlGeneral;
    private javax.swing.JPanel pnlOp;
    private javax.swing.JPanel pnlOpciones;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextArea txtDescrip;
    private javax.swing.JTextArea txtDetalle;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtProblema;
    // End of variables declaration//GEN-END:variables
}
