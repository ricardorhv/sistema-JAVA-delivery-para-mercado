/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.CarrinhoBD;
import dao.PagamentoBD;
import dao.PedidoBD;
import dao.UsuarioBD;
import dao.UsuarioEnderecoBD;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import model.CarrinhoDeCompra;
import model.Endereco;
import model.Itens;
import model.ItensDoPedido;
import model.ListaDeItensDoPedido;
import model.Pagamento;
import model.Pedido;
import model.Usuario;

/**
 *
 * @author ricardorhv
 */
public class TelaDePagamento extends javax.swing.JFrame {
    private PagamentoBD pagamentoBD;
    private ArrayList<Pagamento> listaDeFormasDePagamento;
    private UsuarioBD usuarioBD;
    private CarrinhoBD carrinhoBD;
    private UsuarioEnderecoBD usuarioEnderecoBD;
    private Usuario usuarioLogado;
    private CarrinhoDeCompra carrinhoDeCompra;
    private Endereco enderecoEscolhido;
    private PedidoBD pedidoBD;
    private Pedido pedido;
    private ListaDeItensDoPedido listaDeItensDoPedido;
    
    public TelaDePagamento() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        pagamentoBD = new PagamentoBD();
        this.listaDeFormasDePagamento = this.pagamentoBD.getListaDeFormasDePagamento();
    }
    
    public TelaDePagamento(UsuarioBD usuarioBD, CarrinhoBD carrinhoBD, UsuarioEnderecoBD usuarioEnderecoBD, Usuario usuarioLogado, CarrinhoDeCompra carrinhoDeCompra, Endereco enderecoEscolhido, PedidoBD pedidoBD) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.usuarioBD = usuarioBD;
        this.carrinhoBD = carrinhoBD;
        this.usuarioEnderecoBD = usuarioEnderecoBD;
        this.usuarioLogado = usuarioLogado;
        this.carrinhoDeCompra = carrinhoDeCompra;
        
        this.enderecoEscolhido = enderecoEscolhido;
        this.pedidoBD = pedidoBD;
        
        this.listaDeItensDoPedido = new ListaDeItensDoPedido(this.pedidoBD.gerarIdDoItensDosPedidos(), this.usuarioLogado, this.carrinhoDeCompra.getSubtotal());
        
        this.pedido = new Pedido();
        this.pedido.setListaDeItensDoPedido(this.listaDeItensDoPedido);
        this.pedido.calcularTotal();
        this.pedido.setEndereco(this.enderecoEscolhido);
        
        pagamentoBD = new PagamentoBD();
        this.listaDeFormasDePagamento = this.pagamentoBD.getListaDeFormasDePagamento();
        
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        String total = "R$"+df.format(this.pedido.getTotal());
        String frete = "R$"+df.format(this.pedido.getValorDoFrete());
        
        
        this.lbValorDoFrete.setText(frete);
        this.lbValorTotal.setText(total);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbgFormaDePagamento = new javax.swing.ButtonGroup();
        rbPix = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        rbCartaoDeCredito = new javax.swing.JRadioButton();
        rbCartaoDeDebito = new javax.swing.JRadioButton();
        rbDinheiro = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        lbValorDoFrete = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbValorTotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rbgFormaDePagamento.add(rbPix);
        rbPix.setSelected(true);
        rbPix.setText("PIX");
        rbPix.setName("PIX"); // NOI18N

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel7.setText("Pagamento");

        rbgFormaDePagamento.add(rbCartaoDeCredito);
        rbCartaoDeCredito.setText("Cartão de crédito");
        rbCartaoDeCredito.setName("CARTAO_DE_CREDITO"); // NOI18N
        rbCartaoDeCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCartaoDeCreditoActionPerformed(evt);
            }
        });

        rbgFormaDePagamento.add(rbCartaoDeDebito);
        rbCartaoDeDebito.setText("Cartão de débito");
        rbCartaoDeDebito.setName("CARTAO_DE_DEBITO"); // NOI18N
        rbCartaoDeDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCartaoDeDebitoActionPerformed(evt);
            }
        });

        rbgFormaDePagamento.add(rbDinheiro);
        rbDinheiro.setText("Dinheiro");
        rbDinheiro.setName("DINHEIRO"); // NOI18N
        rbDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDinheiroActionPerformed(evt);
            }
        });

        jLabel1.setText("Frete");

        lbValorDoFrete.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        lbValorDoFrete.setText("valor do frete");

        jLabel3.setText("Total");

        lbValorTotal.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        lbValorTotal.setText("valor total");

        jLabel5.setText("Seleciona uma forma de pagamento");

        btnVoltar.setText("Voltar");
        btnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVoltarMouseClicked(evt);
            }
        });

        btnFinalizar.setForeground(new java.awt.Color(0, 153, 0));
        btnFinalizar.setText("Finalizar");
        btnFinalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFinalizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnFinalizar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(rbPix)
                                            .addGap(18, 18, 18)
                                            .addComponent(rbCartaoDeCredito)
                                            .addGap(18, 18, 18)
                                            .addComponent(rbCartaoDeDebito))
                                        .addComponent(jLabel5))
                                    .addGap(18, 18, 18)
                                    .addComponent(rbDinheiro))
                                .addComponent(btnVoltar)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbValorTotal)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbValorDoFrete))))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(149, 149, 149))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbValorTotal)
                    .addComponent(lbValorDoFrete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbPix)
                    .addComponent(rbCartaoDeCredito)
                    .addComponent(rbCartaoDeDebito)
                    .addComponent(rbDinheiro))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnFinalizar))
                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbCartaoDeCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCartaoDeCreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbCartaoDeCreditoActionPerformed

    private void rbCartaoDeDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCartaoDeDebitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbCartaoDeDebitoActionPerformed

    private void rbDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDinheiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbDinheiroActionPerformed

    private void btnFinalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinalizarMouseClicked
        Pagamento formaDePagamentoSelecionada;
        
        if (this.rbPix.isSelected()) {
            formaDePagamentoSelecionada = this.pagamentoBD.buscarPagamentoPorDescricao("PIX");
        } else if (this.rbCartaoDeCredito.isSelected()) {
            formaDePagamentoSelecionada = this.pagamentoBD.buscarPagamentoPorDescricao("Cartão de crédito");
        } else if (this.rbCartaoDeDebito.isSelected()) {
            formaDePagamentoSelecionada = this.pagamentoBD.buscarPagamentoPorDescricao("Cartão de débito");
        } else {
            formaDePagamentoSelecionada = this.pagamentoBD.buscarPagamentoPorDescricao("Dinheiro");
        }
        
        ArrayList<Itens> listaDeItensDoCarrinho = this.carrinhoBD.buscarItensPorIdDeUsuario(this.usuarioLogado.getIdUsuario());
        
        for (Itens item : listaDeItensDoCarrinho) {
            ItensDoPedido itensDoPedido = new ItensDoPedido(this.listaDeItensDoPedido, item.getProduto(), item.getQuantidadeDeProduto(), item.getSubtotal());
            this.pedidoBD.salvarItensDoPedido(itensDoPedido);
        }
        
        this.pedido.setPagamento(formaDePagamentoSelecionada);
        this.pedidoBD.salvarPedido(this.pedido);
        
        JOptionPane.showMessageDialog(this, "Pedido finalizado com sucesso! Iremos analisar ele e logo iremos confirmar.");
        
        for (Itens item : listaDeItensDoCarrinho) {
            this.carrinhoBD.removerItemDoCarrinho(item);
        }
        
        TelaPrincipal tela = new TelaPrincipal(usuarioBD, usuarioLogado, carrinhoBD, usuarioEnderecoBD, pedidoBD);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnFinalizarMouseClicked

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked
        TelaDeEndereco tela = new TelaDeEndereco(this.usuarioBD, this.carrinhoBD, this.usuarioEnderecoBD, this.usuarioLogado, this.carrinhoDeCompra, this.pedidoBD);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarMouseClicked

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
            java.util.logging.Logger.getLogger(TelaDePagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDePagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDePagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDePagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDePagamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbValorDoFrete;
    private javax.swing.JLabel lbValorTotal;
    private javax.swing.JRadioButton rbCartaoDeCredito;
    private javax.swing.JRadioButton rbCartaoDeDebito;
    private javax.swing.JRadioButton rbDinheiro;
    private javax.swing.JRadioButton rbPix;
    private javax.swing.ButtonGroup rbgFormaDePagamento;
    // End of variables declaration//GEN-END:variables
}
