package br.com.zup.controller;

import br.com.zup.controller.dtos.CadastrarPaisRequest;
import br.com.zup.entity.Pais;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid CadastrarPaisRequest request, UriComponentsBuilder builder){
        Pais pais = request.toModel();
        this.manager.persist(pais);
        return ResponseEntity.created(builder.path("/paises/{id}").buildAndExpand(pais.getId()).toUri()).build();
    }
}
