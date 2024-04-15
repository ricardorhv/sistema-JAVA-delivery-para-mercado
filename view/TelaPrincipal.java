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
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.CarrinhoDeCompra;
import model.Itens;
import model.Produto;
import model.Usuario;

/**
 *
 * @author ricardorhv
 */
public class TelaPrincipal extends javax.swing.JFrame {
    private Usuario usuarioLogado;
    private CarrinhoDeCompra carrinhoDeCompra; 
    
    private UsuarioBD usuarioBD;
    private ProdutoBD produtoBD;
    private CarrinhoBD carrinhoBD;
    private UsuarioEnderecoBD usuarioEnderecoBD;
    private PedidoBD pedidoBD;
    
    
    
    private ArrayList<Produto> listaDeProdutos;
    private ArrayList<String> listaDeCategorias;
    
    
    public TelaPrincipal() {
        initComponents();
        inicializarBancoDeDados();
        
        this.carrinhoDeCompra = new CarrinhoDeCompra();
        this.usuarioEnderecoBD = new UsuarioEnderecoBD();
        this.pedidoBD = new PedidoBD();
        this.listaDeProdutos = this.produtoBD.getListaDeProdutos();
        
        this.setLocationRelativeTo(null);
        
        this.pnMenu.setVisible(false);
        
        this.usuarioLogado = new Usuario();
        this.usuarioLogado.setIdUsuario(1);
        this.usuarioLogado.setNome("Ricardo Vinciguerra");
        this.usuarioLogado.setEmail("ricardo@gmail.com");
        this.usuarioLogado.setTelefone("(44) 99820-2968");
        this.usuarioLogado.setCPF("111.111.111-11");
        this.usuarioLogado.setSenha("123456");
        this.usuarioLogado.setDataDeNascimento(new Date());
        
        this.carrinhoDeCompra.setUsuario(usuarioLogado);
        
        this.listaDeCategorias = new ArrayList<>();
        
        listaDeCategorias.add("Sem filtro");
        
        for (Produto produto : listaDeProdutos) {
            if (!listaDeCategorias.contains(produto.getCategoria())) {
                listaDeCategorias.add(produto.getCategoria());
            }
        }
        
        inicializarTabelaDeProdutos();
        inicializarComboBoxDeCategoria();
    }
    
    public TelaPrincipal(UsuarioBD usuarioBD, Usuario usuarioLogado) {
        initComponents();
        inicializarBancoDeDados();
        
        this.usuarioBD = usuarioBD;
        this.usuarioLogado = usuarioLogado;
        this.usuarioEnderecoBD = new UsuarioEnderecoBD();
        this.carrinhoDeCompra = new CarrinhoDeCompra();
        this.carrinhoDeCompra.setUsuario(this.usuarioLogado);
        this.pedidoBD = new PedidoBD();
        
        this.listaDeProdutos = this.produtoBD.getListaDeProdutos();
        
        this.setLocationRelativeTo(null);
        
        this.pnMenu.setVisible(false);
        
        this.listaDeCategorias = new ArrayList<>();
        
        listaDeCategorias.add("Sem filtro");
        
        for (Produto produto : listaDeProdutos) {
            if (!listaDeCategorias.contains(produto.getCategoria())) {
                listaDeCategorias.add(produto.getCategoria());
            }
        }
        
        inicializarTabelaDeProdutos();
        inicializarComboBoxDeCategoria();
    }
    
    public TelaPrincipal(UsuarioBD usuarioBD, Usuario usuarioLogado, CarrinhoBD carrinhoBD, UsuarioEnderecoBD usuarioEnderecoBD, PedidoBD pedidoBD) {
        initComponents();
        
        this.carrinhoBD = carrinhoBD;
        this.produtoBD = new ProdutoBD();
        this.usuarioBD = usuarioBD;
        this.usuarioEnderecoBD = usuarioEnderecoBD;
        this.usuarioLogado = usuarioLogado;
        this.pedidoBD = pedidoBD;

        this.carrinhoDeCompra = this.carrinhoBD.buscarCarrinhoDeCompra(this.usuarioLogado.getIdUsuario());
        
        if (this.carrinhoDeCompra == null) {
            this.carrinhoDeCompra = new CarrinhoDeCompra();
            this.carrinhoDeCompra.setUsuario(this.usuarioLogado);
        }
        
        this.listaDeProdutos = this.produtoBD.getListaDeProdutos();
        
        this.setLocationRelativeTo(null);
        
        this.pnMenu.setVisible(false);
        
        this.listaDeCategorias = new ArrayList<>();
        
        listaDeCategorias.add("Sem filtro");
        
        for (Produto produto : listaDeProdutos) {
            if (!listaDeCategorias.contains(produto.getCategoria())) {
                listaDeCategorias.add(produto.getCategoria());
            }
        }
        
        inicializarTabelaDeProdutos();
        inicializarComboBoxDeCategoria();
    }
    
    private void inicializarBancoDeDados() {
        this.produtoBD = new ProdutoBD();
        this.carrinhoBD = new CarrinhoBD();
    }
    
