/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ventanas;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Kevin
 */
public class Ventana_Garantias extends javax.swing.JInternalFrame {

    public JButton getBtnInsertarInfo() {
        return btnInsertarInfo;
    }

    public void setBtnInsertarInfo(JButton btnInsertarInfo) {
        this.btnInsertarInfo = btnInsertarInfo;
    }

    public JDialog getDlgInformacion() {
        return dlgInformacion;
    }

    public void setDlgInformacion(JDialog dlgInformacion) {
        this.dlgInformacion = dlgInformacion;
    }

    public JLabel getLblCodigo() {
        return lblCodigo;
    }

    public void setLblCodigo(JLabel lblCodigo) {
        this.lblCodigo = lblCodigo;
    }

    public JLabel getLblNCodigo() {
        return lblNCodigo;
    }

    public void setLblNCodigo(JLabel lblNCodigo) {
        this.lblNCodigo = lblNCodigo;
    }

    public JTextArea getTxtDetalle() {
        return txtDetalle;
    }

    public void setTxtDetalle(JTextArea txtDetalle) {
        this.txtDetalle = txtDetalle;
    }

    public JTextArea getTxtProblema() {
        return txtProblema;
    }

    public void setTxtProblema(JTextArea txtProblema) {
        this.txtProblema = txtProblema;
    }

    public JTextField getTxtProducto1() {
        return txtProducto1;
    }

    public void setTxtProducto1(JTextField txtProducto1) {
        this.txtProducto1 = txtProducto1;
    }

    /**
     * Creates new form Ventana_Reparaciones
     */
    public Ventana_Garantias() {
        initComponents();
    }

    public JDateChooser getDtcFecha() {
        return DtcFecha;
    }

