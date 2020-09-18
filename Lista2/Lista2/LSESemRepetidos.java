package Lista2;

public class LSESemRepetidos<T extends Comparable<T>> {
	private LSENode<T> inicio;
	private LSENode<T> fim;
	private int qtd;

	private void setInicio(LSENode<T> inicio) {
		this.inicio = inicio;
	}

	public LSENode<T> getInicio() {
		return this.inicio;
	}

	private void setFim(LSENode<T> fim) {
		this.fim = fim;
	}

	public LSENode<T> getFim() {
		return this.fim;
	}

	private boolean isEmpty() {
		return this.inicio == null;
	}

	public int getQtd() {
		return this.qtd;
	}

	public void incerirNó(T obj) {
		LSENode<T> node = new LSENode<T>(obj);
		if (this.isEmpty()) {
			this.setInicio(node);
			this.setFim(node);
			this.qtd++;
		} else {
			if (this.buscaItem(obj) == null) {
				node.setProx(this.getInicio());
				this.setInicio(node);
				this.qtd++;
			} else {
				System.out.println("Item já existe na lista.");
			}
		}
	}

	public void inserirNóFinal(T obj) {
		LSENode<T> node = new LSENode<T>(obj);
		if (this.isEmpty()) {
			this.setInicio(node);
			this.setFim(node);
			this.qtd++;
		} else {
			if (this.buscaItem(obj) == null) {
				this.getFim().setProx(node);
				this.setFim(node);
				this.qtd++;
			} else {
				System.out.println("Item já existe na lista.");
			}
		}
	}

	public void exibirLista() {
		if (!this.isEmpty()) {
			LSENode<T> aux = this.getInicio();
			while (aux != null) {
				System.out.println(aux.getInfo());
				aux = aux.getProx();
			}
		} else {
			System.out.println("Não há itens a serem exibidos.");
		}

	}

	public void removerInicio() {
		if (!this.isEmpty()) {
			if (this.qtd == 1) {
				this.setInicio(null);
				this.setFim(null);
			} else {
				this.setInicio(this.getInicio().getProx());
			}
			System.out.println("Item removido.");
			this.qtd--;
		} else {
			System.out.println("Não há itens a serem removidos");
		}
	}

	public void removerFim() {
		if (!this.isEmpty()) {
			if (qtd == 1) {
				this.setInicio(null);
				this.setFim(null);
			} else {
				LSENode<T> aux = this.getInicio();
				LSENode<T> ant = null;
				while (aux.getProx() != null) {
					ant = aux;
					aux = aux.getProx();
				}
				this.setFim(ant);
				this.getFim().setProx(null);
			}
			System.out.println("Item removido.");
			this.qtd--;
		} else {
			System.out.println("Não há itens a serem removidos");
		}
	}

	private LSENode<T> buscaItem(T obj) {
		LSENode<T> aux = this.getInicio();
		while (aux != null) {
			if (aux.getInfo().compareTo(obj) == 0) {
				return aux;
			}
			aux = aux.getProx();
		}
		return null;
	}

	public void exibirItem(T obj) {
		LSENode<T> index = this.buscaItem(obj);
		if (index != null) {
			System.out.println(index.getInfo());
		} else {
			System.out.println("Item não existe na lista.");
		}
	}

	public void removerItem(T obj) {
		if (!this.isEmpty()) {
			LSENode<T> aux = this.getInicio();
			LSENode<T> ant = null;
			while (aux != null) {
				if (aux.getInfo().compareTo(obj) == 0) {
					if (ant == null) {
						this.setInicio(null);
						this.setFim(null);
					} else {
						ant.setProx(aux.getProx());
					}
					this.qtd--;
					System.out.println("Item removido.");
					break;
				}
				ant = aux;
				aux = aux.getProx();
			}
		} else {
			System.out.println("Não há itens a serem removidos.");
		}
	}

	public T buscaObjeto(T obj) {
		LSENode<T> aux = this.getInicio();
		while (aux != null) {
			if (aux.getInfo().compareTo(obj) != 0) {
				return aux.getInfo();
			}
			aux = aux.getProx();
		}
		return null;
	}
}
