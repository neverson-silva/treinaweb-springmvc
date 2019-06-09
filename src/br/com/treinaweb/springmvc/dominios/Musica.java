package br.com.treinaweb.springmvc.dominios;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "musicas")
public class Musica {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 10)
    private String nome;

    @Column(nullable = false, name = "data_criacao")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataCriacao;

    @ManyToOne(fetch = FetchType.EAGER)
    private Album album;


}
