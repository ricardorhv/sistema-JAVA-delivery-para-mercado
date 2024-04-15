package model;

import defaultValues.EStatusDoPedido;
import static defaultValues.EStatusDoPedido.PEDIDO_CONFIRMADO;
import java.util.Date;

public class Pedido {
    private int idPedido;
    private final float valorDoFrete = 15;
    private float total;
    private EStatusDoPedido status;
    private Date data;
    private Pagamento pagamento;
    private Endereco endereco;
    private ListaDeItensDoPedido listaDeItensDoPedido;
    
    public Pedido() {
        this.status = EStatusDoPedido.EM_ANALISE;
    }

    public Pedido(int idPedido, float total, String status, Date data, Pagamento pagamento, ListaDeItensDoPedido listaDeItensDoPedido) {
        this.idPedido = idPedido;
        this.total = total;
        this.status = EStatusDoPedido.EM_ANALISE;
        this.data = data;
        this.pagamento = pagamento;
        this.listaDeItensDoPedido = listaDeItensDoPedido;
    }
    
    public void atualizaStatusDoPedido() {
        switch(this.status) {
            case EM_ANALISE -> {
                //1 minuto para confirmar
                Date dataDoPedidoMaisUmMinuto = new Date(this.data.getTime() + (60 * 1000));
                if (new Date().after(dataDoPedidoMaisUmMinuto)) {
                    this.status = EStatusDoPedido.PEDIDO_CONFIRMADO;
                }
            }
            case PEDIDO_CONFIRMADO -> {
                //1 minuto da análise + 2 minutos para confirmar
                Date dataDoPedidoMaisTresMinutos = new Date(this.data.getTime() + ((60 * 3) * 1000));
                if (new Date().after(dataDoPedidoMaisTresMinutos)) {
                    this.status = EStatusDoPedido.PREPARANDO;
                }
            }
            case PREPARANDO -> {
                //3 minutos para confirmar e analisar + 30 minutos para preparar
                Date dataDoPedidoMaisTrintaETresMinutos = new Date(this.data.getTime() + ((60 * 33) * 1000));
                if (new Date().after(dataDoPedidoMaisTrintaETresMinutos)) {
                    this.status = EStatusDoPedido.SAIU_PARA_ENTREGA;
                }
            }
            case SAIU_PARA_ENTREGA -> {
                //33 minutos para confirmar, analisar e preparar + 15 minutos para entregar
                Date dataDoPedidoMaisQuarentaEOitoMinutos = new Date(this.data.getTime() + ((60 * 48) * 1000));
                if (new Date().after(dataDoPedidoMaisQuarentaEOitoMinutos)) {
                    this.status = EStatusDoPedido.ENTREGUE;
                }
            }
        }

    }
    
    public void calcularTotal() {
        this.total = this.listaDeItensDoPedido.getSubtotal() + this.valorDoFrete;
    }

    public ListaDeItensDoPedido getListaDeItensDoPedido() {
        return listaDeItensDoPedido;
    }

    public void setListaDeItensDoPedido(ListaDeItensDoPedido listaDeItensDoPedido) {
        this.listaDeItensDoPedido = listaDeItensDoPedido;
    }
    
    

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public EStatusDoPedido getStatus() {
        return status;
    }

    public void setStatus(EStatusDoPedido status) {
        this.status = status;
    }
    
    

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public float getValorDoFrete() {
        return valorDoFrete;
    }
    
    
    
    
}
