/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.CarrinhoBD;
import dao.PedidoBD;
import dao.ProdutoBD;
import dao.UsuarioBD;
import dao.UsuarioEnderecoBD;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CarrinhoDeCompra;
import model.Itens;
import model.Produto;
import model.Usuario;

/**
 *
 * @author ricardorhv
 */
public class TelaDeCarrinho extends javax.swing.JFrame {
    private Usuario usuarioLogado;
    private CarrinhoBD carrinhoBD;
    private UsuarioBD usuarioBD;
    private UsuarioEnderecoBD usuarioEnderecoBD;
    private ProdutoBD produtoBD;
    private ArrayList<Itens> listaDeItens;
    private CarrinhoDeCompra carrinhoDeCompra;
    private PedidoBD pedidoBD;
    
    
    public TelaDeCarrinho() {
        initComponents();
        this.listaDeItens = new ArrayList<>();
        
        this.setLocationRelativeTo(null);
    }
    
    public TelaDeCarrinho(Usuario usuarioLogado, UsuarioBD usuarioBD, CarrinhoBD carrinhoBD, CarrinhoDeCompra carrinhoDeCompra, UsuarioEnderecoBD usuarioEnderecoBD, PedidoBD pedidoBD) {
        this.usuarioLogado = usuarioLogado;
        this.carrinhoBD = carrinhoBD;
        this.usuarioBD = usuarioBD;
        this.carrinhoDeCompra = carrinhoDeCompra;
        this.produtoBD = new ProdutoBD();
        this.usuarioEnderecoBD = usuarioEnderecoBD;
        this.pedidoBD = pedidoBD;
        
        this.listaDeItens = carrinhoBD.buscarItensPorIdDeUsuario(usuarioLogado.getIdUsuario());
        
        
        
        initComponents();
        this.setLocationRelativeTo(null);
        
        inicializarTabelaDeProdutos();
    }
    
    private void inicializarTabelaDeProdutos() {
        String nomeDasColunas[] = {"Nome", "Marca", "Descrição", "Categoria", "Valor unitário", "Quantidade", "Subtotal"};
        
        
        int quantidadeDeLinhasNaMatriz = this.listaDeItens.size();
        int quantidadeDeColunasNaMatriz = nomeDasColunas.length;
        
        Object dadosDosProdutos[][] = new Object[quantidadeDeLinhasNaMatriz][quantidadeDeColunasNaMatriz];
        
        for (int linha = 0; linha < quantidadeDeLinhasNaMatriz; linha++) {
            dadosDosProdutos[linha][0] = this.listaDeItens.get(linha).getProduto().getNome();
            dadosDosProdutos[linha][1] = this.listaDeItens.get(linha).getProduto().getMarca();
            dadosDosProdutos[linha][2] = this.listaDeItens.get(linha).getProduto().getDescricao();
            dadosDosProdutos[linha][3] = this.listaDeItens.get(linha).getProduto().getCategoria();
            dadosDosProdutos[linha][4] = "R$"+ String.valueOf(this.listaDeItens.get(linha).getProduto().getValorUnitario());
            dadosDosProdutos[linha][5] = this.listaDeItens.get(linha).getQuantidadeDeProduto();
            dadosDosProdutos[linha][6] = "R$"+ String.valueOf(this.listaDeItens.get(linha).getSubtotal());
        }
        
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        String total = "R$"+df.format(this.carrinhoDeCompra.getSubtotal());
        
        lbTotal.setText(total);
        
        DefaultTableModel model = new DefaultTableModel(dadosDosProdutos, nomeDasColunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5;
            }
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 5) {
                    return Integer.class;
                }
                
