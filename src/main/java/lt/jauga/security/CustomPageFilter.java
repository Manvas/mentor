package lt.jauga.security;

import lt.jauga.TenantContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Order(1)
public class CustomPageFilter implements Filter {

    private final static Logger LOG = LoggerFactory.getLogger(CustomPageFilter.class);
    CustomAuthenticationFilter authenticationFilter = new CustomAuthenticationFilter();

    @Override
    public void init(FilterConfig filterConfig) {
        LOG.info("Initializing filter :{}", this);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        //String tenant = authenticationFilter.obtainTenant(req);
        try {
            String tenant = req.getSession().getAttribute("tenant").toString();
            TenantContextHolder.setTenantId(tenant);
            LOG.info("Starting Transaction for req :{}" + req.getRequestURI());
            filterChain.doFilter(servletRequest, servletResponse);
            LOG.info("Committing Transaction for req :{}" + req.getRequestURI());
            LOG.info("Tenant is: " + tenant);
        }
        catch (NullPointerException ex){
            filterChain.doFilter(servletRequest, servletResponse);
            LOG.info("User is an Idiot");
        }
    }

    @Override
    public void destroy() {
        LOG.warn("Destructing filter :{}", this);
    }
}
