package model;

public class UsuarioEndereco {
    private Endereco endereco;
    private Usuario usuario;
    
    public UsuarioEndereco() {
        
    }
    
    public UsuarioEndereco(Endereco endereco, Usuario usuario) {
        this.endereco = endereco;
        this.usuario = usuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
