package com.api.crm.controller;

import org.springframework.web.bind.annotation.RestController;

import com.api.crm.model.Cliente;
import com.api.crm.repository.ClienteRepository;
import com.api.crm.service.ClienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@RequestMapping("/clientes")
@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteService.getClientes();
	}
	
	@GetMapping(value = "/{id}")
	public Cliente consultarId(@PathVariable long id) {
		return clienteService.consultaPorId(id);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Cliente edit(@RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente Add(@RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}
}
