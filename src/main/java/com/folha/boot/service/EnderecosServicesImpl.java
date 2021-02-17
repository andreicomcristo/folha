package com.folha.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.folha.boot.Reposytory.EnderecosReposytory;
import com.folha.boot.domain.Enderecos;
import com.folha.boot.service.util.UtilidadesDeTexto;

@Service
@Transactional(readOnly = false)
public class EnderecosServicesImpl implements EnderecosServices{

	@Autowired
	private EnderecosReposytory reposytory;
	@Override
	public void salvar(Enderecos enderecos) {
		// TODO Auto-generated method stub
		reposytory.save(enderecos);
	}

	@Override
	public void editar(Enderecos enderecos) {
		// TODO Auto-generated method stub
		reposytory.save(enderecos);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		reposytory.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Enderecos buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return reposytory.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Enderecos> buscarTodos() {
		// TODO Auto-generated method stub
		return reposytory.findAll();
	}

	@Override
	public List<Enderecos> buscarPorNome(String enderecoLogradouro) {
		// TODO Auto-generated method stub
		return reposytory.findByEnderecoLogradouroContainingOrderByEnderecoLogradouroAsc(enderecoLogradouro);
	}

	@Override
	public Enderecos converteEmMaiusculo(Enderecos enderecos) {
		enderecos.setEnderecoLogradouro(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(enderecos.getEnderecoLogradouro()));
		enderecos.setEnderecoBairro(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(enderecos.getEnderecoBairro()));
		enderecos.setEnderecoCep(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(enderecos.getEnderecoCep()));
		enderecos.setEnderecoComplemento(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(enderecos.getEnderecoComplemento()));
		enderecos.setEnderecoNumero(UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(enderecos.getEnderecoNumero()));
		return enderecos;
	}
}
