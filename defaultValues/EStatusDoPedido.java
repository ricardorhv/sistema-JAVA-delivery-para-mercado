package defaultValues;

public enum EStatusDoPedido {
    EM_ANALISE("Em análise"),
    PEDIDO_CONFIRMADO("Confirmado"),
    PREPARANDO("Preparando"),
    SAIU_PARA_ENTREGA("Saiu para entrega"),
    ENTREGUE("Entregue");
    
    private String descricao;
    
    private EStatusDoPedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
