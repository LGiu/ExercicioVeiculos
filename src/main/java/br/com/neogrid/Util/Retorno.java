package br.com.neogrid.Util;


import br.com.neogrid.Interface.Model;

import java.util.List;

public class Retorno<U extends Model> {

    public Retorno() {
        this.erro = false;
    }

    public Retorno(String mensagem) {
        this.mensagem = mensagem;
        this.erro = true;
    }

    public Retorno(List<String> mensagens) {
        this.mensagem = String.join(";", mensagens);
        this.erro = true;
    }

    public Retorno(U clazz) {
        this.erro = false;
    }

    public Retorno(U clazz, String identificador) {
        this.identificador = identificador;
        this.erro = false;
    }

    private String identificador;

    private String mensagem;

    private boolean erro;

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public boolean isErro() {
        return erro;
    }

    public void setErro(boolean erro) {
        this.erro = erro;
    }
}
