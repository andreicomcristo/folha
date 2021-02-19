package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.PaisesReposytoty;
import com.folha.boot.domain.Paises;
import com.folha.boot.service.util.UtilidadesDeTexto;

@Service
@Transactional(readOnly = false)
public class PaisesSeviceImpl implements PaisesSevice{
	
	@Autowired
	private PaisesReposytoty reposytory;
	
	@Override
	public void salvar(Paises paises) {
		// TODO Auto-generated method stub
		reposytory.save(paises);
	}

	@Override
	public void editar(Paises paises) {
		// TODO Auto-generated method stub
		reposytory.save(paises);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Paises buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Paises> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByNomePaisAsc();
	}

	@Override
	public List<Paises> buscarPorNome(String nomePais) {
		return reposytory.findByNomePaisContainingOrderByNomePaisAsc(nomePais);
	}

}
