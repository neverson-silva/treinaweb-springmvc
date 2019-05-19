package br.com.treinaweb.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/message")
    public String message() {
        return "hello";
    }

    @RequestMapping("/mensagemDoServidor")
    public String mensagemDoServidor(Model model) {
        model.addAttribute("nome", "Neverson Bento da Silva");
        model.addAttribute("mensagem", "Treinaweb");
        Date date  = new Date();
        return "mensagemDoServidor";
    }

    @RequestMapping("mensagemServidorSecond")
    public ModelAndView mensagemServidorSecond() {

        return new ModelAndView("mensagemDoServidor", "mensagem", new Date().toString());
    }

    @RequestMapping("receberMensagem/{mensagem}")
    public String receberMensagem(Model model, @PathVariable("mensagem") String mensagem) {
        return "mensagemDoServidor";
    }

    @RequestMapping("receberMensagemSecond")
    public String receberMensagemSecond(Model model, @RequestParam(value = "mensagem") String msg) {
        model.addAttribute("mensagem", msg);
        return "mensagemDoServidor";
    }

}
