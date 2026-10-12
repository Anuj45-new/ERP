
package com.anuj.ERP.security;

import io.jsonwebtoken.Claims;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class TokenRevocationService {

    private final JdbcTemplate jdbcTemplate;
    private final JwtService jwtService;

    public TokenRevocationService(
            JdbcTemplate jdbcTemplate,
            JwtService jwtService) {
        this.jdbcTemplate = jdbcTemplate;
        this.jwtService = jwtService;
    }

    public void revokeToken(String token) {
        Claims claims = jwtService.extractClaims(token);

        String jti = claims.getId();
        Date expiration = claims.getExpiration();

        if (jti == null || expiration == null) {
            throw new IllegalArgumentException(
                    "Token ID or expiration is missing"
            );
        }

        jdbcTemplate.update("""
                INSERT INTO revoked_tokens (jti, expires_at)
                VALUES (?, ?)
                ON DUPLICATE KEY UPDATE jti = jti
                """,
                jti,
                new Timestamp(expiration.getTime())
        );
    }

    public boolean isRevoked(String jti) {
        if (jti == null) {
            return true;
        }

        Boolean revoked = jdbcTemplate.queryForObject(
                """
                SELECT EXISTS(
                    SELECT 1
                    FROM revoked_tokens
                    WHERE jti = ?
                      AND expires_at > CURRENT_TIMESTAMP(6)
                )
                """,
                Boolean.class,
                jti
        );

        return Boolean.TRUE.equals(revoked);
    }
}
