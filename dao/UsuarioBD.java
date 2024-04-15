package dao;

import java.util.ArrayList;
import model.Usuario;

public class UsuarioBD {
    ArrayList<Usuario> listaDeUsuarios;
    
    public UsuarioBD() {
        listaDeUsuarios = new ArrayList<>();
    }

    public ArrayList<Usuario> getListaDeUsuarios() {
        return listaDeUsuarios;
    }

    public void setListaDeUsuarios(ArrayList<Usuario> listaDeUsuarios) {
        this.listaDeUsuarios = listaDeUsuarios;
    }
    
    public int gerarIdDeUsuario() {
        int idUsuario = this.listaDeUsuarios.size() + 1;
        
        return idUsuario;
    }
    
    public void salvarUsuario(Usuario usuario) {
        usuario.setIdUsuario(gerarIdDeUsuario());
        this.listaDeUsuarios.add(usuario);
    }
    
    public void alterarUsuario(int idDeUsuario, Usuario usuarioAlterado) {
        for (Usuario usuario : listaDeUsuarios) {
            if (usuario.getIdUsuario() == idDeUsuario) {
                usuario.setNome(usuarioAlterado.getNome());
                usuario.setCPF(usuarioAlterado.getCPF());
                usuario.setDataDeNascimento(usuarioAlterado.getDataDeNascimento());
                usuario.setEmail(usuarioAlterado.getEmail());
                usuario.setTelefone(usuarioAlterado.getTelefone());
            }
        }
    }
    
    public void alterarSenha(int idDeUsuario, String novaSenha) {
        for (Usuario usuario : listaDeUsuarios) {
            if (usuario.getIdUsuario() == idDeUsuario) {
                usuario.setSenha(novaSenha);
            }
        }
    }
    
    public boolean verificarSeTemUsuarioCadastrado(String email, String senha) {
        for (Usuario usuario : listaDeUsuarios) {
            boolean temUsuarioCadastrado = usuario.getEmail().equals(email) && usuario.getSenha().equals(senha);
            
            if (temUsuarioCadastrado) {
                return true;
            }
        }
        
        return false;
    }
    
    public Usuario buscarUsuarioPorEmailESenha(String email, String senha) {
        for (Usuario usuario : listaDeUsuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        
        return null;
    }
}
