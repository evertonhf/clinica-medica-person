/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.imepac.clinica_medica.administrativo.funcionario;

import br.edu.imepac.clinica_medica.daos.FuncionarioDAO;
import br.edu.imepac.clinica_medica.entidades.Especialidade;
import br.edu.imepac.clinica_medica.entidades.Funcionario;
import br.edu.imepac.clinica_medica.entidades.Perfil;
import br.edu.imepac.clinica_medica.telas.ScreenBase;

import java.util.List;

/**
 * @author ehf_v
 */
public class FuncionarioListagemScreen extends ScreenBase {

    /**
     * Creates new form FuncionarioCadastroScreen
     */
    public FuncionarioListagemScreen() {
        initComponents();

        loadDataFieldsFromDB();

        positionScreen(315, 140, 695, 900);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        cancelarButton = new javax.swing.JButton();
        salvarButton = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 24)); // NOI18N
        jLabel1.setText("Listagem de funcionários");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(6, 18, 299, 40);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(6, 76, 1283, 3);

        cancelarButton.setBackground(new java.awt.Color(204, 51, 0));
        cancelarButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cancelarButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelarButton.setIcon(new javax.swing.ImageIcon("D:\\Imepac\\BACK\\2024-02\\clinica-medica-poo\\src\\main\\resources\\images\\encerrar.png")); // NOI18N
        cancelarButton.setText("Cancelar e fechar");
        cancelarButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cancelarButton.setIconTextGap(20);
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelarButton);
        cancelarButton.setBounds(950, 430, 250, 80);

        salvarButton.setBackground(new java.awt.Color(153, 204, 255));
        salvarButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        salvarButton.setForeground(new java.awt.Color(51, 0, 102));
        salvarButton.setIcon(new javax.swing.ImageIcon("D:\\Imepac\\BACK\\2024-02\\clinica-medica-poo\\src\\main\\resources\\images\\save.png")); // NOI18N
        salvarButton.setText("Salvar");
        salvarButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        salvarButton.setIconTextGap(20);
        salvarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(salvarButton);
        salvarButton.setBounds(950, 340, 250, 80);

        jLabel17.setForeground(new java.awt.Color(102, 0, 0));
        jLabel17.setText("Campos em vermelho são obrigatórios o preenchimento.");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(30, 50, 360, 16);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Id", "Nome", "E-mail", "Perfil"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 110, 910, 402);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void salvarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarButtonActionPerformed
    }//GEN-LAST:event_salvarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FuncionarioListagemScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionarioListagemScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionarioListagemScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionarioListagemScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncionarioListagemScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton salvarButton;
    // End of variables declaration//GEN-END:variables

    private List<Perfil> perfis;
    private List<Especialidade> especialidades;

    private void loadDataFieldsFromDB() {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        List<Funcionario> funcionarios = funcionarioDAO.readAll();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[funcionarios.size()][4],
                new String[]{
                        "Id", "Nome", "E-mail", "Perfil"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        for (int i = 0; i < funcionarios.size(); i++) {
            jTable1.setValueAt(funcionarios.get(i).getId(), i, 0);
            jTable1.setValueAt(funcionarios.get(i).getNome(), i, 1);
            jTable1.setValueAt(funcionarios.get(i).getEmail(), i, 2);
            jTable1.setValueAt(funcionarios.get(i).getPerfil().getNome(), i, 3);
        }
    }

}