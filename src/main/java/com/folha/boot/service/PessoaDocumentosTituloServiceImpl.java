package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.PessoaDocumentosTituloReposytory;
import com.folha.boot.domain.PessoaDocumentosTitulo;
import com.folha.boot.service.util.UtilidadesDeTexto;

@Service
@Transactional(readOnly = false)
public class PessoaDocumentosTituloServiceImpl implements PessoaDocumentosTituloService{

	@Autowired
	private PessoaDocumentosTituloReposytory reposytory;
	@Override
	public void salvar(PessoaDocumentosTitulo pessoaDocumentosTitulo) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentosTitulo);
	}

	@Override
	public void editar(PessoaDocumentosTitulo pessoaDocumentosTitulo) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentosTitulo);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public PessoaDocumentosTitulo buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<PessoaDocumentosTitulo> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	@Override
	public PessoaDocumentosTitulo converteEmMaiusculo(PessoaDocumentosTitulo pessoaDocumentosTitulo) {
		// TODO Auto-generated method stub
		pessoaDocumentosTitulo.setNumeroTitulo(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(pessoaDocumentosTitulo.getNumeroTitulo()));
		pessoaDocumentosTitulo.setSecao(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(pessoaDocumentosTitulo.getSecao()));
		pessoaDocumentosTitulo.setZona(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(pessoaDocumentosTitulo.getZona()));
		return pessoaDocumentosTitulo;
	}

	@Override
	public List<PessoaDocumentosTitulo> buscarPorNumero(String numeroTitulo) {
		// TODO Auto-generated method stub
		return reposytory.findByNumeroTituloContainingOrderByNumeroTituloAsc(numeroTitulo);
	}

}
