package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.TipoDeFolhaTurnoReposytory;
import com.folha.boot.domain.TipoDeFolhaTurno;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.domain.Turnos;
import com.folha.boot.service.seguranca.UsuarioService;

@Service
public class TipoDeFolhaTurnoService implements GenericService<TipoDeFolhaTurno> {

    @Autowired
    private TipoDeFolhaTurnoReposytory reposytory;
    @Autowired
    private UsuarioService usuarioService;

	

	//@Override
	public void editar(TipoDeFolhaTurno tipoDeFolhaTurno) {
		reposytory.save(tipoDeFolhaTurno);

	}

	

	@Transactional(readOnly = true)
	//@Override
	public List<TipoDeFolhaTurno> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByIdTipoDeFolhaFkNomeTipoFolhaAscIdTurnoFkNomeTurnoAsc();
	}
	
	public List<TipoDeFolhaTurno> buscarPorNome( String nome) {
		return reposytory.findByIdTipoDeFolhaFkNomeTipoFolhaContainingOrderByIdTipoDeFolhaFkNomeTipoFolhaAscIdTurnoFkNomeTurnoAsc( nome.toUpperCase().trim());
	}
	
	@Transactional(readOnly = true)
	public Page<TipoDeFolhaTurno> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByIdTipoDeFolhaFkNomeTipoFolhaAscIdTurnoFkNomeTurnoAsc(  pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<TipoDeFolhaTurno> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdTipoDeFolhaFkNomeTipoFolhaContainingOrderByIdTipoDeFolhaFkNomeTipoFolhaAscIdTurnoFkNomeTurnoAsc(  nome.toUpperCase().trim(), pageable);
	}
	
    
    
    @Override
    public void salvar(TipoDeFolhaTurno GrupoUsuario) {
    	reposytory.save(GrupoUsuario);
    }

    @Override
    public void excluir(Long id) {
    	reposytory.deleteById(id);
    }

    @Override
    public TipoDeFolhaTurno buscarPorId(Long id) {
        return reposytory.findById(id).get();
    }
    
    public List<TipoDeFolhaTurno> buscarPorTipoDeFolha(TiposDeFolha tiposDeFolha) {
        return reposytory.findByIdTipoDeFolhaFkOrderByIdTipoDeFolhaFkNomeTipoFolhaAscIdTurnoFkNomeTurnoAsc(tiposDeFolha);
    }
   
    
    public boolean jaCadastrado(TiposDeFolha tiposDeFolha, Turnos turno) {
    	boolean resposta = false;
    	if( !reposytory.findByIdTipoDeFolhaFkAndIdTurnoFkOrderByIdTipoDeFolhaFkNomeTipoFolhaAscIdTurnoFkNomeTurnoAsc(tiposDeFolha, turno).isEmpty()  ) {
    		resposta = true;
    	}
    	return resposta;
    }

    
    public boolean jaCadastradoConsiderandoId(TipoDeFolhaTurno tipoDeFolhaTurno) {
    	boolean resposta = false;
        List <TipoDeFolhaTurno> lista = reposytory.findByIdTipoDeFolhaFkAndIdTurnoFkOrderByIdTipoDeFolhaFkNomeTipoFolhaAscIdTurnoFkNomeTurnoAsc(tipoDeFolhaTurno.getIdTipoDeFolhaFk(), tipoDeFolhaTurno.getIdTurnoFk()); 
        for(TipoDeFolhaTurno g: lista) {
        	if(   !g.getId().equals(tipoDeFolhaTurno.getId())   ) {
        		if(  (g.getIdTipoDeFolhaFk().equals(tipoDeFolhaTurno.getIdTipoDeFolhaFk()))  &&    (g.getIdTurnoFk().equals(tipoDeFolhaTurno.getIdTurnoFk()))  ) {
        			resposta = true;
        		}
        	}
        }
    	return resposta;
    }

    
   
}
