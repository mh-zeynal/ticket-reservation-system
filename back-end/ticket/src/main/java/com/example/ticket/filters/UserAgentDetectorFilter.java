package com.example.ticket.filters;

import java.io.*;

import com.example.ticket.beans.JacksonMapperComponent;
import com.example.ticket.beans.JwtComponent;
import com.example.ticket.repositories.UserAgentRepository;
import com.example.ticket.types.UserAgentEntity;
import com.example.ticket.types.jacksonPojos.AccountPojo;
import com.example.ticket.types.jacksonPojos.LoginPojo;
import com.example.ticket.types.jacksonPojos.UserPojo;
import com.example.ticket.wrappers.RequestWrapper;
import ua_parser.*;
import javax.servlet.*;
import javax.servlet.http.*;
import nl.basjes.parse.useragent.*;
import nl.basjes.parse.useragent.UserAgent;
import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;
import org.springframework.beans.factory.annotation.Autowired;

@Component
@Order(2)
public class UserAgentDetectorFilter implements Filter {
    @Autowired
    private UserAgentRepository agentRepository;

    @Autowired
    private JwtComponent jwt;

    @Autowired
    private JacksonMapperComponent jack;

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
        String test = request.getServletPath();
        AccountPojo pojo = null;
        if (test.endsWith("/login"))
            pojo = jack.convertToJavaObject(copiedRequest.getBody(), LoginPojo.class);
        else
            pojo = jack.convertToJavaObject(copiedRequest.getBody(), UserPojo.class);
        agentRepository.save(generateAgentReport(copiedRequest, pojo));
        generateAgentReport(copiedRequest, pojo);
        filterChain.doFilter(copiedRequest, response);
    }

    @Override
    public void destroy() {

    }

    private UserAgentEntity generateAgentReport(HttpServletRequest request, AccountPojo pojo){
        UserAgentEntity agentEntity = new UserAgentEntity();
        UserAgentAnalyzer uaa = UserAgentAnalyzer.newBuilder().build();
        UserAgent agent = uaa.parse(request.getHeader("User-Agent"));

        Parser uaParser = new Parser();
        Client c = uaParser.parse(request.getHeader("User-Agent"));
        String device = agent.getValue("DeviceName");
        String agentType = agent.getValue("AgentNameVersion");
        String os = c.os.family + " " + c.os.major;

        agentEntity.setAgent(agentType);
        agentEntity.setOs(os);
        agentEntity.setDevice(device);
        agentEntity.setUsername(pojo.getUsername());
        return agentEntity;
    }

    private boolean shouldNotFilter(HttpServletRequest request) {
        String path =  request.getServletPath();
        return !(path.endsWith("/login") || path.endsWith("/signup"));
    }
}
