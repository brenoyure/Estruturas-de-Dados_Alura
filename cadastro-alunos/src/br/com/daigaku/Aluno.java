package br.com.daigaku;

public class Aluno {

    private String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        Aluno outro = new Aluno(nome);
        return this.nome.equals(outro.getNome());
    }

    @Override
    public String toString() {
        return this.nome;
    }

}
