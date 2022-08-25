package br.com.daigaku;

import java.util.Arrays;

/**
 * Tentando criar meu ArrayList que armazena referências do tipo Aluno
 * 
 * @author Breno Yuri
 *
 */
public class Vetor {

	private Aluno[] alunos;
	private int totalDeAlunos;

	public Vetor() {
		this.alunos = new Aluno[100];
		this.totalDeAlunos = 0;
	}

	public Vetor(int tamanho) {
		try {
			this.alunos = new Aluno[tamanho];
			this.totalDeAlunos = 0;
		} catch (NegativeArraySizeException ex) {
			System.err.println("Tamanho de Vetor Inválido");
			System.out.println("Criando vetor com 10 posições...");
			this.alunos = new Aluno[10];
			this.totalDeAlunos = 0;
		}

	}

	/**
	 * Adiciona o aluno na (próxima) posição disponível. Antes de adicionar,
	 * verifica se o vetor está cheio, se sim, cria um novo vetor com o dobro do
	 * tamanho, através do método "garanteEspaço()"
	 * 
	 * @param aluno
	 */
	public void adiciona(Aluno aluno) {
		if (vetorCheio())
			garanteEspaco();
		this.alunos[totalDeAlunos] = aluno;
		this.totalDeAlunos++;
	}

	public void adiciona(int posicao, Aluno aluno) {
		if (posicaoOcupada(posicao)) {
			garanteEspaco();
			for (int i = totalDeAlunos - 1; i >= posicao; i--) {
				alunos[i + 1] = alunos[i];
			}
			alunos[posicao] = aluno;
			totalDeAlunos++;
		}
		try {
			alunos[posicao] = aluno;
			totalDeAlunos++;
		} catch (ArrayIndexOutOfBoundsException ex) {
			trataArrayIndexException(posicao, aluno);
		}

	}

	/**
	 * Verifica se o aluno está na lista
	 * 
	 * @param aluno
	 * @return boolean
	 */
	public boolean contem(Aluno aluno) {
		for (int i = 0; i < totalDeAlunos;) {
			if (alunos[i].equals(aluno))
				return true;
			break;
		}
		return false;
	}

	public void remove(int posicao) {
		if (posicaoOcupada(posicao)) {
			this.alunos[posicao] = null;
			totalDeAlunos--; // -> Subtrai 1, fora do laço for
			for (int i = posicao; i < totalDeAlunos; i++) {
				this.alunos[i] = this.alunos[i + 1];
			}
		}
	}

	public int tamanho() {
		return this.alunos.length;
	}

	public Aluno pega(int posicao) {
		Aluno aluno = null;
		try {
			aluno = this.alunos[posicao];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Posição Inválida ou Objeto Nulo.");
		}
		return aluno;
	}

	@Override
	public String toString() {
		return Arrays.toString(alunos);
	}

	/**
	 * Métodos Auxiliares da classe Vetor
	 * 
	 */

	/**
	 * Verifica se uma posição é válida, tendo como critério: posição deve ser maior
	 * ou igual a zero e menor que o tamanho do vetor
	 * 
	 * @param posicao
	 * @return boolean
	 */
	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= this.alunos.length;
	}

	private boolean posicaoOcupada(int posicao) {
		return posicaoValida(posicao) && posicao < this.totalDeAlunos;
	}

	private void trataArrayIndexException(int posicao, Aluno aluno) {
		try {
			alunos[posicao] = aluno;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Posição inexistente, o aluno " + aluno.getNome()
					+ " será adicionado na próxima posição disponível.");
			adiciona(aluno);
//			totalDeAlunos++; <-- Método adiciona() já soma um no total de alunos.
		}
	}

	private boolean vetorCheio() {
		return totalDeAlunos == tamanho();
	}

	private void garanteEspaco() {
		Aluno[] novoArray = new Aluno[tamanho() * 2];
		for (int i = 0; i < totalDeAlunos; i++) {
			novoArray[i] = alunos[i];
		}
		this.alunos = novoArray;
	}

//	private boolean posicaoLivre(int posicao) {
//	return posicao >= totalDeAlunos && posicao < tamanho();
//}

}
