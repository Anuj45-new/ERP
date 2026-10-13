
package com.anuj.ERP.security;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class TokenRevocationService {

    private final JdbcTemplate jdbcTemplate;

    public TokenRevocationService(
            JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    public void revokeToken(Jwt jwt) {
        String jti = jwt.getId();
        Instant expiration = jwt.getExpiresAt();

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
                Timestamp.from(expiration)
        );
    }

    public boolean isRevoked(String jti) {
        if (jti == null) {
            return true;
        }

        Boolean revoked = jdbcTemplate.queryForObject("""
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
