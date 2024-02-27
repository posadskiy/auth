package com.posadskiy.auth.core.service.impl;

import com.posadskiy.auth.core.service.TokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.KeyAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.Password;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class JwtTokenService implements TokenService {

    @Value("${app.jwtSecret}")
    private String token;

    @Override
    public String create(Long userId) {
        Password password = Keys.password(token.toCharArray());

        KeyAlgorithm<Password, Password> alg = Jwts.KEY.PBES2_HS512_A256KW;
        AeadAlgorithm enc = Jwts.ENC.A256GCM;

        String jwe = Jwts.builder()
            .issuer("posadskiy.com")
            .subject("token")
            .issuedAt(new Date())
            .expiration(Date.from(Instant.now().plus(1, ChronoUnit.DAYS)))
            .claim("user_id", userId)
            .encryptWith(password, alg, enc)
            .compact();

        return jwe;

        //String issuer = Jwts.parser().decryptWith(password).build().parseEncryptedClaims(jwe).getPayload().getIssuer();
    }
}
