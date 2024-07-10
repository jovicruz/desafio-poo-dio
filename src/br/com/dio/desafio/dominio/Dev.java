package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
    private String nome;
    private int hearts = 5;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();


    public void resetarHearts(){
        hearts = 5;
    }
    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        if (hearts <= 0) {
            System.out.println("Você não tem corações no momento.");
            return;
        }
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            if (conteudo.get() instanceof Desafio) {
                Desafio desafio = (Desafio) conteudo.get();
                System.out.println("É um desafio, você precisa acertar 70% para passar, caso contrário, perderá um coração!");
                boolean passou = desafio.iniciarDesafio();
                if (passou) {
                    this.conteudosConcluidos.add(conteudo.get());
                    this.conteudosInscritos.remove(conteudo.get());
                    System.out.println("Você passou no desafio!");
                } else {
                    removeHeart();
                    System.out.println("Você não passou no desafio e perdeu um coração. Corações restantes: " + hearts);
                }
            } else {
                this.conteudosConcluidos.add(conteudo.get());
                this.conteudosInscritos.remove(conteudo.get());
            }
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public int getHearts() {
        return hearts;
    }

    public void removeHeart() {
        hearts--;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
