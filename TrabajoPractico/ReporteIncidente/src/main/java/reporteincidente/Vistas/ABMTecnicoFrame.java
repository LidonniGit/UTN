package reporteincidente.Vistas;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import reporteincidente.Entidades.Especialidad;
import reporteincidente.Entidades.Servicio;
import reporteincidente.Entidades.Tecnico;
import reporteinicidente.Repositorio.ClienteJpaController;
import reporteinicidente.Repositorio.EspecialidadJpaController;
import reporteinicidente.Repositorio.ServicioJpaController;
import reporteinicidente.Repositorio.TecnicoJpaController;
import reporteinicidente.Repositorio.exceptions.NonexistentEntityException;

public class ABMTecnicoFrame extends javax.swing.JInternalFrame {

    private boolean clienteEncontrado = false;
    private int idServicio = -1;

    private final DefaultTableModel tabla = new DefaultTableModel() { //Creo un objeto DefaulTableModel para darle un modelo a la tabla
        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    // Método para centrar los encabezados de las columnas
    private void centrarEncabezado(JTable table) {
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
    }

    /**
     * Creates new form ABMTecnicoFrame
     */
    public ABMTecnicoFrame() {
        initComponents();
        armarCabecerata(); //Armo cabecera de la tabla
        limpiar();
        cargarEspecialidad();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jBtnServiciosMenos = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();
        jCboxEspecialidad = new javax.swing.JComboBox<>();
        jTextCodigo = new javax.swing.JTextField();
        jTextNombre = new javax.swing.JTextField();
        jTextApellido = new javax.swing.JTextField();
        jTextEmail = new javax.swing.JTextField();
        jbtnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaEspecialidad = new javax.swing.JTable();
        jBtnEliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jBtnNuevo = new javax.swing.JButton();
        jBtnServiciosMas = new javax.swing.JButton();
        jBtnGuardar = new javax.swing.JButton();
        jBtnModificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextWhatsApp = new javax.swing.JTextField();
        jTextDNI = new javax.swing.JTextField();
        jChecNoty = new javax.swing.JCheckBox();

        setTitle("Tecnicos");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Nombre");

        jBtnServiciosMenos.setText("- Especialidad");
        jBtnServiciosMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnServiciosMenosActionPerformed(evt);
            }
        });

        jBtnSalir.setText("Salir");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });

        jTextCodigo.setEditable(false);

        jbtnBuscar.setText("Buscar");
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });

        jTablaEspecialidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTablaEspecialidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaEspecialidadMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTablaEspecialidadMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTablaEspecialidad);

        jBtnEliminar.setText("Eliminar");
        jBtnEliminar.setEnabled(false);
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Especialidades");

        jBtnNuevo.setText("Nuevo");
        jBtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNuevoActionPerformed(evt);
            }
        });

        jBtnServiciosMas.setText("+ Especialidad");
        jBtnServiciosMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnServiciosMasActionPerformed(evt);
            }
        });

        jBtnGuardar.setText("Guardar");
        jBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarActionPerformed(evt);
            }
        });

        jBtnModificar.setText("Modificar");
        jBtnModificar.setEnabled(false);
        jBtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Email");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Apellido");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Codigo");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("DNI");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("WhatsApp");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextWhatsApp, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jChecNoty)))
                .addGap(195, 195, 195))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jBtnNuevo)
                        .addGap(30, 30, 30)
                        .addComponent(jBtnGuardar)
                        .addGap(30, 30, 30)
                        .addComponent(jBtnEliminar)
                        .addGap(30, 30, 30)
                        .addComponent(jBtnModificar)
                        .addGap(100, 100, 100)
                        .addComponent(jBtnSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtnServiciosMas)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnServiciosMenos))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCboxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBuscar))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChecNoty)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jTextWhatsApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCboxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnServiciosMas)
                    .addComponent(jBtnServiciosMenos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnEliminar)
                    .addComponent(jBtnModificar)
                    .addComponent(jBtnGuardar)
                    .addComponent(jBtnNuevo)
                    .addComponent(jBtnSalir))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnServiciosMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnServiciosMenosActionPerformed
        if ((idServicio != -1) && (jTablaEspecialidad.getRowCount() > 0)) {
            tabla.removeRow(idServicio - 1);
        }

    }//GEN-LAST:event_jBtnServiciosMenosActionPerformed

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        String dni;
        TecnicoJpaController controlTecnico = new TecnicoJpaController();
