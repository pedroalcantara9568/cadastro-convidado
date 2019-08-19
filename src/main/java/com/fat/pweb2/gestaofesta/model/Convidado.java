package com.fat.pweb2.gestaofesta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Convidado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer qtdAcompanhantes;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQtdAcompanhantes() {
        return qtdAcompanhantes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQtdAcompanhantes(Integer qtdAcompanhantes) {

        this.qtdAcompanhantes = qtdAcompanhantes;
    }
}
