package com.datajpa.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.datajpa.models.entity.Factura;

public interface IFacturaDAO  extends CrudRepository<Factura, Long>{
	
	@Query("select f from Factura f join fetch f.cliente c join fetch f.items l join fetch l.producto where f.id=?1")
	public Factura fectchByIdWithClienteWithItemFacturaWithProducto(Long id);

}
