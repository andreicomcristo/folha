package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.EnderecosReposytory;
import com.folha.boot.domain.Cidades;
import com.folha.boot.domain.Enderecos;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaDocumentosTitulo;
import com.folha.boot.domain.endereco.Endereco;
import com.folha.boot.web.controller.ControladorCEPBean;

@Service
@Transactional(readOnly = false)
public class EnderecosServices{
	@Autowired
	private EnderecosReposytory reposytory;
	
	

	public void salvar(Enderecos enderecos) {
		// TODO Auto-generated method stub
		reposytory.save(enderecos);
	}
	
	public void editar(Enderecos enderecos) {
		// TODO Auto-generated method stub
		reposytory.save(enderecos);
	}

	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Enderecos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	public List<Enderecos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	public List<Enderecos> buscarPorNome(String enderecoLogradouro) {
		// TODO Auto-generated method stub
		return reposytory.findByEnderecoLogradouroContainingOrderByEnderecoLogradouroAsc(enderecoLogradouro);
	}

	public List<Enderecos> buscarPorPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return reposytory.findByIdPessoaFk(pessoa);
	}
}
