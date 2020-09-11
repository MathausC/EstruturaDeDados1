package br.unicap.ed1.TiposDeDados;

public class LSE<T extends Comparable<T>> {
	private LSENode<T> inicio;
	private LSENode<T> fim;
	private int qtd;

	protected void setInicio(LSENode<T> inicio) {
		this.inicio = inicio;
	}

	public LSENode<T> getInicio() {
		return this.inicio;
	}
	
	protected void setFim(LSENode<T> fim) {
		this.fim = fim;
	}
	
	public LSENode<T> getFim() {
		return this.fim;
	}

	protected boolean isEmpty() {
		return this.inicio == null;
	}
	
	public int getQtd() {
		return this.qtd;
	}
	
	protected void addOneToQtd() {
		this.qtd++;
	}

	public void incerirNó(T obj) {
		LSENode<T> node = new LSENode<T>(obj);
		if (this.isEmpty()) {
			this.setInicio(node);
			this.setFim(node);
		}
		else {
			node.setProx(this.getInicio());
			this.setInicio(node);				
		}
		this.addOneToQtd();
	}

	public void inserirNóFinal(T obj) {
		LSENode<T> node = new LSENode<T>(obj);
		if (this.isEmpty()) {
			this.setInicio(node);
			this.setFim(node);
		} 
		else {
			this.getFim().setProx(node);
			this.setFim(node);
		}
		this.addOneToQtd();
	}

	public void exibirLista() {
		LSENode<T> aux = this.getInicio();
		while (aux != null) {
			System.out.println(aux.getInfo());
			aux = aux.getProx();
		}
	}
	
	public void removerInicio() {
		if(!this.isEmpty()) {
			if(this.qtd == 1) {
				this.setInicio(null);
				this.setFim(null);
			}
			else {
				this.setInicio(this.getInicio().getProx());
			}
			System.out.println("Item removido.");
			this.qtd--;
		}
		else {
			System.out.println("Não há itens a serem removidos");
		}
	}
	
	public void removerFim() {		
		if(!this.isEmpty()) {
			if(qtd == 1) {
				this.setInicio(null);
				this.setFim(null);
			}
			else {
				LSENode<T> aux = this.getInicio();
				LSENode<T> ant = null;
				while(aux.getProx() != null) {
					ant = aux;
					aux = aux.getProx();
				}
				this.setFim(ant);
				this.getFim().setProx(null);
			}
			System.out.println("Item removido.");
			this.qtd--;
		}
		else {
			System.out.println("Não há itens a serem removidos");
		}
	}
	
	protected LSENode<T> getItem(T obj) {		
		LSENode<T> aux = this.getInicio();
		while(aux != null) {
			if(aux.getInfo().compareTo(obj) == 0) {
				return aux;
			}
			aux = aux.getProx();
		}
		return null;
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
