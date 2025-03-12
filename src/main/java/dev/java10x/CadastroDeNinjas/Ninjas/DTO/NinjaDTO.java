package dev.java10x.CadastroDeNinjas.Ninjas.DTO;

import dev.java10x.CadastroDeNinjas.Missoes.Model.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private String Rank;
    private int idade;
    private MissoesModel missoes;


}
