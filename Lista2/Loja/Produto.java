package Loja;

class Produto implements Comparable<Produto>{
	
	private String codigo;
	private String descricao;
	private double preco;
	private int estoque;
	
	private void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	String getCodigo() {
		return this.codigo;
	}
	
	private void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	String getDescricao() {
		return this.descricao;
	}
	
	private void setPreco(double preco) {
		if(preco > 0) {
			this.preco = preco;
		}
	}
	double getPreco() {
		return this.preco;
	}
	
	private void setEstoque(int estoque) {
		if(estoque >= 0) {
			this.estoque = estoque;			
		}
	}
	int getEstoque() {
		return this.estoque;
	}
	
	Produto(String codigo, String descricao, double preco, int estoque) {
		this.setCodigo(codigo);
		this.setDescricao(descricao);
		this.setPreco(preco);
		this.setEstoque(estoque);
	}
	
	void alterarPreco(double valor) {
		if(valor > 0) {
			this.setPreco(valor);
			System.out.println("Preço alterado.");
		}
		else {
			System.out.println("O preço deve ser maior que zero (0).");
		}
	}
	
	void alterarEstoque(int est) {
		if(est >= 0) {
			this.setEstoque(est);
			System.out.println("Estoque alterado.");
		}
		else {
			System.out.println("O estoque não pode ser menor que zero (0).");
		}
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
