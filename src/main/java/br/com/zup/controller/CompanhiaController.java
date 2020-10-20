package br.com.zup.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.controller.dtos.NovaCompanhiaRequest;

@RestController
@RequestMapping("/companhias")
public class CompanhiaController {
	
	@PostMapping
	public String cadastrarCompanhia(@Valid @RequestBody NovaCompanhiaRequest request) {
		
		return request.toString();
		
	}
	
}
