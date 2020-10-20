package br.com.zup.controller;

import br.com.zup.controller.dtos.CadastrarPaisRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @PostMapping
    public void cadastrar(@RequestBody @Valid CadastrarPaisRequest request, UriComponentsBuilder builder){

    }
}
