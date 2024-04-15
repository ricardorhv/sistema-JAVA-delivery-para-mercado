package model;


public class ListaDeItensDoPedido {
    private int idDaListaDeItensDoPedido;
    private Usuario usuario;
    private float subtotal;

    public ListaDeItensDoPedido(int idDaListaDeItensDoPedido, Usuario usuario, float subtotal) {
        this.idDaListaDeItensDoPedido = idDaListaDeItensDoPedido;
        this.usuario = usuario;
        this.subtotal = subtotal;
    }

    public int getIdDaListaDeItensDoPedido() {
        return idDaListaDeItensDoPedido;
    }

    public void setIdDaListaDeItensDoPedido(int idDaListaDeItensDoPedido) {
        this.idDaListaDeItensDoPedido = idDaListaDeItensDoPedido;
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
