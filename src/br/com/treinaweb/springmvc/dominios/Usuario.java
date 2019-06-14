package br.com.treinaweb.springmvc.dominios;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 10)
    @Size(min = 3, max = 10, message = "O nome de usuário de conter entre 3 e 10 caracteres")
    @NotEmpty
    private String username;

    @Column(length = 150, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String role;
}
