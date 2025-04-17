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

    String keyEncoded = "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";

    public SecretKey getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(keyEncoded);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}

