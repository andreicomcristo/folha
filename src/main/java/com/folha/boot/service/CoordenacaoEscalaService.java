package com.folha.boot.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.folha.boot.Reposytory.CoordenacaoEscalaReposytory;
import com.folha.boot.domain.AcessoOperadoresCoordenacao;
import com.folha.boot.domain.CoordenacaoEscala;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.Unidades;

@Service
@Transactional(readOnly = false)
public class CoordenacaoEscalaService {

	@Autowired
	private  CoordenacaoEscalaReposytory reposytory;
	
	@Autowired
	private  AcessoOperadoresCoordenacaoService acessoOperadoresCoordenacaoService;

	public void salvar(CoordenacaoEscala coordenacaoEscala) {
		reposytory.save(coordenacaoEscala);
	}

	public void editar(CoordenacaoEscala coordenacaoEscala) {
		reposytory.save(coordenacaoEscala);

	}

	public void excluir(Long id) {
		reposytory.deleteById(id);

	}
	
	@Transactional(readOnly = true)
	public CoordenacaoEscala buscarPorId(Long id) {
		
		return reposytory.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public List<CoordenacaoEscala> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	@Transactional(readOnly = true)
	public List<CoordenacaoEscala> buscarNaUnidade(Unidades unidade) {
		// TODO Auto-generated method stub
		return reposytory.findByIdLocalidadeFkIdUnidadeFk(unidade);
	}
	
	@Transactional(readOnly = true)
	public List<CoordenacaoEscala> buscarAcessoIndividual(Unidades unidades, PessoaOperadores pessoaOperadores, List<AcessoOperadoresCoordenacao> listaDeCoordenacoes ) {
		
		List<CoordenacaoEscala> listaInicial = buscarTodos();
		
		List<CoordenacaoEscala> listaFinal = new ArrayList<CoordenacaoEscala>();
		
		for(int i=0;i<listaInicial.size();i++) {
			for(int j=0;j<listaDeCoordenacoes.size();j++) {
				if( (listaInicial.get(i).getId()==listaDeCoordenacoes.get(j).getIdCoordenacaoFk().getId()) &&  (listaInicial.get(i).getIdLocalidadeFk().getIdUnidadeFk().getId()==unidades.getId()) ) {
					listaFinal.add(listaInicial.get(i));
				}
			}
		}
		
		return listaFinal;
	}
	
	@Transactional(readOnly = true)
	public List<CoordenacaoEscala> buscarAcessoIndividualQueNaoTem(Unidades unidades, PessoaOperadores pessoaOperadores ) {
		
		List<CoordenacaoEscala> listaInicial = reposytory.findByIdLocalidadeFkIdUnidadeFk(unidades);
		
		List<AcessoOperadoresCoordenacao> listaQueTemAcesso = acessoOperadoresCoordenacaoService.buscarPorOperadorEUnidade(pessoaOperadores, unidades);
		
		List<CoordenacaoEscala> listaFinal = new ArrayList<CoordenacaoEscala>();
		
		for(int i=0;i<listaInicial.size();i++) {
			boolean entraNaLista = true;
			for(int j=0;j<listaQueTemAcesso.size();j++) {
				if(listaInicial.get(i)==listaQueTemAcesso.get(j).getIdCoordenacaoFk()) {entraNaLista = false;}
			}
		
			if(entraNaLista==true) {listaFinal.add(listaInicial.get(i));}
		
		}
		
		return listaFinal;
	}
	
	
	
}
