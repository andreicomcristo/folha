package com.folha.boot.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "unidade_gestora")
public class UnidadeGestora extends AbstractEntity<Long> {

	@Column(name = "nome_fantasia")
    private String nomeFantasia;
    @Column(name = "nome_empresarial")
    private String nomeEmpresarial;
    @Column(name = "cnes")
    private String cnes;
    @Column(name = "cnpj")
    private String cnpj;
    @OneToMany(mappedBy = "idUnidadeGestoraFk")
    private List<Unidades> unidadesList;
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeFantasia);
	}
	public String getNomeEmpresarial() {
		return nomeEmpresarial;
	}
	public void setNomeEmpresarial(String nomeEmpresarial) {
		this.nomeEmpresarial = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeEmpresarial);
	}
	public String getCnes() {
		return cnes;
	}
	public void setCnes(String cnes) {
		this.cnes = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cnes);
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = UtilidadesDeTexto.retiraEspacosDuplosAcentosEConverteEmMaiusculo(cnpj);
	}
	public List<Unidades> getUnidadesList() {
		return unidadesList;
	}
	public void setUnidadesList(List<Unidades> unidadesList) {
		this.unidadesList = unidadesList;
	}
    
    
	
}
