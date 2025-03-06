package dev.java10x.CadastroDeNinjas.Missoes.Contoller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "missoes")
public class MissaoController {

    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missao Criada";
    }

    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao Criada";
    }

    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao Alterada";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletada com sucesso";
    }
}
