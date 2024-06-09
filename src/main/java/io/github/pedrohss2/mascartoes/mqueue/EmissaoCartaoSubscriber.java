package io.github.pedrohss2.mascartoes.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.pedrohss2.mascartoes.model.Cartao;
import io.github.pedrohss2.mascartoes.model.CartaoCliente;
import io.github.pedrohss2.mascartoes.model.DadosEmissaoCartao;
import io.github.pedrohss2.mascartoes.repository.CartaoClienteRepository;
import io.github.pedrohss2.mascartoes.repository.CartaoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmissaoCartaoSubscriber {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private CartaoClienteRepository cartaoClienteRepository;

    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void receberSolicitacaoDaEmissao(@Payload String payload) {
        var mapper = new ObjectMapper();
        try {
            DadosEmissaoCartao dadosEmissaoCartao = mapper.readValue(payload, DadosEmissaoCartao.class);
            Cartao cartao = cartaoRepository.findById(dadosEmissaoCartao.getId()).orElseThrow(() -> new RuntimeException("erro"));

            CartaoCliente cartaoCliente = new CartaoCliente();
            cartaoCliente.setCartao(cartao);
            cartaoCliente.setCpf(dadosEmissaoCartao.getCpf());
            cartaoCliente.setLimiteAprovado(dadosEmissaoCartao.getLimiteLiberado());


            cartaoClienteRepository.save(cartaoCliente);
        } catch (JsonProcessingException erro) {
            erro.printStackTrace();
        }
    }

}
