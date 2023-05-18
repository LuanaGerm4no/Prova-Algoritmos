package c2;

import java.util.Scanner;

public class Jogo {
	   public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Seu carrinho começará a corrida na primeira posição!");
	        System.out.print("Digite o tamanho da pista: ");
	        int tamanhoPista = scanner.nextInt();

	        Carrinho jogo = new Carrinho(tamanhoPista);
	        jogo.jogar();
	        scanner.close();
	    }
}
