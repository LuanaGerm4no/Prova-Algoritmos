package c3;

public class Atendimento {
	private String nomeAtendente;
    private int numeroMesa;

    public Atendimento(String nomeAtendente, int numeroMesa) {
        this.nomeAtendente = nomeAtendente;
        this.numeroMesa = numeroMesa;
    }

	public String getNomeAtendente() {
		return nomeAtendente;
	}

	public void setNomeAtendente(String nomeAtendente) {
		this.nomeAtendente = nomeAtendente;
	}

	public int getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}
}
