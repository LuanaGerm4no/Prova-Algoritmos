package c3;

public class FilaAcessorios {
    private No inicio;
    private No fim;
    private int tamanho;

    public FilaAcessorios() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public void enfileirar(Cliente cliente, boolean preferencial) {
        No novoNo = new No(cliente);

        if (preferencial) {
            if (inicio == null) {
                inicio = novoNo;
                fim = novoNo;
            } else {
                novoNo.setNext(inicio);
                inicio = novoNo;
            }
        } else {
            if (fim == null) {
                inicio = novoNo;
                fim = novoNo;
            } else {
                fim.setNext(novoNo);
                fim = novoNo;
            }
        }

        tamanho++;
    }
    public Cliente desenfileirar() {
        if (inicio == null) {
            return null;
        }

        No noRemovido = inicio;
        inicio = inicio.getNext();
        noRemovido.setNext(null);
        tamanho--;

        if (inicio == null) {
            fim = null;
        }

        return noRemovido.getCliente();
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean temClientePreferencial() {
        No atual = inicio;

        while (atual != null) {
            if (atual.cliente.isPreferencial()) {
                return true;
            }
            atual = atual.next;
        }

        return false;
    }

    public Cliente desenfileirarClientePreferencial() {
        if (inicio == null) {
            return null;
        }

        Cliente cliente = null;

        if (inicio.cliente.isPreferencial()) {
            cliente = inicio.cliente;
            inicio = inicio.next;
            if (inicio == null) {
                fim = null;
            }
        } else {
            No atual = inicio;
            while (atual.next != null) {
                if (atual.next.cliente.isPreferencial()) {
                    cliente = atual.next.cliente;
                    atual.next = atual.next.next;
                    if (atual.next == null) {
                        fim = atual;
                    }
                    break;
                }
                atual = atual.next;
            }
        }

        return cliente;
    }
}
