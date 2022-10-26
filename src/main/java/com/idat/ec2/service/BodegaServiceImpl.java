package com.idat.ec2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec2.model.Bodega;
import com.idat.ec2.repository.BodegaRepository;

@Service
public class BodegaServiceImpl implements BodegaService {
	
	@Autowired
	private BodegaRepository repository;
	
	

	@Override
	public void guardar(Bodega bodega) {
		repository.save(bodega);
		
	}

	@Override
	public void actualizar(Bodega bodega) {
		repository.saveAndFlush(bodega);
		
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Bodega> listar() {
		
		return repository.findAll();
	}

	@Override
	public Bodega obtener(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
