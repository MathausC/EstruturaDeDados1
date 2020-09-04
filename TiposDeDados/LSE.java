package br.unicap.ed1.TipoDeDados;

public class LSE<T> {
  private LSENode<T> inicio;
  private LSENode<T> fim;
  private int qtd;

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
      LSENode node = new LSENode(obj);
      if(this.isEmpty()) {
          this.inicio = node;
          this.fim = node;
      }
      else {
          node.setProx(this.inicio);
          this.inicio = node;
      }
      this.qtd++;
  }

  public void inserirNóFinal(T obj) {
      LSENode node = new LSENode(obj);
      if(this.isEmpty()) {
          this.inicio = node;
          this.fim = node;
      }
      else {
          this.fim.setProx(node);
          this.fim = node;
      }
      this.qtd++;
  }

  public void exibirLista() {
      LSENode aux = this.inicio;
      while(aux != null) {
          System.out.println(aux.getInfo());
          aux = aux.getProx();
      }
  }

}
