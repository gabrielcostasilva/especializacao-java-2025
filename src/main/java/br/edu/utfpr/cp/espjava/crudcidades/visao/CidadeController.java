package br.edu.utfpr.cp.espjava.crudcidades.visao;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CidadeController {

    @GetMapping("/")
    public String listar(Model memoria) {

        var cidades = Set.of(
            new Cidade("Cornélio Procópio", "PR"), 
            new Cidade("Assis", "SP"), 
            new Cidade("Itajaí", "SC")
        );

        memoria.addAttribute("listaCidades", cidades);

        return "/crud";
    }
}
