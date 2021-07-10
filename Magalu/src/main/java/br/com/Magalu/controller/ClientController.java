package br.com.Magalu.controller;

import br.com.Magalu.entity.Client;
import br.com.Magalu.payload.Response;
import br.com.Magalu.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/magalu")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/client")
    public ResponseEntity<?> addClient(@RequestBody Client client){
        try {
            Boolean clienteExiste = clientService.existByCpf(client.getCpf());
            if (clienteExiste) {
                return new ResponseEntity<>(
                        new Response(false, "Cliente já existe"),
                        HttpStatus.CONFLICT);
            } else {
                return new ResponseEntity<>(clientService.cadastrarCliente(client), HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new Response(false, "Bad Request"),
                    HttpStatus.BAD_REQUEST);
        }
    }


}
