package br.com.treinaweb.springmvc.controllers;

import br.com.treinaweb.springmvc.dominios.Usuario;
import br.com.treinaweb.springmvc.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("usuarios")
public class UsuariosController extends br.com.treinaweb.springmvc.controllers.Controller {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @RequestMapping(value = "listar")
    public String listar(Model model) {

        List<Usuario> usuarios = repositorioUsuario.findAll();

        model.addAttribute("usuarios", usuarios);

        return "usuarios.listar.tiles";
    }

    @RequestMapping(value = "adicionar", method = RequestMethod.GET)
    public String adicionar(Model model, Usuario usuario){
        model.addAttribute("usuario", usuario);
        return "usuarios.adicionar.tiles";
    }

    @RequestMapping(value = "adicionar", method = RequestMethod.POST)
    public String adicionar(@ModelAttribute("usuario") @Valid Usuario usuario,
                            BindingResult result){
        if (result.hasErrors()) {
            return "usuarios.adicionar.tiles";
        }
        usuario.setPassword(encrypt(usuario.getPassword()));
        repositorioUsuario.save(usuario);
        return redirect("/usuarios/listar");
    }

    public String encrypt(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
