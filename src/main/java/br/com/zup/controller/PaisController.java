package br.com.zup.controller;

import br.com.zup.controller.dtos.CadastrarPaisRequest;
import br.com.zup.entity.Pais;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @PostMapping
    public String cadastrar(@RequestBody @Valid CadastrarPaisRequest request, UriComponentsBuilder builder){
        Pais pais = null;
        return null;
    }
}
