package my.client.feign;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ClientFallback implements ClientIF {
    private final Throwable cause;

    public ClientFallback(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public ResponseEntity<String> getMessage() {
        if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Message From ClientFallback: Not Found");
        }
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Message From Fall ClientFallback: Other error");
    }
}
