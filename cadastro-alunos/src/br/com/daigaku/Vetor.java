package br.com.daigaku;

import java.util.Arrays;
import java.util.Iterator;

public class Vetor {

	private Aluno[] alunos;
	private int totalAlunos = 0;

	/**
	 * Construtor padrão de 10 posições
	 */
	public Vetor() {
		this.alunos = new Aluno[10];
	}

	/**
	 * Construtor que recebe como parâmetro o tamanho do vetor
	 * 
	 * @param tamanho
	 */
	public Vetor(int tamanho) {
		this.alunos = new Aluno[tamanho];
	}

	public void adiciona(Aluno aluno) {
		this.alunos[totalAlunos] = aluno;
		this.totalAlunos++;
	}

	public void adiciona(int posicao, Aluno aluno) {
		if (!posicaoValida(posicao))
			throw new IllegalArgumentException("Posição Inválida.");
		if (posicaoOcupada(posicao)) {
			for (int i = totalAlunos; i > posicao; i--)
				alunos[i] = alunos[i - 1];

			alunos[posicao] = aluno;
			totalAlunos++;
		}
		alunos[posicao] = aluno;
	}

	public boolean contem(Aluno aluno) {
		for (int i = 0; i < totalAlunos; i++)
			if (this.alunos[i] == aluno)
				return true;
		return false;
	}

	public Aluno pega(int posicao) {
		if (!posicaoValida(posicao))
			throw new IllegalArgumentException("Posição Inválida");
		return alunos[posicao];
	}

	public void remove(Aluno aluno) {
		for (int i = 0; i < totalAlunos;) {
			if (aluno.equals(alunos[i]))
				alunos[i] = null;
			break;
		}
	}

	public void remove(int posicao) {
		this.alunos[posicao] = null;
	}

	/*
	 * Métodos auxiliares
	 */

	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao < tamanho();
	}

	private boolean posicaoOcupada(int posicao) {
		return posicaoValida(posicao) && posicao < totalAlunos;
	}

	public int tamanho() {
		return this.alunos.length;
	}

	@Override
	public String toString() {
		return Arrays.toString(alunos);
	}

}
