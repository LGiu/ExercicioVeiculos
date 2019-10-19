package br.com.neogrid.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CorExterna {
	PR("PR", "Preto"),
	BR("BR", "Branco"),
	PA("PA", "Prata"),
	VE("VE", "Vermelho");
	private String chave;
	
	private String descricao;
	
	CorExterna(String chave, String descricao) {
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
			case PR:
			case BR:
			case PA:
			case VE:
				return getChave();
		}
		return "Inválido";
	}
}
