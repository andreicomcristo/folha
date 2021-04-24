package com.folha.boot.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.folha.boot.service.util.UtilidadesDeTexto;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa_limite_horas")
public class PessoaLimiteHoras extends AbstractEntity<Long> {

	@Column(name = "dt_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "dt_cancelamento")
    @Temporal(TemporalType.DATE)
    private Date dtCancelamento;
    @Column(name = "motivo")
    private String motivo;
    @Column(name = "dt_avaliacao_sede")
    @Temporal(TemporalType.DATE)
    private Date dtAvaliacaoSede;
    @Column(name = "motivo_avaliacao_sede")
    private String motivoAvaliacaoSede;
    @JoinColumn(name = "id_pessoa_fk", referencedColumnName = "id")
    @ManyToOne
    private Pessoa idPessoaFk;
    @JoinColumn(name = "id_operador_avaliacao_sede_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorAvaliacaoSedeFk;
    @JoinColumn(name = "id_operador_cadastro_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCadastroFk;
    @JoinColumn(name = "id_operador_cancelamento_fk", referencedColumnName = "id")
    @ManyToOne
    private PessoaOperadores idOperadorCancelamentoFk;
    @JoinColumn(name = "id_avaliacao_sede_sim_nao_fk", referencedColumnName = "id")
    @ManyToOne
    private SimNao idAvaliacaoSedeSimNaoFk;
    @JoinColumn(name = "id_unidade_fk", referencedColumnName = "id")
    @ManyToOne
    private Unidades idUnidadeFk;
    @Column(name = "horas")
    private Integer horas;
    
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	public Date getDtCancelamento() {
		return dtCancelamento;
	}
	public void setDtCancelamento(Date dtCancelamento) {
		this.dtCancelamento = dtCancelamento;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Date getDtAvaliacaoSede() {
		return dtAvaliacaoSede;
	}
	public void setDtAvaliacaoSede(Date dtAvaliacaoSede) {
		this.dtAvaliacaoSede = dtAvaliacaoSede;
	}
	public String getMotivoAvaliacaoSede() {
		return motivoAvaliacaoSede;
	}
	public void setMotivoAvaliacaoSede(String motivoAvaliacaoSede) {
		this.motivoAvaliacaoSede = motivoAvaliacaoSede;
	}
	public Pessoa getIdPessoaFk() {
		return idPessoaFk;
	}
	public void setIdPessoaFk(Pessoa idPessoaFk) {
		this.idPessoaFk = idPessoaFk;
	}
	public PessoaOperadores getIdOperadorAvaliacaoSedeFk() {
		return idOperadorAvaliacaoSedeFk;
	}
	public void setIdOperadorAvaliacaoSedeFk(PessoaOperadores idOperadorAvaliacaoSedeFk) {
		this.idOperadorAvaliacaoSedeFk = idOperadorAvaliacaoSedeFk;
	}
	public PessoaOperadores getIdOperadorCadastroFk() {
		return idOperadorCadastroFk;
	}
	public void setIdOperadorCadastroFk(PessoaOperadores idOperadorCadastroFk) {
		this.idOperadorCadastroFk = idOperadorCadastroFk;
	}
	public PessoaOperadores getIdOperadorCancelamentoFk() {
		return idOperadorCancelamentoFk;
	}
	public void setIdOperadorCancelamentoFk(PessoaOperadores idOperadorCancelamentoFk) {
		this.idOperadorCancelamentoFk = idOperadorCancelamentoFk;
	}
	public SimNao getIdAvaliacaoSedeSimNaoFk() {
		return idAvaliacaoSedeSimNaoFk;
	}
	public void setIdAvaliacaoSedeSimNaoFk(SimNao idAvaliacaoSedeSimNaoFk) {
		this.idAvaliacaoSedeSimNaoFk = idAvaliacaoSedeSimNaoFk;
	}
	public Unidades getIdUnidadeFk() {
		return idUnidadeFk;
	}
	public void setIdUnidadeFk(Unidades idUnidadeFk) {
		this.idUnidadeFk = idUnidadeFk;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
    
    
	
}
