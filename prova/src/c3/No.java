package c3;

public class No {
	Cliente cliente;
    No next;

    public No(Cliente cliente) {
        this.cliente = cliente;
        this.next = null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public No getNext() {
        return next;
    }

    public void setNext(No next) {
        this.next = next;
    }
}
