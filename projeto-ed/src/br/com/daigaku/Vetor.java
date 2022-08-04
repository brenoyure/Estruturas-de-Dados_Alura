package br.com.daigaku;

import java.util.Arrays;

public class Vetor {

	private Aluno[] alunos = new Aluno[100];
	private int totalDeAlunos = 0;

	public void adiciona(Aluno aluno) {
		this.garanteEspaco();
		this.alunos[totalDeAlunos] = aluno;
		this.totalDeAlunos++;
	}
	
	/**
	 * Método auxiliar que verifica por uma posição válida
	 * @param posicao
	 * @return boolean
	 */
	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= this.totalDeAlunos;
	}
	
	private void garanteEspaco() {
		if(totalDeAlunos == alunos.length) {
			Aluno[] novoArray = new Aluno[alunos.length * 2];
			for (int i = 0; i < totalDeAlunos; i++) {
				novoArray[i] = alunos[i];
			}
			this.alunos = novoArray;
		}
	}
	
	public void adiciona(int posicao, Aluno aluno) {
		this.garanteEspaco();
		if(!posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição Inválida");
		}
		for(int i = this.totalDeAlunos - 1; i >= posicao; i--) {
			this.alunos[i+1] = this.alunos[i];
		}
		alunos[posicao] = aluno;
		this.totalDeAlunos++;
		
	}

	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalDeAlunos;
	}
	
	public Aluno pega(int posicao) {
		
		if(!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição Inválida");
		}
		
		return this.alunos[posicao];
	}

	public void remove(int posicao) {
		
		for(int i = posicao ; i < this.totalDeAlunos; i++) {
			this.alunos[i] = this.alunos[i+1];
		}
		this.totalDeAlunos--;
		this.alunos[totalDeAlunos] = null;
		
	}

	public boolean contem(Aluno aluno) {
		for (int i = 0; i < this.totalDeAlunos; i++) {
			if (aluno.equals(alunos[i])) {
				return true;
			}
		}
		return false;
	}

	public int tamanho() {
		return this.totalDeAlunos;
	}

	@Override
	public String toString() {
		return Arrays.toString(alunos);
	}

}
