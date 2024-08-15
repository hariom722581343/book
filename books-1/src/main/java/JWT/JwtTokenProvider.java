package JWT;

import java.sql.Date;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.awt.print.Book;
import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Repository.BookRepository;
import Service.UserService;
import model.User;

import model.User;

@Component
public class JwtTokenProvider {
    
    @Value("${jwt.secret}")
    private String secret;
    
    public String createToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put("role", user.getRole());
        
        Date now = new Date();
        Date expires = new Date(now.getTime() + 1000 * 60 * 60); // 1 hour
        
        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(expires)
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact();
    }
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

