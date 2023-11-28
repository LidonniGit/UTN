package reporteincidente.Vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import reporteincidente.Entidades.Incidente;
import reporteinicidente.Repositorio.IncidenteJpaController;

public class ReporteVerIncidentes extends javax.swing.JInternalFrame {

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

    public ReporteVerIncidentes() {
        initComponents();
        armarCabecerata(); //Armo cabecera de la tabla
        cargoTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnOk = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaIncidentes = new javax.swing.JTable();

        setTitle("Incidentes");

        jBtnOk.setText("Ok");
        jBtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOkActionPerformed(evt);
            }
        });

        jTablaIncidentes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablaIncidentes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnOk)
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jBtnOk)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOkActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnOkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnOk;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaIncidentes;
    // End of variables declaration//GEN-END:variables

    private void armarCabecerata() {
        tabla.addColumn("ID"); //Creo columna
        tabla.addColumn("Descripcion"); //Creo columna
        tabla.addColumn("Fecha"); //Creo columna
        tabla.addColumn("Estado"); //Creo columna
        tabla.addColumn("Cliente"); //Creo columna
        tabla.addColumn("Tecnico"); //Creo columna
        jTablaIncidentes.setModel(tabla); //CARGO LAS COLUMNAS A LA TABLA
        centrarEncabezado(jTablaIncidentes); //Centro los encabezados
        TableColumnModel columnModel = jTablaIncidentes.getColumnModel();//Determino el ancho de cada columna
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(170);
        columnModel.getColumn(3).setPreferredWidth(170);
        columnModel.getColumn(4).setPreferredWidth(170);
        columnModel.getColumn(5).setPreferredWidth(170);
    }

    //CARGO LA INFO EN LA TABLA
    public void cargoTabla() {

        IncidenteJpaController controlIncidente = new IncidenteJpaController();
        List<Incidente> listaIncidente = new ArrayList<>();
        listaIncidente = controlIncidente.findIncidenteEntities();
        listaIncidente.forEach(incidente -> tabla.addRow(new Object[]{incidente.getId(),
            incidente.getDescripcion(), incidente.getFechaInicio(), incidente.isEstado(), incidente.getCliente().getRazonSocial(),
            incidente.getTecnico().getApellido()}));

    }

}
