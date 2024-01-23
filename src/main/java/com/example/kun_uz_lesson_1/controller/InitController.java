package com.example.kun_uz_lesson_1.controller;

import com.example.kun_uz_lesson_1.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/init")
public class InitController {
   /* @Autowired
    private InitService initService;

    @GetMapping("/admin")
    public String initAdmit(){
        initService.initAdmin();
        return "done";
    }*/
}
