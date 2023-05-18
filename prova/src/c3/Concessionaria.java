package c3;

public class Concessionaria {
	private FilaVendas filaVendas;
    private FilaOficina filaOficina;
    private FilaAcessorios filaAcessorios;
    private int contadorClientes;

    public Concessionaria() {
        filaVendas = new FilaVendas();
        filaOficina = new FilaOficina();
        filaAcessorios = new FilaAcessorios();
        contadorClientes = 0;
    }

    public void registrarCliente(String nome, String cpf, String endereco, String telefone, boolean preferencialOuRegular, String filaDestino) {
        Cliente cliente = new Cliente(nome, cpf, endereco, telefone, preferencialOuRegular);
        
        if (filaDestino.equals("vendas")) {
            filaVendas.enfileirar(cliente, preferencialOuRegular);
        } else if (filaDestino.equals("oficina")) {
            filaOficina.enfileirar(cliente, preferencialOuRegular);
        } else if (filaDestino.equals("acessorios")) {
            filaAcessorios.enfileirar(cliente, preferencialOuRegular);
        }
        contadorClientes++;
    }

    public void chamarProximoClienteVendas(String nomeAtendente, int numeroMesa) {
        Cliente cliente = null;
        String filaDestino = null;
        String preferencial = null;

        if (filaVendas.getTamanho() > 0 && filaVendas.temClientePreferencial()) {
            cliente = filaVendas.desenfileirarClientePreferencial();
            filaDestino = "Vendas de Automóveis";
            preferencial = "Sim";
        } else if (filaVendas.getTamanho() > 0) {
            cliente = filaVendas.desenfileirar();
            filaDestino = "Vendas de Automóveis";
            preferencial = "Nao";
        }
        
        if (cliente != null) {
        	Atendimento atendimento = new Atendimento(nomeAtendente, numeroMesa);
        	System.out.println("------- VENDAS -------");
            System.out.println("Atendentimento: " +atendimento.getNomeAtendente() +" - Mesa " + atendimento.getNumeroMesa());
            System.out.println("Próximo cliente a ser atendido:");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Preferencial: "+ preferencial);
            System.out.println("Fila: " + filaDestino);
            System.out.println("----------------------");
        } else {
            System.out.println("Não há clientes na fila.");
        }
    }
    public void chamarProximoClienteOficina(String nomeAtendente, int numeroMesa) {
    	Cliente cliente = null;
        String filaDestino = null;
        String preferencial = null;
        
        if (filaOficina.getTamanho() > 0 && filaOficina.temClientePreferencial()) {
        cliente = filaOficina.desenfileirarClientePreferencial();
        filaDestino = "Oficina Mecânica";
        preferencial = "Sim";
        
        }else if (filaOficina.getTamanho() > 0) {
            cliente = filaOficina.desenfileirar();
            filaDestino = "Oficina Mecânica";
            preferencial = "Nao";
      }
        
        if (cliente != null) {
        	Atendimento atendimento = new Atendimento(nomeAtendente, numeroMesa);

        	System.out.println("------ OFICINA ------");
            System.out.println("Atendentimento: " +atendimento.getNomeAtendente() +" - Mesa " + atendimento.getNumeroMesa());
            System.out.println("Próximo cliente a ser atendido:");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Preferencial: "+ preferencial);
            System.out.println("Fila: " + filaDestino);
            System.out.println("---------------------");
        } else {
            System.out.println("Não há clientes na fila.");
        }
    }
    
    public void chamarProximoClienteAcessorios(String nomeAtendente, int numeroMesa){
    	Cliente cliente = null;
        String filaDestino = null;
        String preferencial = null;
    	
    	if (filaAcessorios.getTamanho() > 0 && filaAcessorios.temClientePreferencial()) {
        cliente = filaAcessorios.desenfileirarClientePreferencial();
        filaDestino = "Acessórios";
        preferencial = "Sim";
    	}else if (filaAcessorios.getTamanho() > 0) {
        cliente = filaAcessorios.desenfileirar();
        filaDestino = "Acessórios";
        preferencial = "Nao";
    }
        if (cliente != null) {
        	Atendimento atendimento = new Atendimento(nomeAtendente, numeroMesa);

        	System.out.println("----- ACESSORIOS -----");
            System.out.println("Atendentimento: " +atendimento.getNomeAtendente() +" - Mesa " + atendimento.getNumeroMesa());
            System.out.println("Próximo cliente a ser atendido:");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Preferencial: "+ preferencial);
            System.out.println("Fila: " + filaDestino);
            System.out.println("----------------------");
        } else {
            System.out.println("Não há clientes na fila.");
        }
    }

	public int getContadorClientes() {
		// TODO Auto-generated method stub
		return contadorClientes;
	}
            
        
            
      

   
    

}

