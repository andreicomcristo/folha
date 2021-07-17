package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.HistFuncionariosUnidadeAtuacaoReposytory;
import com.folha.boot.domain.HistFuncionariosUnidadeAtuacao;
import com.folha.boot.domain.PessoaFuncionarios;

@Service
@Transactional(readOnly = false)
public class HistFuncionariosUnidadeAtuacaoService {

	@Autowired
	private HistFuncionariosUnidadeAtuacaoReposytory reposytory;
	
	
	public void salvar(HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacao) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosUnidadeAtuacao);
	}

	
	public void editar(HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacao) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosUnidadeAtuacao);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public HistFuncionariosUnidadeAtuacao buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<HistFuncionariosUnidadeAtuacao> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	public List<HistFuncionariosUnidadeAtuacao> buscarPorFuncionario(PessoaFuncionarios pessoaFuncionarios) {
		// TODO Auto-generated method stub
		return reposytory.findByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(pessoaFuncionarios);
	}


	public HistFuncionariosUnidadeAtuacao converteEmHistFuncionarios(String justificativa, PessoaFuncionarios pessoaFuncionarios) {
		HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacao = new HistFuncionariosUnidadeAtuacao();
		histFuncionariosUnidadeAtuacao.setDtCadastro(pessoaFuncionarios.getDtCadastro());
		histFuncionariosUnidadeAtuacao.setDtCancelamento(pessoaFuncionarios.getDtCancelamento());
		histFuncionariosUnidadeAtuacao.setIdFuncionarioFk(pessoaFuncionarios);
		histFuncionariosUnidadeAtuacao.setIdOperadorCadastroFk(pessoaFuncionarios.getIdOperadorCadastroFk());
		histFuncionariosUnidadeAtuacao.setIdOperadorCancelamentoFk(pessoaFuncionarios.getIdOperadorCancelamentoFk());
		histFuncionariosUnidadeAtuacao.setIdUnidadeFk(pessoaFuncionarios.getIdUnidadeAtuacaoAtualFk());
		histFuncionariosUnidadeAtuacao.setMotivoCadastro(justificativa);
		if(histFuncionariosUnidadeAtuacao.getDtCancelamento()!=null) {
			histFuncionariosUnidadeAtuacao.setMotivoCancelamento(justificativa);
		}
		
		return histFuncionariosUnidadeAtuacao;
	}
	
	public boolean verSeEstaCadastrado(HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacao) {
		boolean resposta = false;	
		List<HistFuncionariosUnidadeAtuacao> lista = reposytory.findFirstByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(histFuncionariosUnidadeAtuacao.getIdFuncionarioFk());
		if(!lista.isEmpty()) {
			if(lista.get(0).getIdUnidadeFk()==histFuncionariosUnidadeAtuacao.getIdUnidadeFk()) {resposta = true;}
		}
		return resposta;
	}
	
	public void cadastrar(String justificativa, PessoaFuncionarios pessoaFuncionarios){
		HistFuncionariosUnidadeAtuacao histFuncionariosUnidadeAtuacao = converteEmHistFuncionarios( justificativa, pessoaFuncionarios);
		if(verSeEstaCadastrado(histFuncionariosUnidadeAtuacao)==false) {
			salvar(histFuncionariosUnidadeAtuacao);
		}
	}
	
	
	
}
