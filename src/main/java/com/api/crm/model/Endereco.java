package com.api.crm.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_endereco" )
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_endereco", nullable = false)
	private Long cdEndereco;
	
	@Column(name = "de_logradouro", nullable = false)
	private String deLogradouro;
	
	@Column(name = "nr_cep", nullable = false, length = 8)
	private int nrCep;
	
	@Column(name = "nr_numero", nullable = false)
	private String nrNumero;
	
	@Column(name = "de_cidade", nullable = false)
	private String deCidade;
	
	@Column(name = "id_principal", nullable = false)
	private boolean idPrincipal;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "enderecos")
	@JsonBackReference
	private List<Cliente> clientes = new ArrayList();
}