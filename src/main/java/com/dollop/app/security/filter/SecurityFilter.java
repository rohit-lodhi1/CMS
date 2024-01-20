package com.dollop.app.security.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dollop.app.utils.JWTUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService detailsService;
	
	@Autowired
	private JWTUtils jwtUtils;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = request.getParameter("Authorization");
		System.out.println("token => "+token);
		if(token!=null) {
			String userName = jwtUtils.getUserName(token);
			UserDetails user = detailsService.loadUserByUsername(userName);
			UsernamePasswordAuthenticationToken authenticationToken = 
					new UsernamePasswordAuthenticationToken(userName, user.getPassword(),user.getAuthorities());
			  authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
			  SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
        filterChain.doFilter(request, response);		
	}

}
