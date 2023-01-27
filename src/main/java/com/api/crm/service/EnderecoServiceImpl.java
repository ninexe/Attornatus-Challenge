package com.api.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.crm.model.Endereco;
import com.api.crm.repository.EnderecoRepository;
import jakarta.transaction.Transactional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	@Transactional
	public List<Endereco> salvarEnderecos(List<Endereco> enderecos) {
		
		boolean existsIdPrincipal = enderecos.stream().filter(Endereco::isIdPrincipal).findFirst().isPresent();
		if(!existsIdPrincipal) {
			enderecos.stream().findFirst().ifPresent(e -> e.setIdPrincipal(true));
			existsIdPrincipal = true;
		}
		for(Endereco endereco : enderecos) {
			if(endereco.getDeLogradouro() == null || endereco.getDeLogradouro().isEmpty()){
				throw new IllegalArgumentException("Informe o nome do Cliente!");
			}
			
			if(endereco.getNrCep() == 0 || String.valueOf(endereco.getNrCep()).length() != 8){
				throw new IllegalArgumentException("Informe o nome do Cliente!");
			}
			
			if(endereco.getNrNumero() == null || endereco.getNrNumero().isEmpty()){
				throw new IllegalArgumentException("Informe o nome do Cliente!");
			}
			
			if(endereco.getDeCidade() == null || endereco.getDeCidade().isEmpty()){
				throw new IllegalArgumentException("Informe o nome do Cliente!");
			}
			
			if(!existsIdPrincipal) {
				endereco.setIdPrincipal(false);
				continue;
			}
			
			if(existsIdPrincipal && endereco.isIdPrincipal()) {
				endereco.setIdPrincipal(true);
				existsIdPrincipal = false;
			}
		}
		return enderecoRepository.saveAll(enderecos);
	}
}
