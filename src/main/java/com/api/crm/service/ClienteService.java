package com.api.crm.service;

import java.util.List;

import com.api.crm.model.Cliente;

public interface ClienteService {
	List<Cliente> getClientes();
	Cliente consultaPorId(long id);
	Cliente salvar(Cliente cliente);
	
}
