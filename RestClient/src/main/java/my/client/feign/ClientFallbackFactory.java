package my.client.feign;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;



@Component
public class ClientFallbackFactory implements FallbackFactory<ClientIF> {

    @Override
    public ClientIF create(Throwable throwable) {
        return new ClientFallback(throwable);
    }
}
