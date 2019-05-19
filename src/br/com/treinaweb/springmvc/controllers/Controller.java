package br.com.treinaweb.springmvc.controllers;

import org.springframework.lang.Nullable;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

public class Controller {

    public String redirect(String to) {
        return "redirect:" + to;
    }

    public ModelAndView render(String view) {
        return new ModelAndView(view);
    }

    public ModelAndView render(String view, @Nullable Map<String, ?> params) {
        return new ModelAndView(view, params);
    }
}
