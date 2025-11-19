package com.newrelic.instrumentation.labs.spring.web;

import com.newrelic.agent.config.AgentConfig;
import com.newrelic.agent.config.AgentConfigListener;
import com.newrelic.agent.config.ConfigService;
import com.newrelic.agent.service.ServiceFactory;
import com.newrelic.api.agent.Config;
import com.newrelic.api.agent.NewRelic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

public class Utils implements AgentConfigListener {

    private static final String SPRING_REGEX = "Spring_Ignores.regex";
    private static final String SPRING_URLS = "Spring_Ignores.urls";

    private static final HashSet<Pattern> ignoresRegexs = new HashSet<>();
    private static final HashSet<String> ignoredURLs = new HashSet<>();

    static {
        ConfigService configService = ServiceFactory.getConfigService();
        configService.addIAgentConfigListener(new Utils());

        Config config = NewRelic.getAgent().getConfig();

        String regexes = config.getValue(SPRING_REGEX);
        String urls = config.getValue(SPRING_URLS);
        if(urls != null) {
            String[] urlsArray = urls.split(",");
            ignoredURLs.addAll(Arrays.asList(urlsArray));
        }

        if(regexes != null) {
            String[] ignoredRegexArray = regexes.split(",");
            for (String regex : ignoredRegexArray) {
                Pattern pattern = Pattern.compile(regex);
                ignoresRegexs.add(pattern);
            }
        }

    }

    private Utils() {};


    public static boolean ignoreURL(String url) {
        if(ignoredURLs.contains(url)) {return true;}

        for(Pattern pattern : ignoresRegexs) {
            if(pattern.matcher(url).matches()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void configChanged(String appName, AgentConfig config) {
        ignoredURLs.clear();
        ignoresRegexs.clear();

        String regexes = config.getValue(SPRING_REGEX);
        String urls = config.getValue(SPRING_URLS);
        if(urls != null) {
            String[] urlsArray = urls.split(",");
            ignoredURLs.addAll(Arrays.asList(urlsArray));
        }

        if(regexes != null) {
            String[] ignoredRegexArray = regexes.split(",");
            for (String regex : ignoredRegexArray) {
                Pattern pattern = Pattern.compile(regex);
                ignoresRegexs.add(pattern);
            }
        }
    }
}
