package dev.java10x.CadastroDeNinjas.Ninjas.Model;

import dev.java10x.CadastroDeNinjas.Missoes.Model.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "missoes")
//ele transforma uma classe em uma entidade no DB
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(unique = true)
    private String email;
    @Column(name = "idade")
    private int idade;
    @Column(name = "rank")
    private String Rank;
    @Column(name = "img")
    private String img;
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreing Key
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String rank) {
        Rank = rank;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public MissoesModel getMissoes() {
        return missoes;
    }

    public void setMissoes(MissoesModel missoes) {
        this.missoes = missoes;
    }
}
