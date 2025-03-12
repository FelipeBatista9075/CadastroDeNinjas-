package dev.java10x.CadastroDeNinjas.Missoes.Mapper;

import dev.java10x.CadastroDeNinjas.Missoes.DTO.MissoesDTO;
import dev.java10x.CadastroDeNinjas.Missoes.Model.MissoesModel;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO){
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNomeDaMissao(missoesDTO.getNomeDaMissao());
        missoesModel.setNinjas(missoesDTO.getNinjas());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());

        return missoesModel;
    }

    public MissoesDTO map(MissoesModel missoesModel){
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNomeDaMissao(missoesModel.getNomeDaMissao());
        missoesDTO.setNinjas(missoesModel.getNinjas());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());

        return  missoesDTO;
    }
}
