package br.com.orangetalents4.yago.transacao.transacao;

import br.com.orangetalents4.yago.transacao.cartao.Cartao;
import br.com.orangetalents4.yago.transacao.estabelecimento.Estabelecimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoDeTransacao eventoDeTransacao) {
        Transacao transacao = new Transacao(eventoDeTransacao.getId(),
                eventoDeTransacao.getValor(), new Estabelecimento(eventoDeTransacao.getEstabelecimento()),
                new Cartao(eventoDeTransacao.getCartao()), eventoDeTransacao.getEfetivadaEm());

        transacaoRepository.save(transacao);
    }
}
