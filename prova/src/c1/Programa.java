package c1;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Enciclopedia enciclopedia = new Enciclopedia(100); // Limite de 100 verbetes na enciclopédia

        // Adicionar verbetes a enciclopédia
        enciclopedia.adicionarVerbete("Java", "Linguagem de programação orientada a objetos.");
        enciclopedia.adicionarVerbete("Python", "Linguagem de programação interpretada de alto nível.");

        // Adicionar verbetes correlatos
        enciclopedia.adicionarVerbetesCorrelatos("Java", "Programação", "IDE", "Frameworks");
        enciclopedia.adicionarVerbetesCorrelatos("Python", "Programação", "Interpretada", "Scripting");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o título do verbete que deseja buscar: ");
        String titulo = scanner.nextLine();

        String definicao = enciclopedia.buscarDefinicao(titulo);

        if (definicao != null) {
            System.out.println("Definição de " + titulo + ": " + definicao);

            String[] verbetesCorrelatos = enciclopedia.buscarVerbetesCorrelatos(titulo);
            System.out.println("Verbete correlato de " + titulo + ":");
            for (String verbete : verbetesCorrelatos) {
                System.out.println("- " + verbete);
            }
        } else {
            System.out.println("Verbete não encontrado!");
        }

        scanner.close();
    }
}

