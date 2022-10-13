package br.com.fiap.epictaskapi.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserWebController {

    @GetMapping
    public String index(){
        return "user/index";
    }
    
}
