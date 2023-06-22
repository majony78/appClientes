package com.datajpa.utils.paginator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {

	private String url;
	private Page<T> page;

	private int totalPaginas;

	private int numElemntosPorPagina;

	private int paginaActual;

	private List<PageItem> paginas;

	public PageRender(String url, Page<T> page) {
	
		this.url = url;
		this.page = page;
		this.paginas = new ArrayList<PageItem>();

		numElemntosPorPagina = page.getSize();
		totalPaginas = page.getTotalPages();
		paginaActual = page.getNumber() + 1;

		int desde, hasta;

		if (totalPaginas <= numElemntosPorPagina) {
			desde = 1;
			hasta = totalPaginas;
		} else {
			if (paginaActual <= numElemntosPorPagina / 2) {
				desde = 1;
				hasta = numElemntosPorPagina;
			} else if (paginaActual >= totalPaginas - numElemntosPorPagina / 2) {
				desde = totalPaginas - numElemntosPorPagina + 1;
				hasta = numElemntosPorPagina;
			} else {
				desde = paginaActual - numElemntosPorPagina / 2;
				hasta = numElemntosPorPagina;
			}
		}
		
		for(int i=0; i < hasta; i++) {
			paginas.add(new PageItem(desde + i, paginaActual == desde+i));
			
		}

	}

	public String getUrl() {
		return url;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public int getPaginaActual() {
		return paginaActual;
	}

	public List<PageItem> getPaginas() {
		return paginas;
	}
	
	
	public boolean isFirst() {
		return page.isFirst();
	}
	
	public boolean isLast() {
		return page.isLast();
	}
	
	public boolean isHasNext() {
		return page.hasNext();
	}
	
	
	public boolean isHasPrevious() {
		return page.hasPrevious();
	}
	
	
}
