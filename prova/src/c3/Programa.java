package c3;
public class Programa {
	public static void main(String[] args) {
		 Concessionaria concessionaria = new Concessionaria();
		 
		    // Registra clientes regulares
		    concessionaria.registrarCliente("Cliente 1", "11111111111", "Endereco 1", "11111111", false, "vendas");
		    concessionaria.registrarCliente("Cliente 2", "22222222222", "Endereco 2", "22222222", false, "oficina");
		    concessionaria.registrarCliente("Cliente 3", "33333333333", "Endereco 3", "33333333", false, "acessorios");

		    // Registra clientes preferenciais
		    concessionaria.registrarCliente("Cliente 4", "44444444444", "Endereco 4", "44444444", false, "vendas");
		    concessionaria.registrarCliente("Cliente 5", "55555555555", "Endereco 5", "55555555", true, "oficina");

		    // Chama próximo cliente
		    int quantidadeClientes = concessionaria.getContadorClientes();
		    System.out.println(quantidadeClientes);
		    for(int i=0; i<quantidadeClientes;i++ ) {
		    concessionaria.chamarProximoClienteVendas("Claudia", 1);
		    concessionaria.chamarProximoClienteOficina("Rogerio", 2);
		    concessionaria.chamarProximoClienteAcessorios("Marta", 3);
		    }
		}
   

}