    private void inicializarTabelaDeProdutos() {
        String nomeDasColunas[] = {"Nome", "Marca", "Descrição", "Categoria", "Preço"};
        
        
        int quantidadeDeLinhasNaMatriz = this.listaDeProdutos.size();
        int quantidadeDeColunasNaMatriz = nomeDasColunas.length;
        
        String dadosDosProdutos[][] = new String[quantidadeDeLinhasNaMatriz][quantidadeDeColunasNaMatriz];
        
        for (int linha = 0; linha < quantidadeDeLinhasNaMatriz; linha++) {
            dadosDosProdutos[linha][0] = this.listaDeProdutos.get(linha).getNome();
            dadosDosProdutos[linha][1] = this.listaDeProdutos.get(linha).getMarca();
            dadosDosProdutos[linha][2] = this.listaDeProdutos.get(linha).getDescricao();
            dadosDosProdutos[linha][3] = this.listaDeProdutos.get(linha).getCategoria();
            dadosDosProdutos[linha][4] = String.valueOf("R$" + this.listaDeProdutos.get(linha).getValorUnitario());
        }
        
        DefaultTableModel model = new DefaultTableModel(dadosDosProdutos, nomeDasColunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblProdutos.setModel(model);
    }
    
    private void inicializarTabelaDeProdutos(ArrayList<Produto> lista) {
        String nomeDasColunas[] = {"Nome", "Marca", "Descrição", "Categoria", "Preço"};
        
        
        int quantidadeDeLinhasNaMatriz = lista.size();
        int quantidadeDeColunasNaMatriz = nomeDasColunas.length;
        
        String dadosDosProdutos[][] = new String[quantidadeDeLinhasNaMatriz][quantidadeDeColunasNaMatriz];
        
        for (int linha = 0; linha < quantidadeDeLinhasNaMatriz; linha++) {
            dadosDosProdutos[linha][0] = lista.get(linha).getNome();
            dadosDosProdutos[linha][1] = lista.get(linha).getMarca();
            dadosDosProdutos[linha][2] = lista.get(linha).getDescricao();
            dadosDosProdutos[linha][3] = lista.get(linha).getCategoria();
            dadosDosProdutos[linha][4] = String.valueOf("R$" + lista.get(linha).getValorUnitario());
        }
        
        DefaultTableModel model = new DefaultTableModel(dadosDosProdutos, nomeDasColunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblProdutos.setModel(model);
    }
    
    private void inicializarComboBoxDeCategoria() {
        
        
        String categorias[] = new String[this.listaDeCategorias.size()];
        
        for (int i = 0; i < this.listaDeCategorias.size(); i++) {
            categorias[i] = this.listaDeCategorias.get(i);
        }
        
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(categorias);
        cbCategorias.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        tfFiltro = new javax.swing.JTextField();
        cbCategorias = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnMenu = new javax.swing.JButton();
        pnMenu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnPerfil = new javax.swing.JButton();
        btnCarrinho = new javax.swing.JButton();
        btnPedido = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLimparFiltros = new javax.swing.JButton();
        btnAdicionarNoCarrinho = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(204, 0, 102));

        jLabel3.setText("Mercado");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPesquisarMouseClicked(evt);
            }
        });
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        cbCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriasActionPerformed(evt);
            }
        });

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Marca", "Descrição", "Categoria", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
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
        tblProdutos.setGridColor(new java.awt.Color(0, 0, 0));
        tblProdutos.setInheritsPopupMenu(true);
        tblProdutos.setRowHeight(30);
        tblProdutos.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblProdutos.setShowGrid(true);
        tblProdutos.getTableHeader().setResizingAllowed(false);
        tblProdutos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblProdutos);
        if (tblProdutos.getColumnModel().getColumnCount() > 0) {
            tblProdutos.getColumnModel().getColumn(0).setResizable(false);
            tblProdutos.getColumnModel().getColumn(1).setResizable(false);
            tblProdutos.getColumnModel().getColumn(3).setResizable(false);
            tblProdutos.getColumnModel().getColumn(4).setResizable(false);
        }

        btnMenu.setText("Menu");
        btnMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuMouseClicked(evt);
            }
        });

        pnMenu.setBackground(new java.awt.Color(102, 102, 102));
        pnMenu.setForeground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new java.awt.GridLayout(5, 0));

        btnPerfil.setText("Perfil");
        btnPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPerfilMouseClicked(evt);
            }
        });
        jPanel1.add(btnPerfil);

        btnCarrinho.setText("Carrinho");
        btnCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCarrinhoMouseClicked(evt);
            }
        });
        btnCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarrinhoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCarrinho);

        btnPedido.setText("Pedidos");
        btnPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPedidoMouseClicked(evt);
            }
        });
        btnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoActionPerformed(evt);
            }
        });
        jPanel1.add(btnPedido);

        btnSair.setText("Sair");
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSairMouseClicked(evt);
            }
        });
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair);

        btnFechar.setText("X");
        btnFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFecharMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Nome do produto");

        jLabel2.setText("Categoria");

        btnLimparFiltros.setText("Limpar filtros");
        btnLimparFiltros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimparFiltrosMouseClicked(evt);
            }
        });

        btnAdicionarNoCarrinho.setText("Adicionar no carrinho");
        btnAdicionarNoCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdicionarNoCarrinhoMouseClicked(evt);
            }
        });
        btnAdicionarNoCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarNoCarrinhoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Selecione os produtos (Shift + Click do mouse) e clique no botão para adicionar no carrinho");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(765, 765, 765)
                        .addComponent(btnMenu))
                    .addComponent(btnLimparFiltros)
                    .addComponent(btnAdicionarNoCarrinho)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(122, 122, 122)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnPesquisar)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnMenu))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimparFiltros)
                .addGap(2, 2, 2)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdicionarNoCarrinho)
                .addContainerGap(86, Short.MAX_VALUE))
            .addComponent(pnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarrinhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCarrinhoActionPerformed

    private void cbCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoriasActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPedidoActionPerformed

    private void btnMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseClicked
        this.pnMenu.setVisible(!this.pnMenu.isVisible());
    }//GEN-LAST:event_btnMenuMouseClicked

    private void btnFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseClicked
        this.pnMenu.setVisible(false);
    }//GEN-LAST:event_btnFecharMouseClicked

    private void btnPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisarMouseClicked
        String nomeFiltro = tfFiltro.getText();
        String categoriaSelecionada = this.listaDeCategorias.get(cbCategorias.getSelectedIndex());
        ArrayList<Produto> listaDeProdutosFiltrados;
        
        if (nomeFiltro.isEmpty() && cbCategorias.getSelectedIndex() == 0) {
           return;
        } else if (nomeFiltro.isEmpty()) {
            listaDeProdutosFiltrados = this.produtoBD.buscarProdutosPorCategoria(categoriaSelecionada);
        } else if (cbCategorias.getSelectedIndex() == 0) {
            listaDeProdutosFiltrados = produtoBD.buscarProdutosPorNome(nomeFiltro);
        } else {
            listaDeProdutosFiltrados = produtoBD.buscarProdutosPorNomeECategoria(nomeFiltro, categoriaSelecionada);
        }
        
        
        inicializarTabelaDeProdutos(listaDeProdutosFiltrados);
        
    }//GEN-LAST:event_btnPesquisarMouseClicked

    private void btnPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseClicked
        TelaDePerfil tela = new TelaDePerfil(this.usuarioLogado, this.usuarioBD, this.carrinhoBD, this.usuarioEnderecoBD, this.pedidoBD);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPerfilMouseClicked

    private void btnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseClicked
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja sair?", null, JOptionPane.YES_NO_OPTION);
        
        if (opcao == 0) {
            TelaDeLogin tela = new TelaDeLogin(this.usuarioBD, this.carrinhoBD, this.usuarioEnderecoBD, this.pedidoBD);
            tela.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnSairMouseClicked

    private void btnLimparFiltrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparFiltrosMouseClicked
        tfFiltro.setText("");
        cbCategorias.setSelectedIndex(0);
        
        inicializarTabelaDeProdutos();
    }//GEN-LAST:event_btnLimparFiltrosMouseClicked

    private void btnAdicionarNoCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarNoCarrinhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdicionarNoCarrinhoActionPerformed

    private void btnAdicionarNoCarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdicionarNoCarrinhoMouseClicked
        int linhasSelecionadas[] = tblProdutos.getSelectedRows();
        
        if (linhasSelecionadas.length == 0) {
            JOptionPane.showMessageDialog(this, "Você não selecionou nenhum produto!");
            return;
        }
        
        for (int linha : linhasSelecionadas ) {
            String nomeDoProduto =  (String) tblProdutos.getValueAt(linha, 0);
            Produto produto = produtoBD.buscarProdutoPorNome(nomeDoProduto);
            
           
            carrinhoBD.adicionarItemNoCarrinho(new Itens(produto, this.carrinhoDeCompra, 1));
        }
        
        JOptionPane.showMessageDialog(this, "Adicionado no carrinho com sucesso!");
    }//GEN-LAST:event_btnAdicionarNoCarrinhoMouseClicked

    private void btnCarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCarrinhoMouseClicked
        TelaDeCarrinho tela = new TelaDeCarrinho(this.usuarioLogado, this.usuarioBD, this.carrinhoBD, this.carrinhoDeCompra, this.usuarioEnderecoBD, this.pedidoBD);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCarrinhoMouseClicked

    private void btnPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPedidoMouseClicked
        TelaDosPedidos tela = new TelaDosPedidos(usuarioBD, carrinhoBD, usuarioEnderecoBD, usuarioLogado, pedidoBD);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPedidoMouseClicked

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarNoCarrinho;
    private javax.swing.JButton btnCarrinho;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLimparFiltros;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnPedido;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cbCategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
