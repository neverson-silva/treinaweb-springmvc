package br.com.treinaweb.springmvc.controllers;

import br.com.treinaweb.springmvc.dominios.Musica;
import br.com.treinaweb.springmvc.repositorios.RepositorioAlbum;
import br.com.treinaweb.springmvc.repositorios.RepositorioMusica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private RepositorioMusica repositorioMusica;

    @Autowired
    private RepositorioAlbum repositorioAlbum;

    public String listar(Model model) {
        List<Musica> musicas =  repositorioMusica.findAll();
        model.addAttribute("musicas", musicas);
        return "musica.listar.tiles";
    }

}
