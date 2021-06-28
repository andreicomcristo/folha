package com.folha.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.RegimeDeTrabalhoTurnoReposytory;
import com.folha.boot.Reposytory.TipoDeFolhaTurnoReposytory;
import com.folha.boot.Reposytory.UnidadeTurnoReposytory;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.RegimeDeTrabalhoTurno;
import com.folha.boot.domain.RegimesDeTrabalho;
import com.folha.boot.domain.TipoDeFolhaTurno;
import com.folha.boot.domain.Turnos;
import com.folha.boot.domain.UnidadeTurno;
import com.folha.boot.service.seguranca.UsuarioService;

@Service
public class RegimeDeTrabalhoTurnoService implements GenericService<RegimeDeTrabalhoTurno> {

    @Autowired
    private RegimeDeTrabalhoTurnoReposytory reposytory;
    
    @Autowired
    private UnidadeTurnoReposytory unidadeTurnoReposytory;
    @Autowired
    private TipoDeFolhaTurnoReposytory tipoDeFolhaTurnoReposytory;
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
   
    public List<Turnos> buscarPorRegimesEUnidadeEFolha(Escala escala) {
    	List<Turnos> lista = new ArrayList<>();
    	
    	List<RegimeDeTrabalhoTurno> lista1 = reposytory.findByIdRegimeDeTrabalhoFkOrderByIdRegimeDeTrabalhoFkNomeRegimeDeTrabalhoAscIdTurnoFkNomeTurnoAsc(escala.getIdRegimeFk());
    	List<UnidadeTurno> lista2 = unidadeTurnoReposytory.findByIdUnidadeFkOrderByIdUnidadeFkNomeFantasiaAscIdTurnoFkNomeTurnoAsc(escala.getIdCoordenacaoFk().getIdLocalidadeFk().getIdUnidadeFk());
    	List<TipoDeFolhaTurno> lista3 = tipoDeFolhaTurnoReposytory.findByIdTipoDeFolhaFkOrderByIdTipoDeFolhaFkNomeTipoFolhaAscIdTurnoFkNomeTurnoAsc(escala.getIdTipoFolhaFk());
    	
    	List<Turnos> lista1A = new ArrayList<>();  
    	List<Turnos> lista2A = new ArrayList<>();
    	List<Turnos> lista3A = new ArrayList<>();
    	
    	for(RegimeDeTrabalhoTurno r: lista1) {
    		lista1A.add(r.getIdTurnoFk());
    	}
    	
    	for(UnidadeTurno r: lista2) {
    		lista2A.add(r.getIdTurnoFk());
    	}
    	
    	for(TipoDeFolhaTurno r: lista3) {
    		lista3A.add(r.getIdTurnoFk());
    	}
    	
    	for(int i=0;i<lista1A.size();i++) {
    		for(int j=0;j<lista2A.size();j++) {
    			for(int k=0;k<lista3A.size();k++) {
    				if( (lista1A.get(i).equals(lista2A.get(j))) && (lista1A.get(i).equals(lista3A.get(k)))  ) {
    					if(!lista.contains(lista1A.get(i))) {lista.add(lista1A.get(i));}
    				}
    			}
    		}
    	}
    	
        return lista;
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
