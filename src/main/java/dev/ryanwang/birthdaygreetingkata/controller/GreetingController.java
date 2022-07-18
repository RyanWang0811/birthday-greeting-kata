package dev.ryanwang.birthdaygreetingkata.controller;

import dev.ryanwang.birthdaygreetingkata.dto.GreetingDTO;
import dev.ryanwang.birthdaygreetingkata.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("greeting")
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    @GetMapping(produces = { "application/xml", "text/xml" }, consumes = MediaType.ALL_VALUE)
    public List<GreetingDTO> greetingMsg(){
        return  greetingService.findGreetingList();
    }
}
