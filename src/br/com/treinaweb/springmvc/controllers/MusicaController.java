package br.com.treinaweb.springmvc.controllers;

import br.com.treinaweb.springmvc.dominios.Musica;
import br.com.treinaweb.springmvc.repositorios.RepositorioAlbum;
import br.com.treinaweb.springmvc.repositorios.RepositorioMusica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/musicas")
public class MusicaController extends br.com.treinaweb.springmvc.controllers.Controller {

    @Autowired
    private RepositorioMusica repositorioMusica;

    @Autowired
    private RepositorioAlbum repositorioAlbum;

    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public String listar(Model model) {
        List<Musica> musicas = repositorioMusica.findAll();

        model.addAttribute("musicas", musicas);

        return "musica.listar.tiles";
    }

    @RequestMapping(value = "adicionar", method = RequestMethod.GET)
    public String adicionar(Model model, Musica musica) {
        model.addAttribute("musica", musica);
        model.addAttribute("albuns", repositorioAlbum.findAll());
        return "musica.adicionar.tiles";
    }

    @RequestMapping(value = "adicionar", method = RequestMethod.POST)
    public String adicionar(@ModelAttribute("musica") @Valid Musica novaMusica, BindingResult result,
                            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("albuns", repositorioAlbum.findAll());
            return "musica.adicionar.tiles";
        }
        repositorioMusica.save(novaMusica);
        return redirect("/musicas/listar");
    }

    @RequestMapping(value = "alterar/{id}", method = RequestMethod.GET)
    public String alterar(Model model, @PathVariable Long id) {
        Musica musica = repositorioMusica.findOne(id);
        model.addAttribute("musica", musica);
        model.addAttribute("albuns", repositorioAlbum.findAll());
        return "musica.alterar.tiles";
    }

    @RequestMapping(value = "alterar/{id}", method = RequestMethod.POST)
    public String alterar(@ModelAttribute("musica") @Valid Musica musica, BindingResult result,
                          Model model) {
        if (result.hasErrors()) {
            model.addAttribute("albuns", repositorioAlbum.findAll());
            return "musica.alterar.tiles";
        }
        repositorioMusica.save(musica);
        return redirect("/musicas/listar");
    }

    @RequestMapping("excluir/{id}")
    public String excluir(@PathVariable Long id) {
        Musica musica = repositorioMusica.findOne(id);

        musica.setAlbum(null);

        repositorioMusica.delete(musica);

        return redirect("/musicas/listar");
    }
}
