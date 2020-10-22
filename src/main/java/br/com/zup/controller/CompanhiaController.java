package br.com.zup.controller;

import br.com.zup.controller.dtos.NovaCompanhiaRequest;
import br.com.zup.entity.Companhia;
import br.com.zup.entity.Pais;
import br.com.zup.validation.NomeCompanhiaValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/companhias")
public class CompanhiaController {

	@PersistenceContext
	private EntityManager entityManager;

	private Logger log = LoggerFactory.getLogger(CompanhiaController.class);

	@Autowired
	private NomeCompanhiaValidator nomeCompanhiaValidator;

//	@InitBinder
//	public void init(WebDataBinder binder){
//		binder.addValidators(nomeCompanhiaValidator);
//	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrarCompanhia(@Valid @RequestBody NovaCompanhiaRequest request) {

		Companhia companhia = request.toModel(entityManager);

		entityManager.persist(companhia);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
