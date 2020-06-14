/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazGrafica;

import baseDatos.Conexion;
import data.Producto;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import logic.Controlador;

import logic.Paginador;
import static logic.Paginador.nextPage;
import static logic.Paginador.prevPage;

/**
 *
 * @author juanc
 */
public class Busqueda extends javax.swing.JFrame {

    boolean rowCreated;

    public Busqueda() {
        initComponents();
        crearmodelo();
        Conexion.cargarBaseDatos();
        Paginador.cargarPilas();
        rowCreated = false;
        //control booleano

        //Controlador.cargarPaginador();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cod = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Mostrar Todos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Atras");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Categoria");

        jLabel3.setText("Codigo");

        jLabel4.setText("Zona de Busqueda ");

        jButton4.setText(">");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("<");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(686, 686, 686)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // llamar mostrar rango Controlador.ProductosTotales.mostrarrango;

        Paginador.vaciarPilas();
        Paginador.cargarPilas();

        if (rowCreated) {
            for (int i = M.getRowCount() - 1; i >= 0; i--) {
                M.removeRow(i);

            }
            rowCreated = false;

        }
        Paginador.counter = 0;
        int[] nextArray = nextPage(Paginador.pilaA, Paginador.pilaB);

        Controlador.ArbolProductosTotales.printByRange(Controlador.ArbolProductosTotales.getRoot(), nextArray[0], nextArray[1]);

        Object[] elements = Paginador.currentPage;

        for (int i = 0; i < elements.length; i++) {
            Producto p = (Producto) elements[i];

            M.addRow(elements);
            M.setValueAt(p.getCodigoProducto(), i, 0);
            M.setValueAt(p.getDescripcion(), i, 1);
            M.setValueAt(p.getPrecioVenta(), i, 2);
            if (p.getCantidadUnidades() <= 0) {
                M.setValueAt("Si", i, 3);
            } else {
                M.setValueAt("No", i, 3);
            }
            M.setValueAt(p.getCantidadUnidades(), i, 4);
            M.setValueAt(p.getDescuento(), i, 5);
        }
        rowCreated = true;


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (rowCreated) {
            for (int i = M.getRowCount() - 1; i >= 0; i--) {
                M.removeRow(i);

            }
            rowCreated = false;

        }
        Paginador.counter = 0;

        int[] nextArray = nextPage(Paginador.pilaA, Paginador.pilaB);

        Controlador.ArbolProductosTotales.printByRange(Controlador.ArbolProductosTotales.getRoot(), nextArray[0], nextArray[1]);

        Object[] elements = Paginador.currentPage;

        for (int i = 0; i < elements.length; i++) {
            Producto p = (Producto) elements[i];

            M.addRow(elements);
            M.setValueAt(p.getCodigoProducto(), i, 0);
            M.setValueAt(p.getDescripcion(), i, 1);
            M.setValueAt(p.getPrecioVenta(), i, 2);
            if (p.getCantidadUnidades() <= 0) {
                M.setValueAt("Si", i, 3);
            } else {
                M.setValueAt("No", i, 3);
            }
            M.setValueAt(p.getCantidadUnidades(), i, 4);
            M.setValueAt(p.getDescuento(), i, 5);
        }
        rowCreated = true;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //System.out.println(cod.getText());

        if (rowCreated) {
            for (int i = M.getRowCount() - 1; i >= 0; i--) {
                M.removeRow(i);

            }
            rowCreated = false;
        }

        if (cod.getText() == null) {
            //TODO:  REPARAR VALIDACION SE ESTA USANDO ESTA CONDICIONAL 
            System.out.println("No hay elemento a buscar");

        } else {

            int codigoProducto = Integer.parseInt(cod.getText());
            Producto p = new Producto(codigoProducto, null, 0, 0, 0, null);

            Object[] elements = new Object[1];
            Producto temp = (Producto) Controlador.ArbolProductosTotales.find(Controlador.ArbolProductosTotales.getRoot(), p).getKey();
            elements[0] = temp;
            Object[] o = null;

            M.addRow(o);
            M.setValueAt(temp.getCodigoProducto(), 0, 0);
            M.setValueAt(temp.getDescripcion(), 0, 1);
            M.setValueAt(temp.getPrecioVenta(), 0, 2);
            if (temp.getCantidadUnidades() <= 0) {
                M.setValueAt("Si", 0, 3);
            } else {
                M.setValueAt("No", 0, 3);
            }
            M.setValueAt(temp.getCantidadUnidades(), 0, 4);
            M.setValueAt(temp.getDescuento(), 0, 5);
            rowCreated = true;
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (rowCreated) {
            for (int i = M.getRowCount() - 1; i >= 0; i--) {
                M.removeRow(i);

            }
            rowCreated = false;

        }
        Paginador.counter = 0;

        int[] prevArray = prevPage(Paginador.pilaA, Paginador.pilaB);

        Controlador.ArbolProductosTotales.printByRange(Controlador.ArbolProductosTotales.getRoot(), prevArray[0], prevArray[1]);

        Object[] elements = Paginador.currentPage;

        for (int i = 0; i < elements.length; i++) {
            Producto p = (Producto) elements[i];

            M.addRow(elements);
            M.setValueAt(p.getCodigoProducto(), i, 0);
            M.setValueAt(p.getDescripcion(), i, 1);
            M.setValueAt(p.getPrecioVenta(), i, 2);
            if (p.getCantidadUnidades() <= 0) {
                M.setValueAt("Si", i, 3);
            } else {
                M.setValueAt("No", i, 3);
            }
            M.setValueAt(p.getCantidadUnidades(), i, 4);
            M.setValueAt(p.getDescuento(), i, 5);
        }
        rowCreated = true;


    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Busqueda().setVisible(true);
            }
        });
    }
    DefaultTableModel M;

    private void crearmodelo() {
        try {
            M = (new DefaultTableModel(null, new String[]{
                "Codigo", "Descripcion", "Precio", "Agotado", "Unidades", "Descuento"}) {
            });
            jTable1.setModel(M);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error");
        }
    }

    public void addCheckBox(int column, JTable table) {
        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cod;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}