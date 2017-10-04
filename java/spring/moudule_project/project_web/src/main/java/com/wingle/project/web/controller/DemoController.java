package com.wingle.project.web.controller;


import com.wingle.project.web.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("/demo/show")
    public void show() {
        System.out.println(demoService.show());
    }
}
