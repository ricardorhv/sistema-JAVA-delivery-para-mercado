/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.CarrinhoBD;
import dao.PedidoBD;
import dao.UsuarioBD;
import dao.UsuarioEnderecoBD;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 *
 * @author ricardorhv
 */
public class TelaDeLogin extends javax.swing.JFrame {
    private UsuarioBD usuarioBD;
    private CarrinhoBD carrinhoBD;
    private UsuarioEnderecoBD usuarioEnderecoBD;
    private PedidoBD pedidoBd;
    
    public TelaDeLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.usuarioBD = new UsuarioBD();
    }
    
    public TelaDeLogin(UsuarioBD usuarioBD) {
        initComponents();
        this.usuarioBD = usuarioBD;
        this.setLocationRelativeTo(null);
    }
    
    public TelaDeLogin(UsuarioBD usuarioBD, CarrinhoBD carrinhoBD, UsuarioEnderecoBD usuarioEnderecoBD, PedidoBD pedidoBD) {
        initComponents();
        this.usuarioBD = usuarioBD;
        this.carrinhoBD = carrinhoBD;
        this.usuarioEnderecoBD = usuarioEnderecoBD;
        this.pedidoBd = pedidoBD;
        
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbExibirSenha = new javax.swing.JCheckBox();
        pfSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        btnCriarConta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("E-mail");

        tfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmailActionPerformed(evt);
            }
        });

        jLabel2.setText("Senha");

        cbExibirSenha.setText("Exibir senha");
        cbExibirSenha.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbExibirSenhaItemStateChanged(evt);
            }
        });

        btnEntrar.setText("Entrar");
        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntrarMouseClicked(evt);
            }
        });

        btnCriarConta.setText("Criar conta");
        btnCriarConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCriarContaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                    .addComponent(cbExibirSenha)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(pfSenha)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCriarConta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbExibirSenha)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrar)
                    .addComponent(btnCriarConta))
                .addContainerGap(129, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmailActionPerformed

    private void cbExibirSenhaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbExibirSenhaItemStateChanged
        boolean isChecked = cbExibirSenha.isSelected();
        pfSenha.setEchoChar(isChecked ? (char) 0 : '*');
    }//GEN-LAST:event_cbExibirSenhaItemStateChanged

    private void btnEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseClicked
        String email = tfEmail.getText();
        String senha = String.valueOf(pfSenha.getPassword());
        
        boolean temUsuarioComEssesDadosCadastrado = usuarioBD.verificarSeTemUsuarioCadastrado(email, senha);
        
        if (temUsuarioComEssesDadosCadastrado) {
            Usuario usuario = usuarioBD.buscarUsuarioPorEmailESenha(email, senha);
            
            TelaPrincipal tela;
        
            if (this.carrinhoBD != null) {
                tela = new TelaPrincipal(this.usuarioBD, usuario, this.carrinhoBD, this.usuarioEnderecoBD, this.pedidoBd);
            } else {
                tela = new TelaPrincipal(usuarioBD, usuario); 
            }
            tela.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "E-mail ou senha incorretos!", null, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEntrarMouseClicked

    private void btnCriarContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCriarContaMouseClicked
        TelaDeCriacaoDeConta tela;
        
        if (this.carrinhoBD != null) {
            tela = new TelaDeCriacaoDeConta(this.usuarioBD, this.carrinhoBD, this.usuarioEnderecoBD, this.pedidoBd);
        } else {
            tela = new TelaDeCriacaoDeConta(usuarioBD); 
        }
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCriarContaMouseClicked

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
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriarConta;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JCheckBox cbExibirSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JTextField tfEmail;
    // End of variables declaration//GEN-END:variables
}
