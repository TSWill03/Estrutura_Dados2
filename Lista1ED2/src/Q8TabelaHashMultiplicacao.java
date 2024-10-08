public class Q8TabelaHashMultiplicacao {

    static class Entrada {
        int chave;

        Entrada(int chave) {
            this.chave = chave;
        }

        @Override
        public String toString() {
            return String.valueOf(chave);
        }
    }

    static class TabelaHash {
        Entrada[] tabela;
        int tamanho;
        final double A = (Math.sqrt(5) - 1) / 2;

        public TabelaHash(int tamanho) {
            this.tamanho = tamanho;
            tabela = new Entrada[tamanho];
        }


        public int funcaoHash(int chave) {
            double hash = tamanho * ((chave * A) % 1);
            return (int) Math.floor(hash);
        }


        public void inserir(int chave) {
            int indice = funcaoHash(chave);
            System.out.println("Inserindo chave " + chave + " no índice " + indice);

            while (tabela[indice] != null) {
                System.out.println("Colisão no índice " + indice + ", tentando próximo índice...");
                indice = (indice + 1) % tamanho;
            }

            tabela[indice] = new Entrada(chave);
            exibirTabela();
        }


        public void remover(int chave) {
            int indice = funcaoHash(chave);
            System.out.println("Removendo chave " + chave + " do índice " + indice);

            while (tabela[indice] != null && tabela[indice].chave != chave) {
                indice = (indice + 1) % tamanho;
            }

            if (tabela[indice] != null) {
                tabela[indice] = null;
                System.out.println("Chave " + chave + " removida.");
            } else {
                System.out.println("Chave " + chave + " não encontrada.");
            }
            exibirTabela();
        }


        public void exibirTabela() {
            for (int i = 0; i < tabela.length; i++) {
                if (tabela[i] != null) {
                    System.out.println("Índice " + i + ": " + tabela[i]);
                } else {
                    System.out.println("Índice " + i + ": vazio");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash(11);

        int[] chavesInserir = {4, 17, 13, 35, 25, 11, 2, 10, 32};
        for (int chave : chavesInserir) {
            tabelaHash.inserir(chave);
        }

        int[] chavesRemover = {25, 11};
        for (int chave : chavesRemover) {
            tabelaHash.remover(chave);
        }

        int[] novasChavesInserir = {40, 3};
        for (int chave : novasChavesInserir) {
            tabelaHash.inserir(chave);
        }
    }
}
