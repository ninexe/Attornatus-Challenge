package com.api.crm.service.test;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.api.crm.util.*;
import com.api.crm.model.Cliente;
import com.api.crm.repository.ClienteRepository;
import com.api.crm.service.ClienteServiceImpl;
import com.api.crm.util.ClienteEx;


@ExtendWith(MockitoExtension.class)
@DisplayName("Cliente Service:")
public class ClienteServiceImplTests {
	
	ClienteEx cliente1 = ClienteEx.builder().cdCliente(Long.valueOf(1)).nmClienteEx("João").dtClienteEx("1999-01-01").build();
	
	
}
	

