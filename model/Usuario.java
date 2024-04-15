package model;

import java.util.Date;
import javax.swing.JOptionPane;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String telefone;
    private Date dataDeNascimento;
    private String CPF;
    private String email;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
    public boolean validarDados(){
        if (this.getNome().length() < 5) {
            JOptionPane.showMessageDialog(null, "O nome deve ter mais de 5 caracteres!", null, JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (this.getCPF().replace(".", "").replace("-", "").isBlank()) {
            JOptionPane.showMessageDialog(null, "É necessário preencher o CPF para criar uma conta!", null, JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (this.getTelefone().replace("(", "").replace(")", "").replace("-", "").trim().length() < 4) {
            JOptionPane.showMessageDialog(null, "É necessário preencher o telefone para criar uma conta!", null, JOptionPane.ERROR_MESSAGE);
            return false;
        } else if ((!this.getEmail().endsWith("@gmail.com") && !this.getEmail().endsWith("@hotmail.com")) || this.getEmail().substring(0, this.getEmail().indexOf("@")).length() < 5) {
            JOptionPane.showMessageDialog(null, "Preencha um e-mail válido!", null, JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (this.getSenha().length() < 6) {
            JOptionPane.showMessageDialog(null, "A senha deve ter mais de 6 caracteres!", null, JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (this.getDataDeNascimento().after(new Date()) || this.getDataDeNascimento().before(new Date(new Date().getYear() - 100, 01, 01)) || this.getDataDeNascimento().after(new Date(new Date().getYear() - 18, 01, 01))) {
            JOptionPane.showMessageDialog(null, "Digite uma data de nascimento válida!!", null, JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    public boolean validarSenha(String senhaAtual, String novaSenha) {
        if (!this.getSenha().equals(senhaAtual)) {
            JOptionPane.showMessageDialog(null, "Senha atual incorreta!", null, JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (this.getSenha().equals(novaSenha)) {
            JOptionPane.showMessageDialog(null, "Nova senha deve ser diferente da senha atual!", null, JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (novaSenha.length() < 6) {
            JOptionPane.showMessageDialog(null, "A senha deve ter mais de 6 caracteres!", null, JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    
}
