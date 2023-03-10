package com.example.ticket.beans;

import com.example.ticket.types.userType.User;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwk.*;
import org.jose4j.jws.*;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.*;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Component("jwtComp")
@Scope("singleton")
@ComponentScan
public class JwtComponent implements InitializingBean {
    private RsaJsonWebKey rsaJsonWebKey;

    @Override
    public void afterPropertiesSet() {
        try {
            rsaJsonWebKey = RsaJwkGenerator.generateJwk(2048);
        }catch (JoseException e) {
            e.printStackTrace();
        }
        rsaJsonWebKey.setKeyId("tick_reserve_app_key_id");
    }

    public String generateToken(User user) throws JoseException {
        JwtClaims claims = new JwtClaims();
        claims.setGeneratedJwtId();
        claims.setIssuedAtToNow();
        claims.setExpirationTimeMinutesInTheFuture(131400);
        claims.setClaim("username", user.getUsername());
        claims.setClaim("role", user.getRole());
        JsonWebSignature jws = new JsonWebSignature();
        jws.setPayload(claims.toJson());
        jws.setKey(rsaJsonWebKey.getPrivateKey());
        jws.setKeyIdHeaderValue(rsaJsonWebKey.getKeyId());
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
        return jws.getCompactSerialization();
    }

    public String getUsername(String token){
        return getValueFromToken("username", token);
    }

    public String getRole(String token){
        return getValueFromToken("role", token);
    }

    private String getValueFromToken(String claimName, String token){
        String res;
        JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                .setRequireExpirationTime()
                .setVerificationKey(rsaJsonWebKey.getKey())
                .setJwsAlgorithmConstraints(
                        AlgorithmConstraints.ConstraintType.PERMIT, AlgorithmIdentifiers.RSA_USING_SHA256)
                .build();
        try
        {
            JwtClaims jwtClaims = jwtConsumer.processToClaims(token);
            res =  jwtClaims.getClaimValueAsString(claimName);
        }
        catch (InvalidJwtException e)
        {
            if (e.hasExpired())
                res = null;
            else
                res = e.getJwtContext().getJwtClaims().getClaimValueAsString(claimName);
        }
        return res;
    }
}
