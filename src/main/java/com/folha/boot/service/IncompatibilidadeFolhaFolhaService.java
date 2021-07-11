package com.folha.boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.IncompatibilidadeFolhaFolhaReposytory;
import com.folha.boot.domain.Escala;
import com.folha.boot.domain.IncompatibilidadeFolhaFolha;
import com.folha.boot.domain.IncompatibilidadeFolhaFolhaExcessao;
import com.folha.boot.domain.TiposDeFolha;
import com.folha.boot.service.seguranca.UsuarioService;

@Service
public class IncompatibilidadeFolhaFolhaService implements GenericService<IncompatibilidadeFolhaFolha> {

	@Autowired
    ObjectFactory<HttpSession> httpSessionFactory;
    @Autowired
    private IncompatibilidadeFolhaFolhaReposytory reposytory;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private IncompatibilidadeFolhaFolhaService incompatibilidadeFolhaFolhaService;
    @Autowired
    private IncompatibilidadeFolhaFolhaExcessaoService incompatibilidadeFolhaFolhaExcessaoService;
    @Autowired
    private EscalaService escalaService;

	

	//@Override
	public void editar(IncompatibilidadeFolhaFolha incompatibilidadeFolhaFolha) {
		reposytory.save(incompatibilidadeFolhaFolha);

	}

	

