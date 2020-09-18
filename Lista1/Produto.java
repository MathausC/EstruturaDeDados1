import java.util.Scanner;

public class Produto implements Comparable<Produto>{
	
	private String codigo;
	private String descricao;
	private double preco;
	private int estoque;
	
	private void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCodigo() {
		return this.codigo;
	}
	
	private void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return this.descricao;
	}
	
	private void setPreco(double preco) {
		if(preco > 0) {
			this.preco = preco;
		}
	}
	public double getPreco() {
		return this.preco;
	}
	
	private void setEstoque(int estoque) {
		if(estoque >= 0) {
			this.estoque = estoque;			
		}
	}
	public int getEstoque() {
		return this.estoque;
	}
	
	public Produto(String codigo, String descricao, double preco, int estoque) {
		this.setCodigo(codigo);
		this.setDescricao(descricao);
		this.setPreco(preco);
		this.setEstoque(estoque);
	}
	
	private void alterarPreco(double valor) {
		if(valor > 0) {
			this.setPreco(valor);
			System.out.println("Preço alterado.");
		}
		else {
			System.out.println("O preço deve ser maior que zero (0).");
		}
	}
	
	private void alterarEstoque(int est) {
		if(est >= 0) {
			this.setEstoque(est);
			System.out.println("Estoque alterado.");
		}
		else {
			System.out.println("O estoque não pode ser menor que zero (0).");
		}
	}
	
	public void alteraItem() {
		Scanner in = new Scanner(System.in);
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
				this.alterarPreco(preco);
			}
			if(resp == 'E') {
				flagE = true;
				System.out.print("Informe a quantidade do estoque: ");
				est = in.nextInt(); in.nextLine();
				this.alterarEstoque(est);
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
	
	public int compareTo(Produto p) {
		return this.getCodigo().compareToIgnoreCase(p.getCodigo());
	}
	
	public String toString() {
		String mensagem = 
				"Código: " + this.getCodigo() + "\n" + 
				"Descrição: " + this.getDescricao() + "\n" +
				"Preço: R$" + this.getPreco() + "\n" +
				"Estoque: " + this.getEstoque();
		return mensagem;
	}
}
