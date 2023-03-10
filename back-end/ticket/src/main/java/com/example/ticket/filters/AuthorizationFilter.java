package com.example.ticket.filters;

import javax.servlet.*;
import java.io.IOException;
import javax.servlet.http.*;
import com.example.ticket.beans.JwtComponent;
import com.example.ticket.wrappers.RequestWrapper;
import com.example.ticket.repositories.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;
import org.springframework.beans.factory.annotation.Autowired;

@Component
@Order(1)
public class AuthorizationFilter implements Filter {

    @Autowired
    private JwtComponent jwt;

    @Autowired
    private UserRepository repository;

    private boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        return !path.endsWith("/account");
    }

    private String getCookie(HttpServletRequest req) {
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("mytok"))
                return cookie.getValue();
        }
        return null;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = ((HttpServletRequest) servletRequest);
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (shouldNotFilter(request)){
            filterChain.doFilter(request, response);
            return;
        }
        RequestWrapper copiedRequest = new RequestWrapper(request);
        String user = jwt.getUsername(getCookie(copiedRequest));
        if ( user == null)
            return;
//        if (repository.getFirstByUsername(user) == null)
//            return;
        filterChain.doFilter(copiedRequest, response);
    }

    @Override
    public void destroy() {

    }
}
