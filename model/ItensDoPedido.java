package model;

public class ItensDoPedido {
    private ListaDeItensDoPedido listaDeItensDoPedido;
    private Produto produto;
    private int quantidade;
    private float subtotal;

    public ItensDoPedido(ListaDeItensDoPedido listaDeItensDoPedido, Produto produto, int quantidade, float subtotal) {
        this.listaDeItensDoPedido = listaDeItensDoPedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
    }

    public ListaDeItensDoPedido getListaDeItensDoPedido() {
        return listaDeItensDoPedido;
    }

    public void setListaDeItensDoPedido(ListaDeItensDoPedido listaDeItensDoPedido) {
        this.listaDeItensDoPedido = listaDeItensDoPedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
    
    
}
