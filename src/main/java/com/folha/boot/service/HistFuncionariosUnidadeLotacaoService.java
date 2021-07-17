package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.HistFuncionariosUnidadeLotacaoReposytory;
import com.folha.boot.domain.HistFuncionariosUnidadeLotacao;
import com.folha.boot.domain.PessoaFuncionarios;

@Service
@Transactional(readOnly = false)
public class HistFuncionariosUnidadeLotacaoService {

	@Autowired
	private HistFuncionariosUnidadeLotacaoReposytory reposytory;
	
	
	public void salvar(HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacao) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosUnidadeLotacao);
	}

	
	public void editar(HistFuncionariosUnidadeLotacao histFuncionariosUnidadeLotacao) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosUnidadeLotacao);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public HistFuncionariosUnidadeLotacao buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<HistFuncionariosUnidadeLotacao> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	public List<HistFuncionariosUnidadeLotacao> buscarPorFuncionario(PessoaFuncionarios pessoaFuncionarios) {
		// TODO Auto-generated method stub
		return reposytory.findByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(pessoaFuncionarios);
	}

	
	public HistFuncionariosUnidadeLotacao converteEmHistFuncionarios(String justificativa, PessoaFuncionarios pessoaFuncionarios) {
		HistFuncionariosUnidadeLotacao histFuncionarios = new HistFuncionariosUnidadeLotacao();
		histFuncionarios.setDtCadastro(pessoaFuncionarios.getDtCadastro());
		histFuncionarios.setDtCancelamento(pessoaFuncionarios.getDtCancelamento());
		histFuncionarios.setIdFuncionarioFk(pessoaFuncionarios);
		histFuncionarios.setIdOperadorCadastroFk(pessoaFuncionarios.getIdOperadorCadastroFk());
		histFuncionarios.setIdOperadorCancelamentoFk(pessoaFuncionarios.getIdOperadorCancelamentoFk());
		histFuncionarios.setIdUnidadeFk(pessoaFuncionarios.getIdUnidadeAtuacaoAtualFk());
		histFuncionarios.setMotivoCadastro(justificativa);
		if(histFuncionarios.getDtCancelamento()!=null) {
			histFuncionarios.setMotivoCancelamento(justificativa);
		}
		
		return histFuncionarios;
	}
	
	public boolean verSeEstaCadastrado(HistFuncionariosUnidadeLotacao histFuncionariosUnidadeAtuacao) {
		boolean resposta = false;	
		List<HistFuncionariosUnidadeLotacao> lista = reposytory.findFirstByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(histFuncionariosUnidadeAtuacao.getIdFuncionarioFk());
		if(!lista.isEmpty()) {
			if(lista.get(0).getIdUnidadeFk()==histFuncionariosUnidadeAtuacao.getIdUnidadeFk()) {resposta = true;}
		}
		return resposta;
	}
	
	public void cadastrar(String justificativa, PessoaFuncionarios pessoaFuncionarios){
		HistFuncionariosUnidadeLotacao histFuncionarios = converteEmHistFuncionarios( justificativa, pessoaFuncionarios);
		if(verSeEstaCadastrado(histFuncionarios)==false) {
			salvar(histFuncionarios);
		}
	}

}
