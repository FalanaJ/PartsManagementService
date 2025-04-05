package pl.FalanaJ.PartsManagementService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HomeController {
    @GetMapping("/hello")
    public String Hello(){
        return "Hello World!";
    }

    @GetMapping("/hello2")
    public String Hello2(){
        return "Hello World! - 2";
    }
}
