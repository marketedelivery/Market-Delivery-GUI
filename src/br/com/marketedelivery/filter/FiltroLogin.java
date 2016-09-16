package br.com.marketedelivery.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.marketedelivery.classesbasicas.Usuario;

 
public class FiltroLogin extends AbstractFilter implements Filter{
	
	private String LOGIN_ACTION_URI;
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
        
        if(session.isNew()) {
        	System.out.println("inicio");
        	doLogin(request, response, req);
            chain.doFilter(request, response);
            System.out.println("passou");
            return;
        } 
         Usuario user = (Usuario) session.getAttribute("usuario");
        
         if (user == null) {
 			System.out.println(req.getRequestURI());
 			doLogin(request, response, req);
 			 System.out.println("passou");
 			return;
 		}
         chain.doFilter(request, response);
    }
		
	

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		LOGIN_ACTION_URI = fConfig.getInitParameter("loginActionURI");
		
	}

}
