package com.folha.boot.domain;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name="acesso_operadores_unidades")

public class AcessoOperadoresUnidade extends AbstractEntity <Long>{

	//bi-directional many-to-one association to PessoaOperadore
		@ManyToOne
		@JoinColumn(name="id_operador_fk" , insertable = false, updatable = false)
		private PessoaOperadores pessoaOperadore;

		//bi-directional many-to-one association to Unidade
		@ManyToOne
		@JoinColumn(name="id_unidade_fk", insertable = false, updatable = false)
		private Unidades unidade;

		public AcessoOperadoresUnidade() {
		}

		public PessoaOperadores getPessoaOperadore() {
			return this.pessoaOperadore;
		}

		public void setPessoaOperadore(PessoaOperadores pessoaOperadore) {
			this.pessoaOperadore = pessoaOperadore;
		}

		public Unidades getUnidade() {
			return this.unidade;
		}

		public void setUnidade(Unidades unidade) {
			this.unidade = unidade;
		}

}