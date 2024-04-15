package model;

import java.util.Date;

public class Produto {
    private int idProduto;
    private String nome;
    private String descricao;
    private String categoria;
    private String marca;
    private int quantidadeEmEstoque;
    private Date dataDeFabricacao;
    private Date dataDeVencimento;
    private float valorUnitario;
    
    public Produto() {
        
    }

    public Produto(int idProduto, String nome, String descricao, String categoria, String marca, int quantidadeEmEstoque, Date dataDeFabricacao, Date dataDeVencimento, float valorUnitario) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.marca = marca;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.dataDeFabricacao = dataDeFabricacao;
        this.dataDeVencimento = dataDeVencimento;
        this.valorUnitario = valorUnitario;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public Date getDataDeFabricacao() {
        return dataDeFabricacao;
    }

    public void setDataDeFabricacao(Date dataDeFabricacao) {
        this.dataDeFabricacao = dataDeFabricacao;
    }

    public Date getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(Date dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
    
    
    
}
