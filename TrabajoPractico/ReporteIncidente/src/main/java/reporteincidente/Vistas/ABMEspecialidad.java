package reporteincidente.Vistas;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import reporteincidente.Entidades.Complejidad;
import reporteincidente.Entidades.Especialidad;
import reporteincidente.Entidades.Servicio;
import reporteinicidente.Repositorio.EspecialidadJpaController;
import reporteinicidente.Repositorio.ServicioJpaController;
import reporteinicidente.Repositorio.exceptions.NonexistentEntityException;

public class ABMEspecialidad extends javax.swing.JInternalFrame {

    private boolean especialidadencontrada = false;

    private final DefaultTableModel tabla = new DefaultTableModel() { //Creo un objeto DefaulTableModel para darle un modelo a la tabla
        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

   
    public ABMEspecialidad() {
        initComponents();
        armarCabecerata(); //Armo cabecera de la tabla
        limpiar();
        cargoTabla();
    }

    // Método para centrar los encabezados de las columnas
    private void centrarEncabezado(JTable table) {
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnModificar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaEspecialidad = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jBtnSalir = new javax.swing.JButton();
        jTextCodigo = new javax.swing.JTextField();
        jTextTipo = new javax.swing.JTextField();
        jBtnEliminar = new javax.swing.JButton();
        jBtnNuevo = new javax.swing.JButton();
        jBtnGuardar = new javax.swing.JButton();
        jCboxComplejidad = new javax.swing.JComboBox<>();

        setTitle("Especialidad");

        jBtnModificar.setText("Modificar");
        jBtnModificar.setEnabled(false);
        jBtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Complejidad");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Codigo");

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTablaEspecialidadMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTablaEspecialidad);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tipo");

        jBtnSalir.setText("Salir");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });

        jTextCodigo.setEditable(false);

        jBtnEliminar.setText("Eliminar");
        jBtnEliminar.setEnabled(false);
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });

        jBtnNuevo.setText("Nuevo");
        jBtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNuevoActionPerformed(evt);
            }
        });

        jBtnGuardar.setText("Guardar");
        jBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarActionPerformed(evt);
            }
        });

        jCboxComplejidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Medio", "Complejo" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(jTextCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(jCboxComplejidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(311, 311, 311))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboxComplejidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
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

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
        int respuesta;
        if (especialidadencontrada) {
            respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Deseas borrar al cliene", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                try {
                    EspecialidadJpaController controlEspecialidad = new EspecialidadJpaController();
                    controlEspecialidad.destroy(Integer.parseInt(jTextCodigo.getText()));
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(ABMClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            limpiar();
            cargoTabla();
        } else {
            JOptionPane.showMessageDialog(this, "No hay cliente seleccionado");
        }
    }//GEN-LAST:event_jBtnEliminarActionPerformed

    private void jBtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNuevoActionPerformed
        limpiar();
    }//GEN-LAST:event_jBtnNuevoActionPerformed

    private void jBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarActionPerformed
        Complejidad complejidadTipo = new Complejidad();
        EspecialidadJpaController controlEspecialidad = new EspecialidadJpaController();

        if ((jTextTipo.getText() != null) && (jCboxComplejidad.getSelectedItem() != null)) {
            if (controlEspecialidad.buscarTipo(jTextTipo.getText().toUpperCase())) {
                if (jCboxComplejidad.getSelectedItem() == "Medio") {
                    complejidadTipo.setNivel(1);
                } else if (jCboxComplejidad.getSelectedItem() == "Complejo") {
                    complejidadTipo.setNivel(2);
                }

              
                Especialidad esp = new Especialidad(jTextTipo.getText().toUpperCase(), complejidadTipo.getEstado());
                controlEspecialidad.create(esp);
                cargoTabla();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(this, "TIPO REPETIDO");
                limpiar();
            }
        }

    }//GEN-LAST:event_jBtnGuardarActionPerformed

    private void jTablaEspecialidadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaEspecialidadMousePressed
        int filaSeleccionada = -1;
        int idEspecialidad;
        filaSeleccionada = jTablaEspecialidad.getSelectedRow();
        if (filaSeleccionada != -1) { //Se selecciono una fila
            idEspecialidad = (Integer) jTablaEspecialidad.getValueAt(filaSeleccionada, 0);
            especialidadencontrada = true;
            jBtnModificar.setEnabled(true); //Activar Boton Modificar
            jBtnEliminar.setEnabled(true); //Activar Boton Eliminar
            jBtnGuardar.setEnabled(false);
            cargarDatos(idEspecialidad);
           
        }
    }//GEN-LAST:event_jTablaEspecialidadMousePressed

    private void jBtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarActionPerformed
        EspecialidadJpaController controlEspecialidad = new EspecialidadJpaController();

        Complejidad complejidadTipo = new Complejidad();
        if ((jTextTipo.getText() != null) && (jCboxComplejidad.getSelectedItem() != null)) {

            try {
                if (jCboxComplejidad.getSelectedItem() == "Medio") {
                    complejidadTipo.setNivel(1);
                } else if (jCboxComplejidad.getSelectedItem() == "Complejo") {
                    complejidadTipo.setNivel(2);
                }
               
                Especialidad esp = new Especialidad(jTextTipo.getText().toUpperCase(), complejidadTipo.getEstado());
                esp.setId(Integer.parseInt(jTextCodigo.getText()));
                controlEspecialidad.edit(esp);
                cargoTabla();
                limpiar();
            } catch (Exception ex) {
                Logger.getLogger(ABMEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "TIPO REPETIDO");
            limpiar();

        }

    }//GEN-LAST:event_jBtnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnGuardar;
    private javax.swing.JButton jBtnModificar;
    private javax.swing.JButton jBtnNuevo;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JComboBox<String> jCboxComplejidad;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaEspecialidad;
    private javax.swing.JTextField jTextCodigo;
    private javax.swing.JTextField jTextTipo;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        jTextCodigo.setText("");
        jTextTipo.setText("");
        jBtnEliminar.setEnabled(false);
        jBtnModificar.setEnabled(false);
        jBtnGuardar.setEnabled(true);
        especialidadencontrada = false;

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

    //LIMPIO LAS FILAS
    private void borrarFilas() {

        int filas = jTablaEspecialidad.getRowCount() - 1;
        for (int f = filas; f >= 0; f--) {
            tabla.removeRow(f);

        }

         }

    //CARGO LA INFO EN LA TABLA
    public void cargoTabla() {

        EspecialidadJpaController controlaEspecialidad = new EspecialidadJpaController();
        List<Especialidad> listaEsp = new ArrayList<>();
        listaEsp = controlaEspecialidad.findEspecialidadEntities();
        borrarFilas();
        for (Especialidad cuartel : listaEsp) {
            tabla.addRow(new Object[]{cuartel.getId(), cuartel.getTipo(), cuartel.getComplejidad()});

        }
             
      
        
    }
   
    

    private void cargarDatos(int idEspecialidad) {
        EspecialidadJpaController controlaEspecialidad = new EspecialidadJpaController();
        Especialidad espe = new Especialidad();
        espe = controlaEspecialidad.findEspecialidad(idEspecialidad);
        jTextCodigo.setText(espe.getId() + "");
        jTextTipo.setText(espe.getTipo());
        switch (espe.getComplejidad()) {
            case 0:
                jCboxComplejidad.setSelectedIndex(0);
                break;
            case 1:
                jCboxComplejidad.setSelectedIndex(1);
                break;
            default:
                jCboxComplejidad.setSelectedIndex(2);
                break;
        }
     

    }
}