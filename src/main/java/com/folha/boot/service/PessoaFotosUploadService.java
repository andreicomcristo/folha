package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.folha.boot.Reposytory.PessoaFotosReposytory;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.domain.PessoaFotos;



@Service
public class PessoaFotosUploadService {
	
	@Autowired
	private PessoaFotosReposytory pessoaFotosReposytory;
	
	public PessoaFotos saveFile(MultipartFile file, Pessoa pessoa) {
		try {
			PessoaFotos pessoaFotos  = new PessoaFotos(pessoa, file.getBytes());
			return pessoaFotosReposytory.save(pessoaFotos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<PessoaFotos> getAllProduct()
	{
		return pessoaFotosReposytory.findAll();
	}
    public void deleteProductById(Long id)
    {
    	pessoaFotosReposytory.deleteById(id);
    }
    
    public List<PessoaFotos> buscarPorPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return pessoaFotosReposytory.findByIdPessoaFk(pessoa);
	}
    
}
