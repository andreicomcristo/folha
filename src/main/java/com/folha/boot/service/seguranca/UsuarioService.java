package com.folha.boot.service.seguranca;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpSession;

import com.folha.boot.Reposytory.PessoaOperadoresReposytory;
import com.folha.boot.domain.PessoaOperadores;
import com.folha.boot.domain.seguranca.Perfil;
import com.folha.boot.domain.seguranca.Permissao;
import com.folha.boot.service.GenericService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


@Service
public class UsuarioService implements GenericService<PessoaOperadores>, UserDetailsService {

    @Autowired
    private PessoaOperadoresReposytory usuarioRepository;

    @Autowired
    ObjectFactory<HttpSession> httpSessionFactory;
    
    public void salvar(PessoaOperadores pessoaOperadores) {
		// TODO Auto-generated method stub
    	usuarioRepository.save(pessoaOperadores);
	}

	
	public void editar(PessoaOperadores pessoaOperadores) {
		// TODO Auto-generated method stub
		usuarioRepository.save(pessoaOperadores);
	}

	
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	
	public PessoaOperadores buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id).get();
	}

	@Transactional(readOnly = true)
	
	public List<PessoaOperadores> buscarTodos() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAllByOrderByIdPessoaFkNomeAsc();
	}

    
    
    
/*
    @Override
    public void salvar(Usuario usuario) {

        if (usuario.getId() == null){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            SituacaoRegistro situacaoRegistro = situacaoRegistroService.buscarPorId(new Long(1L));

            for(Perfil p : usuario.getPerfis()){
                System.out.println("Grupo--------->" + p.getGrupoUsuario().getId());
                System.out.println("Unidade--------->" + p.getUnidade().getId());
            }

            usuario.setSenha(encoder.encode(usuario.getSenha()));
            usuario.setSituacaoRegistro(situacaoRegistro);
        }

        usuarioRepository.save(usuario);
    }

    @Override
    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Page<Usuario> listAll(int numeroPagina){
        Pageable pageable = PageRequest.of(numeroPagina - 1, 20);

        return usuarioRepository.findAll(pageable);
    }

    public Page<Usuario> listAll(int numeroPagina, String pesquisa){
        Pageable pageable = PageRequest.of(numeroPagina - 1, 20);
        List<Usuario> lista = null;

        lista = usuarioRepository.findAllTable(pesquisa.toUpperCase());

        return new PageImpl(lista, pageable, lista.size());
    }
*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Usuario usuario = usuarioRepository.findById(new Long(1L)).get();

    	
    	
        String[] usuarioUnidade = StringUtils.split(
                username, String.valueOf(Character.LINE_SEPARATOR));

        PessoaOperadores usuario = usuarioRepository.findFirstByUsername(usuarioUnidade[0]);
        
        System.out.println("VEJA:"+usuario.getIdPessoaFk().getNome());
        
        //System.out.println("----------->>>>>" + usuarioUnidade[0]);
        //System.out.println("----------->>>>>" + usuarioUnidade[1]);

        

        
        
        //comando para armazenar a unidade na sessão
        HttpSession session = httpSessionFactory.getObject();
        session.setAttribute("unidade", "Unidade de teste");

        //consulta sobre autorizações
        List<Perfil> perfil = usuario.getPerfilList().stream().filter(p -> p.getIdUnidadeFk().getId().equals(Integer.valueOf(usuarioUnidade[1]))).collect(Collectors.toList());
        //List<Permissao> listaPermissao = perfil.get(0).getGrupoUsuario().getPermissoes();

        //String[] colecao = listaPermissao.stream().toArray(String[]::new);

        return new User(
                usuario.getUsername(),
                usuario.getPassword(),
                AuthorityUtils.createAuthorityList(new String[]{ "ADM2" })
                //AuthorityUtils.createAuthorityList(colecao)
        );
    }

 
}


