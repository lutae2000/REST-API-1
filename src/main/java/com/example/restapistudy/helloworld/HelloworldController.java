package com.example.restapistudy.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;


@RestController
public class HelloworldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello-world")
    public String helloworld(){
        return "hello world";
    }


    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloworldBean(){
        return new HelloWorldBean("hello world");
    }

    @GetMapping("/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloworldBean(@PathVariable String name){
        return new HelloWorldBean(String.format("hello world,  %s",name));
    }

    //API 다국어 MessageSource에 정의
    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required = false) Locale locale){
        return messageSource.getMessage("greeting.message", null, locale);
    }
}
