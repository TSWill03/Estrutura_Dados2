import java.util.Arrays;

public class Q10TabelaHashComResize {

    static class TabelaHash {
        int[] tabela;
        int tamanho;
        int numElementos;
        final double fatorCarga = 0.75;

        public TabelaHash(int tamanho) {
            this.tamanho = tamanho;
            tabela = new int[tamanho];
            Arrays.fill(tabela, -1);
            numElementos = 0;
        }

        public int funcaoHash(int chave) {
            return chave % tamanho;
        }

        private void verificarResize() {
            if ((double) numElementos / tamanho >= fatorCarga) {
                resize();
            }
        }

        private void resize() {
            System.out.println("Redimensionando a tabela...");
            int novoTamanho = tamanho * 2;
            int[] novaTabela = new int[novoTamanho];
            Arrays.fill(novaTabela, -1);

            for (int i = 0; i < tamanho; i++) {
                if (tabela[i] != -1) {
                    int novaPosicao = tabela[i] % novoTamanho;
                    while (novaTabela[novaPosicao] != -1) {
                        novaPosicao = (novaPosicao + 1) % novoTamanho;
                    }
                    novaTabela[novaPosicao] = tabela[i];
                }
            }

            tabela = novaTabela;
            tamanho = novoTamanho;
            exibirTabela();
        }

        public void inserir(int chave) {
            verificarResize();

            int indice = funcaoHash(chave);
            while (tabela[indice] != -1) {
                indice = (indice + 1) % tamanho;
            }
            tabela[indice] = chave;
            numElementos++;
            System.out.println("Inserido: " + chave);
            exibirTabela();
        }

        public void remover(int chave) {
            int indice = funcaoHash(chave);
            while (tabela[indice] != -1 && tabela[indice] != chave) {
                indice = (indice + 1) % tamanho;
            }
            if (tabela[indice] == chave) {
                tabela[indice] = -1;
                numElementos--;
                System.out.println("Removido: " + chave);
            } else {
                System.out.println("Chave " + chave + " não encontrada.");
            }
            exibirTabela();
        }

        public void buscar(int chave) {
            int indice = funcaoHash(chave);
            while (tabela[indice] != -1 && tabela[indice] != chave) {
                indice = (indice + 1) % tamanho;
            }
            if (tabela[indice] == chave) {
                System.out.println("Chave " + chave + " encontrada no índice " + indice);
            } else {
                System.out.println("Chave " + chave + " não encontrada.");
            }
        }

        public void exibirTabela() {
            System.out.println("Tabela Hash:");
            for (int i = 0; i < tamanho; i++) {
                if (tabela[i] != -1) {
                    System.out.println("Índice " + i + ": " + tabela[i]);
                } else {
                    System.out.println("Índice " + i + ": vazio");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash(8);

        // a) Inserção dos elementos e exibição da tabela após cada inserção
        int[] matriculas = {52, 45, 64, 34, 69, 11, 10, 3, 6, 2};
        for (int matricula : matriculas) {
            tabelaHash.inserir(matricula);
        }

        // b) Busca do elemento com matrícula 45
        tabelaHash.buscar(45);

        // c) Busca do elemento com matrícula 75
        tabelaHash.buscar(75);

        // d) Remoção do aluno com matrícula 11 e exibição da tabela atualizada
        tabelaHash.remover(11);
    }
}
