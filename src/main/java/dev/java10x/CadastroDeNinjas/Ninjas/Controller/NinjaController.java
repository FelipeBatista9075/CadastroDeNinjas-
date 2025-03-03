package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVinda(){
        return "Essa e a minha primeira mensagem nessa rota";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    // Mostrar todos os ninjas por id (CREATE)
    @GetMapping("/todosId")
    public String mostrarTodosPorId(){
        return  "Mostrar ninja por id";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/todos")
    public String mostrarTodos() {
        return "Mostrar todos";
    }

    // Alterar dados dos ninjas(UPDATE)
    @PutMapping("/alterarID")
    public String alterarPorId() {
        return "Alterar Ninja por id";
    }
    // Deletar Ninja(DELETE
    @DeleteMapping("/deletarID")
    public  String deletarNinjaPorId(){
        return "Ninja Deletado por id";
    }

}
