package com.sysco.hello.controller;

import com.sysco.hello.config.RemoteProperties;
import com.sysco.hello.config.WebProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class HelloController {

    public static final String BANNER_TEXT = "Hello, World of ";
    @Autowired
    private WebProperties _webProperties;

    @Autowired
    private RemoteProperties _remoteProperties;

    @RequestMapping( "/" )
    public String home( Model model ) {
        return "index";
    }

    @RequestMapping( "/refresh" )
    public @ResponseBody
    RefreshResponse refresh()
    {
        RestTemplate restTemplate = new RestTemplate();
        String worldServiceName = _remoteProperties.getWorldServiceName();
        String url = "http://" + worldServiceName + "/message";
        System.out.println( "Calling " + url );
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()), String.class);
        System.out.println( responseEntity.getBody() );
        return new RefreshResponse( _webProperties.getColor(), BANNER_TEXT + responseEntity.getBody() );
    }
}
