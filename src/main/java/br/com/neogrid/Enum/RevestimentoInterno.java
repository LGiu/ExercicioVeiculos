package br.com.neogrid.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RevestimentoInterno {

	T("T", "Tecido"),
	C("C", "Couro");

	private String chave;

	private String descricao;

	RevestimentoInterno(String chave, String descricao) {
		this.chave = chave;
		this.descricao = descricao;
	}
	
	public String getChave() {
		return chave;
	}
	
	public void setChave(String chave) {
		this.chave = chave;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@JsonValue
	public String getValor() {
		switch (this) {
			case T:
			case C:
				return getChave();
		}
		return "Inválido";
	}
}
