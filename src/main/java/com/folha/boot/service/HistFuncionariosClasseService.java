package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.HistFuncionariosClasseReposytory;
import com.folha.boot.domain.HistFuncionariosCargaHoraria;
import com.folha.boot.domain.HistFuncionariosCarreira;
import com.folha.boot.domain.HistFuncionariosClasse;
import com.folha.boot.domain.PessoaFuncionarios;

@Service
@Transactional(readOnly = false)
public class HistFuncionariosClasseService {

	@Autowired
	private HistFuncionariosClasseReposytory reposytory;
	
	public void salvar(HistFuncionariosClasse histFuncionariosClasse) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosClasse);
	}

	
	public void editar(HistFuncionariosClasse histFuncionariosClasse) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosClasse);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public HistFuncionariosClasse buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<HistFuncionariosClasse> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	public List<HistFuncionariosClasse> buscarPorFuncionario(PessoaFuncionarios pessoaFuncionarios) {
		// TODO Auto-generated method stub
		return reposytory.findByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(pessoaFuncionarios);
	}


	public HistFuncionariosClasse converteEmHistFuncionarios(String justificativa, PessoaFuncionarios pessoaFuncionarios) {
		HistFuncionariosClasse histFuncionarios = new HistFuncionariosClasse();
		histFuncionarios.setDtCadastro(pessoaFuncionarios.getDtCadastro());
		histFuncionarios.setDtCancelamento(pessoaFuncionarios.getDtCancelamento());
		histFuncionarios.setIdFuncionarioFk(pessoaFuncionarios);
		histFuncionarios.setIdOperadorCadastroFk(pessoaFuncionarios.getIdOperadorCadastroFk());
		histFuncionarios.setIdOperadorCancelamentoFk(pessoaFuncionarios.getIdOperadorCancelamentoFk());
		histFuncionarios.setIdClasseFk(pessoaFuncionarios.getIdClasseCarreiraAtualFk());
		histFuncionarios.setMotivoCadastro(justificativa);
		if(histFuncionarios.getDtCancelamento()!=null) {
			histFuncionarios.setMotivoCancelamento(justificativa);
		}
		
		return histFuncionarios;
	}
	
	public boolean verSeEstaCadastrado(HistFuncionariosClasse histFuncionarios) {
		boolean resposta = false;	
		List<HistFuncionariosClasse> lista = reposytory.findFirstByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(histFuncionarios.getIdFuncionarioFk());
		if(!lista.isEmpty()) {
			if(lista.get(0).getIdClasseFk()==histFuncionarios.getIdClasseFk()) {resposta = true;}
		}
		return resposta;
	}
	
	public void cadastrar(String justificativa, PessoaFuncionarios pessoaFuncionarios){
		HistFuncionariosClasse histFuncionarios = converteEmHistFuncionarios( justificativa, pessoaFuncionarios);
		if(verSeEstaCadastrado(histFuncionarios)==false) {
			salvar(histFuncionarios);
		}
	}
	
	
}
