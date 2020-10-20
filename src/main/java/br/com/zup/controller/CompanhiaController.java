package br.com.zup.controller;

import br.com.zup.controller.dtos.NovaCompanhiaRequest;
import br.com.zup.entity.Pais;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/companhias")
public class CompanhiaController {

	@PersistenceContext
	private EntityManager entityManager;

	private Logger log = LoggerFactory.getLogger(CompanhiaController.class);

	@PostMapping
	public ResponseEntity<?> cadastrarCompanhia(@Valid @RequestBody NovaCompanhiaRequest request) {
		Optional<Pais> pais = Optional.ofNullable(this.entityManager.find(Pais.class, request.getIdPais()));
		if (pais.isEmpty()) {
			log.error("Pais=[{}] não encontrado", request.getIdPais());
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(String.format("Pais=[%s] não existe", request.getIdPais()));
		}

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
