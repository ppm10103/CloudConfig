package my.client.feign;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "rest-server", url = "http://localhost:8080",
        fallbackFactory = ClientFallbackFactory.class)
public interface ClientIF {

    @RequestLine("GET")
    @RequestMapping("/rest/server_message")
    ResponseEntity<String> getMessage();
}
