package com.datajpa.view.json;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.datajpa.models.entity.Cliente;
import com.datajpa.models.service.IClienteService;



@Component("listar.json")
public class ClienteListJsonView extends MappingJackson2JsonView {
	
	@Autowired
	private IClienteService clienteService;

	@Override
	protected Object filterModel(Map<String, Object> model) {

		model.remove("titulo");
		model.remove("page");
		
		
		List<Cliente> clientes = clienteService.findAll();
		model.remove("clientes");
		model.put("clientes", clientes);

		return super.filterModel(model);
	}

}
