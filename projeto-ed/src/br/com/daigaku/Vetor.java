package br.com.daigaku;

import java.util.Arrays;

public class Vetor {

	private Aluno[] alunos = new Aluno[100];
	private int totalAlunos = 0;

	/**
	 * Método para adicionar um aluno no vetor. Utiliza o laço for para verificar se
	 * a posição "i" é nula antes de adicionar
	 * 
	 * @param aluno
	 */

	public void adiciona(Aluno aluno) {
		this.alunos[totalAlunos] = aluno;
		this.totalAlunos++;
	}

	public void adiciona(int posicao, Aluno aluno) {
		for (int i = totalAlunos-1; i >= posicao; i-=1) {
			alunos[i+1] = alunos[i];
		}
		alunos[posicao] = aluno;
		totalAlunos++;
	}
	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < totalAlunos;
	}
	
	public Aluno pega(int posicao) {
		if(!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição Inválida.");
		}
		return alunos[posicao];
	}

	public void remove(int posicao) {

	}

	public boolean contem(Aluno aluno) {
		for (int i = 0; i < totalAlunos; i++) {
			if (aluno.equals(alunos[i])) {
				return true;
			}
		}
		return false;
	}

	public int tamanho() {
		return this.totalAlunos;
	}

	/**
	 * Arrays.toString() pega todos os elementos do vetor e chamar o toString de
	 * cada um deles
	 */
	public String toString() {
		return Arrays.toString(alunos);
	}

}
