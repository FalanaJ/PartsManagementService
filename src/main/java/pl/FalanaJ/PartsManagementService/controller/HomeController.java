package pl.FalanaJ.PartsManagementService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class HomeController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello World !!!";
    }
}
