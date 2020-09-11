package br.unicap.ed1.TiposDeDados;

public class LSESemRepetir<T extends Comparable<T>> extends LSE<T>{
	
	public void incerirNó(T obj) {		
		LSENode<T> node = new LSENode<T>(obj);
		if (this.isEmpty()) {
			this.setInicio(node);
			this.setFim(node);
			this.addOneToQtd();
		}
		else {
			if(this.getItem(obj) == null) {
				node.setProx(this.getInicio());
				this.setInicio(node);
				this.addOneToQtd();
			}
			else {
				System.out.println("Item já existe na lista.");
			}
		}
	}
	
	public void inserirNóFinal(T obj) {
		LSENode<T> node = new LSENode<T>(obj);
		if (this.isEmpty()) {
			this.setInicio(node);
			this.setFim(node);
			this.addOneToQtd();
		} 
		else {
			if(this.getItem(obj) == null) {
				this.getFim().setProx(node);
				this.setFim(node);
				this.addOneToQtd();
			}
			else {
				System.out.println("Item já existe na lista.");
			}
		}
	}
	
	public void substituiItem(T item, T novo) {
		if(novo != null) {
			LSENode<T> index = this.getItem(item);
			if(index != null) {
				if(getItem(novo) == null) {
					index.setInfo(novo);
				}
				else {
					System.out.println("O item substituto já existe na lista.");
				}
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
