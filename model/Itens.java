package model;

public class Itens {
    private Produto produto;
    private CarrinhoDeCompra carrinhoDeCompra;
    private int quantidadeDeProduto;
    private float subtotal;

    public Itens(Produto produto, CarrinhoDeCompra carrinhoDeCompra, int quantidadeDeProduto) {
        this.produto = produto;
        this.carrinhoDeCompra = carrinhoDeCompra;
        this.quantidadeDeProduto = quantidadeDeProduto;
    }
    
    public void calcularSubtotal() {
        this.subtotal = this.quantidadeDeProduto * this.produto.getValorUnitario();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public CarrinhoDeCompra getCarrinhoDeCompra() {
        return carrinhoDeCompra;
    }

    public void setCarrinhoDeCompra(CarrinhoDeCompra carrinhoDeCompra) {
        this.carrinhoDeCompra = carrinhoDeCompra;
    }

    public int getQuantidadeDeProduto() {
        return quantidadeDeProduto;
    }

    public void setQuantidadeDeProduto(int quantidadeDeProduto) {
        this.quantidadeDeProduto = quantidadeDeProduto;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
    
    
}
