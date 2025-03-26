package dev.java10x.CadastroDeNinjas.Missoes.Contoller;

import dev.java10x.CadastroDeNinjas.Missoes.DTO.MissoesDTO;
import dev.java10x.CadastroDeNinjas.Missoes.Service.MissoesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Lista todas as missoes", description = "Rota lista todas as missoes catalogadas")
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        return ResponseEntity.ok().body(missoesService.listarMissoes());
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista uma missao por id", description = "Rota lista uma missao pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missao encontrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Missao nao encontarda")
    })
    public ResponseEntity<?> listarMissaoPorId(
            @Parameter(description = "Usuario manda o id no caminho da requisicao")
            @PathVariable Long id){
        if (missoesService.listarMissaoPorId(id) != null){
            MissoesDTO missao = missoesService.listarMissaoPorId(id);
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao nao encontrada no catalogo de missoes");
        }
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria uma nova missao", description = "Rota cria uma nova missao e insere no banco de dados")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoes){
        return  ResponseEntity.ok("missao criada com sucesso: id:" + missoes.getId() + " Nome: " + missoes.getNomeDaMissao());
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Atualiza uma missao", description = "Rota atualiza uma missao por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "missao atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "missao nao encontrada no catalago")
    })
    public ResponseEntity<String> alterarMissao(
            @Parameter(description = "Usuario manda o id no caminho da requisicao")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados da missao a ser atualizada")
            @RequestBody MissoesDTO missaoAtualizada){
        if (missoesService.listarMissaoPorId(id) != null){
            missaoAtualizada = missoesService.atualizarMissao(id, missaoAtualizada);
            return ResponseEntity.ok().body("Missao atualizada com sucesso: " + missaoAtualizada.getId() + " - " + missaoAtualizada.getNomeDaMissao());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao nao encontrada no catalogo");
        }
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta uma missao", description = "Rota deleta uma missao por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "missao deletada com sucesso"),
            @ApiResponse(responseCode = "400", description = "missao nao encontrada no catalago")
    })
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
