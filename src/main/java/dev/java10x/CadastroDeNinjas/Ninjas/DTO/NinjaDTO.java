package dev.java10x.CadastroDeNinjas.Ninjas.DTO;

import dev.java10x.CadastroDeNinjas.Missoes.Model.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String img;
    private String email;
    private String Rank;
    private int idade;
    private MissoesModel missoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String rank) {
        Rank = rank;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public MissoesModel getMissoes() {
        return missoes;
    }

    public void setMissoes(MissoesModel missoes) {
        this.missoes = missoes;
    }
}
