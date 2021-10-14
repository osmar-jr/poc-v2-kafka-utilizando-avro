package br.com.zup.pocv2.kafka;

import br.com.zup.poc.avro.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UsuarioProducerService {

    @Value("${topic.name}")
    private String topico;

    private final KafkaTemplate<String, Usuario> kafkaTemplate;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    public UsuarioProducerService(KafkaTemplate<String, Usuario> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarMensagem(Usuario usuario) {
        this.kafkaTemplate.send(this.topico, usuario);
        logger.info("Detalhes do usuário enviados: " + usuario.toString());
    }
}
