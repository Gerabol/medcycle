package com.medcycle.demo.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "rodizio_aluno")
public class RodizioAluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Rodizio rodizio;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario aluno;

    @Enumerated(EnumType.STRING)
    private Status status;

    // getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Rodizio getRodizio() { return rodizio; }
    public void setRodizio(Rodizio rodizio) { this.rodizio = rodizio; }

    public Usuario getAluno() { return aluno; }
    public void setAluno(Usuario aluno) { this.aluno = aluno; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}

enum Status {
    ATIVO, FALTA, REPOSICAO, CONCLUIDO
}
