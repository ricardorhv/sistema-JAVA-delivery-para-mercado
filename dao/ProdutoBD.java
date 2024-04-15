package dao;

import java.util.ArrayList;
import java.util.Date;
import model.Produto;

public class ProdutoBD {
    private ArrayList<Produto> listaDeProdutos;
    
    public ProdutoBD() {
        listaDeProdutos = new ArrayList<>();
        
        //Inicializar a lista com os produtos
        listaDeProdutos.add(new Produto(gerarIdDoProduto(), "Chocolate ao Leite", "Delicioso chocolate cremoso", "Alimento", "Nestlé", 50, new Date(2024, 4, 11), new Date(2025, 12, 31), 5.99f));
        listaDeProdutos.add(new Produto(gerarIdDoProduto(), "Arroz Integral", "Arroz integral orgânico", "Alimento", "Tio João", 100, new Date(2024, 3, 20), new Date(2025, 10, 31), 3.49f));
        listaDeProdutos.add(new Produto(gerarIdDoProduto(), "Feijão Preto", "Feijão preto de alta qualidade", "Alimento", "Camil", 80, new Date(2024, 2, 15), new Date(2025, 9, 30), 4.79f));
        listaDeProdutos.add(new Produto(gerarIdDoProduto(), "Macarrão Espaguete", "Macarrão longo e fino", "Alimento", "Adria", 120, new Date(2024, 1, 10), new Date(2025, 8, 30), 2.29f));
        listaDeProdutos.add(new Produto(gerarIdDoProduto(), "Leite em Pó", "Leite em pó integral", "Alimento", "Itambé", 60, new Date(2024, 4, 5), new Date(2025, 11, 30), 6.99f));
        listaDeProdutos.add(new Produto(gerarIdDoProduto(), "Sabonete Líquido", "Sabonete líquido suave", "Higiene", "Dove", 40, new Date(2024, 3, 2), new Date(2025, 12, 31), 7.49f));
        listaDeProdutos.add(new Produto(gerarIdDoProduto(), "Detergente Multiuso", "Detergente para limpeza geral", "Limpeza", "Ypê", 90, new Date(2024, 2, 25), new Date(2025, 11, 30), 2.99f));
        listaDeProdutos.add(new Produto(gerarIdDoProduto(), "Shampoo Revitalizante", "Shampoo para cabelos danificados", "Higiene", "Pantene", 70, new Date(2024, 1, 20), new Date(2025, 10, 31), 8.99f));
        listaDeProdutos.add(new Produto(gerarIdDoProduto(), "Pasta de Dente Branqueadora", "Pasta de dente para dentes brancos", "Higiene", "Colgate", 50, new Date(2024, 4, 1), new Date(2025, 9, 30), 4.29f));
        listaDeProdutos.add(new Produto(gerarIdDoProduto(), "Desinfetante Floral", "Desinfetante com aroma floral", "Limpeza", "Veja", 80, new Date(2024, 3, 10), new Date(2025, 10, 31), 5.49f));
    }
    
    private int gerarIdDoProduto() {
        int idProduto = this.listaDeProdutos.size() + 1;
        
        return idProduto;
    }
    
    public ArrayList<Produto> buscarProdutosPorNome(String nome) {
        ArrayList<Produto> listaDeProdutosFiltrados = new ArrayList<>();
        
        this.listaDeProdutos.forEach(produto -> {
            if (produto.getNome().toLowerCase().contains(nome.toLowerCase())) {
                listaDeProdutosFiltrados.add(produto);
            }
        });
        
        return listaDeProdutosFiltrados;
    }
    
    public ArrayList<Produto> buscarProdutosPorNomeECategoria(String nome, String categoria) {
        ArrayList<Produto> listaDeProdutosFiltrados = new ArrayList<>();
        
        this.listaDeProdutos.forEach(produto -> {
            if (produto.getNome().toLowerCase().contains(nome.toLowerCase()) && produto.getCategoria().equals(categoria)) {
                listaDeProdutosFiltrados.add(produto);
            }
        });
        
        return listaDeProdutosFiltrados;
    }
    
    public ArrayList<Produto> buscarProdutosPorCategoria(String categoria) {
        ArrayList<Produto> listaDeProdutosFiltrados = new ArrayList<>();
        
        this.listaDeProdutos.forEach(produto -> {
            if (produto.getCategoria().equals(categoria)) {
                listaDeProdutosFiltrados.add(produto);
            }
        });
        
        return listaDeProdutosFiltrados;
    }
    
    public Produto buscarProdutoPorNome(String nome) {
        Produto produtoSelecionado = new Produto();
        
        for (Produto produto : listaDeProdutos) {
            if (produto.getNome().toLowerCase().equals(nome.toLowerCase())) {
                produtoSelecionado = produto;
            }
        }
        
        return produtoSelecionado;
    }

    public ArrayList<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }
    
    
}
