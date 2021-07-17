package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.UnidadeTurnoReposytory;
import com.folha.boot.domain.Turnos;
import com.folha.boot.domain.UnidadeTurno;
import com.folha.boot.domain.Unidades;
import com.folha.boot.service.seguranca.UsuarioService;

@Service
public class UnidadeTurnoService implements GenericService<UnidadeTurno> {

    @Autowired
    private UnidadeTurnoReposytory reposytory;
    @Autowired
    private UsuarioService usuarioService;

	

	//@Override
	public void editar(UnidadeTurno unidadeTurno) {
		reposytory.save(unidadeTurno);

	}

	

	@Transactional(readOnly = true)
	//@Override
	public List<UnidadeTurno> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByIdUnidadeFkNomeFantasiaAscIdTurnoFkNomeTurnoAsc();
	}
	
	public List<UnidadeTurno> buscarPorNome( String nome) {
		return reposytory.findByIdUnidadeFkNomeFantasiaContainingOrderByIdUnidadeFkNomeFantasiaAscIdTurnoFkNomeTurnoAsc( nome.toUpperCase().trim());
	}
	
	@Transactional(readOnly = true)
	public Page<UnidadeTurno> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByIdUnidadeFkNomeFantasiaAscIdTurnoFkNomeTurnoAsc(  pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<UnidadeTurno> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdUnidadeFkNomeFantasiaContainingOrderByIdUnidadeFkNomeFantasiaAscIdTurnoFkNomeTurnoAsc(  nome.toUpperCase().trim(), pageable);
	}
	
    
    
    @Override
    public void salvar(UnidadeTurno GrupoUsuario) {
    	reposytory.save(GrupoUsuario);
    }

    @Override
    public void excluir(Long id) {
    	reposytory.deleteById(id);
    }

    @Override
    public UnidadeTurno buscarPorId(Long id) {
        return reposytory.findById(id).get();
    }
    
    public List<UnidadeTurno> buscarPorUnidade(Unidades unidades) {
        return reposytory.findByIdUnidadeFkOrderByIdUnidadeFkNomeFantasiaAscIdTurnoFkNomeTurnoAsc(unidades);
    }
   
    
    public boolean jaCadastrado(Unidades unidades, Turnos turno) {
    	boolean resposta = false;
    	if( !reposytory.findByIdUnidadeFkAndIdTurnoFkOrderByIdUnidadeFkNomeFantasiaAscIdTurnoFkNomeTurnoAsc(unidades, turno).isEmpty()  ) {
    		resposta = true;
    	}
    	return resposta;
    }

    
    public boolean jaCadastradoConsiderandoId(UnidadeTurno unidadeTurno) {
    	boolean resposta = false;
        List <UnidadeTurno> lista = reposytory.findByIdUnidadeFkAndIdTurnoFkOrderByIdUnidadeFkNomeFantasiaAscIdTurnoFkNomeTurnoAsc(unidadeTurno.getIdUnidadeFk(), unidadeTurno.getIdTurnoFk()); 
        for(UnidadeTurno g: lista) {
        	if(   !g.getId().equals(unidadeTurno.getId())   ) {
        		if(  (g.getIdUnidadeFk().equals(unidadeTurno.getIdUnidadeFk()))  &&    (g.getIdTurnoFk().equals(unidadeTurno.getIdTurnoFk()))  ) {
        			resposta = true;
        		}
        	}
        }
    	return resposta;
    }

    
   
}
