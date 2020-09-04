package br.unicap.ed1.TiposDeDados;

public class LSE<T> {
	private LSENode<T> inicio;
	private LSENode<T> fim;
	private int qtd;

	@SuppressWarnings("unused")
	private void setInicio(LSENode<T> inicio) {
		this.inicio = inicio;
	}

	public LSENode<T> getInicio() {
		return this.inicio;
	}

	private boolean isEmpty() {
		return this.inicio == null;
	}

	public void incerirNó(T obj) {
		LSENode<T> node = new LSENode<T>(obj);
		if (this.isEmpty()) {
			this.inicio = node;
			this.fim = node;
		} else {
			node.setProx(this.inicio);
			this.inicio = node;
		}
		this.qtd++;
	}

	public void inserirNóFinal(T obj) {
		LSENode<T> node = new LSENode<T>(obj);
		if (this.isEmpty()) {
			this.inicio = node;
			this.fim = node;
		} else {
			this.fim.setProx(node);
			this.fim = node;
		}
		this.qtd++;
	}

	public void exibirLista() {
		LSENode<T> aux = this.inicio;
		while (aux != null) {
			System.out.println(aux.getInfo());
			aux = aux.getProx();
		}
	}
	
	public void removerInicio() {
		if(!this.isEmpty()) {
			if(this.qtd == 1) {
				this.inicio = this.inicio.getProx();
				this.fim = this.fim.getProx();
			}
			else {
				this.inicio = this.inicio.getProx();
			}
			this.qtd--;
		}
		else {
			System.out.println("Não há itens a serem removidos");
		}
	}
	
	public void removerFim() {		
		if(!this.isEmpty()) {
			if(qtd == 1) {
				this.inicio = this.inicio.getProx();
				this.fim = this.fim.getProx();
			}
			else {
				LSENode<T> aux = this.inicio.getProx();
				LSENode<T> ant = this.inicio;
				while(aux != null) {
					ant = aux;
					aux = aux.getProx();
				}
				this.fim = ant;
			}
			this.qtd--;
		}
		else {
			System.out.println("Não há itens a serem removidos");
		}
	}
	
	private LSENode<T> getItem(T obj) {		
		LSENode<T> aux = this.inicio;
		while(aux.getInfo() != obj && aux != null) {
			aux = aux.getProx();
		}
		return aux;
	}

	public void substituiItem(T item, T novo) {
		if(novo != null) {
			LSENode<T> index = this.getItem(item);
			if(index != null) {
				index.setInfo(novo);
			}
			else {
				System.out.println("Item não encontrado para substituição");
			}
		}
		else {
			System.out.println("Não e possível substitir o item desejado\n"
								+ "por um objeto nulo.");
		}
	}
}
