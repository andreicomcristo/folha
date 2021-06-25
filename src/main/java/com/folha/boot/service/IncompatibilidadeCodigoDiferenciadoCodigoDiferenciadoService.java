package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.IncompatibilidadeCodigoDiferenciadoCodigoDiferenciadoReposytory;
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.EscalaCodDiferenciado;
import com.folha.boot.domain.IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado;
import com.folha.boot.service.seguranca.UsuarioService;

@Service
public class IncompatibilidadeCodigoDiferenciadoCodigoDiferenciadoService implements GenericService<IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado> {

    @Autowired
    private IncompatibilidadeCodigoDiferenciadoCodigoDiferenciadoReposytory reposytory;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private EscalaCodDiferenciadoService escalaCodDiferenciadoService;

	

	//@Override
	public void editar(IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado incompatibilidadeCodigoDiferenciadoCodigoDiferenciado) {
		reposytory.save(incompatibilidadeCodigoDiferenciadoCodigoDiferenciado);

	}

	

	@Transactional(readOnly = true)
	//@Override
	public List<IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdCodigoDiferenciadoFkNomeCodigoDiferenciadoAscIdCodigoDiferenciadoIncompativelFkNomeCodigoDiferenciadoAsc();
	}
	
	public List<IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado> buscarPorNome( String nome) {
		return reposytory.findByIdCodigoDiferenciadoFkNomeCodigoDiferenciadoContainingOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdCodigoDiferenciadoFkNomeCodigoDiferenciadoAscIdCodigoDiferenciadoIncompativelFkNomeCodigoDiferenciadoAsc( nome.toUpperCase().trim());
	}
	
	@Transactional(readOnly = true)
	public Page<IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdCodigoDiferenciadoFkNomeCodigoDiferenciadoAscIdCodigoDiferenciadoIncompativelFkNomeCodigoDiferenciadoAsc(  pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdCodigoDiferenciadoFkNomeCodigoDiferenciadoContainingOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdCodigoDiferenciadoFkNomeCodigoDiferenciadoAscIdCodigoDiferenciadoIncompativelFkNomeCodigoDiferenciadoAsc(  nome.toUpperCase().trim(), pageable);
	}
	
    
    
    @Override
    public void salvar(IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado GrupoUsuario) {
    	reposytory.save(GrupoUsuario);
    }

    @Override
    public void excluir(Long id) {
    	reposytory.deleteById(id);
    }

    @Override
    public IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado buscarPorId(Long id) {
        return reposytory.findById(id).get();
    }
    
    public List<IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado> buscarPorCodigoDiferenciado(CodigoDiferenciado codigoDiferenciado) {
        return reposytory.findByIdCodigoDiferenciadoFkOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdCodigoDiferenciadoFkNomeCodigoDiferenciadoAscIdCodigoDiferenciadoIncompativelFkNomeCodigoDiferenciadoAsc(codigoDiferenciado);
    }
    
    public boolean jaCadastrado(CodigoDiferenciado codigoDiferenciado, CodigoDiferenciado codigoDiferenciadoIncompativel) {
    	boolean resposta = false;
    	if( !reposytory.findByIdCodigoDiferenciadoFkAndIdCodigoDiferenciadoIncompativelFkOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdCodigoDiferenciadoFkNomeCodigoDiferenciadoAscIdCodigoDiferenciadoIncompativelFkNomeCodigoDiferenciadoAsc(codigoDiferenciado, codigoDiferenciadoIncompativel).isEmpty()  ) {
    		resposta = true;
    	}
    	return resposta;
    }

    
    public boolean jaCadastradoConsiderandoId(IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado incompatibilidadeCodigoDiferenciadoCodigoDiferenciado) {
    	boolean resposta = false;
        List <IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado> lista = reposytory.findByIdCodigoDiferenciadoFkAndIdCodigoDiferenciadoIncompativelFkOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdCodigoDiferenciadoFkNomeCodigoDiferenciadoAscIdCodigoDiferenciadoIncompativelFkNomeCodigoDiferenciadoAsc(incompatibilidadeCodigoDiferenciadoCodigoDiferenciado.getIdCodigoDiferenciadoFk(), incompatibilidadeCodigoDiferenciadoCodigoDiferenciado.getIdCodigoDiferenciadoIncompativelFk()); 
        for(IncompatibilidadeCodigoDiferenciadoCodigoDiferenciado g: lista) {
        	if(   !g.getId().equals(incompatibilidadeCodigoDiferenciadoCodigoDiferenciado.getId())   ) {
        		if(  (g.getIdCodigoDiferenciadoFk().equals(incompatibilidadeCodigoDiferenciadoCodigoDiferenciado.getIdCodigoDiferenciadoFk()))  &&    (g.getIdCodigoDiferenciadoIncompativelFk().equals(incompatibilidadeCodigoDiferenciadoCodigoDiferenciado.getIdCodigoDiferenciadoIncompativelFk()))  ) {
        			resposta = true;
        		}
        	}
        }
    	return resposta;
    }

    public CodigoDiferenciado compatibilidadeEscalaIncompatibilidade(EscalaCodDiferenciado escalaCodDiferenciado) {
    	CodigoDiferenciado resposta = null;
    	
    	List<EscalaCodDiferenciado> listaCodigosNaEscala = escalaCodDiferenciadoService.buscarPorEscala(escalaCodDiferenciado.getIdEscalaFk());
    		for(int i=0; i<listaCodigosNaEscala.size();i++) {
    			boolean prerequisitoCadastrado = jaCadastrado(escalaCodDiferenciado.getIdCodigoDiferenciadoFk(), listaCodigosNaEscala.get(i).getIdCodigoDiferenciadoFk());
    			boolean prerequisitoCadastradoReverso = jaCadastrado( listaCodigosNaEscala.get(i).getIdCodigoDiferenciadoFk(), escalaCodDiferenciado.getIdCodigoDiferenciadoFk() );
    			
    			if(prerequisitoCadastrado==true || prerequisitoCadastradoReverso==true) {
    				resposta = listaCodigosNaEscala.get(i).getIdCodigoDiferenciadoFk();
    			}
    			
    		}
    
    	return resposta;
    }
    
    
    
    
   
}
