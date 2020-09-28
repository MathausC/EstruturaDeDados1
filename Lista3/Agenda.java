package com.agenda;
import java.util.Scanner;
import Lista3.LSEOrdenada;

public class Agenda {
	private LSEOrdenada<Contato> contatos;
	private Scanner in;
	
	public Agenda() {
		contatos = new LSEOrdenada<Contato>();
		in = new Scanner(System.in);
	}
	
	public void adicionaContato() {
		contatos.incerir(criaContato());
	}
	
	public void removerContato() {
		contatos.remover(criaContatoDePesquisa());
	}
	
	public void exibirContatos() {
		contatos.exibirLista();
	}
	
	public void exibirContato() {
		contatos.exibirItem(criaContatoDePesquisa());
	}
	
	public void alterarContato() {
		Contato contato = contatos.buscaObjeto(criaContatoDePesquisa());
		if(contato != null) {
			char resp;
			do {
				System.out.println("Escolha uma das opções abaixo:");
				System.out.print("1 - Alterar numero de telefone;\n"
						+ "2 - Alterar email;\n"
						+ "0 - Sair\n"
						+ "Opção: ");
				resp = in.next().charAt(0); in.nextLine();
				switch(resp) {
					case '1': alterarTelefone(contato); break;
					case '2': alterarEmail(contato); break;
					case '0': System.out.println("Operação encerrada."); break;
					default: System.out.println("Opção inválida."); break;
				}
			} while (resp != '0');
			
		} else {
			System.out.println("Contato não encontrado.");
		}
	}
	
	public Agenda copiaAgenda() {
		Agenda copia = new Agenda();
		copia.contatos = this.contatos;
		return copia;
	}
	
	private void alterarTelefone(Contato c) {
		System.out.print("Infome o numero telefônico sem o DDD: ");
		String telefone = in.nextLine();
		while (!validaTelefone(telefone)) {
			System.out.println(
					"O telefone deve conter somente digitos\n" + "e não deve ter mais de 9 digitos ou menos que 8.");
			System.out.print("Infome o numero telefônico sem o DDD: ");
			telefone = in.nextLine();
		}
		c.setTelefone(telefone);
		System.out.println("Telefone alterado.");
	}
	
	private void alterarEmail(Contato c) {
		System.out.print("Informe o email do contato: ");
		String email = in.nextLine();
		while(!validaEmail(email)) {
			System.out.println("O email deve serguir o padrão de exemplo.1@ospedagem.xxx");
			System.out.print("Informe o email do contato: ");
			email = in.nextLine();
		}
		c.setEmail(email);
		System.out.println("Email alterado.");
	}
	
	private Contato criaContatoDePesquisa() {
		System.out.println("Informe o nome do contato: ");
		String nome = in.nextLine();
		return new Contato(nome, "", "");
	}
	
	private Contato criaContato() {
		System.out.print("Informe o nome do contato: ");
		String nome = in.nextLine();
		while (!validaNome(nome)) {
			System.out.println("O nome deve conter somentes letras e espaços,\n"
					+ "sem mais de um espaço entre os nomes e sem começar com espaço.");
			System.out.print("Informe o nome do contato: ");
			nome = in.nextLine();
		}
		System.out.print("Infome o numero telefônico sem o DDD: ");
		String telefone = in.nextLine();
		while (!validaTelefone(telefone)) {
			System.out.println(
					"O telefone deve conter somente digitos\n" + "e não deve ter mais de 9 digitos ou menos que 8.");
			System.out.print("Infome o numero telefônico sem o DDD: ");
			telefone = in.nextLine();
		}
		System.out.print("Informe o email do contato: ");
		String email = in.nextLine();
		while(!validaEmail(email)) {
			System.out.println("O email deve serguir o padrão de exemplo.1@ospedagem.xxx");
			System.out.print("Informe o email do contato: ");
			email = in.nextLine();
		}
		return new Contato(nome, telefone, email);
	}

	private boolean validaNome(String nome) {
		boolean val = true;
		int length = nome.length();
		if (nome.charAt(0) == ' ') {
			val = false;
		} else {
			for (int i = 0; i < length; i++) {
				if (!Character.isLetter(nome.charAt(i)) && !Character.isSpaceChar(nome.charAt(i))) {
					val = false;
					break;
				}
				if (i > 0) {
					char ant = nome.charAt(i - 1);
					char aux = nome.charAt(i);
					if (ant == ' ' && aux == ' ') {
						val = false;
						break;
					}
				}
			}
		}
		return val;
	}

	private boolean validaTelefone(String telefone) {
		boolean val = true;
		int length = telefone.length();
		if (length > 9 || length < 8) {
			val = false;
		} else {
			for(int i = 0; i < length; i++) {
				if(!Character.isDigit(telefone.charAt(i))) {
					val = false;
					break;
				}
			}
		}
		return val;
	}

	private boolean validaEmail(String email) {
		int length = email.length();
		int index = -1;
		for(int i = 0; i < length; i++) {
			if(!Character.isLetterOrDigit(email.charAt(i)) && email.charAt(i) != '@' &&
					email.charAt(i) != '.' && email.charAt(i) != '_') {
				return false;
			}
			if(email.charAt(i) == '@') {
				index = i;
				break;
			}
		}
		if (index == -1) {
			return false;
		} else {
			for (int j = index + 1; j < length; j++) {
				if (!Character.isAlphabetic(email.charAt(j)) && email.charAt(j) != '.') {
					return false;
				}
				if (j > index + 2) {
					char ant = email.charAt(j - 1);
					char aux = email.charAt(j);
					if (ant == '.' && aux == '.') {
						return false;
					}
				}
			}
		}	
		return true;
	}
}
