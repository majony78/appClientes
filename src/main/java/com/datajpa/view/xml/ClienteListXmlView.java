package com.datajpa.view.xml;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.xml.MarshallingView;

import com.datajpa.models.entity.Cliente;
import com.datajpa.models.service.IClienteService;

@Component("listar.xml")
public class ClienteListXmlView extends MarshallingView {
	
	@Autowired
	private IClienteService clienteService;
	
	
	@Autowired
	public ClienteListXmlView(Jaxb2Marshaller marshaller) {
		super(marshaller);
		
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		model.remove("titulo");
		model.remove("page");
		
		List<Cliente> clientes = clienteService.findAll();
		model.remove("clientes");
		
		model.put("clienteList", new ClienteList(clientes));
		
		
		
		super.renderMergedOutputModel(model, request, response);
	}

}
