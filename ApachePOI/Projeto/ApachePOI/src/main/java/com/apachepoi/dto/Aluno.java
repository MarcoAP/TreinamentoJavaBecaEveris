package com.apachepoi.dto;

public class Aluno {

	private String nomeAluno;
	private String notaProva1;
	private double notaProva2;
	private double media;
	private double participacao;
	private double mediaFinal;

	public Aluno() {
	}

	public Aluno(String nome, String ra, double nota1, double nota2, double media, double aprovado) {
		super();
		this.nomeAluno = nome;
		this.notaProva1 = ra;
		this.notaProva2 = nota1;
		this.media = nota2;
		this.participacao = media;
		this.mediaFinal = aprovado;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getNotaProva1() {
		return notaProva1;
	}

	public void setNotaProva1(String notaProva1) {
		this.notaProva1 = notaProva1;
	}

	public double getNotaProva2() {
		return notaProva2;
	}

	public void setNotaProva2(double notaProva2) {
		this.notaProva2 = notaProva2;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public double getParticipacao() {
		return participacao;
	}

	public void setParticipacao(double participacao) {
		this.participacao = participacao;
	}

	public double getMediaFinal() {
		return mediaFinal;
	}

	public void setMediaFinal(double mediaFinal) {
		this.mediaFinal = mediaFinal;
	}

}