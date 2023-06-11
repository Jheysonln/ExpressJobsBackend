package com.expressJobs.jwt;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
//
//public class JwtAuthorizationFilter extends OncePerRequestFilter {
//
//    private JwtConfig jwtConfig;
//
//    public JwtAuthorizationFilter(JwtConfig jwtConfig) {
//        this.jwtConfig = jwtConfig;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        String header = request.getHeader(jwtConfig.getHeader());
//
//        if (header == null || !header.startsWith(jwtConfig.getPrefix())) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        String token = header.replace(jwtConfig.getPrefix(), "");
//
//        try {
//            Claims claims = Jwts.parserBuilder()
//                    .setSigningKey(jwtConfig.getSecret().getBytes())
//                    .build()
//                    .parseClaimsJws(token)
//                    .getBody();
//
//            String username = claims.getSubject();
//
//            if (username != null) {
//                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null,
//                        Collections.emptyList());
//                SecurityContextHolder.getContext().setAuthentication(auth);
//            }
//
//        } catch (JwtException e) {
//            response.setStatus(HttpStatus.FORBIDDEN.value());
//            response.sendError(HttpStatus.FORBIDDEN.value(), "Invalid JWT token");
//            return;
//        }
//
//        chain.doFilter(request, response);
//    }
//}
//
//

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private JwtTokenProvider jwtTokenProvider;

    public JwtAuthorizationFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        String token = header.replace("Bearer ", "");

        try {
            if (jwtTokenProvider.validateToken(token)) {
                Authentication authentication = jwtTokenProvider.getAuthenticationFromToken(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

        } catch (JwtException e) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Invalid JWT token");
            return;
        }

        chain.doFilter(request, response);
    }
}
