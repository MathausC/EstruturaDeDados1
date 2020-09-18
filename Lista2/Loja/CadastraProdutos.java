package Loja;
import java.util.Scanner;
import Lista1.LSESemRepetidos;

public class CadastraProdutos {
	Scanner in = new Scanner(System.in);
	LSESemRepetidos<Produto> LSE = new LSESemRepetidos<Produto>();
	
	public void inserirProdutoInicio() {
		LSE.incerirNó(this.geraProduto());
	}
	
	public void inserirProdutoFinal() {
		LSE.inserirNóFinal(this.geraProduto());
	}
	
	public void removerPrimeiroProduto() {
		LSE.removerInicio();
	}
	
	public void removerUltimoProduto() {
		LSE.removerFim();
	}
	
	public void exibirProdutos() {
		LSE.exibirLista();
	}
	
	public void exibirProduto() {
		LSE.exibirItem(this.geraProdutoDeBusca());
	}
	
	public void alterarProduto() {
		Produto index = LSE.buscaObjeto(this.geraProdutoDeBusca());
		char resp;
		boolean flagP = false, flagE = false;
		double preco;
		int est;
		System.out.println("O que você deseja alterar (P - preço | E - estoque)? ");
		resp = in.next().charAt(0); in.nextLine();
		resp = Character.toUpperCase(resp);
		while(resp != 'P' && resp != 'E') {
			System.out.println("Opção inválida.");
			System.out.println("O que você deseja alterar (P - preço | E - estoque)? ");
			resp = in.next().charAt(0); in.nextLine();
			resp = Character.toUpperCase(resp);
		}
		do {
			if(resp == 'P') {
				flagP = true;
				System.out.print("Informe o novo preço do produto: ");
				preco = in.nextDouble(); in.hasNextLine();
				index.alterarPreco(preco);
			}
			if(resp == 'E') {
				flagE = true;
				System.out.print("Informe a quantidade do estoque: ");
				est = in.nextInt(); in.nextLine();
				index.alterarEstoque(est);
			}
			if(flagP && !flagE) {
				System.out.print("Deseja alterar o estoque? (S - sim | N - não) ");
				resp = in.next().charAt(0); in.nextLine();
				resp = Character.toUpperCase(resp);
				while(resp != 'S' && resp != 'N') {
					System.out.println("Opção inválida.");
					System.out.print("Deseja alterar o estoque? (S - sim | N - não) ");
					resp = in.next().charAt(0); in.nextLine();
					resp = Character.toUpperCase(resp);
				}
				if(resp == 'S') {
					resp = 'E';
				}
				else {
					flagE = true;
				}
			}
			if(flagE && !flagP){
				System.out.print("Deseja alterar o preço? (S - sim | N - não) ");
				resp = in.next().charAt(0); in.nextLine();
				resp = Character.toUpperCase(resp);
				while(resp != 'S' && resp != 'N') {
					System.out.println("Opção inválida.");
					System.out.print("Deseja alterar o estoque? (S - sim | N - não) ");
					resp = in.next().charAt(0); in.nextLine();
					resp = Character.toUpperCase(resp);
				}
				if(resp == 'S') {
					resp = 'P';
				}
				else {
					flagP = true;
				}
			}
		} while(!flagP || !flagE);
	}
	
	public void removerProduto() {
		LSE.removerItem(this.geraProdutoDeBusca());
	}
	
	private Produto geraProdutoDeBusca() {
		System.out.print("informe o código do produto: ");
		String c = in.nextLine();
		return new Produto(c, "", 0, 0);
	}
	
	private Produto geraProduto() {
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

}
