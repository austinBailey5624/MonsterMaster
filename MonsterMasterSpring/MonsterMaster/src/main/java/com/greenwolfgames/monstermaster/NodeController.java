package com.greenwolfgames.monstermaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenwolfgames.monstermaster.NatureService;

@RestController
@RequestMapping("/api")
public class NodeController {

    @Autowired
    private NatureService natureService;
    
    @GetMapping("/node")
    public String sayHello() {
        return "Hello, Spring Boot!;lkj";
    }

    @GetMapping("/nature")
    public String getNatures() {
        return natureService.getAllNatures;
    }
}
