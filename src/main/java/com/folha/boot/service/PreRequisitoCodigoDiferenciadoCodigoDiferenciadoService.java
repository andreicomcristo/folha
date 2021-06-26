package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.PreRequisitoCodigoDiferenciadoCodigoDiferenciadoReposytory;
import com.folha.boot.domain.CodigoDiferenciado;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.EscalaCodDiferenciado;
import com.folha.boot.domain.PreRequisitoCodigoDiferenciadoCodigoDiferenciado;
import com.folha.boot.service.seguranca.UsuarioService;

@Service
public class PreRequisitoCodigoDiferenciadoCodigoDiferenciadoService implements GenericService<PreRequisitoCodigoDiferenciadoCodigoDiferenciado> {

    @Autowired
    private PreRequisitoCodigoDiferenciadoCodigoDiferenciadoReposytory reposytory;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private EscalaCodDiferenciadoService escalaCodDiferenciadoService;

	

	//@Override
	public void editar(PreRequisitoCodigoDiferenciadoCodigoDiferenciado preRequisitoCodigoDiferenciadoCodigoDiferenciado) {
		reposytory.save(preRequisitoCodigoDiferenciadoCodigoDiferenciado);

	}

	

	@Transactional(readOnly = true)
	//@Override
	public List<PreRequisitoCodigoDiferenciadoCodigoDiferenciado> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdCodigoDiferenciadoFkNomeCodigoDiferenciadoAscIdCodigoDiferenciadoCompativelFkNomeCodigoDiferenciadoAsc();
	}
	
	public List<PreRequisitoCodigoDiferenciadoCodigoDiferenciado> buscarPorNome( String nome) {
		return reposytory.findByIdCodigoDiferenciadoFkNomeCodigoDiferenciadoContainingOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdCodigoDiferenciadoFkNomeCodigoDiferenciadoAscIdCodigoDiferenciadoCompativelFkNomeCodigoDiferenciadoAsc( nome.toUpperCase().trim());
	}
	
	@Transactional(readOnly = true)
	public Page<PreRequisitoCodigoDiferenciadoCodigoDiferenciado> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdCodigoDiferenciadoFkNomeCodigoDiferenciadoAscIdCodigoDiferenciadoCompativelFkNomeCodigoDiferenciadoAsc(  pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<PreRequisitoCodigoDiferenciadoCodigoDiferenciado> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdCodigoDiferenciadoFkNomeCodigoDiferenciadoContainingOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdCodigoDiferenciadoFkNomeCodigoDiferenciadoAscIdCodigoDiferenciadoCompativelFkNomeCodigoDiferenciadoAsc(  nome.toUpperCase().trim(), pageable);
	}
	
    
    
    @Override
    public void salvar(PreRequisitoCodigoDiferenciadoCodigoDiferenciado GrupoUsuario) {
    	reposytory.save(GrupoUsuario);
    }

    @Override
    public void excluir(Long id) {
    	reposytory.deleteById(id);
    }

    @Override
    public PreRequisitoCodigoDiferenciadoCodigoDiferenciado buscarPorId(Long id) {
        return reposytory.findById(id).get();
    }
    
    public List<PreRequisitoCodigoDiferenciadoCodigoDiferenciado> buscarPorCodigoDiferenciado(CodigoDiferenciado codigoDiferenciado) {
        return reposytory.findByIdCodigoDiferenciadoFkOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdCodigoDiferenciadoFkNomeCodigoDiferenciadoAscIdCodigoDiferenciadoCompativelFkNomeCodigoDiferenciadoAsc(codigoDiferenciado);
    }
    
    public boolean jaCadastrado(CodigoDiferenciado codigoDiferenciado, CodigoDiferenciado codigoDiferenciadoCompativel) {
    	boolean resposta = false;
    	if( !reposytory.findByIdCodigoDiferenciadoFkAndIdCodigoDiferenciadoCompativelFkOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdCodigoDiferenciadoFkNomeCodigoDiferenciadoAscIdCodigoDiferenciadoCompativelFkNomeCodigoDiferenciadoAsc(codigoDiferenciado, codigoDiferenciadoCompativel).isEmpty()  ) {
    		resposta = true;
    	}
    	return resposta;
    }

    
    public boolean jaCadastradoConsiderandoId(PreRequisitoCodigoDiferenciadoCodigoDiferenciado preRequisitoCodigoDiferenciadoCodigoDiferenciado) {
    	boolean resposta = false;
        List <PreRequisitoCodigoDiferenciadoCodigoDiferenciado> lista = reposytory.findByIdCodigoDiferenciadoFkAndIdCodigoDiferenciadoCompativelFkOrderByIdCodigoDiferenciadoFkIdUnidadeFkNomeFantasiaAscIdCodigoDiferenciadoFkNomeCodigoDiferenciadoAscIdCodigoDiferenciadoCompativelFkNomeCodigoDiferenciadoAsc(preRequisitoCodigoDiferenciadoCodigoDiferenciado.getIdCodigoDiferenciadoFk(), preRequisitoCodigoDiferenciadoCodigoDiferenciado.getIdCodigoDiferenciadoCompativelFk()); 
        for(PreRequisitoCodigoDiferenciadoCodigoDiferenciado g: lista) {
        	if(   !g.getId().equals(preRequisitoCodigoDiferenciadoCodigoDiferenciado.getId())   ) {
        		if(  (g.getIdCodigoDiferenciadoFk().equals(preRequisitoCodigoDiferenciadoCodigoDiferenciado.getIdCodigoDiferenciadoFk()))  &&    (g.getIdCodigoDiferenciadoCompativelFk().equals(preRequisitoCodigoDiferenciadoCodigoDiferenciado.getIdCodigoDiferenciadoCompativelFk()))  ) {
        			resposta = true;
        		}
        	}
        }
    	return resposta;
    }

    public CodigoDiferenciado compatibilidadeEscalaPreRequisito(EscalaCodDiferenciado escalaCodDiferenciado) {
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
