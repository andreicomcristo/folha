package com.folha.boot.service;

import java.util.List;
import java.util.Optional;
import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.folha.boot.Reposytory.DocumentosReposytory;
import com.folha.boot.Reposytory.PessoaFotosReposytory;
import com.folha.boot.domain.Doc;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFotos;

@Service
@Transactional(readOnly = false)
public class PessoaFotosService {

	@Autowired
	private PessoaFotosReposytory reposytory;
	
	public void salvar(PessoaFotos pessoaFotos) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaFotos);
	}

	
	public void editar(PessoaFotos pessoaFotos) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaFotos);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public PessoaFotos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<PessoaFotos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	public PessoaFotos saveFile(MultipartFile file, Pessoa pessoa) {
		String fileName = file.getOriginalFilename();

		try {
			PessoaFotos pessoaFotos = new PessoaFotos(pessoa, file.getBytes());
			return reposytory.save(pessoaFotos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public Optional<PessoaFotos> getFile(Long id) {
		return reposytory.findById(id);
	}

	
	public List<PessoaFotos> getFiles() {
		return reposytory.findAll();
	}
	

}
