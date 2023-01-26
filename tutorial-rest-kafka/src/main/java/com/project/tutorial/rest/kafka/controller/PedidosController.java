package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidosController {

    public ResponseEntity<String> salvarPedido() {
        return ResponseEntity.ok("Sucesso");
    }
}
