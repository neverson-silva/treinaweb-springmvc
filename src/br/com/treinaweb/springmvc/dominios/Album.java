package br.com.treinaweb.springmvc.dominios;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "albuns")
@Data
public class Album {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nome", length = 10, nullable = false)
    @Size(min = 4, max = 10, message = "O nome do álbum deve conter ao menos 4 caracteres e no máximo 10 caracteres.")
    private String nome;

    @Column(name = "ano_lancamento", nullable = false)
    @Min(value = 1990)
    @Max(value = 2030)
    private int anoLancamento;
}
