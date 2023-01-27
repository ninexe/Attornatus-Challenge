package com.api.crm.service;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.crm.model.Cliente;
import com.api.crm.repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

	private ClienteRepository clienteRepository;
	private EnderecoService enderecoService;
	
	@Autowired
	public ClienteServiceImpl(ClienteRepository clienteRepository, EnderecoService enderecoService) {
		this.clienteRepository = clienteRepository;
		this.enderecoService = enderecoService;
	}

	@Override
	public List<Cliente> getClientes() {
		return clienteRepository.findAll();
	}

	@Override
	@Transactional
	public Cliente salvar(final Cliente cliente) {
		Cliente entity = new Cliente();
		if(cliente.getCdCliente() != null) {
			entity = clienteRepository.findById(cliente.getCdCliente()).orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado!"));
		}
		
		Objects.requireNonNull(cliente.getDtNascimento(), "Informe a data de nascimento!");
		
		if(cliente.getNmCliente() == null || cliente.getNmCliente().isEmpty()){
			throw new IllegalArgumentException("Informe o nome do Cliente!");
		}
		
		var enderecos = enderecoService.salvarEnderecos(cliente.getEnderecos());
		
		entity.setDtNascimento(cliente.getDtNascimento());
		entity.setNmCliente(cliente.getNmCliente());
		entity.setEnderecos(enderecos);
		
		return clienteRepository.save(entity);
	}

	@Override
	public Cliente consultaPorId(long id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
}
