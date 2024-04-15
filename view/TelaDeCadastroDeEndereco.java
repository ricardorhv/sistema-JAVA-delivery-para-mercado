/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.CarrinhoBD;
import dao.PedidoBD;
import dao.UsuarioBD;
import dao.UsuarioEnderecoBD;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.CarrinhoDeCompra;
import model.Endereco;
import model.Usuario;

/**
 *
 * @author ricardorhv
 */
public class TelaDeCadastroDeEndereco extends javax.swing.JFrame {
    private CarrinhoBD carrinhoBD;
    private UsuarioBD usuarioBD;
    private Usuario usuarioLogado;
    private UsuarioEnderecoBD usuarioEnderecoBD;
    private CarrinhoDeCompra carrinhoDeCompra;
    private PedidoBD pedidoBD;
    
    public TelaDeCadastroDeEndereco() {
        initComponents();
        this.carrinhoBD = new CarrinhoBD();
        this.usuarioBD = new UsuarioBD();
        this.usuarioLogado = new Usuario();
        this.usuarioEnderecoBD = new UsuarioEnderecoBD();
        this.pedidoBD = new PedidoBD();
        
        this.setLocationRelativeTo(null);
    }
    
    public TelaDeCadastroDeEndereco(UsuarioBD usuarioBD, CarrinhoBD carrinhoBD, Usuario usuarioLogado, UsuarioEnderecoBD usuarioEnderecoBD, PedidoBD pedidoBD) {
        initComponents();
        
        this.carrinhoBD = carrinhoBD;
        this.usuarioBD = usuarioBD;
        this.usuarioLogado = usuarioLogado;
        this.usuarioEnderecoBD = usuarioEnderecoBD;
        this.pedidoBD = pedidoBD;
        
        this.setLocationRelativeTo(null);
    }
    
     public TelaDeCadastroDeEndereco(UsuarioBD usuarioBD, CarrinhoBD carrinhoBD, Usuario usuarioLogado, UsuarioEnderecoBD usuarioEnderecoBD, CarrinhoDeCompra carrinhoDeCompra, PedidoBD pedidoBD) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.usuarioBD = usuarioBD;
        this.carrinhoBD = carrinhoBD;
        this.usuarioEnderecoBD = usuarioEnderecoBD;
        this.usuarioLogado = usuarioLogado;
        this.carrinhoDeCompra = carrinhoDeCompra;
        this.pedidoBD = pedidoBD;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfRua = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ffNumeroDaCasa = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        ffCEP = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnCriar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taComplemento = new javax.swing.JTextArea();
        tfBairro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Numero da casa");

        ffNumeroDaCasa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel3.setText("Bairro");

        try {
            ffCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("CEP");

        jLabel5.setText("Complemento");

        btnVoltar.setText("Voltar");
        btnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVoltarMouseClicked(evt);
            }
        });
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel7.setText("Cadastro de Endereço");

        jLabel1.setText("Rua");

        btnCriar.setText("Criar");
        btnCriar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCriarMouseClicked(evt);
            }
        });
        btnCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarActionPerformed(evt);
            }
        });

        taComplemento.setColumns(20);
        taComplemento.setRows(5);
        jScrollPane1.setViewportView(taComplemento);

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Opcional");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addComponent(tfRua, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(jLabel3)
                                    .addComponent(tfBairro))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(ffNumeroDaCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ffCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel7)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ffNumeroDaCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ffCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnCriar))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked
        JFrame tela;
        
        if (this.carrinhoDeCompra != null) {
            tela = new TelaDeEndereco(this.usuarioBD, this.carrinhoBD, this.usuarioEnderecoBD, this.usuarioLogado, this.carrinhoDeCompra, this.pedidoBD);
        } else {
            tela = new TelaDeEndereco(this.usuarioBD, this.carrinhoBD, this.usuarioEnderecoBD, this.usuarioLogado, this.pedidoBD);
        }
        
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarMouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnCriarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCriarMouseClicked
        String rua = tfRua.getText();
        int numeroDaCasa = Integer.parseInt((ffNumeroDaCasa.getText().isEmpty()) ? "0" : ffNumeroDaCasa.getText());
        String CEP = ffCEP.getText();
        String bairro = tfBairro.getText();
        String complemento = taComplemento.getText();
        
        Endereco endereco = new Endereco();

        endereco.setBairro(bairro);
        endereco.setCEP(CEP);
        endereco.setComplemento(complemento);
        endereco.setNomeDaRua(rua);
        endereco.setNumeroDaCasa(numeroDaCasa);

        if (endereco.validarDados(endereco)) {
            this.usuarioEnderecoBD.salvarEndereco(endereco, usuarioLogado);
            JOptionPane.showMessageDialog(this, "Endereço cadastrado com sucesso!");
            
            JFrame tela;
        
            if (this.carrinhoDeCompra != null) {
                tela = new TelaDeEndereco(this.usuarioBD, this.carrinhoBD, this.usuarioEnderecoBD, this.usuarioLogado, this.carrinhoDeCompra, this.pedidoBD);
            } else {
                tela = new TelaDeEndereco(this.usuarioBD, this.carrinhoBD, this.usuarioEnderecoBD, this.usuarioLogado, this.pedidoBD);
            }

            tela.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_btnCriarMouseClicked

    private void btnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCriarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDeCadastroDeEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeCadastroDeEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeCadastroDeEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeCadastroDeEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeCadastroDeEndereco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JFormattedTextField ffCEP;
    private javax.swing.JFormattedTextField ffNumeroDaCasa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taComplemento;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfRua;
    // End of variables declaration//GEN-END:variables
}
