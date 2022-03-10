package net.wilsonsantos.devweekphillips.Entities;

import javax.persistence.*;

@Entity
public class Incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    private Integer Regiao_id;
    private Integer mes;
    private Long Faixa_id;
    private Integer Qnt_exames;

    public Incidencia(Integer regiao_id, Integer mes, Long faixa_id, Integer qnt_exames) {
        Regiao_id = regiao_id;
        this.mes = mes;
        Faixa_id = faixa_id;
        Qnt_exames = qnt_exames;
    }

    public Incidencia(){}

    public Long getId() {
        return id;
    }

    public Integer getRegiao_id() {
        return Regiao_id;
    }

    public void setRegiao_id(Integer regiao_id) {
        Regiao_id = regiao_id;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Long getFaixa_id() {
        return Faixa_id;
    }

    public void setFaixa_id(Long faixa_id) {
        Faixa_id = faixa_id;
    }

    public Integer getQnt_exames() {
        return Qnt_exames;
    }

    public void setQnt_exames(Integer qnt_exames) {
        Qnt_exames = qnt_exames;
    }
}
