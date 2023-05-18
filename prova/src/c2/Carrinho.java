package c2;

import java.util.Random;
import java.util.Scanner;

public class Carrinho {
	private static final int TIJOLO_NORMAL = 0;
    private static final int TIJOLO_BOMBA = 1;
    private static final int TIJOLO_ENERGIA = 2;

    private int tamanhoPista;
    private int[] pista;
    private int posicaoCarrinho;
    private int energiaCampoForca;
    private int tijolosPercorridos;
    private int energiaCapturada;
    private int bombasBatidas;

    public Carrinho(int tamanhoPista) {
        this.tamanhoPista = tamanhoPista;
        this.pista = new int[tamanhoPista];
        this.posicaoCarrinho = 0;
        this.energiaCampoForca = 0;
        this.tijolosPercorridos = 0;
        this.energiaCapturada = 0;
        this.bombasBatidas = 0;
        gerarPista();
    }

    private void gerarPista() {
        Random random = new Random();
        for (int i = 0; i < tamanhoPista; i++) {
            int tipoTijolo = random.nextInt(3);
            pista[i] = tipoTijolo;
        }
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);
        boolean jogoAtivo = true;

        System.out.println("Bem-vindo ao jogo do carrinho!");
        System.out.println("Lembre-se, os tijolos podem ser normais, bombas ou energia, a cada 1 energia, você fica imune a 1 bomba! E (;w;), indica a posição do seu carrinho.");
        System.out.println("Você também poderá acabar pulando para uma bomba, tome cuidado!");
        System.out.println("Pressione 'p' para pular o tijolo atual.");
        System.out.println("Boa sorte!");

        while (jogoAtivo) {
            exibirPista();
            System.out.println("Tijolos percorridos: " + tijolosPercorridos);
            System.out.println("Energia capturada: " + energiaCapturada);
            System.out.println("Bombas batidas: " + bombasBatidas);

            System.out.print("Pressione 'p' para pular: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("p")) {
                pularTijolo();
            }

            if (posicaoCarrinho >= tamanhoPista) {
                jogoAtivo = false;
            } else {
                int tipoTijoloAtual = pista[posicaoCarrinho];
                if (tipoTijoloAtual == TIJOLO_NORMAL) {
                    tijolosPercorridos++;
                } else if (tipoTijoloAtual == TIJOLO_BOMBA) {
                    if (energiaCampoForca > 0) {
                        energiaCampoForca--;
                        energiaCapturada--;
                    } else {
                        bombasBatidas++;
                        jogoAtivo = false;
                    }
                } else if (tipoTijoloAtual == TIJOLO_ENERGIA) {
                    energiaCapturada++;
                    energiaCampoForca++;
                    tijolosPercorridos++;
                }

                posicaoCarrinho++;
            }
        }
        scanner.close();

        exibirEstatisticas();
        System.out.println("Fim de jogo!");
    }

    private void exibirPista() {
    	StringBuilder pistaString = new StringBuilder();
        for (int i = 0; i < tamanhoPista; i++) {
            if (i == posicaoCarrinho) {
                pistaString.append("(;w;)");
            } else {
                switch (pista[i]) {
                    case TIJOLO_NORMAL:
                        pistaString.append("|-|");
                        break;
                    case TIJOLO_BOMBA:
                        pistaString.append("|-|");
                        break;
                    case TIJOLO_ENERGIA:
                        pistaString.append("|-|");
                        break;
                }
            }
        }
        System.out.println(pistaString.toString());
    }

    private void pularTijolo() {
        if (posicaoCarrinho < tamanhoPista - 1) {
            posicaoCarrinho++;
            tijolosPercorridos++;
        }
    }

    private void exibirEstatisticas() {
        System.out.println("----- RESULTADO -----");
        System.out.println("Tijolos percorridos: " + tijolosPercorridos);
        System.out.println("Energia capturada: " + energiaCapturada);
        System.out.println("Bombas batidas: " + bombasBatidas);
    }
   
}
