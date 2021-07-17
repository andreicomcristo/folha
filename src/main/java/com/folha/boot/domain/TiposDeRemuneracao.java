package com.folha.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "tipos_de_remuneracao")
public class TiposDeRemuneracao extends AbstractEntity<Long> {

	@Column(name = "nome_tipo_remuneracao")
    private String nomeTipoRemuneracao;
    @OneToMany(mappedBy = "idTipoRemuneracaoFk")
    private List<TiposDeFolha> tiposDeFolhaList;
	public String getNomeTipoRemuneracao() {
		return nomeTipoRemuneracao;
	}
	public void setNomeTipoRemuneracao(String nomeTipoRemuneracao) {
		this.nomeTipoRemuneracao = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeTipoRemuneracao);
	}
	public List<TiposDeFolha> getTiposDeFolhaList() {
		return tiposDeFolhaList;
	}
	public void setTiposDeFolhaList(List<TiposDeFolha> tiposDeFolhaList) {
		
		this.tiposDeFolhaList = tiposDeFolhaList;
	}

    

}