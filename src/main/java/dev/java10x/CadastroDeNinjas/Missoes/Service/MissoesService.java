package dev.java10x.CadastroDeNinjas.Missoes.Service;

import dev.java10x.CadastroDeNinjas.Missoes.DTO.MissoesDTO;
import dev.java10x.CadastroDeNinjas.Missoes.Mapper.MissoesMapper;
import dev.java10x.CadastroDeNinjas.Missoes.Model.MissoesModel;
import dev.java10x.CadastroDeNinjas.Missoes.Repository.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {
    private MissoesMapper missoesMapper;
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesMapper missoesMapper, MissoesRepository missoesRepository) {
        this.missoesMapper = missoesMapper;
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesDTO> listarMissoes(){
            List<MissoesModel> missoes = missoesRepository.findAll();
            return missoes.stream()
                    .map(missoesMapper::map)
                    .collect(Collectors.toList());
    }

    public MissoesDTO listarMissaoPorId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.map(missoesMapper::map).orElse(null);
    }
    public MissoesDTO criarMissao(MissoesDTO missoes){
        MissoesModel missao = new MissoesMapper().map(missoes);
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);

    }

    public void deletar(long id){
        missoesRepository.deleteById(id);
    }

    public MissoesDTO atualizarMissao(Long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if (missaoExistente.isPresent()){
            MissoesModel missaoAtualizada = missoesMapper.map(missoesDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return  missoesMapper.map(missaoSalva);
        }
        return null;
    }
}
