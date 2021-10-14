package br.com.zup.pocv2.kafka;

import br.com.zup.poc.avro.Usuario;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UsuarioConsumerService {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consomeMensagem(ConsumerRecord<String, Usuario> record) {
        logger.info("Mensagem recebida com sucesso: " + record.value());
    }
}
