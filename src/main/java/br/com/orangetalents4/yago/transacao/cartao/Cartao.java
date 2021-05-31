package br.com.orangetalents4.yago.transacao.cartao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cartao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroCartao;
    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(CartaoResponse cartaoResponse) {
        this.numeroCartao = cartaoResponse.getId();
        this.email = cartaoResponse.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public String getEmail() {
        return email;
    }
}
