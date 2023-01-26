package com.project.tutorial.rest.kafka.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistraEventoService {

    private final KafkaTemplate<Object, Object> template;

    public <T> void adicionarEvento(String topico, T dados) {
        template.send(topico, dados);
    }

}
