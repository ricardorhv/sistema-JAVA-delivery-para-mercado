/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.CarrinhoBD;
import dao.PedidoBD;
import dao.UsuarioBD;
import dao.UsuarioEnderecoBD;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CarrinhoDeCompra;
import model.Endereco;
import model.Usuario;
import model.UsuarioEndereco;

/**
 *
 * @author ricardorhv
 */
public class TelaDeEndereco extends javax.swing.JFrame {

    private UsuarioBD usuarioBD;
    private CarrinhoBD carrinhoBD;
    private UsuarioEnderecoBD usuarioEnderecoBD;
    private Usuario usuarioLogado;
    private CarrinhoDeCompra carrinhoDeCompra;
    private ArrayList<UsuarioEndereco> listaDeEndereco;
    private PedidoBD pedidoBD;
    
    public TelaDeEndereco() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        this.usuarioBD = new UsuarioBD();
        this.carrinhoBD = new CarrinhoBD();
        this.usuarioEnderecoBD = new UsuarioEnderecoBD();
        this.usuarioLogado = new Usuario();
        this.pedidoBD = new PedidoBD();
        
        
        this.btnContinuar.setVisible(false);
        this.lbInformacao.setVisible(false);
        
        this.usuarioLogado.setIdUsuario(1);
        this.usuarioLogado.setNome("Ricardo Vinciguerra");
        this.usuarioLogado.setEmail("ricardo@gmail.com");
        this.usuarioLogado.setTelefone("(44) 99820-2968");
        this.usuarioLogado.setCPF("111.111.111-11");
        this.usuarioLogado.setSenha("123456");
        this.usuarioLogado.setDataDeNascimento(new Date());
        
        Endereco endereco = new Endereco();
        endereco.setNomeDaRua("Teste");
        
        this.usuarioEnderecoBD.salvarEndereco(endereco, usuarioLogado);
        
        listaDeEndereco = this.usuarioEnderecoBD.buscarEnderecosDoUsuario(this.usuarioLogado.getIdUsuario());
        
