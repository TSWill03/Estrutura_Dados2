public class Q7TabelaHashEnderecamentoAberto {

    static class Entrada {
        char chave;
        int valor;

        Entrada(char chave, int valor) {
            this.chave = chave;
            this.valor = valor;
        }

        @Override
        public String toString() {
            return chave + "(" + valor + ")";
        }
    }

    static class TabelaHash {
        Entrada[] tabela;
        int tamanho;

        public TabelaHash(int tamanho) {
            this.tamanho = tamanho;
            tabela = new Entrada[tamanho];
        }

        public int funcaoHash(int valor) {
            return valor % tamanho;
        }

        public void inserir(char chave) {
            int valor = chave - 'A';
            int indice = funcaoHash(valor);
            System.out.println("Inserindo chave " + chave + " com valor " + valor + " no índice " + indice);

            while (tabela[indice] != null) {
                System.out.println("Colisão no índice " + indice + ", tentando próximo índice...");
                indice = (indice + 1) % tamanho;
            }

            tabela[indice] = new Entrada(chave, valor);
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

        char[] chaves = {'P', 'E', 'S', 'Q', 'U', 'I', 'S', 'A'};

        TabelaHash tabelaHash = new TabelaHash(13);

        for (char chave : chaves) {
            tabelaHash.inserir(chave);
        }
    }
}
