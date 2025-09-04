package com.medcycle.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "checkin")
public class Checkin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario aluno;

    @ManyToOne(fetch = FetchType.EAGER)
    private Rodizio rodizio;

    private LocalDateTime dataHoraCheckin;
    private LocalDateTime dataHoraCheckout;

    private boolean presente;
    private boolean valido; // Validado pelo preceptor

    // getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getAluno() { return aluno; }
    public void setAluno(Usuario aluno) { this.aluno = aluno; }

    public Rodizio getRodizio() { return rodizio; }
    public void setRodizio(Rodizio rodizio) { this.rodizio = rodizio; }

    public LocalDateTime getDataHoraCheckin() { return dataHoraCheckin; }
    public void setDataHoraCheckin(LocalDateTime dataHoraCheckin) { this.dataHoraCheckin = dataHoraCheckin; }

    public LocalDateTime getDataHoraCheckout() { return dataHoraCheckout; }
    public void setDataHoraCheckout(LocalDateTime dataHoraCheckout) { this.dataHoraCheckout = dataHoraCheckout; }

    public boolean getPresente() { return presente; }
    public void setPresente(boolean presente) { this.presente = presente; }

    public boolean getValido() { return valido; }
    public void setValido(boolean valido) { this.valido = valido; }


}
