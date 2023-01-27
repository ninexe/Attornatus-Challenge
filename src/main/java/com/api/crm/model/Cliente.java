package com.api.crm.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_cliente" )
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_cliente", nullable = false)
	private Long cdCliente;
	
	@Column(name = "nm_cliente", nullable = false, length = 40)
	private String nmCliente;
	
	@Column(name = "dt_nascimento", nullable = false)
	private LocalDate dtNascimento;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "cliente_has_endereco",	joinColumns = { @JoinColumn(name = "cd_cliente") },inverseJoinColumns = { @JoinColumn(name = "cd_endereco") })
	private List<Endereco> enderecos = new ArrayList();
}