package nakup.api.gateway.service;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.ws.rs.client.Client;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Getter
@Service
public class JwtKeyService {

    WebClient client = WebClient.create("http://localhost:8092");

    String keyEncoded;

    JwtKeyService() throws NoSuchAlgorithmException {
        keyEncoded = client.get()
                .uri("/internal/jwt/key/encoded")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public SecretKey getSecretKey() throws RuntimeException {
        if (keyEncoded == null) {
            throw new RuntimeException("Key is null");
        }
        byte[] keyBytes = Decoders.BASE64.decode(keyEncoded);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}

