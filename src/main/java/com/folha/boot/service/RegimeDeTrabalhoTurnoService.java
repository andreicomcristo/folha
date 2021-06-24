package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.RegimeDeTrabalhoTurnoReposytory;
import com.folha.boot.domain.RegimeDeTrabalhoTurno;
import com.folha.boot.domain.RegimesDeTrabalho;
import com.folha.boot.domain.Turnos;
import com.folha.boot.service.seguranca.UsuarioService;

@Service
public class RegimeDeTrabalhoTurnoService implements GenericService<RegimeDeTrabalhoTurno> {

    @Autowired
    private RegimeDeTrabalhoTurnoReposytory reposytory;
    @Autowired
    private UsuarioService usuarioService;

	

	//@Override
	public void editar(RegimeDeTrabalhoTurno regimeDeTrabalhoTurno) {
		reposytory.save(regimeDeTrabalhoTurno);

	}

	

	@Transactional(readOnly = true)
	//@Override
	public List<RegimeDeTrabalhoTurno> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByIdRegimeDeTrabalhoFkNomeRegimeDeTrabalhoAscIdTurnoFkNomeTurnoAsc();
	}
	
	public List<RegimeDeTrabalhoTurno> buscarPorNome( String nome) {
		return reposytory.findByIdRegimeDeTrabalhoFkNomeRegimeDeTrabalhoContainingOrderByIdRegimeDeTrabalhoFkNomeRegimeDeTrabalhoAscIdTurnoFkNomeTurnoAsc( nome.toUpperCase().trim());
	}
	
	@Transactional(readOnly = true)
	public Page<RegimeDeTrabalhoTurno> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByIdRegimeDeTrabalhoFkNomeRegimeDeTrabalhoAscIdTurnoFkNomeTurnoAsc(  pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<RegimeDeTrabalhoTurno> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdRegimeDeTrabalhoFkNomeRegimeDeTrabalhoContainingOrderByIdRegimeDeTrabalhoFkNomeRegimeDeTrabalhoAscIdTurnoFkNomeTurnoAsc(  nome.toUpperCase().trim(), pageable);
	}
	
    
    
    @Override
    public void salvar(RegimeDeTrabalhoTurno GrupoUsuario) {
    	reposytory.save(GrupoUsuario);
    }

    @Override
    public void excluir(Long id) {
    	reposytory.deleteById(id);
    }

    @Override
    public RegimeDeTrabalhoTurno buscarPorId(Long id) {
        return reposytory.findById(id).get();
    }
    
    public List<RegimeDeTrabalhoTurno> buscarPorRegime(RegimesDeTrabalho regimesDeTrabalho) {
        return reposytory.findByIdRegimeDeTrabalhoFkOrderByIdRegimeDeTrabalhoFkNomeRegimeDeTrabalhoAscIdTurnoFkNomeTurnoAsc(regimesDeTrabalho);
    }
   
    
    public boolean jaCadastrado(RegimesDeTrabalho regimesDeTrabalho, Turnos turno) {
    	boolean resposta = false;
    	if( !reposytory.findByIdRegimeDeTrabalhoFkAndIdTurnoFkOrderByIdRegimeDeTrabalhoFkNomeRegimeDeTrabalhoAscIdTurnoFkNomeTurnoAsc(regimesDeTrabalho, turno).isEmpty()  ) {
    		resposta = true;
    	}
    	return resposta;
    }

    
    public boolean jaCadastradoConsiderandoId(RegimeDeTrabalhoTurno regimeDeTrabalhoTurno) {
    	boolean resposta = false;
        List <RegimeDeTrabalhoTurno> lista = reposytory.findByIdRegimeDeTrabalhoFkAndIdTurnoFkOrderByIdRegimeDeTrabalhoFkNomeRegimeDeTrabalhoAscIdTurnoFkNomeTurnoAsc(regimeDeTrabalhoTurno.getIdRegimeDeTrabalhoFk(), regimeDeTrabalhoTurno.getIdTurnoFk()); 
        for(RegimeDeTrabalhoTurno g: lista) {
        	if(   !g.getId().equals(regimeDeTrabalhoTurno.getId())   ) {
        		if(  (g.getIdRegimeDeTrabalhoFk().equals(regimeDeTrabalhoTurno.getIdRegimeDeTrabalhoFk()))  &&    (g.getIdTurnoFk().equals(regimeDeTrabalhoTurno.getIdTurnoFk()))  ) {
        			resposta = true;
        		}
        	}
        }
    	return resposta;
    }

    
   
}