//        EspecialidadJpaController controlEspecialidad = new EspecialidadJpaController();
        try { //Bloque TRY-CATCH para verificar si el codigo es valido.
            dni = jTextDNI.getText();
            if (!dni.isEmpty()) {
                List<Tecnico> tecnixoAux = new ArrayList<>();
                List<Especialidad> espList = new ArrayList();
                tecnixoAux = controlTecnico.buscarPorDNI(dni);
                if (!tecnixoAux.isEmpty()) {
                    jTextCodigo.setText(tecnixoAux.get(0).getId() + "");
                    jTextApellido.setText(tecnixoAux.get(0).getApellido() + "");
                    jTextEmail.setText(tecnixoAux.get(0).getEmail());
                    jTextWhatsApp.setText(tecnixoAux.get(0).getWhatsapp());
                    jTextNombre.setText(tecnixoAux.get(0).getNombre());
                    jBtnEliminar.setEnabled(true);
                    jBtnModificar.setEnabled(true);
                    jBtnGuardar.setEnabled(false);
                    clienteEncontrado = true;
                    jChecNoty.setSelected(tecnixoAux.get(0).isNoti());
                    espList = tecnixoAux.get(0).getEspecialidad();
                    cargoTabla(espList);
                    jBtnServiciosMas.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese un DNI válido.", "INFORMACIÓN", 1);
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese un DNI válido.", "INFORMACIÓN", 1);
        }
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void jTablaEspecialidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaEspecialidadMouseClicked
        int filaSeleccionada = -1;
        filaSeleccionada = jTablaEspecialidad.getSelectedRow();
        if (filaSeleccionada != -1) { //Se selecciono una fila
            idServicio = (Integer) jTablaEspecialidad.getValueAt(filaSeleccionada, 0);
        }
    }//GEN-LAST:event_jTablaEspecialidadMouseClicked

    private void jTablaEspecialidadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaEspecialidadMousePressed
        int filaSeleccionada = -1;
        filaSeleccionada = jTablaEspecialidad.getSelectedRow();
        if (filaSeleccionada != -1) { //Se selecciono una fila
            idServicio = (Integer) jTablaEspecialidad.getValueAt(filaSeleccionada, 0);
        }
    }//GEN-LAST:event_jTablaEspecialidadMousePressed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed

        int respuesta;
        if (clienteEncontrado) {
            respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Deseas borrar al Tecnico", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                try {
                    TecnicoJpaController controlTecnico = new TecnicoJpaController();
                    controlTecnico.destroy(Integer.parseInt(jTextCodigo.getText()));
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(ABMClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            limpiar();
        } else {
            JOptionPane.showMessageDialog(this, "No hay Tecnico seleccionado");
        }

    }//GEN-LAST:event_jBtnEliminarActionPerformed

    private void jBtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNuevoActionPerformed
        limpiar();
    }//GEN-LAST:event_jBtnNuevoActionPerformed

    private void jBtnServiciosMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnServiciosMasActionPerformed
        DefaultComboBoxModel<Especialidad> model = (DefaultComboBoxModel<Especialidad>) jCboxEspecialidad.getModel();
        Especialidad servT = (Especialidad) jCboxEspecialidad.getSelectedItem();
        tabla.addRow(new Object[]{servT.getId(), servT.getTipo(), servT.getComplejidad()});

    }//GEN-LAST:event_jBtnServiciosMasActionPerformed

    private void jBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarActionPerformed

        TecnicoJpaController controlTecnico = new TecnicoJpaController();
        Tecnico tecnicoNuevo = new Tecnico();
        if ((!jTextDNI.getText().isEmpty()) && (!jTextApellido.getText().isEmpty())) {
            tecnicoNuevo.setApellido(jTextApellido.getText());
            tecnicoNuevo.setDni(jTextDNI.getText());
            tecnicoNuevo.setEmail(jTextEmail.getText());
            tecnicoNuevo.setEstado(true);
            tecnicoNuevo.setNombre(jTextNombre.getText());
            tecnicoNuevo.setWhatsapp(jTextWhatsApp.getText());
            tecnicoNuevo.setNoti(jChecNoty.isSelected());

            List<Especialidad> listaEsp = new ArrayList();

            for (int fila = 0; fila <= jTablaEspecialidad.getRowCount() - 1; fila++) {
                Especialidad Esp = new Especialidad();
                Esp.setId((Integer) jTablaEspecialidad.getValueAt(fila, 0));
                Esp.setTipo((String) jTablaEspecialidad.getValueAt(fila, 1));
                Esp.setComplejidad((Integer) jTablaEspecialidad.getValueAt(fila, 2));
                listaEsp.add(Esp);
            }
            tecnicoNuevo.setEspecialidad(listaEsp);
            controlTecnico.create(tecnicoNuevo);
            limpiar();
        }

    }//GEN-LAST:event_jBtnGuardarActionPerformed

    private void jBtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarActionPerformed

        TecnicoJpaController controlTecnico = new TecnicoJpaController();
        Tecnico tecnicoNuevo = new Tecnico();
        if ((!jTextDNI.getText().isEmpty()) && (!jTextApellido.getText().isEmpty())) {
            tecnicoNuevo.setApellido(jTextApellido.getText());
            tecnicoNuevo.setDni(jTextDNI.getText());
            tecnicoNuevo.setEmail(jTextEmail.getText());
            tecnicoNuevo.setEstado(true);
            tecnicoNuevo.setNombre(jTextNombre.getText());
            tecnicoNuevo.setWhatsapp(jTextWhatsApp.getText());
            tecnicoNuevo.setNoti(jChecNoty.isSelected());

            List<Especialidad> listaEsp = new ArrayList();

            for (int fila = 0; fila <= jTablaEspecialidad.getRowCount() - 1; fila++) {
                Especialidad Esp = new Especialidad();
                Esp.setId((Integer) jTablaEspecialidad.getValueAt(fila, 0));
                Esp.setTipo((String) jTablaEspecialidad.getValueAt(fila, 1));
                Esp.setComplejidad((Integer) jTablaEspecialidad.getValueAt(fila, 2));
                listaEsp.add(Esp);
            }
            tecnicoNuevo.setEspecialidad(listaEsp);
            tecnicoNuevo.setId(Integer.parseInt(jTextCodigo.getText()));
            try {
                controlTecnico.edit(tecnicoNuevo);
            } catch (Exception ex) {
                Logger.getLogger(ABMTecnicoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            limpiar();
        }


    }//GEN-LAST:event_jBtnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnGuardar;
    private javax.swing.JButton jBtnModificar;
    private javax.swing.JButton jBtnNuevo;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JButton jBtnServiciosMas;
    private javax.swing.JButton jBtnServiciosMenos;
    private javax.swing.JComboBox<Especialidad> jCboxEspecialidad;
    private javax.swing.JCheckBox jChecNoty;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaEspecialidad;
    private javax.swing.JTextField jTextApellido;
    private javax.swing.JTextField jTextCodigo;
    private javax.swing.JTextField jTextDNI;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextWhatsApp;
    private javax.swing.JButton jbtnBuscar;
    // End of variables declaration//GEN-END:variables

    private void borrarFilas() {
        int filas = jTablaEspecialidad.getRowCount() - 1;
        for (int f = filas; f >= 0; f--) {
            tabla.removeRow(f);

        }
    }

    private void armarCabecerata() {
        tabla.addColumn("ID"); //Creo columna
        tabla.addColumn("Tipo"); //Creo columna
        tabla.addColumn("Complejidad"); //Creo columna
        jTablaEspecialidad.setModel(tabla); //CARGO LAS COLUMNAS A LA TABLA
        centrarEncabezado(jTablaEspecialidad); //Centro los encabezados
        TableColumnModel columnModel = jTablaEspecialidad.getColumnModel();//Determino el ancho de cada columna
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(170);

    }

    private void limpiar() {
        jTextCodigo.setText("");
        jTextNombre.setText("");
        jTextApellido.setText("");
        jTextDNI.setText("");
        jTextEmail.setText("");
        jTextWhatsApp.setText("");
        jChecNoty.setSelected(false);
        jBtnEliminar.setEnabled(false);
        jBtnModificar.setEnabled(false);
        jBtnGuardar.setEnabled(true);
        clienteEncontrado = false;
        borrarFilas();
    }

    private void cargarEspecialidad() {
        EspecialidadJpaController controlEsp = new EspecialidadJpaController();
        List<Especialidad> serv = new ArrayList<>();
        serv = controlEsp.findEspecialidadEntities();
        for (Especialidad unEsp : serv) {
            jCboxEspecialidad.addItem(unEsp);

        }

    }

    private void cargoTabla(List<Especialidad> espList) {
        for (Especialidad cuartel : espList) {
            tabla.addRow(new Object[]{cuartel.getId(), cuartel.getTipo(), cuartel.getComplejidad()});
            // modelo.addElement(cuartel.getId()+" "+ cuartel.getTipo()+" "+ cuartel.getDescripcion());
        }
    }
}
