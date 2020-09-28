package com.agenda;

class Contato implements Comparable<Contato>{

	private String nome;
	private String telefone;
	private String email;
	
	String getNome() {
		return this.nome;
	}
	private void setNome(String nome) {
		this.nome = nome;
	}
	
	String getTelefone() {
		return this.telefone;
	}
	void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	String getEmail() {
		return this.email;
	}
	void setEmail(String email) {
		this.email = email;
	}
	
	Contato(String nome, String telefone, String email) {
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setEmail(email);
	}
	
	@Override
	public int compareTo(Contato contato) {
		return this.getNome().compareToIgnoreCase(contato.getNome());
	}
	
	@Override
	public String toString() {
		String mensagem = "Nome: " + this.getNome() + "\n"
				+ "Telefone: " + this.getTelefone() + "\n"
				+ "Email: " + this.getEmail() + "\n";
		return mensagem;
	}
}