    public void setDtcFecha(JDateChooser DtcFecha) {
        this.DtcFecha = DtcFecha;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JButton getBtnAnadirP() {
        return btnAnadirP;
    }

    public void setBtnAnadirP(JButton btnAnadirP) {
        this.btnAnadirP = btnAnadirP;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }


    public JButton getBtnEliminarG() {
        return btnEliminarG;
    }

    public void setBtnEliminarG(JButton btnEliminarG) {
        this.btnEliminarG = btnEliminarG;
    }

    public JButton getBtnElminarP() {
        return btnElminarP;
    }

    public void setBtnElminarP(JButton btnElminarP) {
        this.btnElminarP = btnElminarP;
    }

    public JTextField getTxtNGarant() {
        return txtNGarant;
    }

    public void setTxtNGarant(JTextField txtNGarant) {
        this.txtNGarant = txtNGarant;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JButton getBtnGuardar1() {
        return btnGuardar1;
    }

    public void setBtnGuardar1(JButton btnGuardar1) {
        this.btnGuardar1 = btnGuardar1;
    }

    public JButton getBtnGuardar3() {
        return btnGuardar3;
    }

    public void setBtnGuardar3(JButton btnGuardar3) {
        this.btnGuardar3 = btnGuardar3;
    }

    public JButton getBtnImprimir() {
        return btnImprimir;
    }

    public void setBtnImprimir(JButton btnImprimir) {
        this.btnImprimir = btnImprimir;
    }

    public JButton getBtnInsertCliente() {
        return btnInsertCliente;
    }

    public void setBtnInsertCliente(JButton btnInsertCliente) {
        this.btnInsertCliente = btnInsertCliente;
    }

   

    public JButton getBtnNuevoG() {
        return btnNuevoG;
    }

    public void setBtnNuevoG(JButton btnNuevoG) {
        this.btnNuevoG = btnNuevoG;
    }

    public JComboBox<String> getCmbEstado() {
        return cmbEstado;
    }

    public void setCmbEstado(JComboBox<String> cmbEstado) {
        this.cmbEstado = cmbEstado;
    }

    public JDialog getDlgGarantia() {
        return dlgGarantia;
    }

    public void setDlgGarantia(JDialog dlgGarantia) {
        this.dlgGarantia = dlgGarantia;
    }

    public JDialog getDlgListaC() {
        return dlgListaC;
    }

    public void setDlgListaC(JDialog dlgListaC) {
        this.dlgListaC = dlgListaC;
    }

    public JDialog getDlgListaP() {
        return dlgListaP;
    }

    public void setDlgListaP(JDialog dlgListaP) {
        this.dlgListaP = dlgListaP;
    }

    public JTable getTblDetalle() {
        return tblDetalle;
    }

    public void setTblDetalle(JTable tblDetalle) {
        this.tblDetalle = tblDetalle;
    }

    public JTable getTblProducto() {
        return tblProducto;
    }

    public void setTblProducto(JTable tblProducto) {
        this.tblProducto = tblProducto;
    }

    public JTable getTblProducto1() {
        return tblProducto1;
    }

    public void setTblProducto1(JTable tblProducto1) {
        this.tblProducto1 = tblProducto1;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JTextField getTxtCliente() {
        return txtCliente;
    }

    public void setTxtCliente(JTextField txtCliente) {
        this.txtCliente = txtCliente;
    }

    public JTextField getTxtDescuento() {
        return txtDescuento;
    }

    public void setTxtDescuento(JTextField txtDescuento) {
        this.txtDescuento = txtDescuento;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(JTextField txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public JTextField getTxtNFact() {
        return txtNGarant;
    }

    public void setTxtNFact(JTextField txtNFact) {
        this.txtNGarant = txtNFact;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtProducto() {
        return txtProducto;
    }

    public void setTxtProducto(JTextField txtProducto) {
        this.txtProducto = txtProducto;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(JTextField txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public JTextField getTxtVendedor() {
        return txtVendedor;
    }

    public void setTxtVendedor(JTextField txtVendedor) {
        this.txtVendedor = txtVendedor;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgGarantia = new javax.swing.JDialog();
        pnlFACTURA = new javax.swing.JPanel();
        pnlOp = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlEncFact = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtNGarant = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        DtcFecha = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        DtcFecha1 = new com.toedter.calendar.JDateChooser();
        pnlDatosCliente = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtVendedor = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        btnGuardar1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        pnlDetFact = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable();
        pnlOpcFact = new javax.swing.JPanel();
        btnAnadirP = new javax.swing.JButton();
        btnElminarP = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();
        dlgListaC = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        btnInsertCliente = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProducto1 = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        dlgListaP = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        btnGuardar3 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        dlgInformacion = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        btnInsertarInfo = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        txtProducto1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtProblema = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();
        lblNCodigo = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        pnlGeneral = new javax.swing.JPanel();
        pnlOpciones = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnNuevoG = new javax.swing.JButton();
        btnEliminarG = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReparacion = new javax.swing.JTable();

        dlgGarantia.setTitle("Garantia");
        dlgGarantia.setResizable(false);
        dlgGarantia.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFACTURA.setOpaque(false);

        pnlOp.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlOp.setOpaque(false);
        pnlOp.setLayout(new java.awt.GridLayout(3, 1));

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8_save_64px.png"))); // NOI18N
        btnGuardar.setText("Generar");
        btnGuardar.setToolTipText("Clic para generar garantia");
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        pnlOp.add(btnGuardar);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8_cancel_64px.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancelar garantia");
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        pnlOp.add(btnCancelar);

        pnlEncFact.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Garant??a", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlEncFact.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Fecha de Emisi??n:");

        txtNGarant.setEditable(false);
        txtNGarant.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtNGarant.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtNGarant.setPreferredSize(new java.awt.Dimension(160, 25));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("N?? Garant??a: ");

        DtcFecha.setPreferredSize(new java.awt.Dimension(160, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/kelv1.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Fecha de Retiro:");

        DtcFecha1.setPreferredSize(new java.awt.Dimension(160, 30));

        javax.swing.GroupLayout pnlEncFactLayout = new javax.swing.GroupLayout(pnlEncFact);
        pnlEncFact.setLayout(pnlEncFactLayout);
        pnlEncFactLayout.setHorizontalGroup(
            pnlEncFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncFactLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlEncFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14))
                .addGap(30, 30, 30)
                .addGroup(pnlEncFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNGarant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DtcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DtcFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );
        pnlEncFactLayout.setVerticalGroup(
            pnlEncFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncFactLayout.createSequentialGroup()
                .addGroup(pnlEncFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(pnlEncFactLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnlEncFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNGarant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEncFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlEncFactLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel14))
                            .addGroup(pnlEncFactLayout.createSequentialGroup()
                                .addComponent(DtcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DtcFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDatosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlDatosCliente.setOpaque(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Direcci??n:");

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtNombre.setPreferredSize(new java.awt.Dimension(160, 25));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Cliente:");

        txtDireccion.setEditable(false);
        txtDireccion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtDireccion.setPreferredSize(new java.awt.Dimension(160, 25));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("C??dula:");

        txtCedula.setEditable(false);
        txtCedula.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtCedula.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtCedula.setPreferredSize(new java.awt.Dimension(160, 25));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Tel??fono:");

        txtTelefono.setEditable(false);
        txtTelefono.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtTelefono.setPreferredSize(new java.awt.Dimension(160, 25));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Vendedor:");

        txtVendedor.setEditable(false);
        txtVendedor.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtVendedor.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtVendedor.setPreferredSize(new java.awt.Dimension(160, 25));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Descuento:");

        txtDescuento.setEditable(false);
        txtDescuento.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtDescuento.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtDescuento.setPreferredSize(new java.awt.Dimension(160, 25));

        btnGuardar1.setBackground(new java.awt.Color(71, 75, 78));
        btnGuardar1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnGuardar1.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8_customer_96px_1.png"))); // NOI18N
        btnGuardar1.setToolTipText("Coloque el cliente");
        btnGuardar1.setBorderPainted(false);
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Estado");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "REALIZADO", "EN PROCESO" }));

        javax.swing.GroupLayout pnlDatosClienteLayout = new javax.swing.GroupLayout(pnlDatosCliente);
        pnlDatosCliente.setLayout(pnlDatosClienteLayout);
        pnlDatosClienteLayout.setHorizontalGroup(
            pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel19))
                    .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );
        pnlDatosClienteLayout.setVerticalGroup(
            pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addComponent(btnGuardar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlDetFact.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle Reparacion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlDetFact.setOpaque(false);

        tblDetalle.setBackground(new java.awt.Color(94, 33, 41));
        tblDetalle.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tblDetalle.setForeground(new java.awt.Color(255, 255, 255));
        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "Problema", "Detalle"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDetalle);

        pnlOpcFact.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlOpcFact.setOpaque(false);
        pnlOpcFact.setLayout(new java.awt.GridLayout(3, 1));

        btnAnadirP.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnAnadirP.setForeground(new java.awt.Color(255, 255, 255));
        btnAnadirP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8_add_new_64px.png"))); // NOI18N
        btnAnadirP.setText("A??adir");
        btnAnadirP.setToolTipText("A??adir Producto");
        btnAnadirP.setBorderPainted(false);
        btnAnadirP.setContentAreaFilled(false);
        pnlOpcFact.add(btnAnadirP);

        btnElminarP.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnElminarP.setForeground(new java.awt.Color(255, 255, 255));
        btnElminarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8_cancel_64px_1.png"))); // NOI18N
        btnElminarP.setText("Eliminar");
        btnElminarP.setToolTipText("Eliminar Producto");
        btnElminarP.setBorderPainted(false);
        btnElminarP.setContentAreaFilled(false);
        pnlOpcFact.add(btnElminarP);

        javax.swing.GroupLayout pnlDetFactLayout = new javax.swing.GroupLayout(pnlDetFact);
        pnlDetFact.setLayout(pnlDetFactLayout);
        pnlDetFactLayout.setHorizontalGroup(
            pnlDetFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetFactLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlOpcFact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDetFactLayout.setVerticalGroup(
            pnlDetFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetFactLayout.createSequentialGroup()
                .addGroup(pnlDetFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlOpcFact, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDetFactLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlFACTURALayout = new javax.swing.GroupLayout(pnlFACTURA);
        pnlFACTURA.setLayout(pnlFACTURALayout);
        pnlFACTURALayout.setHorizontalGroup(
            pnlFACTURALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFACTURALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFACTURALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDetFact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFACTURALayout.createSequentialGroup()
                        .addGroup(pnlFACTURALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlEncFact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlDatosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlOp, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 4, Short.MAX_VALUE))
        );
        pnlFACTURALayout.setVerticalGroup(
            pnlFACTURALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFACTURALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFACTURALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlFACTURALayout.createSequentialGroup()
                        .addComponent(pnlEncFact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlOp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDetFact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dlgGarantia.getContentPane().add(pnlFACTURA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 680));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/068107f58d5f340ef44be46c4e8e0dfd.jpg"))); // NOI18N
        dlgGarantia.getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 680));

        dlgListaC.setTitle("Lista Clientes");
        dlgListaC.setResizable(false);
        dlgListaC.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setOpaque(false);

        btnInsertCliente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnInsertCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8_add_64px.png"))); // NOI18N
        btnInsertCliente.setText("Insertar");
        btnInsertCliente.setToolTipText("Insertar Cliente");
        btnInsertCliente.setBorderPainted(false);
        btnInsertCliente.setContentAreaFilled(false);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Cliente:");

        txtCliente.setPreferredSize(new java.awt.Dimension(160, 25));

        tblProducto1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Direcci??n", "Cedula", "Tel??fono", "Descuento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblProducto1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInsertCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnInsertCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
        );

        dlgListaC.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 680, 250));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/068107f58d5f340ef44be46c4e8e0dfd.jpg"))); // NOI18N
        dlgListaC.getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 280));

        dlgListaP.setTitle("Lista Productos");
        dlgListaP.setResizable(false);
        dlgListaP.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setOpaque(false);

        btnGuardar3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnGuardar3.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8_add_64px.png"))); // NOI18N
        btnGuardar3.setText("Elegir");
        btnGuardar3.setBorderPainted(false);
        btnGuardar3.setContentAreaFilled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Producto:");

        txtProducto.setPreferredSize(new java.awt.Dimension(160, 25));

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblProducto);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(txtProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardar3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnGuardar3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
        );

        dlgListaP.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 680, 250));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/068107f58d5f340ef44be46c4e8e0dfd.jpg"))); // NOI18N
        dlgListaP.getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 280));

        dlgInformacion.setTitle("Informacion producto");
        dlgInformacion.setResizable(false);
        dlgInformacion.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel5.setOpaque(false);

        btnInsertarInfo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnInsertarInfo.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertarInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8_add_64px.png"))); // NOI18N
        btnInsertarInfo.setText("Insertar");
        btnInsertarInfo.setBorderPainted(false);
        btnInsertarInfo.setContentAreaFilled(false);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Producto:");

        txtProducto1.setEditable(false);
        txtProducto1.setPreferredSize(new java.awt.Dimension(160, 25));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Problema:");

        txtProblema.setColumns(20);
        txtProblema.setRows(5);
        jScrollPane6.setViewportView(txtProblema);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Detalle:");

        txtDetalle.setColumns(20);
        txtDetalle.setRows(5);
        jScrollPane7.setViewportView(txtDetalle);

        lblNCodigo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblNCodigo.setForeground(new java.awt.Color(255, 255, 255));
        lblNCodigo.setText("C??digo:");

        lblCodigo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblCodigo.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigo.setText("00 ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(18, 18, 18)
                        .addComponent(txtProducto1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel26))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane6)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInsertarInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblNCodigo)
                        .addGap(18, 18, 18)
                        .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnInsertarInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel26))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNCodigo)
                                    .addComponent(lblCodigo))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        dlgInformacion.getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 680, 250));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/068107f58d5f340ef44be46c4e8e0dfd.jpg"))); // NOI18N
        dlgInformacion.getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 280));

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mant. Garantias");

        pnlGeneral.setBackground(new java.awt.Color(102, 102, 102));

        pnlOpciones.setBackground(new java.awt.Color(152, 48, 48));
        pnlOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlOpciones.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar:");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnNuevoG.setBackground(new java.awt.Color(94, 33, 41));
        btnNuevoG.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnNuevoG.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8_new_16px.png"))); // NOI18N
        btnNuevoG.setText("Nueva Garant??a");

        btnEliminarG.setBackground(new java.awt.Color(94, 33, 41));
        btnEliminarG.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnEliminarG.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8_delete_16px.png"))); // NOI18N
        btnEliminarG.setText("Eliminar Garant??a");

        btnImprimir.setBackground(new java.awt.Color(94, 33, 41));
        btnImprimir.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8_print_48px.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setBorder(null);

        btnActualizar.setBackground(new java.awt.Color(94, 33, 41));
        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8_update_16px.png"))); // NOI18N
        btnActualizar.setText("    Actualizar");
        btnActualizar.setBorderPainted(false);

        javax.swing.GroupLayout pnlOpcionesLayout = new javax.swing.GroupLayout(pnlOpciones);
        pnlOpciones.setLayout(pnlOpcionesLayout);
        pnlOpcionesLayout.setHorizontalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevoG)
                    .addGroup(pnlOpcionesLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78)
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(btnActualizar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevoG)
                            .addComponent(btnEliminarG)))
                    .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Garantias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("N??mero de filas:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("0");

        tblReparacion.setBackground(new java.awt.Color(94, 33, 41));
        tblReparacion.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tblReparacion.setForeground(new java.awt.Color(255, 255, 255));
        tblReparacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N?? GARANTIA", "CLIENTE", "ADMIN", "FECHA EMISION", "FECHA RETIRO", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblReparacion);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    /**
     * @param args the command line arguments
     */

    public JDateChooser getDtcFecha1() {
        return DtcFecha1;
    }

    public void setDtcFecha1(JDateChooser DtcFecha1) {
        this.DtcFecha1 = DtcFecha1;
    }

    public JTable getTblReparacion() {
        return tblReparacion;
    }

    /**
     * @param args the command line arguments
     */
    public void setTblReparacion(JTable tblReparacion) {
        this.tblReparacion = tblReparacion;
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DtcFecha;
    private com.toedter.calendar.JDateChooser DtcFecha1;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAnadirP;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarG;
    private javax.swing.JButton btnElminarP;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnGuardar3;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnInsertCliente;
    private javax.swing.JButton btnInsertarInfo;
    private javax.swing.JButton btnNuevoG;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JDialog dlgGarantia;
    private javax.swing.JDialog dlgInformacion;
    private javax.swing.JDialog dlgListaC;
    private javax.swing.JDialog dlgListaP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblNCodigo;
    private javax.swing.JPanel pnlDatosCliente;
    private javax.swing.JPanel pnlDetFact;
    private javax.swing.JPanel pnlEncFact;
    private javax.swing.JPanel pnlFACTURA;
    private javax.swing.JPanel pnlGeneral;
    private javax.swing.JPanel pnlOp;
    private javax.swing.JPanel pnlOpcFact;
    private javax.swing.JPanel pnlOpciones;
    private javax.swing.JTable tblDetalle;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTable tblProducto1;
    private javax.swing.JTable tblReparacion;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextArea txtDetalle;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNGarant;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtProblema;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtProducto1;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables
}
