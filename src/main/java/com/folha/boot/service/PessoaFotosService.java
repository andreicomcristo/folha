package com.folha.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFotos;

public interface PessoaFotosService {
	
	void salvar(PessoaFotos pessoaFotos);

	void editar(PessoaFotos pessoaFotos);

	void excluir(Long id);

	PessoaFotos buscarPorId(Long id);

	List<PessoaFotos> buscarTodos();
	
	PessoaFotos saveFile(MultipartFile file, Pessoa pessoa); 
	
	Optional<PessoaFotos> getFile(Long id);
	
	List<PessoaFotos> getFiles();
	
	
}
