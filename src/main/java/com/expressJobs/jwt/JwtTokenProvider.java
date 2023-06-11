package com.expressJobs.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.expressJobs.CustomUserDetails;
import com.expressJobs.models.Rol;
import com.expressJobs.models.Usuario;

import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

	private static final String SECRET_KEY = "LAKSDJLKASDNAKJSNDKJASBASLDKNASKLDNLkndlkanAKJSDASFASFASNDJKASJKDASJDJASDdakldnKLDANSDy";
	private static final long EXPIRATION_TIME = 86400000; // 24 hours

	public String generateToken(Authentication authentication) {
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		Usuario usuario = userDetails.getUsuario();

		List<String> roles = usuario.getRoles().stream().map(Rol::getDes_rol).collect(Collectors.toList());

		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

		return Jwts.builder()
				  .claim("user", usuario.getEmail()) // Cambiar "sub" por "user"
				  .claim("roles", roles)
				  .setIssuedAt(new Date())
				  .setExpiration(expiryDate)
				  .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
				  .compact();
	}
	
	public Authentication getAuthenticationFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        String username = claims.getSubject();
        List<String> roles = (List<String>) claims.get("roles");

        Collection<GrantedAuthority> authorities = roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(username, null, authorities);
    }

	public String resolveToken(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
