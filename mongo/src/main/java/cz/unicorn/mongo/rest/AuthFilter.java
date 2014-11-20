package cz.unicorn.mongo.rest;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.core.util.Base64;

/**
 * Servlet Filter implementation class AuthFilter
 */
public class AuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
				// place your code here
				String authHeader =  ((HttpServletRequest)request).getHeader("Authorization");
				if(authHeader != null && authHeader.startsWith("Basic")) {
					String decoded = new String(Base64.base64Decode(authHeader.substring(5)));
					if(!decoded.equals("user:pass")){
						HttpServletResponse httpResponse = (HttpServletResponse)response;
						httpResponse.addHeader("WWW-Authenticate", "Basic real=test");
						httpResponse.sendError(401,"Wrong authentication data");
						return;
					}
				}else{
					HttpServletResponse httpResponse = (HttpServletResponse)response;
					httpResponse.addHeader("WWW-Authenticate", "Basic real=test");
					httpResponse.sendError(401,"Missing authentication data");
					return;
				}
				// pass the request along the filter chain
				chain.doFilter(request, response);
				
				
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