        inicializarTabelaDeEnderecos();
    }
    
    public TelaDeEndereco(UsuarioBD usuarioBD, CarrinhoBD carrinhoBD, UsuarioEnderecoBD usuarioEnderecoBD, Usuario usuarioLogado, PedidoBD pedidoBD) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.usuarioBD = usuarioBD;
        this.carrinhoBD = carrinhoBD;
        this.usuarioEnderecoBD = usuarioEnderecoBD;
        this.usuarioLogado = usuarioLogado;
        this.pedidoBD = pedidoBD;
        
        this.listaDeEndereco = this.usuarioEnderecoBD.buscarEnderecosDoUsuario(this.usuarioLogado.getIdUsuario());
        
        this.btnContinuar.setVisible(false);
        this.lbInformacao.setVisible(false);
        
        inicializarTabelaDeEnderecos();
    }
    
    public TelaDeEndereco(UsuarioBD usuarioBD, CarrinhoBD carrinhoBD, UsuarioEnderecoBD usuarioEnderecoBD, Usuario usuarioLogado, CarrinhoDeCompra carrinhoDeCompra, PedidoBD pedidoBD) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.usuarioBD = usuarioBD;
        this.carrinhoBD = carrinhoBD;
        this.usuarioEnderecoBD = usuarioEnderecoBD;
        this.usuarioLogado = usuarioLogado;
        this.carrinhoDeCompra = carrinhoDeCompra;
        this.pedidoBD = pedidoBD;
        
        this.listaDeEndereco = this.usuarioEnderecoBD.buscarEnderecosDoUsuario(this.usuarioLogado.getIdUsuario());
        
        this.btnContinuar.setVisible(true);
        this.lbInformacao.setVisible(true);
        
        inicializarTabelaDeEnderecos();
    }
    
    private void inicializarTabelaDeEnderecos() {
        String nomeDasColunas[] = {"ID", "Rua", "Bairro", "Número", "CEP", "Complemento"};
        
        
        int quantidadeDeLinhasNaMatriz = this.listaDeEndereco.size();
        int quantidadeDeColunasNaMatriz = nomeDasColunas.length;
        
        Object dadosDosProdutos[][] = new Object[quantidadeDeLinhasNaMatriz][quantidadeDeColunasNaMatriz];
        
        for (int linha = 0; linha < quantidadeDeLinhasNaMatriz; linha++) {
            dadosDosProdutos[linha][0] = String.valueOf(this.listaDeEndereco.get(linha).getEndereco().getIdEndereco());
            dadosDosProdutos[linha][1] = this.listaDeEndereco.get(linha).getEndereco().getNomeDaRua();
            dadosDosProdutos[linha][2] = this.listaDeEndereco.get(linha).getEndereco().getBairro();
            dadosDosProdutos[linha][3] = this.listaDeEndereco.get(linha).getEndereco().getNumeroDaCasa();
            dadosDosProdutos[linha][4] = this.listaDeEndereco.get(linha).getEndereco().getCEP();
            dadosDosProdutos[linha][5] = this.listaDeEndereco.get(linha).getEndereco().getComplemento();
        }
        
        
        DefaultTableModel model = new DefaultTableModel(dadosDosProdutos, nomeDasColunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        tblEnderecos.setModel(model);
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
        btnVoltar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();
        btnAdicionarEndereco = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEnderecos = new javax.swing.JTable();
        lbInformacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel7.setText("Endereços");

        btnVoltar.setText("Voltar");
        btnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVoltarMouseClicked(evt);
            }
        });

        btnRemover.setForeground(new java.awt.Color(204, 0, 0));
        btnRemover.setText("Remover");
        btnRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoverMouseClicked(evt);
            }
        });

        btnContinuar.setForeground(new java.awt.Color(0, 204, 0));
        btnContinuar.setText("Continuar");
        btnContinuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnContinuarMouseClicked(evt);
            }
        });

        btnAdicionarEndereco.setText("Adicionar endereço");
        btnAdicionarEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdicionarEnderecoMouseClicked(evt);
            }
        });

        tblEnderecos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "Teste", null, null, "", null}
            },
            new String [] {
                "ID", "Rua", "Bairro", "Número", "CEP", "Complemento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEnderecos.setGridColor(new java.awt.Color(0, 0, 0));
        tblEnderecos.setInheritsPopupMenu(true);
        tblEnderecos.setRowHeight(30);
        tblEnderecos.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblEnderecos.setShowGrid(true);
        tblEnderecos.getTableHeader().setResizingAllowed(false);
        tblEnderecos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblEnderecos);
        if (tblEnderecos.getColumnModel().getColumnCount() > 0) {
            tblEnderecos.getColumnModel().getColumn(1).setResizable(false);
            tblEnderecos.getColumnModel().getColumn(2).setResizable(false);
            tblEnderecos.getColumnModel().getColumn(3).setResizable(false);
            tblEnderecos.getColumnModel().getColumn(4).setResizable(false);
            tblEnderecos.getColumnModel().getColumn(5).setResizable(false);
        }

        lbInformacao.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        lbInformacao.setForeground(new java.awt.Color(102, 102, 102));
        lbInformacao.setText("Selecione um endereço e clique em continuar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbInformacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(356, 356, 356))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVoltar)
                                .addGap(41, 41, 41)
                                .addComponent(btnAdicionarEndereco)
                                .addGap(307, 307, 307)
                                .addComponent(btnRemover)
                                .addGap(29, 29, 29)
                                .addComponent(btnContinuar)))
                        .addContainerGap(54, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbInformacao)
                        .addGap(7, 7, 7)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnRemover)
                    .addComponent(btnAdicionarEndereco)
                    .addComponent(btnContinuar))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarEnderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdicionarEnderecoMouseClicked
        TelaDeCadastroDeEndereco tela = new TelaDeCadastroDeEndereco(this.usuarioBD, this.carrinhoBD, this.usuarioLogado, this.usuarioEnderecoBD, this.carrinhoDeCompra, this.pedidoBD);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdicionarEnderecoMouseClicked

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked
        JFrame tela;
        
        if (this.carrinhoDeCompra != null) {
            tela = new TelaDeCarrinho(this.usuarioLogado, this.usuarioBD, this.carrinhoBD, this.carrinhoDeCompra, this.usuarioEnderecoBD, this.pedidoBD);
        } else {
            tela = new TelaPrincipal(this.usuarioBD, this.usuarioLogado, this.carrinhoBD, this.usuarioEnderecoBD, this.pedidoBD);
        }
        
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarMouseClicked

    private void btnRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoverMouseClicked
        int linhasSelecionadas[] = this.tblEnderecos.getSelectedRows();
        
        if (linhasSelecionadas.length == 0) {
            JOptionPane.showMessageDialog(this, "Selecione um endereço para ser removido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        for (int linhaSelecionada : linhasSelecionadas) {
            String idDoEndereco = (String) this.tblEnderecos.getValueAt(linhaSelecionada, 0);
            this.usuarioEnderecoBD.removerEndereco(Integer.parseInt(idDoEndereco), this.usuarioLogado.getIdUsuario());
        }
        
        JOptionPane.showMessageDialog(this, "Removido com sucesso!");
        this.listaDeEndereco = this.usuarioEnderecoBD.buscarEnderecosDoUsuario(this.usuarioLogado.getIdUsuario());
        
        inicializarTabelaDeEnderecos();
    }//GEN-LAST:event_btnRemoverMouseClicked

    private void btnContinuarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContinuarMouseClicked
        int linhaSelecionada = this.tblEnderecos.getSelectedRow();
        
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um endereço para continuar!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String idDoEndereco = (String) this.tblEnderecos.getValueAt(linhaSelecionada, 0);
        Endereco enderecoEscolhido = this.usuarioEnderecoBD.buscarEndereco(Integer.parseInt(idDoEndereco), this.usuarioLogado.getIdUsuario());
        
        TelaDePagamento tela = new TelaDePagamento(this.usuarioBD, this.carrinhoBD, this.usuarioEnderecoBD, this.usuarioLogado, this.carrinhoDeCompra, enderecoEscolhido, this.pedidoBD);
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
            java.util.logging.Logger.getLogger(TelaDeEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeEndereco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarEndereco;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbInformacao;
    private javax.swing.JTable tblEnderecos;
    // End of variables declaration//GEN-END:variables
}
