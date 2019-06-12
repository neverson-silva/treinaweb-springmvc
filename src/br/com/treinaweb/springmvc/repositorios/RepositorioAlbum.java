package br.com.treinaweb.springmvc.repositorios;

import br.com.treinaweb.springmvc.dominios.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioAlbum extends JpaRepository<Album, Long> {

    Album findByNome(String nome);

    Album findAllByNomeLike(String nome);
}
