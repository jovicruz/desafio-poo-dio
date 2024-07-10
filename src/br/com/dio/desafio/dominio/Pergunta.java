package br.com.dio.desafio.dominio;

import java.util.ArrayList;
import java.util.List;

public class Pergunta {
    private String enunciado;
    private List<String> opcoes = new ArrayList<>();
    private int certa;


    public int getCerta() {
        return certa;
    }
    public void setCerta(int certa) {
        this.certa = certa;
    }
    public String getEnunciado() {
        return enunciado;
    }
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }
    public List<String> getOpcoes() {
        return opcoes;
    }
    public void addOpcao(String opcao) {
        this.opcoes.add(opcao);
    }

    

}
