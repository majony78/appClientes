package com.datajpa.models.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.datajpa.models.entity.Cliente;

public interface IClienteDAO extends PagingAndSortingRepository<Cliente, Long> {
	
	@Query("select c from Cliente c left join fetch c.facturas f where c.id=?1")
	public Cliente fetchByIdWithFacturas(Long id);
	

}
