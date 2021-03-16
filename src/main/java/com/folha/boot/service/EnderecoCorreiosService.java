package com.folha.boot.service;

import java.io.Serializable;

import com.folha.boot.domain.EnderecoCorreios;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class EnderecoCorreiosService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 171188508122915069L;
	
	public EnderecoCorreios buscarEnderecoPor(String urlJson) {
		System.out.println("CHAMOU O SERVIÇO....");
		
		final GsonBuilder gsonBuilder = new GsonBuilder();
		final Gson gson = gsonBuilder.create();
		Gson g = new Gson();		
		EnderecoCorreios retornoEndereco = gson.fromJson(urlJson, EnderecoCorreios.class);		
		return retornoEndereco;
	}

}
