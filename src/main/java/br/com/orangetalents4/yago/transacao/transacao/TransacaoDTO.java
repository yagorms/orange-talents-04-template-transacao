package br.com.orangetalents4.yago.transacao.transacao;

import br.com.orangetalents4.yago.transacao.estabelecimento.Estabelecimento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoDTO {

    private String id;
    private BigDecimal valor;
    private Estabelecimento estabelecimento;
    private LocalDateTime efetivadaEm;


    public TransacaoDTO(Transacao transacao) {
        this.id = transacao.getNumeroTransacao();
        this.valor = transacao.getValor();
        this.estabelecimento = transacao.getEstabelecimento();
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
