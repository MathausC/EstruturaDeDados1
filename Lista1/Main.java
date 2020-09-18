import java.util.Scanner;
import Lista1.LSESemRepetidos;

public class Main {

	public static void main(String[] args) {
		LSESemRepetidos<Produto> lista = new LSESemRepetidos<Produto>();
		Scanner in = new Scanner(System.in);
		int op;
		Produto p;
		String c;

		System.out.println("Vamos iniciar nossa lista de produtos.");
		do {
			exibeMenu();
			op = in.nextInt();
			in.nextLine();
			switch (op) {
			case 1:
				p = criaProduto();
				lista.incerirNó(p);
				break;
			case 2:
				p = criaProduto();
				lista.incerirNó(p);
				lista.inserirNóFinal(p);
				break;
			case 3:
				lista.removerInicio();
				break;
			case 4:
				lista.removerFim();
				break;
				
			case 5:
				lista.exibirLista();
				break;
			case 6:
				System.out.println("Informe o código do produto: ");
				c = in.nextLine();
				p = criaProdutoDePesquisa(c);
				lista.exibirItem(p);
				break;
			case 7:
				System.out.println("Informe o código do produto: ");
				c = in.nextLine();
				p = criaProdutoDePesquisa(c);
				p = lista.buscaObjeto(p);
				if(p != null) {
					p.alteraItem();
				}
				else {
					System.out.println("Produto não encontrado");
				}
				break;
			case 8: 
				System.out.println("Informe o código do produto: ");
				c = in.nextLine();
				p = criaProdutoDePesquisa(c);
				lista.removerItem(p);
			case 0:
				System.out.println("Obrigado e até mais!");
				break;
			default:
				System.out.println("Opção inválida.");
				break;
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
	
	private static Produto criaProduto() {
		Scanner in = new Scanner(System.in);
		String codigo, descricao;
		double preco;
		int est;
		System.out.print("Informe o código do produto: ");
		codigo = in.nextLine();
		System.out.print("Informe a descrição do produto: ");
		descricao = in.nextLine();
		System.out.print("Informe o preço do produto: ");
		preco = in.nextDouble(); in.nextLine();
		while(preco <= 0) {
			System.out.println("O preço deve ser maior que zero (0).");
			System.out.print("Informe o preço do produto: ");
			preco = in.nextDouble(); in.nextLine();
		}
		System.out.print("Informe a quantidade em estoque: ");
		est = in.nextInt(); in.nextLine();
		while(est < 0) {
			System.out.println("O estoque não pode ser menor que zero (0).");
			System.out.print("Informe a quantidade em estoque: ");
			est = in.nextInt(); in.nextLine();
		}
		return new Produto(codigo, descricao, preco, est);
	}
	
	private static Produto criaProdutoDePesquisa(String c) {
		return new Produto(c, "", 0, 0);
	}

}
