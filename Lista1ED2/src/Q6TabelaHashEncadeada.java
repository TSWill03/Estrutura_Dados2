import java.util.LinkedList;

public class Q6TabelaHashEncadeada {

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
        LinkedList<Entrada>[] tabela;

        @SuppressWarnings("unchecked")
        public TabelaHash(int tamanho) {
            tabela = new LinkedList[tamanho];
            for (int i = 0; i < tamanho; i++) {
                tabela[i] = new LinkedList<>();
            }
        }

        // Função hash: h(k) = k mod tamanho da tabela
        public int funcaoHash(int valor) {
            return valor % tabela.length;
        }

        public void inserir(char chave) {
            int valor = chave - 'A';
            int indice = funcaoHash(valor);
            System.out.println("Inserindo chave " + chave + " com valor " + valor + " no índice " + indice);
            tabela[indice].add(new Entrada(chave, valor));
            exibirTabela();
        }

        public void exibirTabela() {
            for (int i = 0; i < tabela.length; i++) {
                System.out.print("Índice " + i + ": ");
                for (Entrada entrada : tabela[i]) {
                    System.out.print(entrada + " -> ");
                }
                System.out.println("null");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        char[] chaves = {'P', 'E', 'S', 'Q', 'U', 'I', 'S', 'A'};

        TabelaHash tabelaHash = new TabelaHash(7);

        for (char chave : chaves) {
            tabelaHash.inserir(chave);
        }
    }
}
