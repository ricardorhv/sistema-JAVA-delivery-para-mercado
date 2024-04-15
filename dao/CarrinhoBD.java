package dao;

import java.util.ArrayList;
import model.CarrinhoDeCompra;
import model.Itens;


public class CarrinhoBD {
    private ArrayList<Itens> listaDeItens;
    
    public CarrinhoBD() {
        this.listaDeItens = new ArrayList<>();
    }
    
    public void adicionarItemNoCarrinho(Itens item) {
        int idDeUsuario = item.getCarrinhoDeCompra().getUsuario().getIdUsuario();
        int idDoProduto = item.getProduto().getIdProduto();
        
        Itens itemNoCarrinho = buscarItemEspecificoNoCarrinho(idDeUsuario, idDoProduto);
        
        boolean jaPossuiEsseItemNoCarrinho = itemNoCarrinho != null;
        
        if (jaPossuiEsseItemNoCarrinho) {
            int novaQuantidade = itemNoCarrinho.getQuantidadeDeProduto() + 1;
            itemNoCarrinho.setQuantidadeDeProduto(novaQuantidade);
            itemNoCarrinho.calcularSubtotal();
            
            float subtotalDoCarrinho = itemNoCarrinho.getCarrinhoDeCompra().getSubtotal();
            
            itemNoCarrinho.getCarrinhoDeCompra().setSubtotal(subtotalDoCarrinho + itemNoCarrinho.getProduto().getValorUnitario());
            
            return;
        }
        
        item.calcularSubtotal();
        
        float subtotalDoCarrinho = item.getCarrinhoDeCompra().getSubtotal();
        item.getCarrinhoDeCompra().setSubtotal(subtotalDoCarrinho + item.getProduto().getValorUnitario());
        this.listaDeItens.add(item);
    }
    
    public void removerItemDoCarrinho(Itens itemParaSerRemovido) {
        this.listaDeItens.remove(itemParaSerRemovido);  
    }
    
    public void alterarQuantidadeDoItem(int novaQuantidade, int idDoUsuario, int idDoProduto) {
        Itens item = buscarItemEspecificoNoCarrinho(idDoUsuario, idDoProduto);
        item.setQuantidadeDeProduto(novaQuantidade);
        item.calcularSubtotal();
        
        calcularSubtotalDoCarrinho(idDoUsuario, item.getCarrinhoDeCompra());
    }
    
    public void calcularSubtotalDoCarrinho(int idDeUsuario, CarrinhoDeCompra carrinhoDeCompra) {
        float subtotal = 0;
        
        for (Itens item : this.listaDeItens) {
            if (item.getCarrinhoDeCompra().getUsuario().getIdUsuario() == idDeUsuario) {
                subtotal += item.getSubtotal();
            }
        }
        
        carrinhoDeCompra.setSubtotal(subtotal);
    }
    
    public Itens buscarItemEspecificoNoCarrinho(int idDeUsuario, int idDoProduto) {
        for (Itens item : listaDeItens) {
            if (item.getCarrinhoDeCompra().getUsuario().getIdUsuario() == idDeUsuario) {
                if (item.getProduto().getIdProduto() == idDoProduto) {
                    return item;
                }
            }
        }
        
        return null;
    }
     
    public ArrayList<Itens> buscarItensPorIdDeUsuario(int idDeUsuario) {
        ArrayList<Itens> listaDeItensDesseCarrinho = new ArrayList<>();
        
        listaDeItens.forEach(item -> {
            if (item.getCarrinhoDeCompra().getUsuario().getIdUsuario() == idDeUsuario) {
                listaDeItensDesseCarrinho.add(item);
            }
        });
        
        return listaDeItensDesseCarrinho;
    }
    
    public CarrinhoDeCompra buscarCarrinhoDeCompra(int idDeUsuario) {
        for (Itens item : listaDeItens) {
            if (item.getCarrinhoDeCompra().getUsuario().getIdUsuario() == idDeUsuario) {
                return item.getCarrinhoDeCompra();
            }
        }
        
        return null;
    }
    
    
}
