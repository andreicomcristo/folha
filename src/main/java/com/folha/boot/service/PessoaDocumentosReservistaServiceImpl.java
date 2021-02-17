package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.PessoaDocumentosReservistaReposytory;
import com.folha.boot.domain.PessoaDocumentosReservista;
import com.folha.boot.service.util.UtilidadesDeTexto;

@Service
@Transactional(readOnly = false)
public class PessoaDocumentosReservistaServiceImpl implements PessoaDocumentosReservistaService{

	@Autowired
	private PessoaDocumentosReservistaReposytory reposytory;
	
	@Override
	public void salvar(PessoaDocumentosReservista pessoaDocumentosReservista) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentosReservista);
	}

	@Override
	public void editar(PessoaDocumentosReservista pessoaDocumentosReservista) {
		// TODO Auto-generated method stub
		reposytory.save(pessoaDocumentosReservista);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public PessoaDocumentosReservista buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<PessoaDocumentosReservista> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	@Override
	public PessoaDocumentosReservista converteEmMaiusculo(PessoaDocumentosReservista pessoaDocumentosReservista) {
		// TODO Auto-generated method stub
		pessoaDocumentosReservista.setNumero(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(pessoaDocumentosReservista.getNumero()));
		pessoaDocumentosReservista.setSerie(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(pessoaDocumentosReservista.getSerie()));
		return pessoaDocumentosReservista;
	}

	@Override
	public List<PessoaDocumentosReservista> buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return reposytory.findByNumeroContainingOrderByNumeroAsc(numero);
	}

}
