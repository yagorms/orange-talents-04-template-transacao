package br.com.orangetalents4.yago.transacao.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;


@RestController
@RequestMapping("/transacoes")
public class ConsultaController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping("/{numeroCartao}")
    public ResponseEntity<?> consultar(@PathVariable String numeroCartao,
                                       @PageableDefault(sort = "efetivadaEm", direction = Sort.Direction.DESC, page = 0, size = 10)Pageable paginacao){

        Page<Transacao> transacoes = transacaoRepository.findByCartaoNumeroCartao(numeroCartao, paginacao);

        if (!transacoes.isEmpty()){

            return ResponseEntity.ok(transacoes.stream().map(TransacaoDTO::new).collect(Collectors.toList()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
