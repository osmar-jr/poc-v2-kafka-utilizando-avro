package br.com.zup.pocv2.usuarios;

import br.com.zup.poc.avro.Usuario;
import br.com.zup.pocv2.kafka.UsuarioProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioProducerService service;

    @PostMapping
    public ResponseEntity<?> enviar(@RequestBody @Valid UsuarioRequest request){

        Usuario usuario = request.toModel();
        service.enviarMensagem(usuario);

        return ResponseEntity.ok(request);
    }
}
