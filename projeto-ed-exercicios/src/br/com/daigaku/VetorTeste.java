package br.com.daigaku;

public class VetorTeste {

	public static void main(String[] args) {
		
		Vetor lista = new Vetor();
		
		Aluno a1 = new Aluno("Breno");
		Aluno a2 = new Aluno("Guilherme Mussolini");
		Aluno a3 = new Aluno("Nathanael Flintch");
		
		System.out.println("Lista de Alunos com " + lista.tamanho() + " posições.");
		
		lista.adiciona(a1);
		lista.adiciona(a2);
		System.out.println(lista);
		lista.adiciona(1,a3);
		System.out.println(lista);
				
				
		
	}
	
}
