package br.com.daigaku;

public class TestaVetor {

	public static void main(String[] args) {

		Vetor lista = new Vetor(5);

		Aluno a1 = new Aluno("Cleiton");
		Aluno a2 = new Aluno("Fulano");
		Aluno a3 = new Aluno("Cigano");
		Aluno a4 = new Aluno("Beltrano");
		Aluno a5 = new Aluno("Kratos");

		lista.adiciona(a1);
		lista.adiciona(a2);
		lista.adiciona(a3);
		lista.adiciona(a4);

		System.out.println(lista);
		lista.adiciona(3, a5);
		System.out.println(lista);
		lista.remove(3);
		System.out.println(lista);

	}

}
