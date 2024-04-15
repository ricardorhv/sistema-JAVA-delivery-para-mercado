package model;

public class CarrinhoDeCompra {
    private int idCarrinhoDeCompra;
    private Usuario usuario;
    private float subtotal;
    
    public CarrinhoDeCompra() {
        
    }

    public CarrinhoDeCompra(int idCarrinhoDeCompra, Usuario usuario, float subtotal) {
        this.idCarrinhoDeCompra = idCarrinhoDeCompra;
        this.usuario = usuario;
        this.subtotal = subtotal;
    }
    

    public int getIdCarrinhoDeCompra() {
        return idCarrinhoDeCompra;
    }

    public void setIdCarrinhoDeCompra(int idCarrinhoDeCompra) {
        this.idCarrinhoDeCompra = idCarrinhoDeCompra;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
    
    
}
