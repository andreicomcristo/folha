package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.HistFuncionariosCarreiraReposytory;
import com.folha.boot.domain.HistFuncionariosCargaHoraria;
import com.folha.boot.domain.HistFuncionariosCargos;
import com.folha.boot.domain.HistFuncionariosCarreira;
import com.folha.boot.domain.PessoaFuncionarios;

@Service
@Transactional(readOnly = false)
public class HistFuncionariosCarreiraService {

	@Autowired
	private HistFuncionariosCarreiraReposytory reposytory;
	
	public void salvar(HistFuncionariosCarreira histFuncionariosCarreira) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosCarreira);
	}

	
	public void editar(HistFuncionariosCarreira histFuncionariosCarreira) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosCarreira);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public HistFuncionariosCarreira buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<HistFuncionariosCarreira> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	public List<HistFuncionariosCarreira> buscarPorFuncionario(PessoaFuncionarios pessoaFuncionarios) {
		// TODO Auto-generated method stub
		return reposytory.findByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(pessoaFuncionarios);
	}


	public HistFuncionariosCarreira converteEmHistFuncionarios(String justificativa, PessoaFuncionarios pessoaFuncionarios) {
		HistFuncionariosCarreira histFuncionarios = new HistFuncionariosCarreira();
		histFuncionarios.setDtCadastro(pessoaFuncionarios.getDtCadastro());
		histFuncionarios.setDtCancelamento(pessoaFuncionarios.getDtCancelamento());
		histFuncionarios.setIdFuncionarioFk(pessoaFuncionarios);
		histFuncionarios.setIdOperadorCadastroFk(pessoaFuncionarios.getIdOperadorCadastroFk());
		histFuncionarios.setIdOperadorCancelamentoFk(pessoaFuncionarios.getIdOperadorCancelamentoFk());
		histFuncionarios.setIdCarreiraFk(pessoaFuncionarios.getIdCarreiraAtualFk());
		histFuncionarios.setMotivoCadastro(justificativa);
		if(histFuncionarios.getDtCancelamento()!=null) {
			histFuncionarios.setMotivoCancelamento(justificativa);
		}
		
		return histFuncionarios;
	}
	
	public boolean verSeEstaCadastrado(HistFuncionariosCarreira histFuncionarios) {
		boolean resposta = false;	
		List<HistFuncionariosCarreira> lista = reposytory.findFirstByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(histFuncionarios.getIdFuncionarioFk());
		if(!lista.isEmpty()) {
			if(lista.get(0).getIdCarreiraFk()==histFuncionarios.getIdCarreiraFk()) {resposta = true;}
		}
		return resposta;
	}
	
	public void cadastrar(String justificativa, PessoaFuncionarios pessoaFuncionarios){
		HistFuncionariosCarreira histFuncionarios = converteEmHistFuncionarios( justificativa, pessoaFuncionarios);
		if(verSeEstaCadastrado(histFuncionarios)==false) {
			salvar(histFuncionarios);
		}
	}
	
}
