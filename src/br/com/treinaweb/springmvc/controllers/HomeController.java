package br.com.treinaweb.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {

    @RequestMapping("login")
    public String login() {
        return "home.login.tiles";
    }

    @RequestMapping("bemvindo")
    public String bemVindo() {
        return "home.bemvindo.tiles";
    }
}
