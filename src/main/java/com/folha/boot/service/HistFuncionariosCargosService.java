package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.HistFuncionariosCargosReposytory;
import com.folha.boot.domain.HistFuncionariosCargaHoraria;
import com.folha.boot.domain.HistFuncionariosCargos;
import com.folha.boot.domain.PessoaFuncionarios;

@Service
@Transactional(readOnly = false)
public class HistFuncionariosCargosService {

	@Autowired
	private HistFuncionariosCargosReposytory reposytory;

	
	public void salvar(HistFuncionariosCargos histFuncionariosCargos) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosCargos);
	}

	
	public void editar(HistFuncionariosCargos histFuncionariosCargos) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosCargos);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public HistFuncionariosCargos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<HistFuncionariosCargos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	public List<HistFuncionariosCargos> buscarPorFuncionario(PessoaFuncionarios pessoaFuncionarios) {
		// TODO Auto-generated method stub
		return reposytory.findByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(pessoaFuncionarios);
	}


	public HistFuncionariosCargos converteEmHistFuncionarios(String justificativa, PessoaFuncionarios pessoaFuncionarios) {
		HistFuncionariosCargos histFuncionarios = new HistFuncionariosCargos();
		histFuncionarios.setDtCadastro(pessoaFuncionarios.getDtCadastro());
		histFuncionarios.setDtCancelamento(pessoaFuncionarios.getDtCancelamento());
		histFuncionarios.setIdFuncionarioFk(pessoaFuncionarios);
		histFuncionarios.setIdOperadorCadastroFk(pessoaFuncionarios.getIdOperadorCadastroFk());
		histFuncionarios.setIdOperadorCancelamentoFk(pessoaFuncionarios.getIdOperadorCancelamentoFk());
		histFuncionarios.setIdCargoFk(pessoaFuncionarios.getIdCargoAtualFk());
		histFuncionarios.setMotivoCadastro(justificativa);
		if(histFuncionarios.getDtCancelamento()!=null) {
			histFuncionarios.setMotivoCancelamento(justificativa);
		}
		
		return histFuncionarios;
	}
	
	public boolean verSeEstaCadastrado(HistFuncionariosCargos histFuncionarios) {
		boolean resposta = false;	
		List<HistFuncionariosCargos> lista = reposytory.findFirstByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(histFuncionarios.getIdFuncionarioFk());
		if(!lista.isEmpty()) {
			if(lista.get(0).getIdCargoFk()==histFuncionarios.getIdCargoFk()) {resposta = true;}
		}
		return resposta;
	}
	
	public void cadastrar(String justificativa, PessoaFuncionarios pessoaFuncionarios){
		HistFuncionariosCargos histFuncionarios = converteEmHistFuncionarios( justificativa, pessoaFuncionarios);
		if(verSeEstaCadastrado(histFuncionarios)==false) {
			salvar(histFuncionarios);
		}
	}
	
}
