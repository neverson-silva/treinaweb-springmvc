package br.com.treinaweb.springmvc.repositorios;

import br.com.treinaweb.springmvc.dominios.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioMusica extends JpaRepository<Musica, Long >{
}
