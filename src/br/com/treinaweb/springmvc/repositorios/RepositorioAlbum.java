package br.com.treinaweb.springmvc.repositorios;

import br.com.treinaweb.springmvc.dominios.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioAlbum extends JpaRepository<Album, Long> {

    Album findByNome(String nome);

    @Query("from Album where nome like %:nome%")
    List<Album> findAllByNomeLike(@Param("nome") String nome);
}
