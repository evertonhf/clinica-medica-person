/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.imepac.clinica_medica.administrativo.funcionario;

import br.edu.imepac.clinica_medica.daos.EspecialidadeDAO;
import br.edu.imepac.clinica_medica.daos.FuncionarioDAO;
import br.edu.imepac.clinica_medica.daos.PerfilDAO;
import br.edu.imepac.clinica_medica.entidades.Especialidade;
import br.edu.imepac.clinica_medica.entidades.Funcionario;
import br.edu.imepac.clinica_medica.entidades.Perfil;
import br.edu.imepac.clinica_medica.telas.ScreenBase;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author ehf_v
 */
public class FuncionarioCadastroScreen extends ScreenBase {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bairroTextField;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JTextField cidadeTextField;
    private javax.swing.JTextField complementoTextField;
    private javax.swing.JFormattedTextField contatoTextField1;
    private javax.swing.JFormattedTextField dataNascimentoTextField;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JComboBox<Especialidade> especialidadeField;
    private javax.swing.JLabel especialidadeLabel;
    private javax.swing.JComboBox<String> estadoTextField1;
    private javax.swing.JFormattedTextField idadeTextField;
    private javax.swing.JFormattedTextField identificacaoTextField;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton limparBotton;
    private javax.swing.JTextField logradouroTextField;
    private javax.swing.JTextField nomeCompletoTextfield;
    private javax.swing.JTextField numeroTextField;
    private javax.swing.JComboBox<Perfil> perfilField;
    private javax.swing.JButton salvarButton;
    private javax.swing.JFormattedTextField senhaTextField;
    private javax.swing.JComboBox<String> sexoTextField;
    private javax.swing.JComboBox<String> tipoFuncionarioField;
    private javax.swing.JTextField usuarioTextField;
    private List<Perfil> perfis;
    private PerfilDAO perfilDAO;
    private List<Especialidade> especialidades;
    private EspecialidadeDAO especialidadeDAO;
    private FuncionarioDAO funcionarioDAO;
    /**
     * Creates new form FuncionarioCadastroScreen
     */
    public FuncionarioCadastroScreen() {
        perfilDAO = new PerfilDAO();
        especialidadeDAO = new EspecialidadeDAO();
        funcionarioDAO = new FuncionarioDAO();

        initComponents();

        loadDataFieldsFromDB();

        positionScreen(315, 140, 695, 900);
    }

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
            java.util.logging.Logger.getLogger(FuncionarioCadastroScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionarioCadastroScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionarioCadastroScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionarioCadastroScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncionarioCadastroScreen().setVisible(true);
            }
        });
    }

    private void loadDataFieldsFromDB() {
        perfis = perfilDAO.readAll();

        perfilField.removeAllItems();
        for (Perfil perfil : perfis) {
            perfilField.addItem(perfil);
        }

        especialidades = especialidadeDAO.readAll();
        especialidadeField.removeAllItems();
        for (Especialidade especialidade : especialidades) {
            especialidadeField.addItem(especialidade);
        }
    }

    private boolean camposValidos() {
        /* Verifica se os campos obrigatórios estão preenchidos */
        if (contatoTextField1.getText().isEmpty() || perfilField.getSelectedItem() == null || nomeCompletoTextfield.getText().isEmpty() || identificacaoTextField.getText().isEmpty() || emailTextField.getText().isEmpty() || dataNascimentoTextField.getText().isEmpty() || senhaTextField.getText().isEmpty() || usuarioTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (tipoFuncionarioField != null && tipoFuncionarioField.getSelectedItem().toString().equalsIgnoreCase("MÉDICO") && especialidadeField.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma especialidade", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
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
        jLabel3 = new javax.swing.JLabel();
        nomeCompletoTextfield = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        idadeTextField = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        identificacaoTextField = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dataNascimentoTextField = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        senhaTextField = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        logradouroTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        numeroTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        complementoTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        bairroTextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cidadeTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        sexoTextField = new javax.swing.JComboBox<>();
        cancelarButton = new javax.swing.JButton();
        salvarButton = new javax.swing.JButton();
        limparBotton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        especialidadeLabel = new javax.swing.JLabel();
        usuarioTextField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        contatoTextField1 = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        estadoTextField1 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        especialidadeField = new javax.swing.JComboBox<>();
        perfilField = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        tipoFuncionarioField = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 24)); // NOI18N
        jLabel1.setText("Cadastro de funcionários");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(6, 18, 297, 40);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(6, 76, 1283, 3);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setText("Tipo funcionário");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 110, 130, 25);

        nomeCompletoTextfield.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(nomeCompletoTextfield);
        nomeCompletoTextfield.setBounds(600, 97, 600, 50);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Idade");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(828, 178, 45, 25);

        idadeTextField.setEnabled(false);
        idadeTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(idadeTextField);
        idadeTextField.setBounds(879, 165, 73, 52);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 0));
        jLabel5.setText("Doc. Identificação");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(6, 178, 141, 25);

        try {
            identificacaoTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        identificacaoTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(identificacaoTextField);
        identificacaoTextField.setBounds(165, 165, 287, 52);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 0));
        jLabel6.setText("Sexo");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(975, 178, 38, 25);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 0));
        jLabel7.setText("Data nascimento");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(460, 178, 133, 25);

        emailTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(emailTextField);
        emailTextField.setBounds(165, 236, 550, 50);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Telefone/Contato");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(730, 250, 138, 25);

        try {
            dataNascimentoTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataNascimentoTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dataNascimentoTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dataNascimentoTextFieldFocusLost(evt);
            }
        });
        getContentPane().add(dataNascimentoTextField);
        dataNascimentoTextField.setBounds(600, 170, 225, 52);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 0));
        jLabel9.setText("E-mail");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(98, 248, 49, 25);

        senhaTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        senhaTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(senhaTextField);
        senhaTextField.setBounds(750, 620, 450, 52);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("DADOS DE AUTENTICAÇÃO");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 570, 236, 25);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Logradouro");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(51, 360, 94, 25);

        logradouroTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(logradouroTextField);
        logradouroTextField.setBounds(165, 348, 850, 50);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Número");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(1030, 360, 65, 25);

        numeroTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(numeroTextField);
        numeroTextField.setBounds(1110, 348, 90, 50);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Complemento");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(40, 430, 114, 25);

        complementoTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(complementoTextField);
        complementoTextField.setBounds(165, 420, 490, 50);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Bairro");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(690, 430, 46, 25);

        bairroTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(bairroTextField);
        bairroTextField.setBounds(750, 420, 450, 50);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Cidade");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(90, 500, 55, 25);

        cidadeTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(cidadeTextField);
        cidadeTextField.setBounds(165, 490, 490, 50);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Estado");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(680, 500, 54, 25);

        sexoTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sexoTextField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Masculino", "Feminino"}));
        getContentPane().add(sexoTextField);
        sexoTextField.setBounds(1020, 165, 178, 50);

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
        cancelarButton.setBounds(950, 760, 250, 80);

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
        salvarButton.setBounds(40, 760, 220, 80);

        limparBotton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        limparBotton.setIcon(new javax.swing.ImageIcon("D:\\Imepac\\BACK\\2024-02\\clinica-medica-poo\\src\\main\\resources\\images\\limpar.png")); // NOI18N
        limparBotton.setText("Limpar campos");
        limparBotton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        limparBotton.setIconTextGap(20);
        limparBotton.setMaximumSize(new java.awt.Dimension(161, 70));
        limparBotton.setMinimumSize(new java.awt.Dimension(161, 70));
        limparBotton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparBottonActionPerformed(evt);
            }
        });
        getContentPane().add(limparBotton);
        limparBotton.setBounds(690, 760, 240, 80);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("ENDEREÇO RESIDENCIAL PARA CONTATO");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(24, 305, 360, 25);

        especialidadeLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        especialidadeLabel.setForeground(new java.awt.Color(102, 0, 0));
        especialidadeLabel.setText("Especialidade");
        getContentPane().add(especialidadeLabel);
        especialidadeLabel.setBounds(630, 700, 120, 25);

        usuarioTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(usuarioTextField);
        usuarioTextField.setBounds(160, 620, 450, 50);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 0, 0));
        jLabel18.setText("Perfil");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(70, 700, 60, 25);

        try {
            contatoTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)9####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        contatoTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(contatoTextField1);
        contatoTextField1.setBounds(880, 240, 320, 52);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 0, 0));
        jLabel19.setText("Senha[números]");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(620, 630, 170, 25);

        estadoTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        estadoTextField1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"}));
        getContentPane().add(estadoTextField1);
        estadoTextField1.setBounds(750, 490, 450, 50);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 0, 0));
        jLabel20.setText("Usuário");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(75, 630, 70, 25);

        especialidadeField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(especialidadeField);
        especialidadeField.setBounds(750, 690, 450, 50);

        perfilField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(perfilField);
        perfilField.setBounds(160, 690, 450, 50);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 0, 0));
        jLabel21.setText("Nome completo");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(460, 110, 130, 25);

        tipoFuncionarioField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tipoFuncionarioField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"MÉDICO", "ATENDENTE"}));
        tipoFuncionarioField.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                stateChanged(evt);
            }
        });
        getContentPane().add(tipoFuncionarioField);
        tipoFuncionarioField.setBounds(170, 100, 280, 50);

        jLabel17.setForeground(new java.awt.Color(102, 0, 0));
        jLabel17.setText("Campos em vermelho são obrigatórios o preenchimento.");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(30, 50, 360, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // End of variables declaration//GEN-END:variables

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void limparBottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparBottonActionPerformed
    }//GEN-LAST:event_limparBottonActionPerformed

    private void salvarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarButtonActionPerformed
        if (camposValidos()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoTextField.getText(), formatter);

            Funcionario funcionario = new Funcionario(
                    usuarioTextField.getText(),
                    Integer.parseInt(senhaTextField.getText()),
                    nomeCompletoTextfield.getText(),
                    Integer.parseInt(idadeTextField.getText()),
                    sexoTextField.getSelectedItem().toString().charAt(0),
                    identificacaoTextField.getText(),
                    logradouroTextField.getText(),
                    numeroTextField.getText(),
                    complementoTextField.getText(),
                    bairroTextField.getText(),
                    cidadeTextField.getText(),
                    estadoTextField1.getSelectedItem().toString(),
                    contatoTextField1.getText(),
                    emailTextField.getText(),
                    dataNascimento,
                    tipoFuncionarioField.getSelectedItem().toString(),
                    ((Especialidade) especialidadeField.getSelectedItem()).getId(),
                    ((Perfil) perfilField.getSelectedItem()).getId()
            );

            funcionarioDAO.create(funcionario);
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso.");

            this.dispose();
        }
    }//GEN-LAST:event_salvarButtonActionPerformed

    private void stateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_stateChanged
        if (tipoFuncionarioField.getSelectedItem().toString().equalsIgnoreCase("ATENDENTE")) {
            especialidadeLabel.setVisible(false);
            especialidadeField.setVisible(false);
        } else {
            especialidadeLabel.setVisible(true);
            especialidadeField.setVisible(true);
        }
    }//GEN-LAST:event_stateChanged

    private void dataNascimentoTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataNascimentoTextFieldFocusLost
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoTextField.getText(), formatter);

        LocalDate currentDate = LocalDate.now();
        idadeTextField.setText(String.valueOf(Period.between(dataNascimento, currentDate).getYears()));
    }//GEN-LAST:event_dataNascimentoTextFieldFocusLost


}
