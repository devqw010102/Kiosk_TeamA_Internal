package kr.hcnc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;

public class SecretKeyFilter implements Filter {

	@Value("${Globals.ApiSecretKey}")
	private String apiSecretKey;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String secretHeader = httpRequest.getHeader("X-Api-Secret");
		
		if(apiSecretKey.equals(secretHeader)) {
			chain.doFilter(request,  response);
		}
		else {
			httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			httpResponse.setContentType("application/json;charset=UTF-8");
			httpResponse.getWriter().write("{\"status\":\"error\",\"message\":\"Unauthorized\"}");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
}
