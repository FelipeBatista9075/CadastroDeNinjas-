package dev.java10x.CadastroDeNinjas.Missoes.Contoller;

import dev.java10x.CadastroDeNinjas.Missoes.DTO.MissoesDTO;
import dev.java10x.CadastroDeNinjas.Missoes.Service.MissoesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("missoes/ui")
public class MissoesControllerUi {

    private final MissoesService missoesService;

    public MissoesControllerUi(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public String listarMissoes(Model model){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        model.addAttribute("missoes", missoes);
        return "listarMissoes";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id){
        missoesService.deletar(id);
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String listarPorId(@PathVariable Long id, Model model){
        MissoesDTO missao = missoesService.listarMissaoPorId(id);
        if (missao != null){
            model.addAttribute("missao", missao);
            return "detalhesMissoes";
        } else {
            model.addAttribute("mensagem", "Missao Nao catalogada");
            return "detalheMissoes";
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioMissoes(Model model){
        model.addAttribute("missao", new MissoesDTO());
        return "adicionarMissoes";
    }

    @PostMapping("/salvar")
    public String criarMissao(@ModelAttribute MissoesDTO missao, RedirectAttributes redirectAttributes){
        missoesService.criarMissao(missao);
        redirectAttributes.addFlashAttribute("mensagem", "Missao adicionada com sucesso");
        return "redirect:/missoes/ui/listar";
    }


}
