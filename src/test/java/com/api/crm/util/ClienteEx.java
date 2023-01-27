package com.api.crm.util;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder(toBuilder = true)
public class ClienteEx {
	private  Long cdCliente;
	private  String nmClienteEx;	
	private  String dtClienteEx;	
		
	
	
}

