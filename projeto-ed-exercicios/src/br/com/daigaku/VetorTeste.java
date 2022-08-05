package br.com.daigaku;

public class VetorTeste {

	public static void main(String[] args) {

		Vetor lista = new Vetor();

		Aluno a1 = new Aluno("Breno");
		Aluno a2 = new Aluno("Inácio da Paz");
		Aluno a3 = new Aluno("Nathanael Flintch");
		Aluno a4 = new Aluno("Guilherme Linhares");

		System.out.println("Lista de Alunos com " + lista.tamanho() + " posições.");

		lista.adiciona(a1);
		lista.adiciona(a2);
		lista.adiciona(a3);
		System.out.println(lista);
		lista.adiciona(1, a4);
		System.out.println(lista);

		for (int i = 0; i < 20; i++) {
			System.out.println("IMPLEMENTAR O MÉTODO PARA GERAR NOVO ARRAY AO ADICIONAR");
		}

	}

}
