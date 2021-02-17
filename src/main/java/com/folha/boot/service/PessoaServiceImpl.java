package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.PessoaReposytory;
import com.folha.boot.domain.Pessoa;
import com.folha.boot.service.util.UtilidadesDeTexto;

@Service
@Transactional(readOnly = false)
public class PessoaServiceImpl implements PessoaService{

	@Autowired
	private PessoaReposytory reposytory;
	
	@Override
	public void salvar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		reposytory.save(pessoa);
	}

	@Override
	public void editar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		reposytory.save(pessoa);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Pessoa buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Pessoa> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	@Override
	public Pessoa converteEmMaiusculo(Pessoa pessoa) {
		// TODO Auto-generated method stub
		pessoa.setCpf(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(pessoa.getCpf()));
		pessoa.setEmail(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(pessoa.getEmail()));
		pessoa.setEmailSaude(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(pessoa.getEmailSaude()));
		pessoa.setFone1(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(pessoa.getFone1()));
		pessoa.setFone2(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(pessoa.getFone2()));
		pessoa.setFone3(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(pessoa.getFone3()));
		pessoa.setMoivoCancelamento(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(pessoa.getMoivoCancelamento()));
		pessoa.setNome(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(pessoa.getNome()));
		pessoa.setNomeMae(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(pessoa.getNomeMae()));
		pessoa.setNomePai(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(pessoa.getNomePai()));
		
		return null;
	}

	@Override
	public List<Pessoa> buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return reposytory.findByNomeContainingOrderByNomeAsc(nome);
	}
	
}
