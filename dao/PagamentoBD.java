package dao;

import java.util.ArrayList;
import model.Pagamento;


public class PagamentoBD {
    private ArrayList<Pagamento> listaDeFormasDePagamento;
    
    public PagamentoBD() {
        this.listaDeFormasDePagamento = new ArrayList<>();
        
        this.listaDeFormasDePagamento.add(new Pagamento(1, "ativo", "PIX"));
        this.listaDeFormasDePagamento.add(new Pagamento(2, "ativo", "Cartão de crédito"));
        this.listaDeFormasDePagamento.add(new Pagamento(3, "ativo", "Cartão de débito"));
        this.listaDeFormasDePagamento.add(new Pagamento(4, "ativo", "Dinheiro"));
    }
    
    public Pagamento buscarPagamentoPorDescricao(String descricao) {
        for (Pagamento pagamento : this.listaDeFormasDePagamento) {
            if (pagamento.getDescricao().equals(descricao)) {
                return pagamento;
            }
        }
        
        return null;
    }

    public ArrayList<Pagamento> getListaDeFormasDePagamento() {
        return listaDeFormasDePagamento;
    }

    public void setListaDeFormasDePagamento(ArrayList<Pagamento> listaDeFormasDePagamento) {
        this.listaDeFormasDePagamento = listaDeFormasDePagamento;
    }
    
    
}
