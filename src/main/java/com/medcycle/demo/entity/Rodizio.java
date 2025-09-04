package com.medcycle.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "rodizio")
public class Rodizio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    @Enumerated(EnumType.STRING)
    private Turno turno;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "local_parceiro_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private LocalParceiro localParceiro;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "especialidade_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Especialidade especialidade;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "preceptor_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario preceptor;

    private int vagas;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalParceiro getLocalParceiro() { return localParceiro; }
    public void setLocalParceiro(LocalParceiro localParceiro) { this.localParceiro = localParceiro; }

    public Especialidade getEspecialidade() { return especialidade; }
    public void setEspecialidade(Especialidade especialidade) { this.especialidade = especialidade; }

    public Usuario getPreceptor() { return preceptor; }
    public void setPreceptor(Usuario preceptor) { this.preceptor = preceptor; }

    public LocalDateTime getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDateTime dataInicio) { this.dataInicio = dataInicio; }

    public LocalDateTime getDataFim() { return dataFim; }
    public void setDataFim(LocalDateTime dataFim) { this.dataFim = dataFim; }

    public Turno getTurno() { return turno; }
    public void setTurno(Turno turno) { this.turno = turno; }

    public int getVagas() { return vagas; }
    public void setVagas(int vagas) { this.vagas = vagas; }
}

enum Turno {
    MANHA, TARDE, NOITE
}
