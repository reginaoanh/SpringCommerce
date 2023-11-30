package com.midtern.SpringCommerce.service;

import com.midtern.SpringCommerce.repository.TokenRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
public class LogoutService implements LogoutHandler {
    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String authorization = request.getHeader("Authorization");

        if (authorization == null || !authorization.startsWith("Bearer ")) {
            return;
        }

        String token = authorization.substring(7);
        var tokenStored = tokenRepository.findByToken(token).orElse(null);

        if (tokenStored != null) {
            tokenStored.setRevoked(true);
            tokenStored.setExpired(true);
            tokenRepository.save(tokenStored);
//            delete cookie user
            Cookie userCookie = new Cookie("user", null);
            userCookie.setMaxAge(0);
            userCookie.setPath("/");
            response.addCookie(userCookie);
//            delete cookie products
            Cookie tokenCookie = new Cookie("token", null);
            userCookie.setMaxAge(0);
            userCookie.setPath("/");
            response.addCookie(tokenCookie);

            Cookie productCookie = new Cookie("products", "");
            productCookie.setMaxAge(60 * 60 * 24 * 30);
            productCookie.setPath("/");
            response.addCookie(productCookie);
            SecurityContextHolder.clearContext();
        }
    }
}
