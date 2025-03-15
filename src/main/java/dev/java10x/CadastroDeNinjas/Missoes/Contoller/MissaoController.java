package dev.java10x.CadastroDeNinjas.Missoes.Contoller;

import dev.java10x.CadastroDeNinjas.Missoes.DTO.MissoesDTO;
import dev.java10x.CadastroDeNinjas.Missoes.Service.MissoesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    private final MissoesService missoesService;

    public MissaoController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        return ResponseEntity.ok().body(missoesService.listarMissoes());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissaoPorId(@PathVariable Long id){
        if (missoesService.listarMissaoPorId(id) != null){
            MissoesDTO missao = missoesService.listarMissaoPorId(id);
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao nao encontrada no catalogo de missoes");
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoes){
        return  ResponseEntity.ok("missao criada com sucesso: id:" + missoes.getId() + " Nome: " + missoes.getNomeDaMissao());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){
        if (missoesService.listarMissaoPorId(id) != null){
            missaoAtualizada = missoesService.atualizarMissao(id, missaoAtualizada);
            return ResponseEntity.ok().body("Missao atualizada com sucesso: " + missaoAtualizada.getId() + " - " + missaoAtualizada.getNomeDaMissao());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao nao encontrada no catalogo");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
        if (missoesService.listarMissaoPorId(id) != null){
            missoesService.deletar(id);
            return ResponseEntity.ok("missao com id - " + id + " - deletado com sucesso");
        } else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao nao encontrada no catalogo");
        }
    }
}
