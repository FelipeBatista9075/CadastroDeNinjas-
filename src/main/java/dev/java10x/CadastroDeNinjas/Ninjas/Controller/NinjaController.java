package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import dev.java10x.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.Service.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem acessa ela")
    public String boasVinda(){
        return "Essa e minha primeira mensagem nessa rota";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja Criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criacao do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado com sucesso: (Id) " + novoNinja.getId() + " - " + novoNinja.getNome());
    }

    // Mostrar todos os ninjas por id (CREATE)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o ninja por id", description = "Rota lista um ninja pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Ninja nao encontrado")
    })
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        if (ninjaService.listarPorId(id) != null) {
            NinjaDTO ninja = ninjaService.listarPorId(id);
            return ResponseEntity.ok().body(ninja);
        } else  {
            String erroMsg = "Ninja do id - " + id + " - nao encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroMsg);
        }
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    @Operation(summary = "Lista todos os ninjas", description = "Rota lista todos os ninjas catalogados")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        return ResponseEntity.ok(ninjaService.listarNinjas());
    }

    // Alterar dados dos ninjas(UPDATE)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "altera o ninja por id", description = "Rota altera um ninja pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Ninja nao encontrado, nao foi possivel alterar")
    })
    public ResponseEntity<String> alterarPorId(
            @Parameter(description = "Usuario manda o id no caminho da requisicao")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do ninja a ser atualizado no corpo da requisicao")
            @RequestBody NinjaDTO ninjaAtualizado) {
        if (ninjaService.listarPorId(id) != null){
            ninjaService.atualizarNinja(id, ninjaAtualizado);
            return  ResponseEntity.status(HttpStatus.OK).body("Ninja do id - " + id + " - Atualizado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja nao encontrado");
        }
    }

    // Deletar Ninja(DELETE
    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta um ninja por id", description = "Rota Deleta um ninja pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Ninja nao encontardo")
    })
    public ResponseEntity<String> deletarNinjaPorId(
            @Parameter(description = "Usuario manda um id no caminho da requisicao")
            @PathVariable Long id){
        if (ninjaService.listarPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com id - " + id + " - deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id - " + id + " Nao encontrado");
        }
    }

}
