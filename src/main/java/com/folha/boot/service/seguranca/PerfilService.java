package com.folha.boot.service.seguranca;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.PerfilReposytory;
import com.folha.boot.domain.FaixasValoresFolhExt;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.seguranca.GrupoUsuario;
import com.folha.boot.domain.seguranca.Perfil;

@Service
@Transactional(readOnly = false)
public class PerfilService {

	@Autowired
	private  PerfilReposytory reposytory;

	public void salvar(Perfil perfil) {
		boolean podeSalvar = true;
		
		if(perfilJaCadastrado(perfil) ==true) {
			podeSalvar = false;
		}
		
		if(jaTemPerfilNaUnidade(perfil) ==true) {
			podeSalvar = false;
		}
		
		if(podeSalvar==true) {
			reposytory.save(perfil);
		}
	}

	public void editar(Perfil perfil) {
		reposytory.save(perfil);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public Perfil buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<Perfil> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<Perfil> buscarPorOperadorEUnidade(PessoaOperadores pessoaopOperadores, Unidades unidades) {
		// TODO Auto-generated method stub
		return reposytory.findFirstByIdOperadorFkAndIdUnidadeFk( pessoaopOperadores,  unidades);
		 
	}
	
	public boolean jaTemPerfilNaUnidade (Perfil perfil) {
		boolean resposta = false;
		if(!buscarPorOperadorEUnidade(perfil.getIdOperadorFk(), perfil.getIdUnidadeFk()).isEmpty()) {resposta = true;}
		return resposta;
	}
	
	public boolean perfilJaCadastrado (Perfil perfil) {
		boolean resposta = false;
		if(!buscarPorOperadorEUnidadeEGrupoUsuario(perfil).isEmpty()) {resposta = true;}
		return resposta;
	}
	
	@Transactional(readOnly = true)
	public List<Perfil> buscarPorOperadorEUnidadeEGrupoUsuario(Perfil perfil) {
		PessoaOperadores operador = perfil.getIdOperadorFk();
		Unidades unidade = perfil.getIdUnidadeFk();
		GrupoUsuario grupoUsuario = perfil.getIdGrupoUsuarioFk();
		
		// TODO Auto-generated method stub
		return reposytory.findFirstByIdOperadorFkAndIdUnidadeFkAndIdGrupoUsuarioFk( operador,  unidade, grupoUsuario);
	}
	
	
	
	public Page<Perfil> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByIdOperadorFkIdPessoaFkNomeAscIdUnidadeFkNomeFantasiaAsc(pageable);
	}

	public Page<Perfil> findPaginatedNome(int pageNo, int pageSize, String nome) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdOperadorFkIdPessoaFkNomeContainingOrderByIdOperadorFkIdPessoaFkNomeAscIdUnidadeFkNomeFantasiaAsc(nome.toUpperCase().trim(), pageable);
	}
	
	
}
