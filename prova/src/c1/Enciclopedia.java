package c1;

import java.util.Arrays;

public class Enciclopedia {
	private static class Verbete {
        private String titulo;
        private String definicao;
        private String[] verbetesCorrelatos;
        private int numVerbetesCorrelatos;

        public Verbete(String titulo, String definicao, int maxVerbetesCorrelatos) {
            this.titulo = titulo;
            this.definicao = definicao;
            this.verbetesCorrelatos = new String[maxVerbetesCorrelatos];
            this.numVerbetesCorrelatos = 0;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getDefinicao() {
            return definicao;
        }

        public String[] getVerbetesCorrelatos() {
            return Arrays.copyOf(verbetesCorrelatos, numVerbetesCorrelatos);
        }

        public void adicionarVerbetesCorrelatos(String... verbetes) {
            for (String verbete : verbetes) {
                if (numVerbetesCorrelatos < verbetesCorrelatos.length) {
                    verbetesCorrelatos[numVerbetesCorrelatos] = verbete;
                    numVerbetesCorrelatos++;
                }
            }
        }
    }

    private Verbete[] verbetes;
    private int numVerbetes;

    public Enciclopedia(int maxVerbetes) {
        verbetes = new Verbete[maxVerbetes];
        numVerbetes = 0;
    }

    public void adicionarVerbete(String titulo, String definicao) {
        Verbete verbete = new Verbete(titulo, definicao, 10); // Limite de 10 verbetes correlatos por verbete
        verbetes[numVerbetes] = verbete;
        numVerbetes++;
    }

    public void adicionarVerbetesCorrelatos(String titulo, String... verbetesCorrelatos) {
        Verbete verbete = buscarVerbete(titulo);
        if (verbete != null) {
            verbete.adicionarVerbetesCorrelatos(verbetesCorrelatos);
        }
    }

    public String buscarDefinicao(String titulo) {
        Verbete verbete = buscarVerbete(titulo);
        if (verbete != null) {
            return verbete.getDefinicao();
        } else {
            return "Verbete não encontrado.";
        }
    }

    public String[] buscarVerbetesCorrelatos(String titulo) {
        Verbete verbete = buscarVerbete(titulo);
        if (verbete != null) {
            return verbete.getVerbetesCorrelatos();
        } else {
            return new String[0];
        }
    }

    private Verbete buscarVerbete(String titulo) {
        for (int i = 0; i < numVerbetes; i++) {
            if (verbetes[i].getTitulo().equalsIgnoreCase(titulo)) {
                return verbetes[i];
            }
        }
        return null;
    }
}




