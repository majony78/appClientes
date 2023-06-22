package com.datajpa.view.csv;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;
import org.supercsv.io.CsvListWriter;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.prefs.CsvPreference;

import com.datajpa.models.entity.Cliente;
import com.datajpa.models.service.IClienteService;

@Component("listar.csv")
public class ClienteCsvView extends AbstractView {

	/*
	   De esta manera obtendremos una lista con el clienteService y luego usando
	   ICsvListWriter.
	   En el video lo hacen desde el bean y desde el model se obtiene
	   el page , entonces no sale la lista completa , solo la lista del Page , osea
	   5 en este caso.
	 */

	@Autowired
	private IClienteService clienteService;

	public ClienteCsvView() {
		setContentType("text/csv");
	}

	@Override
	protected boolean generatesDownloadContent() {

		return true;
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition", "attachmnet; filename=\"clientes.csv\"");
		response.setContentType(getContentType());

		ICsvListWriter listWriter = null;

		List<Cliente> clientes = clienteService.findAll();

		listWriter = new CsvListWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

		String header[] = { "id", "nombre", "apellido", "email", "createAt" };
		listWriter.writeHeader(header);

		for (Cliente cliente : clientes) {
			listWriter.write(cliente, header);
		}

		listWriter.close();
	}

}
