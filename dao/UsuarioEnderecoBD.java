package dao;

import java.util.ArrayList;
import model.Endereco;
import model.Usuario;
import model.UsuarioEndereco;

public class UsuarioEnderecoBD {
    private ArrayList<UsuarioEndereco> listaDeEnderecoDoUsuario;
    
    public UsuarioEnderecoBD() {
        this.listaDeEnderecoDoUsuario = new ArrayList<>();
    }
    
    public int gerarIdDeEndereco() {
        int idEndereco = this.listaDeEnderecoDoUsuario.size() + 1;
        
        return idEndereco;
    }
    
    public void salvarEndereco(Endereco endereco, Usuario usuario) {
        endereco.setIdEndereco(gerarIdDeEndereco());
        UsuarioEndereco usuarioEndereco = new UsuarioEndereco(endereco, usuario);
        
        this.listaDeEnderecoDoUsuario.add(usuarioEndereco);
    }
    
    public void removerEndereco(int idDoEndereco, int idDoUsuario) {
        UsuarioEndereco usuarioEnderecoParaSerRemovido = new UsuarioEndereco();
        
        for (UsuarioEndereco usuarioEndereco : this.listaDeEnderecoDoUsuario) {
            if (usuarioEndereco.getEndereco().getIdEndereco() == idDoEndereco && usuarioEndereco.getUsuario().getIdUsuario() == idDoUsuario) {
                usuarioEnderecoParaSerRemovido = usuarioEndereco;
            }
        }
        
        this.listaDeEnderecoDoUsuario.remove(usuarioEnderecoParaSerRemovido);
    }
    
    public ArrayList<UsuarioEndereco> buscarEnderecosDoUsuario(int idDeUsuario) {
        ArrayList<UsuarioEndereco> listaDeEnderecos = new ArrayList<>();
        
        this.listaDeEnderecoDoUsuario.forEach(usuarioEndereco -> {
            if (usuarioEndereco.getUsuario().getIdUsuario() == idDeUsuario) {
                listaDeEnderecos.add(usuarioEndereco);
            }
        });
        
        return listaDeEnderecos;
    }
    
    public Endereco buscarEndereco(int idDoEndereco, int idDoUsuario) {
        Endereco endereco = new Endereco();
        
        for (UsuarioEndereco usuarioEndereco : this.listaDeEnderecoDoUsuario) {
            if (usuarioEndereco.getUsuario().getIdUsuario() == idDoUsuario && usuarioEndereco.getEndereco().getIdEndereco() == idDoEndereco) {
                endereco = usuarioEndereco.getEndereco();
            }
        }
        
        return endereco;
    }
    
    
}
