package org.springframework.web.servlet;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.newrelic.instrumentation.labs.spring.web.Utils;

@Weave(originalName = "org.springframework.web.servlet.FrameworkServlet", type = MatchType.BaseClass)
public class FrameworkServlet_Instrumentation {

    protected void service(HttpServletRequest request, HttpServletResponse response) {
        String requestURI = request.getRequestURI();
       if(Utils.ignoreURL(requestURI)) {
           NewRelic.getAgent().getTransaction().ignore();
       }
        Weaver.callOriginal();
    }
}