	@Transactional(readOnly = true)
	//@Override
	public List<IncompatibilidadeFolhaFolha> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByIdFolhaFkNomeTipoFolhaAscIdFolhaIncompativelFkNomeTipoFolhaAsc();
	}
	
	public List<IncompatibilidadeFolhaFolha> buscarPorNome( String nome) {
		return reposytory.findByIdFolhaFkNomeTipoFolhaContainingOrderByIdFolhaFkNomeTipoFolhaAscIdFolhaIncompativelFkNomeTipoFolhaAsc( nome.toUpperCase().trim());
	}
	
	@Transactional(readOnly = true)
	public Page<IncompatibilidadeFolhaFolha> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByIdFolhaFkNomeTipoFolhaAscIdFolhaIncompativelFkNomeTipoFolhaAsc(  pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<IncompatibilidadeFolhaFolha> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdFolhaFkNomeTipoFolhaContainingOrderByIdFolhaFkNomeTipoFolhaAscIdFolhaIncompativelFkNomeTipoFolhaAsc(  nome.toUpperCase().trim(), pageable);
	}
	
    
    
    @Override
    public void salvar(IncompatibilidadeFolhaFolha GrupoUsuario) {
    	reposytory.save(GrupoUsuario);
    }

    @Override
    public void excluir(Long id) {
    	reposytory.deleteById(id);
    }

    @Override
    public IncompatibilidadeFolhaFolha buscarPorId(Long id) {
        return reposytory.findById(id).get();
    }
    
    public List<IncompatibilidadeFolhaFolha> buscarPorFolha(TiposDeFolha tiposDeFolha) {
        return reposytory.findByIdFolhaFkOrderByIdFolhaFkNomeTipoFolhaAscIdFolhaIncompativelFkNomeTipoFolhaAsc(tiposDeFolha);
    }
    
    public List<IncompatibilidadeFolhaFolha> buscarPorFolhaIncompativel(TiposDeFolha tiposDeFolha) {
        return reposytory.findByIdFolhaIncompativelFkOrderByIdFolhaFkNomeTipoFolhaAscIdFolhaIncompativelFkNomeTipoFolhaAsc(tiposDeFolha);
    }
    
    public boolean jaCadastrado(TiposDeFolha tiposDeFolha, TiposDeFolha tiposDeFolhaIncompativel) {
    	boolean resposta = false;
    	if( !reposytory.findByIdFolhaFkAndIdFolhaIncompativelFkOrderByIdFolhaFkNomeTipoFolhaAscIdFolhaIncompativelFkNomeTipoFolhaAsc(tiposDeFolha, tiposDeFolhaIncompativel).isEmpty()  ) {
    		resposta = true;
    	}
    	return resposta;
    }

    
    public boolean jaCadastradoConsiderandoId(IncompatibilidadeFolhaFolha incompatibilidadeFolhaFolha) {
    	boolean resposta = false;
        List <IncompatibilidadeFolhaFolha> lista = reposytory.findByIdFolhaFkAndIdFolhaIncompativelFkOrderByIdFolhaFkNomeTipoFolhaAscIdFolhaIncompativelFkNomeTipoFolhaAsc(incompatibilidadeFolhaFolha.getIdFolhaFk(), incompatibilidadeFolhaFolha.getIdFolhaIncompativelFk()); 
        for(IncompatibilidadeFolhaFolha g: lista) {
        	if(   !g.getId().equals(incompatibilidadeFolhaFolha.getId())   ) {
        		if(  (g.getIdFolhaFk().equals(incompatibilidadeFolhaFolha.getIdFolhaFk()))  &&    (g.getIdFolhaIncompativelFk().equals(incompatibilidadeFolhaFolha.getIdFolhaIncompativelFk()))  ) {
        			resposta = true;
        		}
        	}
        }
    	return resposta;
    }

    
    
    public boolean incompativelFolhaFolha(Escala escala) {
    	boolean resposta = false;
    	//
    	
    	List <IncompatibilidadeFolhaFolha> lista1 = incompatibilidadeFolhaFolhaService.buscarPorFolha(escala.getIdTipoFolhaFk());
    	List <IncompatibilidadeFolhaFolha> lista2 = incompatibilidadeFolhaFolhaService.buscarPorFolhaIncompativel(escala.getIdTipoFolhaFk());
    	for(IncompatibilidadeFolhaFolha i: lista2) {
    		lista1.add(i);
    	}
    	
    	// Limpando as incompatibilidades que nao interessam
    	List <IncompatibilidadeFolhaFolha> listaA = new ArrayList<>(); 
    	for(int i=0; i<lista1.size();i++) {
    		if(  lista1.get(i).getIdFolhaFk().equals(escala.getIdTipoFolhaFk())  ||  lista1.get(i).getIdFolhaIncompativelFk().equals(escala.getIdTipoFolhaFk())  ) {
    			listaA.add(lista1.get(i));
    		}
    	}
    	
    	if(!listaA.isEmpty()) {
    		List <IncompatibilidadeFolhaFolhaExcessao> listaExcessao = incompatibilidadeFolhaFolhaExcessaoService.buscarPorMesExatoEFuncionario(escala.getIdAnoMesFk(), escala.getIdFuncionarioFk());
    		
    		List <IncompatibilidadeFolhaFolha> listaB = new ArrayList<>();
    		for(int j=0;j<listaA.size();j++) {
    			boolean encontrou = false;
	    			for(int i=0;i<listaExcessao.size();i++) {
	    				if( (listaA.get(j).getIdFolhaFk().equals(listaExcessao.get(i).getIdFolhaFk())  &&  listaA.get(j).getIdFolhaIncompativelFk().equals(listaExcessao.get(i).getIdFolhaIncompativelFk()))    ) {
	    					encontrou = true; break;
	    				}
	    				
	    				if( (listaA.get(j).getIdFolhaFk().equals(listaExcessao.get(i).getIdFolhaIncompativelFk())  &&  listaA.get(j).getIdFolhaIncompativelFk().equals(listaExcessao.get(i).getIdFolhaFk()))    ) {
	    					encontrou = true; break;
	    				}
	    			}
    			
    			if(encontrou == false) {
    				listaB.add(listaA.get(j));
    			}
    			
    		}
    		
	    		if(!listaB.isEmpty()) {
	    			List <Escala> listaEscalas = escalaService.buscarPorFuncionarioEAnoMes(escala);
	    			
	    			for(int i=0;i<listaB.size();i++) {
	    				for(int j=0;j<listaEscalas.size();j++) {
	    					if(!listaEscalas.get(j).getId().equals(escala.getId())) {
	    						if( (listaEscalas.get(j).getIdTipoFolhaFk().equals(listaB.get(i).getIdFolhaFk())  && escala.getIdTipoFolhaFk().equals(listaB.get(i).getIdFolhaIncompativelFk()) )     ||   (listaEscalas.get(j).getIdTipoFolhaFk().equals(listaB.get(i).getIdFolhaIncompativelFk())  && escala.getIdTipoFolhaFk().equals(listaB.get(i).getIdFolhaFk()) )    ) {
	    							resposta = true; 
	    							
	    							// Colocando na Sessao
	    							HttpSession session = httpSessionFactory.getObject();
	    					        session.setAttribute("folhaA", listaB.get(i).getIdFolhaFk().getId() );
	    					        session.setAttribute("folhaB", listaB.get(i).getIdFolhaIncompativelFk().getId() );
	    							
	    							break;
	    						}
	    					}
	    				}
	    			}
	    			
	    		}
    	}
    	
    	return resposta;
    }
    
   
}
