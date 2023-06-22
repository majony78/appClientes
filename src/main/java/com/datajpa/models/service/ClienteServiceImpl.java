package com.datajpa.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datajpa.models.dao.IClienteDAO;
import com.datajpa.models.dao.IFacturaDAO;
import com.datajpa.models.dao.IProductoDAO;
import com.datajpa.models.entity.Cliente;
import com.datajpa.models.entity.Factura;
import com.datajpa.models.entity.Producto;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDAO clienteDAO;

	@Autowired
	private IProductoDAO productoDAO;

	@Autowired
	private IFacturaDAO facturaDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDAO.save(cliente);

	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findByOne(Long id) {
		return clienteDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		clienteDAO.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteDAO.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombre(String term) {
		return productoDAO.findByNombre(term);
	}

	@Override
	@Transactional
	public void saveFactura(Factura factura) {

		facturaDAO.save(factura);

	}

	@Override
	@Transactional(readOnly = true)
	public Producto findProductoById(Long id) {

		return productoDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Factura findFacturaById(Long id) {
		
		return facturaDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteFactura(Long id) {
		facturaDAO.deleteById(id);;
		
	}

	@Override
	@Transactional(readOnly = true)
	public Factura fecthFacturaByIdWithClienteWithItemFacturaWithProducto(Long id) {
		return facturaDAO.fectchByIdWithClienteWithItemFacturaWithProducto(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente fetchByIdWithFacturas(Long id) {
		return clienteDAO.fetchByIdWithFacturas(id);
	}

}
