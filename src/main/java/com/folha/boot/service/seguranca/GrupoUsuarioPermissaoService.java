package com.folha.boot.service.seguranca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.GrupoUsuarioPermissaoReposytory;
import com.folha.boot.domain.AtividadeEscala;
import com.folha.boot.domain.Unidades;
import com.folha.boot.domain.seguranca.GrupoUsuario;
import com.folha.boot.domain.seguranca.GrupoUsuarioPermissao;
import com.folha.boot.service.GenericService;

@Service
public class GrupoUsuarioPermissaoService implements GenericService<GrupoUsuarioPermissao> {

    @Autowired
    private GrupoUsuarioPermissaoReposytory reposytory;

	

	//@Override
	public void editar(GrupoUsuarioPermissao grupoUsuarioPermissao) {
		reposytory.save(grupoUsuarioPermissao);

	}

	

	@Transactional(readOnly = true)
	//@Override
	public List<GrupoUsuarioPermissao> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByIdGrupoUsuarioFkNomeAscIdPermissaoFkNomeAsc();
	}
	
	public List<GrupoUsuarioPermissao> buscarPorNome( String nome) {
		return reposytory.findByIdGrupoUsuarioFkNomeOrderByIdGrupoUsuarioFkNomeAscIdPermissaoFkNomeAsc( nome.toUpperCase().trim());
	}
	
	@Transactional(readOnly = true)
	public Page<GrupoUsuarioPermissao> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByIdGrupoUsuarioFkNomeAscIdPermissaoFkNomeAsc(  pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<GrupoUsuarioPermissao> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdGrupoUsuarioFkNomeOrderByIdGrupoUsuarioFkNomeAscIdPermissaoFkNomeAsc(  nome.toUpperCase().trim(), pageable);
	}
	
    
    
    @Override
    public void salvar(GrupoUsuarioPermissao GrupoUsuario) {
    	reposytory.save(GrupoUsuario);
    }

    @Override
    public void excluir(Long id) {
    	reposytory.deleteById(id);
    }

    @Override
    public GrupoUsuarioPermissao buscarPorId(Long id) {
        return reposytory.findById(id).get();
    }
    
    
    public List<GrupoUsuarioPermissao> buscarPorGrupoUsuario(GrupoUsuario grupoUsuario) {
        return reposytory.findByIdGrupoUsuarioFkOrderByIdPermissaoFkAsc(grupoUsuario);
    }

    

   
}
