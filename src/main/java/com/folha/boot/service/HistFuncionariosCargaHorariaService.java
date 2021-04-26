package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.HistFuncionariosCargaHorariaReposytory;
import com.folha.boot.domain.HistFuncionariosCargaHoraria;
import com.folha.boot.domain.HistFuncionariosUnidadeLotacao;
import com.folha.boot.domain.PessoaFuncionarios;

@Service
@Transactional(readOnly = false)
public class HistFuncionariosCargaHorariaService{

	@Autowired
	private HistFuncionariosCargaHorariaReposytory reposytory;
	
	
	public void salvar(HistFuncionariosCargaHoraria histFuncionariosCargaHoraria) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosCargaHoraria);
	}

	
	public void editar(HistFuncionariosCargaHoraria histFuncionariosCargaHoraria) {
		// TODO Auto-generated method stub
		reposytory.save(histFuncionariosCargaHoraria);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public HistFuncionariosCargaHoraria buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<HistFuncionariosCargaHoraria> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	public List<HistFuncionariosCargaHoraria> buscarPorFuncionario(PessoaFuncionarios pessoaFuncionarios) {
		// TODO Auto-generated method stub
		return reposytory.findByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(pessoaFuncionarios);
	}


	public HistFuncionariosCargaHoraria converteEmHistFuncionarios(String justificativa, PessoaFuncionarios pessoaFuncionarios) {
		HistFuncionariosCargaHoraria histFuncionarios = new HistFuncionariosCargaHoraria();
		histFuncionarios.setDtCadastro(pessoaFuncionarios.getDtCadastro());
		histFuncionarios.setDtCancelamento(pessoaFuncionarios.getDtCancelamento());
		histFuncionarios.setIdFuncionarioFk(pessoaFuncionarios);
		histFuncionarios.setIdOperadorCadastroFk(pessoaFuncionarios.getIdOperadorCadastroFk());
		histFuncionarios.setIdOperadorCancelamentoFk(pessoaFuncionarios.getIdOperadorCancelamentoFk());
		histFuncionarios.setIdCargaHorariaSemanalFk(pessoaFuncionarios.getIdCargaHorariaAtualFk());
		histFuncionarios.setMotivoCadastro(justificativa);
		if(histFuncionarios.getDtCancelamento()!=null) {
			histFuncionarios.setMotivoCancelamento(justificativa);
		}
		
		return histFuncionarios;
	}
	
	public boolean verSeEstaCadastrado(HistFuncionariosCargaHoraria histFuncionarios) {
		boolean resposta = false;	
		List<HistFuncionariosCargaHoraria> lista = reposytory.findFirstByIdFuncionarioFkAndDtCancelamentoIsNullOrderByIdDesc(histFuncionarios.getIdFuncionarioFk());
		if(!lista.isEmpty()) {
			if(lista.get(0).getIdCargaHorariaSemanalFk()==histFuncionarios.getIdCargaHorariaSemanalFk()) {resposta = true;}
		}
		return resposta;
	}
	
	public void cadastrar(String justificativa, PessoaFuncionarios pessoaFuncionarios){
		HistFuncionariosCargaHoraria histFuncionarios = converteEmHistFuncionarios( justificativa, pessoaFuncionarios);
		if(verSeEstaCadastrado(histFuncionarios)==false) {
			salvar(histFuncionarios);
		}
	}
	
}
