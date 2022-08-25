package br.com.daigaku;

public class VetorTeste {

	public static void main(String[] args) {

		Vetor lista = new Vetor(6);

		Aluno a1 = new Aluno("Breno");
		Aluno a2 = new Aluno("Inácio da Paz");
		Aluno a3 = new Aluno("Nathanael Flintch");
		Aluno a4 = new Aluno("Guilherme Linhares");
		Aluno a5 = new Aluno("Dennys");


		System.out.println("Lista de Alunos com " + lista.tamanho() + " posições.");

		lista.adiciona(a1);
		lista.adiciona(a2);
		lista.adiciona(a3);
		lista.adiciona(a4);
		System.out.println(lista);
		lista.remove(3);
		System.out.println(lista);
		lista.adiciona(a5);
		System.out.println(lista);
		System.out.println(lista);

		System.out.println("Lista de Alunos com " + lista.tamanho() + " posições.");

		Aluno x = lista.pega(0);
		boolean cotemX = lista.contem(x);
		System.out.println(cotemX);

	}

}
