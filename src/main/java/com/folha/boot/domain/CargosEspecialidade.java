package com.folha.boot.domain;

import java.util.List;

import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "cargos_especialidade")
public class CargosEspecialidade extends AbstractEntity<Long> {
	
	@Basic(optional = false)
    @Column(name = "nome_especialidade_cargo")
    private String nomeEspecialidadeCargo;
    @Column(name = "descricao_especialidade_cargo")
    private String descricaoEspecialidadeCargo;
    @JoinColumn(name = "id_cargo_fk", referencedColumnName = "id")
    @ManyToOne
    private Cargos idCargoFk;
    @OneToMany(mappedBy = "idCargoEspecialidadeAtualFk")
    private List<FuncionariosLicencas> funcionariosLicencasList;
    @OneToMany(mappedBy = "idEspecialidadeAtualFk")
    private List<PessoaFuncionarios> pessoaFuncionariosList;
    
    @JoinColumn(name = "id_area_do_cargo_fk", referencedColumnName = "id")
    @ManyToOne
    private AreaDoCargo idAreaDoCargoFk;
    
    @OneToMany(mappedBy = "idEspecialidadeFk")
    private List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> limiteHorasAcrescimoPorUnidadeEEspecialidadeList;
	
	public List<FuncionariosLicencas> getFuncionariosLicencasList() {
		return funcionariosLicencasList;
	}

	public void setFuncionariosLicencasList(List<FuncionariosLicencas> funcionariosLicencasList) {
		this.funcionariosLicencasList = funcionariosLicencasList;
	}

	public List<PessoaFuncionarios> getPessoaFuncionariosList() {
		return pessoaFuncionariosList;
	}

	public void setPessoaFuncionariosList(List<PessoaFuncionarios> pessoaFuncionariosList) {
		this.pessoaFuncionariosList = pessoaFuncionariosList;
	}

	public String getNomeEspecialidadeCargo() {
		return nomeEspecialidadeCargo;
	}

	public void setNomeEspecialidadeCargo(String nomeEspecialidadeCargo) {
		this.nomeEspecialidadeCargo = UtilidadesDeTexto
				.retiraEspacosDuplosAcentosEConverteEmMaiusculo(nomeEspecialidadeCargo);
	}

	public String getDescricaoEspecialidadeCargo() {
		return descricaoEspecialidadeCargo;
	}

	public void setDescricaoEspecialidadeCargo(String descricaoEspecialidadeCargo) {
		this.descricaoEspecialidadeCargo = UtilidadesDeTexto
				.retiraEspacosDuplosAcentosEConverteEmMaiusculo(descricaoEspecialidadeCargo);
	}

	public Cargos getIdCargoFk() {
		return idCargoFk;
	}

	public void setIdCargoFk(Cargos idCargoFk) {
		this.idCargoFk = idCargoFk;
	}

	public AreaDoCargo getIdAreaDoCargoFk() {
		return idAreaDoCargoFk;
	}

	public void setIdAreaDoCargoFk(AreaDoCargo idAreaDoCargoFk) {
		this.idAreaDoCargoFk = idAreaDoCargoFk;
	}

	public List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> getLimiteHorasAcrescimoPorUnidadeEEspecialidadeList() {
		return limiteHorasAcrescimoPorUnidadeEEspecialidadeList;
	}

	public void setLimiteHorasAcrescimoPorUnidadeEEspecialidadeList(
			List<LimiteHorasAcrescimoPorUnidadeEEspecialidade> limiteHorasAcrescimoPorUnidadeEEspecialidadeList) {
		this.limiteHorasAcrescimoPorUnidadeEEspecialidadeList = limiteHorasAcrescimoPorUnidadeEEspecialidadeList;
	}
	
	
	
}
