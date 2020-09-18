import java.util.Scanner;
import Loja.CadastraProdutos;

public class Main {

	public static void main(String[] args) {
		CadastraProdutos cadastro = new CadastraProdutos();
		Scanner in = new Scanner(System.in);
		int op;

		System.out.println("Vamos iniciar nossa lista de produtos.");
		do {
			exibeMenu();
			op = in.nextInt();
			in.nextLine();
			switch (op) {
			case 1:	cadastro.inserirProdutoInicio(); break;
			case 2: cadastro.inserirProdutoFinal();	break;
			case 3:	cadastro.removerPrimeiroProduto(); break;
			case 4:	cadastro.removerUltimoProduto(); break;				
			case 5:	cadastro.exibirProdutos(); break;
			case 6:	cadastro.exibirProduto(); break;
			case 7:	cadastro.alterarProduto(); break;
			case 8: cadastro.removerProduto(); break;
			case 0:	System.out.println("Obrigado e até mais!");	break;
			default: System.out.println("Opção inválida.");	break;
			}
		} while (op != 0);
		in.close();

	}

	private static void exibeMenu() {
		String menu = 
				"Escolha umas das opções abaixo.\n" +
				"1 - Inserir novo produto no início da lista;\n" +
				"2 - Inserir novo produto no final da lista;\n" + 
				"3 - Remover o primeiro produto da lista;\n" + 
				"4 - Remover o último produto da lista;\n" + 
				"5 - Exibir todos os produtos da lista;\n"+ 
				"6 - Exibir os dados de um produto da lista;" + 
				"7 - Alterar os dados de um produto da lista;\n" + 
				"8 - Remover um produto da lista" + 
				"0 - Sair do programa.\n" + 
				"Opção: ";
		System.out.print(menu);
	}
	

}
