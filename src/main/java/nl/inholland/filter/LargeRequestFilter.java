package nl.inholland.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import java.io.IOException;
import java.rmi.ServerError;
import java.util.logging.Logger;

@Component
@Order(1)
public class LargeRequestFilter implements Filter{

    public static final int MAX_SIZE = 60;
    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        int size = request.getContentLength();
        log.info("Request size is: " + size);
        if(size > MAX_SIZE){
            try{
                log.severe("request with size " + size + " was rejected. Max size is " + MAX_SIZE);
                throw new ServletException("Request too large");
            } catch (ServletException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {

    }
}
