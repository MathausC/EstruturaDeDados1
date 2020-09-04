package br.unicap.ed1.TipoDeDados;

class LSENode <T> {
    private T info;
    private LSENode<T> prox;

    void setInfo(T obj) {
        this.info = obj;
    }
    T getInfo() {
        return this.info;
    }

    void setProx(LSENode<T> prox) {
        this.prox = prox;
    }
    LSENode<T> getProx(){
        return this.prox;
    }

    LSENode (T obj) {
        setInfo(obj);
    }
}
