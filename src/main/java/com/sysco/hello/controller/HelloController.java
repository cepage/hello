package com.sysco.hello.controller;

import com.sysco.hello.config.WebProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;

@Controller
public class HelloController {

    @Autowired
    private WebProperties _webProperties;

    @RequestMapping( "/" )
    public String home( Model model ) throws Exception {
        model.addAttribute( "webColor", _webProperties.getColor() );
        return "index";
    }

    @RequestMapping( "/refresh" )
    public @ResponseBody ColorResponse refresh()
    {
        return new ColorResponse( _webProperties.getColor() );
    }
}
