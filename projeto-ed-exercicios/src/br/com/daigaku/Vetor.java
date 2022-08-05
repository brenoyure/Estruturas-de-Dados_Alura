package br.com.daigaku;

import java.util.Arrays;

public class Vetor {

	private Aluno[] alunos = new Aluno[4];
	private int totalDeAlunos;

	public Vetor() {
		this.totalDeAlunos = 0;
	}

	public void adiciona(Aluno aluno) {
		this.alunos[totalDeAlunos] = aluno;
		this.totalDeAlunos++;
	}

	public void adiciona(int posicao, Aluno aluno) {
		if (posicaoOcupada(posicao)) {
			for (int i = totalDeAlunos; i > posicao; i--) {
				alunos[i] = alunos[i - 1];
			}
			alunos[posicao] = aluno;
			totalDeAlunos++;

		}
		alunos[posicao] = aluno;
		totalDeAlunos++;

	}

	/**
	 * Método contém passando ref Aluno
	 * 
	 * @param aluno
	 * @return
	 */
	public boolean contem(Aluno aluno) {
		for (int i = 0; i < totalDeAlunos;) {
			if (alunos[i].equals(aluno)) {
				return true;
			}
			break;
		}
		return false;
	}

	public void remove(int posicao) {

	}

	public int tamanho() {
		return this.alunos.length;
	}

	public Aluno pega(int posicao) {
		if (!posicaoValida(posicao))
			throw new IllegalArgumentException("Posição Inválida.");
		return this.alunos[posicao];
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
	 * Método Auxiliar para verificar se uma posição é válida, tendo como critério:
	 * Posição deve ser maior ou igual a zero e menor que o tamanho do vetor
	 * 
	 * @param posicao
	 * @return
	 */
	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= this.alunos.length;
	}

	private boolean posicaoOcupada(int posicao) {
		return posicaoValida(posicao) && posicao < this.totalDeAlunos;
	}

}
