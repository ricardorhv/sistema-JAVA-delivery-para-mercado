package model;

public class Pagamento {
    private int idPagamento;
    private String status;
    private String descricao;
    
    public Pagamento(int idPagamento, String status, String descricao) {
        this.idPagamento = idPagamento;
        this.status = status;
        this.descricao = descricao;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
