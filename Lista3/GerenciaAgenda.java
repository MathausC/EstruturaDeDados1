import com.agenda.Agenda;
import java.util.Scanner;

public class GerenciaAgenda {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Agenda agenda = new Agenda();
		Agenda copia = null;
		char resp;
		System.out.println("Vamos iniciar nossa agenda.");
		do {
			System.out.print("Informe uma das opções abaixo.\n"
					+ "1 - Adicionar um novo contato;\n"
					+ "2 - Remover um contato;\n"
					+ "3 - Exibir lista de contatos;\n"
					+ "4 - Exibir um contato;\n"
					+ "5 - Alterar contato;\n"
					+ "6 - Fazer uma cópia da agenda;\n"
					+ "0 - Encerrar."
					+ "Opção: ");
			resp = in.next().charAt(0); in.nextLine();
			switch(resp) {
				case '1': agenda.adicionaContato(); break;
				case '2': agenda.removerContato(); break;
				case '3': agenda.exibirContatos(); break;
				case '4': agenda.exibirContato(); break;
				case '5': agenda.alterarContato(); break;
				case '6': copia = agenda.copiaAgenda(); break;
				case '0': System.out.println("Até mais."); break;
				default: System.out.println("Opção inválida."); break;
			}			
		} while (resp != '0');
		in.close();
	}

}
