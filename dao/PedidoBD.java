package dao;

import java.util.ArrayList;
import java.util.Date;
import model.ItensDoPedido;
import model.Pedido;


public class PedidoBD {
    private ArrayList<Pedido> listaDePedidos;
    private ArrayList<ItensDoPedido> listaDeItensDosPedidos;
    
    public PedidoBD() {
        this.listaDePedidos = new ArrayList<>();
        this.listaDeItensDosPedidos = new ArrayList<>();
    }
    
    public int gerarIdDoPedido() {
        int idDoPedido = this.listaDePedidos.size() + 1;
        
        return idDoPedido;
    }
    
    public int gerarIdDoItensDosPedidos() {
        int idDosItens = this.listaDeItensDosPedidos.size() + 1;
        
        return idDosItens;
    }
    
    public void salvarItensDoPedido(ItensDoPedido itensDoPedido) {
        this.listaDeItensDosPedidos.add(itensDoPedido);
    }
    
    public ArrayList<ItensDoPedido> buscarItensDoPedido(int idDoUsuario, int idDaListaDeItensDoPedido) {
        ArrayList<ItensDoPedido> listaDeItensDestePedido = new ArrayList<>();
        
        for (ItensDoPedido itemDoPedido : this.listaDeItensDosPedidos) {
            if (itemDoPedido.getListaDeItensDoPedido().getUsuario().getIdUsuario() == idDoUsuario && itemDoPedido.getListaDeItensDoPedido().getIdDaListaDeItensDoPedido() == idDaListaDeItensDoPedido) {
                listaDeItensDestePedido.add(itemDoPedido);
            }
        }
        
        return listaDeItensDestePedido;
    }
    
    public int buscarQuantidadeDeItensPorIdDeUsuario(int idDoUsuario, int idDaListaDeItensDoPedido) {
        int quantidadeDeItens = 0;
        
        for (ItensDoPedido itemDoPedido : this.listaDeItensDosPedidos) {
            if (itemDoPedido.getListaDeItensDoPedido().getUsuario().getIdUsuario() == idDoUsuario && itemDoPedido.getListaDeItensDoPedido().getIdDaListaDeItensDoPedido() == idDaListaDeItensDoPedido) {
                quantidadeDeItens++;
            }
        }
        
        return quantidadeDeItens;
    }
    
    public void salvarPedido(Pedido pedido) {
        pedido.setIdPedido(gerarIdDoPedido());
        pedido.setData(new Date());
        this.listaDePedidos.add(pedido);
    }
    
    public ArrayList<Pedido> buscarPedidosPorIdDeUsuario(int idDeUsuario) {
        ArrayList<Pedido> listaDePedidosDoUsuario = new ArrayList<>();
        
        for (Pedido pedido : this.listaDePedidos) {
            if (pedido.getListaDeItensDoPedido().getUsuario().getIdUsuario() == idDeUsuario) {
                pedido.atualizaStatusDoPedido();
                listaDePedidosDoUsuario.add(pedido);
            }
        }
        
        return listaDePedidosDoUsuario;
    }
    
    public Pedido buscarPedidoPorIdDoPedido(int idDoPedido) {
        for (Pedido pedido : this.listaDePedidos) {
            if (pedido.getIdPedido() == idDoPedido) {
                pedido.atualizaStatusDoPedido();
                return pedido;
            }
        }
        
        return null;
    }
}
