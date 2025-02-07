package com.greenwolfgames.monstermaster;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NodeController
{
    @GetMapping("/node")
    public String sayHello()
    {
        return "Hello, Spring Boot!;lkj";
    }
}