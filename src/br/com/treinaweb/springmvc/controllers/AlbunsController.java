package br.com.treinaweb.springmvc.controllers;

import br.com.treinaweb.springmvc.dominios.Album;
import br.com.treinaweb.springmvc.repositorios.RepositorioAlbum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/albuns")
public class AlbunsController extends br.com.treinaweb.springmvc.controllers.Controller {

    @Autowired
    private RepositorioAlbum repositorioAlbum;

    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public ModelAndView listar(Map model) {
        List<Album> albuns = repositorioAlbum.findAll();
        model.put("albuns", albuns);
        return render("albuns.listar.tiles", model);
    }

    @RequestMapping(value = "adicionar", method = RequestMethod.GET)
    public String adicionar(Model model) {
        model.addAttribute("album", new Album());
        return "albuns.adicionar.tiles";
    }

    @RequestMapping(value = "adicionar", method = RequestMethod.POST)
    public String adicionar(@ModelAttribute("album") @Valid Album novoAlbum, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "albuns.adicionar.tiles";
        }
        repositorioAlbum.save(novoAlbum);
        model.addAttribute("album", novoAlbum);
        return redirect("/albuns/listar");
    }

    @RequestMapping(value = "alterar/{id}", method = RequestMethod.GET)
    public String alterar(@PathVariable("id") Long id, Model model) {
        Album album = repositorioAlbum.findOne(id);
        model.addAttribute("album", album);
        return "albuns.alterar.tiles";
    }

    @RequestMapping(value = "alterar/{id}", method = RequestMethod.POST)
    public String alterar(@ModelAttribute("album") @Valid Album album, BindingResult result) {
        if (result.hasErrors()) {

            return "albuns.alterar.tiles";
        }
        repositorioAlbum.save(album);
        return redirect("/albuns/listar");
    }

    @RequestMapping(value = "excluir/{id}", method = RequestMethod.GET)
    public String excluir(@PathVariable("id") Long id) {
        repositorioAlbum.delete(id);
        return redirect("/albuns/listar");
    }

}
