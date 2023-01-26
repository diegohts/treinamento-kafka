package com.project.tutorial.microsservico.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.tutorial.microsservico.kafka.data.PedidoData;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SalvarPedidoService {

    @KafkaListener(topics= "SalvarPedido", groupId = "MicrosservicoSalvaPedido")
    private void executar(ConsumerRecord<String, String> record) {

        log.info("Chave = {}", record.key());
        log.info("Cabecalho = {}", record.headers());
        log.info("Particao = {}", record.partition());

        String strDados = record.value();

        ObjectMapper mapper = new ObjectMapper();
        PedidoData pedido;

        try {
            pedido = mapper.readValue(strDados, PedidoData.class);
        } catch (JsonProcessingException e) {
            log.error("Falha ao converter evento [dado={}]", strDados, e);
            return;
        }

        log.info("Evento recebido = {}", pedido);

        //Gravar no banco de dados
        //Responder para a fila de que o pedido foi salvo
    }

    private void gravar(PedidoData pedido) {
        // Gravar no banco de dados
    }
}
