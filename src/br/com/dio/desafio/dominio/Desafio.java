package br.com.dio.desafio.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Desafio extends Conteudo {
    private List<Pergunta> listaPerguntas = new ArrayList<>();

    public void addPergunta(Pergunta pergunta) {
        listaPerguntas.add(pergunta);
    }

    public boolean iniciarDesafio() {
        Scanner scanner = new Scanner(System.in);
        int acertos = 0;
        for (Pergunta pergunta : listaPerguntas) {
            System.out.println(pergunta.getEnunciado());
            List<String> opcoes = pergunta.getOpcoes();

            for (int i = 0; i < opcoes.size(); i++) {
                System.out.println(i + ". " + opcoes.get(i));
            }

            System.out.print("Digite o número da opção certa: ");
            int digitado = scanner.nextInt();
            if (pergunta.getCerta() == digitado) {
                acertos++;
            }
        }
        double percentualAcertos = (double) acertos / listaPerguntas.size();
        return percentualAcertos >= 0.7;
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO;
    }
}
