/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Importar.java
 *
 * Created on 23/07/2011, 19:40:00
 */
package ipfixed;

import Excepcion.ExceptionIPFixed;
import Modelo.Host;
import Modelo.Ip;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author matuuar
 */
public class Importar extends javax.swing.JDialog {

    /** Creates new form Importar */
    public Importar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextoInfo = new javax.swing.JTextPane();
        mostrarRuta = new javax.swing.JTextField();
        seleccionarFile = new javax.swing.JButton();
        importarConfig = new javax.swing.JButton();
        cerrarImportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TextoInfo.setBorder(null);
        TextoInfo.setEditable(false);
        TextoInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TextoInfo.setDisabledTextColor(new java.awt.Color(1, 1, 1));
        TextoInfo.setMargin(new java.awt.Insets(20, 20, 20, 20));
        jScrollPane1.setViewportView(TextoInfo);
        TextoInfo.setText("Este dialogo le permite importar la configuración desde un archivo .csv (Texto CSV).\n"
            + "El formato esperado es '[MAC],[Nombre de máquina]'\n"
            + "Un host por linea.");

        mostrarRuta.setEnabled(false);
        mostrarRuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarRutaMouseClicked(evt);
            }
        });

        seleccionarFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ipfixed/resources/16.png"))); // NOI18N
        seleccionarFile.setText("Seleccionar...");
        seleccionarFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarFileActionPerformed(evt);
            }
        });

        importarConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ipfixed/resources/8.png"))); // NOI18N
        importarConfig.setText("Importar");
        importarConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarConfigActionPerformed(evt);
            }
        });

        cerrarImportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ipfixed/resources/116.png"))); // NOI18N
        cerrarImportar.setText("Cerrar");
        cerrarImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarImportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(mostrarRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seleccionarFile, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cerrarImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(importarConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cerrarImportar, importarConfig});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(seleccionarFile)
                    .addComponent(mostrarRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importarConfig)
                    .addComponent(cerrarImportar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionarFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarFileActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            fileSave = fileChooser.getSelectedFile();
            mostrarRuta.setText(fileSave.getAbsolutePath());
        }
    }//GEN-LAST:event_seleccionarFileActionPerformed

    private void mostrarRutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mostrarRutaMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showSaveDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            if (fileChooser.getSelectedFile().canRead()) {
                fileSave = fileChooser.getSelectedFile();
                mostrarRuta.setText(fileSave.getAbsolutePath());
            } else {
                JOptionPane.showMessageDialog(fileChooser, "El archivo no se puede leer");
            }
        }
    }//GEN-LAST:event_mostrarRutaMouseClicked

    private void cerrarImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarImportarActionPerformed
        dispose();
    }//GEN-LAST:event_cerrarImportarActionPerformed

    private void importarConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importarConfigActionPerformed
        Boolean salto = false;
        String numIP=JOptionPane.showInputDialog("Ingrese la dirección IP del primer host. "
                + "Las siguientes se eligirán secuencialmente.");
        Ip ip = new Ip(numIP);
        ArrayList<Host> hosts = Main.getHost();
        int id=Main.getId();
        if (!hosts.isEmpty()) {
            if (JOptionPane.showConfirmDialog(rootPane, "Existen host cargados anteriormente. ¿Desea conservarlos?",
                    "Agregar host", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) != JOptionPane.YES_OPTION) {
                hosts = new ArrayList<Host>();
                id=1000;
            }
        }
        FileReader fr;
        String tmp = "";
        try {
            fr = new FileReader(fileSave);
            BufferedReader br = new BufferedReader(fr);
            tmp = br.readLine();

            while (tmp != null && !tmp.isEmpty()) {  //bucle de lectura
                Host h = new Host();
                String[] line = tmp.split(",", 2);
                if (line[0].isEmpty() && line[1].isEmpty()) {  //si ambos no son nulos
                    salto = true;
                } else {
                    if (line[0].length() != 12) {
                        salto = true;
                    } else {
                        h.setMac(line[0]);
                        h.setNombre(line[1]);
                        h.setIp(ip.toString());
                        h.setId(id);
                        hosts.add(h);
                        ip.nextIP();
                        id++;
                    }
                }
                tmp = br.readLine();
            } //fin del while
            if(salto){
                JOptionPane.showMessageDialog(this, "Si saltaron algunas lineas por formato erroneo. Revisar!");
            }
            Main.setHost(hosts);
            Main.setId(id);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExceptionIPFixed ex) {
            Logger.getLogger(Importar.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "Importación completada!");
        dispose();


    }//GEN-LAST:event_importarConfigActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Importar dialog = new Importar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane TextoInfo;
    private javax.swing.JButton cerrarImportar;
    private javax.swing.JButton importarConfig;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mostrarRuta;
    private javax.swing.JButton seleccionarFile;
    // End of variables declaration//GEN-END:variables
    File fileSave;
}
