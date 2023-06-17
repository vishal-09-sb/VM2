package com.moviebookingApp.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTfilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		@SuppressWarnings("unused")
		HttpServletResponse httpRes = (HttpServletResponse) response;

		String authHeader = httpReq.getHeader("Authorization");
		String requestURI = httpReq.getRequestURI();
		
		// Skip the authentication check for the login route
		// Skip the authentication check for the authenticate route
		System.out.println("Checking uri -> " + requestURI);
		System.out.println("Auth Header : " + authHeader);
		if (requestURI.endsWith("/api/v1.0/authenticate")) {
		    chain.doFilter(request, response);
		    return;
		}
		
		if (requestURI.endsWith("/api/v1.0/logout")) {
		    chain.doFilter(request, response);
		    return;
		}

		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			throw new ServletException("Missing or invalid authentication header");
		}
		
		
		

		String jwtToken = authHeader.substring(7);
		System.out.println("jwt token : " + jwtToken);
		Claims claims = Jwts.parser().setSigningKey("learn_programming_yourself").parseClaimsJws(jwtToken).getBody();
		String username = (String) claims.get("username");
		System.out.println("Username from claims: " + username);

		httpReq.setAttribute("username", claims);
		chain.doFilter(request, response);

	}

}
