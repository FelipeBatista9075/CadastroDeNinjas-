package dev.java10x.CadastroDeNinjas.Missoes.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroDeNinjas.Missoes.Model.Enum.RankMissoes;
import dev.java10x.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDaMissao;
    private RankMissoes dificuldade;
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<NinjaModel> ninjas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDaMissao() {
        return nomeDaMissao;
    }

    public void setNomeDaMissao(String nomeDaMissao) {
        this.nomeDaMissao = nomeDaMissao;
    }

    public RankMissoes getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(RankMissoes dificuldade) {
        this.dificuldade = dificuldade;
    }

    public List<NinjaModel> getNinjas() {
        return ninjas;
    }

    public void setNinjas(List<NinjaModel> ninjas) {
        this.ninjas = ninjas;
    }
}
