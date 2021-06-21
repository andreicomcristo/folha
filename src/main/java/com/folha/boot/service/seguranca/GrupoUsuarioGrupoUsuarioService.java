package com.folha.boot.service.seguranca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.GrupoUsuarioGrupoUsuarioReposytory;
import com.folha.boot.domain.seguranca.GrupoUsuario;
import com.folha.boot.domain.seguranca.GrupoUsuarioGrupoUsuario;
import com.folha.boot.service.GenericService;

@Service
public class GrupoUsuarioGrupoUsuarioService implements GenericService<GrupoUsuarioGrupoUsuario> {

    @Autowired
    private GrupoUsuarioGrupoUsuarioReposytory reposytory;
    @Autowired
    private UsuarioService usuarioService;

	

	//@Override
	public void editar(GrupoUsuarioGrupoUsuario grupoUsuarioGrupoUsuario) {
		reposytory.save(grupoUsuarioGrupoUsuario);

	}

	

	@Transactional(readOnly = true)
	//@Override
	public List<GrupoUsuarioGrupoUsuario> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAllByOrderByIdGrupoUsuarioFkNomeAscIdGrupoUsuarioCompativelFkNomeAsc();
	}
	
	public List<GrupoUsuarioGrupoUsuario> buscarPorNome( String nome) {
		return reposytory.findByIdGrupoUsuarioFkNomeContainingOrderByIdGrupoUsuarioFkNomeAscIdGrupoUsuarioCompativelFkNomeAsc( nome.toUpperCase().trim());
	}
	
	@Transactional(readOnly = true)
	public Page<GrupoUsuarioGrupoUsuario> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findAllByOrderByIdGrupoUsuarioFkNomeAscIdGrupoUsuarioCompativelFkNomeAsc(  pageable);
	}
	
	@Transactional(readOnly = true)
	public Page<GrupoUsuarioGrupoUsuario> findPaginatedNome(String nome, int pageNo, int pageSize ) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return this.reposytory.findByIdGrupoUsuarioFkNomeContainingOrderByIdGrupoUsuarioFkNomeAscIdGrupoUsuarioCompativelFkNomeAsc(  nome.toUpperCase().trim(), pageable);
	}
	
    
    
    @Override
    public void salvar(GrupoUsuarioGrupoUsuario GrupoUsuario) {
    	reposytory.save(GrupoUsuario);
    }

    @Override
    public void excluir(Long id) {
    	reposytory.deleteById(id);
    }

    @Override
    public GrupoUsuarioGrupoUsuario buscarPorId(Long id) {
        return reposytory.findById(id).get();
    }
    
    public List<GrupoUsuarioGrupoUsuario> buscarPorGrupoUsuario(GrupoUsuario grupoUsuario) {
        return reposytory.findByIdGrupoUsuarioFkOrderByIdGrupoUsuarioFkNomeAscIdGrupoUsuarioCompativelFkNomeAsc(grupoUsuario);
    }

    public List<GrupoUsuarioGrupoUsuario> buscarPorGrupoUsuarioLogado() {
    	return reposytory.findByIdGrupoUsuarioFkOrderByIdGrupoUsuarioFkNomeAscIdGrupoUsuarioCompativelFkNomeAsc(usuarioService.pegarGrupoUsuarioLogado());
    }
    

   
}
