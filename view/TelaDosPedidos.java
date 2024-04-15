/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.CarrinhoBD;
import dao.PedidoBD;
import dao.UsuarioBD;
import dao.UsuarioEnderecoBD;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CarrinhoDeCompra;
import model.Pedido;
import model.Usuario;
import model.UsuarioEndereco;

/**
 *
 * @author ricardorhv
 */
public class TelaDosPedidos extends javax.swing.JFrame {
    private UsuarioBD usuarioBD;
    private CarrinhoBD carrinhoBD;
    private UsuarioEnderecoBD usuarioEnderecoBD;
    private PedidoBD pedidoBD;
    private Usuario usuarioLogado;
    private ArrayList<Pedido> listaDePedidos;
    
    
    public TelaDosPedidos() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public TelaDosPedidos(UsuarioBD usuarioBD, CarrinhoBD carrinhoBD, UsuarioEnderecoBD usuarioEnderecoBD, Usuario usuarioLogado, PedidoBD pedidoBD) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.usuarioBD = usuarioBD;
        this.carrinhoBD = carrinhoBD;
        this.usuarioEnderecoBD = usuarioEnderecoBD;
        this.usuarioLogado = usuarioLogado;
        this.pedidoBD = pedidoBD;
        
        this.listaDePedidos = this.pedidoBD.buscarPedidosPorIdDeUsuario(this.usuarioLogado.getIdUsuario());
        
        inicializarTabelaDeEnderecos();
    }
    
    private void inicializarTabelaDeEnderecos() {
        String nomeDasColunas[] = {"ID", "Data", "Quant. de itens", "Status", "Total"};
        
        
        int quantidadeDeLinhasNaMatriz = this.listaDePedidos.size();
        int quantidadeDeColunasNaMatriz = nomeDasColunas.length;
        
        Object dadosDosProdutos[][] = new Object[quantidadeDeLinhasNaMatriz][quantidadeDeColunasNaMatriz];
        
        
        for (int linha = 0; linha < quantidadeDeLinhasNaMatriz; linha++) {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String dataFormatada = formato.format(this.listaDePedidos.get(linha).getData());
            
            int quantidadeDeItens = this.pedidoBD.buscarQuantidadeDeItensPorIdDeUsuario(this.usuarioLogado.getIdUsuario(), this.listaDePedidos.get(linha).getListaDeItensDoPedido().getIdDaListaDeItensDoPedido());
            
            dadosDosProdutos[linha][0] = String.valueOf(this.listaDePedidos.get(linha).getIdPedido());
            dadosDosProdutos[linha][1] = dataFormatada;
            dadosDosProdutos[linha][2] = quantidadeDeItens;
            dadosDosProdutos[linha][3] = this.listaDePedidos.get(linha).getStatus().getDescricao();
            dadosDosProdutos[linha][4] = "R$" + this.listaDePedidos.get(linha).getTotal();
        }
        
        
        DefaultTableModel model = new DefaultTableModel(dadosDosProdutos, nomeDasColunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        tblPedidos.setModel(model);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        btnDetalhesDoPedido = new javax.swing.JButton();
        btnAtualizarTabela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "Teste", null, null, null}
            },
            new String [] {
                "ID", "Data ", "Quant. de itens", "Status", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPedidos.setGridColor(new java.awt.Color(0, 0, 0));
        tblPedidos.setInheritsPopupMenu(true);
        tblPedidos.setRowHeight(30);
        tblPedidos.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblPedidos.setShowGrid(true);
        tblPedidos.getTableHeader().setResizingAllowed(false);
        tblPedidos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblPedidos);

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel7.setText("Pedidos");

        btnVoltar.setText("Voltar");
        btnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVoltarMouseClicked(evt);
            }
        });

        btnDetalhesDoPedido.setText("Detalhes do pedido");
        btnDetalhesDoPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDetalhesDoPedidoMouseClicked(evt);
            }
        });

        btnAtualizarTabela.setText("Atualizar tabela");
        btnAtualizarTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtualizarTabelaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVoltar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAtualizarTabela)
                                .addGap(18, 18, 18)
                                .addComponent(btnDetalhesDoPedido))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(jLabel7)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetalhesDoPedido)
                    .addComponent(btnVoltar)
                    .addComponent(btnAtualizarTabela))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked
        TelaPrincipal tela = new TelaPrincipal(usuarioBD, usuarioLogado, carrinhoBD, usuarioEnderecoBD, pedidoBD);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarMouseClicked

    private void btnAtualizarTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtualizarTabelaMouseClicked
        this.listaDePedidos = this.pedidoBD.buscarPedidosPorIdDeUsuario(this.usuarioLogado.getIdUsuario());
        
        inicializarTabelaDeEnderecos();
    }//GEN-LAST:event_btnAtualizarTabelaMouseClicked

    private void btnDetalhesDoPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetalhesDoPedidoMouseClicked
        int linhaSelecionada = this.tblPedidos.getSelectedRow();
        
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um pedido para visualizar os detalhes!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String idDoPedido = (String) this.tblPedidos.getValueAt(linhaSelecionada, 0);
        Pedido pedidoSelecionado = this.pedidoBD.buscarPedidoPorIdDoPedido(Integer.parseInt(idDoPedido));
        
        TelaDeDetalhesDoPedido tela = new TelaDeDetalhesDoPedido(usuarioBD, carrinhoBD, usuarioEnderecoBD, usuarioLogado, pedidoBD, pedidoSelecionado);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDetalhesDoPedidoMouseClicked

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
            java.util.logging.Logger.getLogger(TelaDosPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDosPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDosPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDosPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDosPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizarTabela;
    private javax.swing.JButton btnDetalhesDoPedido;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblPedidos;
    // End of variables declaration//GEN-END:variables
}
