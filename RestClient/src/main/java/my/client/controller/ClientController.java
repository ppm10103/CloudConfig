package my.client.controller;

import my.client.feign.ClientIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientIF client;

    @GetMapping("/server_response")
    public ResponseEntity<String> getMessageFromRestServer() {

        return client.getMessage();
    }

    @GetMapping("/client_message")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("Greeting from client local");
    }
}