                return Object.class;
            }
        };
        tblCarrinho.setModel(model);
    }
    
    private void inicializarTabelaDeProdutos(ArrayList<Itens> lista) {
        String nomeDasColunas[] = {"Nome", "Marca", "Descrição", "Categoria", "Valor unitário", "Quantidade", "Subtotal"};
        
        
        int quantidadeDeLinhasNaMatriz = lista.size();
        int quantidadeDeColunasNaMatriz = nomeDasColunas.length;
        
        Object dadosDosProdutos[][] = new Object[quantidadeDeLinhasNaMatriz][quantidadeDeColunasNaMatriz];
        
        for (int linha = 0; linha < quantidadeDeLinhasNaMatriz; linha++) {
            dadosDosProdutos[linha][0] = lista.get(linha).getProduto().getNome();
            dadosDosProdutos[linha][1] = lista.get(linha).getProduto().getMarca();
            dadosDosProdutos[linha][2] = lista.get(linha).getProduto().getDescricao();
            dadosDosProdutos[linha][3] = lista.get(linha).getProduto().getCategoria();
            dadosDosProdutos[linha][4] = "R$"+ String.valueOf(this.listaDeItens.get(linha).getProduto().getValorUnitario());
            dadosDosProdutos[linha][5] = lista.get(linha).getQuantidadeDeProduto();
            dadosDosProdutos[linha][6] = "R$"+ String.valueOf(lista.get(linha).getSubtotal());
        }
        
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        String total = "R$"+df.format(this.carrinhoDeCompra.getSubtotal());
        
        lbTotal.setText(total);
        
        DefaultTableModel model = new DefaultTableModel(dadosDosProdutos, nomeDasColunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblCarrinho.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarrinho = new javax.swing.JTable();
        btnRemover = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();
        lbTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 0, 32)); // NOI18N
        jLabel7.setText("Meu carrinho");

        tblCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Teste", null, null, "", null,  new Integer(1), null}
            },
            new String [] {
                "Nome", "Marca", "Descrição", "Categoria", "Valor unitário", "Quantidade", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCarrinho.setGridColor(new java.awt.Color(0, 0, 0));
        tblCarrinho.setInheritsPopupMenu(true);
        tblCarrinho.setRowHeight(30);
        tblCarrinho.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblCarrinho.setShowGrid(true);
        tblCarrinho.getTableHeader().setResizingAllowed(false);
        tblCarrinho.getTableHeader().setReorderingAllowed(false);
        tblCarrinho.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblCarrinhoPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tblCarrinho);

        btnRemover.setForeground(new java.awt.Color(204, 0, 0));
        btnRemover.setText("Remover");
        btnRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoverMouseClicked(evt);
            }
        });
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVoltarMouseClicked(evt);
            }
        });

        btnContinuar.setForeground(new java.awt.Color(0, 204, 0));
        btnContinuar.setText("Continuar");
        btnContinuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnContinuarMouseClicked(evt);
            }
        });
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        lbTotal.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        lbTotal.setText("Total: R$100,00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 450, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(454, 454, 454))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTotal)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnVoltar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRemover)
                            .addGap(46, 46, 46)
                            .addComponent(btnContinuar))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 981, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel7)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(lbTotal)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnRemover)
                    .addComponent(btnContinuar))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void tblCarrinhoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblCarrinhoPropertyChange
        int linhaSelecionada = this.tblCarrinho.getSelectedRow();
        
        if (linhaSelecionada > -1) {
            Object valorDaColunaQuantidade = this.tblCarrinho.getValueAt(linhaSelecionada, 5);
            String nomeDoProduto = (String) this.tblCarrinho.getValueAt(linhaSelecionada, 0);
            Produto produto = this.produtoBD.buscarProdutoPorNome(nomeDoProduto);
            Itens item = this.carrinhoBD.buscarItemEspecificoNoCarrinho(this.usuarioLogado.getIdUsuario(), produto.getIdProduto());
            
            
            if (valorDaColunaQuantidade == null) {
                this.tblCarrinho.getModel().setValueAt(item.getQuantidadeDeProduto(), linhaSelecionada, 5);
                return;
            }
            
            int novaQuantidade = (int) this.tblCarrinho.getValueAt(linhaSelecionada, 5);
            
            
            if (novaQuantidade != item.getQuantidadeDeProduto()) {
                this.carrinhoBD.alterarQuantidadeDoItem(novaQuantidade, this.usuarioLogado.getIdUsuario(), produto.getIdProduto());

                this.listaDeItens = this.carrinhoBD.buscarItensPorIdDeUsuario(this.usuarioLogado.getIdUsuario());

                inicializarTabelaDeProdutos();
            }
        }
        
    }//GEN-LAST:event_tblCarrinhoPropertyChange

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked
        TelaPrincipal tela = new TelaPrincipal(this.usuarioBD, this.usuarioLogado, this.carrinhoBD, this.usuarioEnderecoBD, this.pedidoBD);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarMouseClicked

    private void btnRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverMouseClicked
        int linhasSelecionadas[] = tblCarrinho.getSelectedRows();
        
        if (linhasSelecionadas.length == 0) {
            JOptionPane.showMessageDialog(this, "Você não selecionou nenhum produto!");
            return;
        }
        
        for (int linha : linhasSelecionadas ) {
            String nomeDoProduto =  (String) tblCarrinho.getValueAt(linha, 0);
            Produto produto = produtoBD.buscarProdutoPorNome(nomeDoProduto);
            int idDoProduto = produto.getIdProduto();
            Itens item = carrinhoBD.buscarItemEspecificoNoCarrinho(this.usuarioLogado.getIdUsuario(), idDoProduto);
            
           
            carrinhoBD.removerItemDoCarrinho(item);
        }
        
        this.carrinhoBD.calcularSubtotalDoCarrinho(this.usuarioLogado.getIdUsuario(), this.carrinhoDeCompra);
        
        this.listaDeItens = carrinhoBD.buscarItensPorIdDeUsuario(this.usuarioLogado.getIdUsuario());
        
        inicializarTabelaDeProdutos();
        
        JOptionPane.showMessageDialog(this, "Removido do carrinho com sucesso!");
    }//GEN-LAST:event_btnRemoverMouseClicked

    private void btnContinuarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContinuarMouseClicked
        if (this.carrinhoDeCompra.getSubtotal() == 0) {
            JOptionPane.showMessageDialog(this, "Você não possui nenhum item no carrinho!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        TelaDeEndereco tela = new TelaDeEndereco(this.usuarioBD, this.carrinhoBD, this.usuarioEnderecoBD, this.usuarioLogado, this.carrinhoDeCompra, this.pedidoBD);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnContinuarMouseClicked

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
            java.util.logging.Logger.getLogger(TelaDeCarrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeCarrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeCarrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeCarrinho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeCarrinho().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JTable tblCarrinho;
    // End of variables declaration//GEN-END:variables
}
