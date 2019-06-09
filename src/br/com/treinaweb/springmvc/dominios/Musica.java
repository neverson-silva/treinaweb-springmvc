package br.com.treinaweb.springmvc.dominios;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(name = "musicas")
public class Musica {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 10)
    @Size(min = 3, max = 10, message = "Nome da música deve conter entre 3 e 10 caracteres.")
    @NotEmpty(message = "O nome é obrigatório")
    @NotNull(message = "O nome é obrigatório")
    private String nome;

    @Column(nullable = false, name = "data_criacao")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotEmpty(message = "A data de criacao é obrigatório")
    @NotNull(message = "A data de criacao é obrigatório")
    private Date dataCriacao;

    @ManyToOne(fetch = FetchType.EAGER)
    private Album album;


}
