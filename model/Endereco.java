package model;

import javax.swing.JOptionPane;

public class Endereco {
    private int idEndereco;
    private String nomeDaRua;
    private String bairro;
    private int numeroDaCasa;
    private String CEP;
    private String complemento;
    
    public boolean validarDados(Endereco endereco) {
        if (endereco.getNomeDaRua().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o nome da rua!", null, JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (endereco.numeroDaCasa == 0) {
            JOptionPane.showMessageDialog(null, "Coloque um numero de casa válido!", null, JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (endereco.getBairro().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o bairro!", null, JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (endereco.getCEP().replace("-", " ").trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o CEP!", null, JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getNomeDaRua() {
        return nomeDaRua;
    }

    public void setNomeDaRua(String nomeDaRua) {
        this.nomeDaRua = nomeDaRua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public void setNumeroDaCasa(int numeroDaCasa) {
        this.numeroDaCasa = numeroDaCasa;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    
}
