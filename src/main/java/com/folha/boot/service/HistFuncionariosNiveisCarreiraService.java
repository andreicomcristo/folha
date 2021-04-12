package com.folha.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.HistFuncionariosNiveisCarreiraReposytory;
import com.folha.boot.domain.HistFuncionariosCargaHoraria;
import com.folha.boot.domain.HistFuncionariosClasse;
import com.folha.boot.domain.HistFuncionariosNiveisCarreira;
import com.folha.boot.domain.PessoaFuncionarios;

@Service
@Transactional(readOnly = false)
public class HistFuncionariosNiveisCarreiraService {

	@Autowired
	private  HistFuncionariosNiveisCarreiraReposytory reposytory;

	public void salvar(HistFuncionariosNiveisCarreira histFuncionariosNiveisCarreira) {
		reposytory.save(histFuncionariosNiveisCarreira);
	}

	public void editar(HistFuncionariosNiveisCarreira histFuncionariosNiveisCarreira) {
		reposytory.save(histFuncionariosNiveisCarreira);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public HistFuncionariosNiveisCarreira buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<HistFuncionariosNiveisCarreira> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	public List<HistFuncionariosNiveisCarreira> buscarPorFuncionario(PessoaFuncionarios pessoaFuncionarios) {
		// TODO Auto-generated method stub
		return reposytory.findByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(pessoaFuncionarios);
	}

	
	public HistFuncionariosNiveisCarreira converteEmHistFuncionarios(String justificativa, PessoaFuncionarios pessoaFuncionarios) {
		HistFuncionariosNiveisCarreira histFuncionarios = new HistFuncionariosNiveisCarreira();
		histFuncionarios.setDtCadastro(pessoaFuncionarios.getDtCadastro());
		histFuncionarios.setDtCancelamento(pessoaFuncionarios.getDtCancelamento());
		histFuncionarios.setIdFuncionarioFk(pessoaFuncionarios);
		histFuncionarios.setIdOperadorCadastroFk(pessoaFuncionarios.getIdOperadorCadastroFk());
		histFuncionarios.setIdOperadorCancelamentoFk(pessoaFuncionarios.getIdOperadorCancelamentoFk());
		histFuncionarios.setIdNivelCarreiraFk(pessoaFuncionarios.getIdNivelCarreiraAtualFk());
		histFuncionarios.setMotivoCadastro(justificativa);
		if(histFuncionarios.getDtCancelamento()!=null) {
			histFuncionarios.setMotivoCancelamento(justificativa);
		}
		
		return histFuncionarios;
	}
	
	public boolean verSeEstaCadastrado(HistFuncionariosNiveisCarreira histFuncionarios) {
		boolean resposta = false;	
		List<HistFuncionariosNiveisCarreira> lista = reposytory.findFirstByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(histFuncionarios.getIdFuncionarioFk());
		if(!lista.isEmpty()) {
			if(lista.get(0).getIdNivelCarreiraFk()==histFuncionarios.getIdNivelCarreiraFk()) {resposta = true;}
		}
		return resposta;
	}
	
	public void cadastrar(String justificativa, PessoaFuncionarios pessoaFuncionarios){
		HistFuncionariosNiveisCarreira histFuncionarios = converteEmHistFuncionarios( justificativa, pessoaFuncionarios);
		if(verSeEstaCadastrado(histFuncionarios)==false) {
			salvar(histFuncionarios);
		}
	}
	
}
