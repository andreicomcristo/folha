package com.folha.boot;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        UsernamePasswordAuthenticationToken authRequest
                = getAuthRequest(request);
        setDetails(request, authRequest);

        return this.getAuthenticationManager()
                .authenticate(authRequest);
    }

    private UsernamePasswordAuthenticationToken getAuthRequest(
            HttpServletRequest request) {

        String username = obtainUsername(request);
        String password = obtainPassword(request);
        String unidade = request.getParameter("unidade");

        String usernameDomain = String.format("%s%s%s", username.trim(),
                String.valueOf(Character.LINE_SEPARATOR), unidade);
        
        return new UsernamePasswordAuthenticationToken(
                usernameDomain, password);
    }

}
