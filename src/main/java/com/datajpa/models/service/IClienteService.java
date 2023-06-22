package com.datajpa.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.datajpa.models.entity.Cliente;
import com.datajpa.models.entity.Factura;
import com.datajpa.models.entity.Producto;

public interface IClienteService {
	
	public List<Cliente> findAll();
	public Page<Cliente> findAll(Pageable pageable);
	public void save(Cliente cliente);
	public Cliente findByOne(Long id);
	public void deleteById(Long id);
    public List<Producto> findByNombre(String term);
    public void saveFactura(Factura factura);
    public Producto findProductoById(Long id);
    public Factura findFacturaById(Long id);
    public void deleteFactura(Long id);
    public Factura fecthFacturaByIdWithClienteWithItemFacturaWithProducto(Long id);
    public Cliente fetchByIdWithFacturas(Long id);
}
