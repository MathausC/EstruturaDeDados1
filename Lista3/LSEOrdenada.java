package Lista3;

public class LSEOrdenada <T extends Comparable<T>> {

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

	public void exibirLista() {
		LSENode<T> aux = this.getInicio();
		while (aux != null) {
			System.out.println(aux.getInfo());
			aux = aux.getProx();
		}
	}
	
	private LSENode<T> buscaItem(T obj) {
		LSENode<T> aux = this.getInicio();
		LSENode<T> prox = aux.getProx();
		while (aux != null) {
			if (aux.getInfo().compareTo(obj) == 0) {
				break;
			}
			if(prox.getInfo().compareTo(obj) > 0) {
				aux = null;
				break;
			}
			aux = aux.getProx();
		}
		return aux;
	}
	
	public T buscaObjeto(T obj) {
		LSENode<T> node = this.getInicio();
		while(node.getInfo().compareTo(obj) <= 0) {
			if(node.getInfo().compareTo(obj) == 0) {
				return node.getInfo();
			}
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
	
	public void incerir(T obj) {		
		LSENode<T> node;
		if (this.isEmpty()) {
			node = new LSENode<T>(obj);
			this.setInicio(node);
			this.setFim(node);
			this.qtd++;
		}
		else {			
			node = new LSENode<T>(obj);
			if(this.getInicio().getInfo().compareTo(obj) > 0) {
				node.setProx(this.getInicio());
				this.setInicio(node);
				this.qtd++;	
			}
			else if(this.getFim().getInfo().compareTo(obj) < 0) {
				this.getFim().setProx(node);
				this.setFim(node);
				this.qtd++;	
			}
			else {
				LSENode<T> ant = this.getInicio();
				LSENode<T> aux = ant.getProx();
				while(true) {
					if(aux.getInfo().compareTo(obj) < 0) {
						ant = aux;
						aux = aux.getProx();
					}
					else if(aux.getInfo().compareTo(obj) == 0) {
						System.out.println("Item já existe na lista.");
						break;
					}
					else {
						node.setProx(aux);
						ant.setProx(node);
						this.qtd++;	
						System.out.println("Item inserido.");
						break;
					}
				}				
			}
		}	
	}
	
	public void remover(T obj) {
		if(this.isEmpty()) {
			System.out.println("Lista vazia.");
		}
		else {
			if(this.getInicio().getInfo().compareTo(obj) > 0 || this.getFim().getInfo().compareTo(obj) < 0) {
				System.out.println("Item não pertence a lista.");
			}
			else {
				if(this.getInicio().getInfo().compareTo(obj) == 0) {
					this.setInicio(this.getInicio().getProx());
					this.qtd--;
					if(this.getInicio() == null) {
						this.setFim(null);
					}
					System.out.println("Item removido.");
				}
				else if(this.getFim().getInfo().compareTo(obj) == 0) {
					LSENode<T> aux = this.getInicio();
					while(aux.getProx() != this.getFim()) {
						aux = aux.getProx();
					}
					aux.setProx(null);
					this.setFim(aux);
					this.qtd--;
					System.out.println("Item removido.");
				}
				else {
					LSENode<T> ant = this.getInicio();
					LSENode<T> aux = this.getInicio().getProx();
					while(true) {
						if(aux.getInfo().compareTo(obj) == 0) {
							ant.setProx(aux.getProx());
							this.qtd--;
							break;
						}
						ant = aux;
						aux = aux.getProx();
						if(aux.getProx().getInfo().compareTo(obj) > 0) {
							System.out.println("Item não encontrado");
							break;
						}
					}
				}
			}			
		}
	}
}
