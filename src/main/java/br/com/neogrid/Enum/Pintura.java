package br.com.neogrid.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Pintura {

	M("M", "Metálica"),
	S("S", "Sólida");

	private String chave;

	private String descricao;

	Pintura(String chave, String descricao) {
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
			case M:
			case S:
				return getChave();
		}
		return "Inválido";
	}
}
