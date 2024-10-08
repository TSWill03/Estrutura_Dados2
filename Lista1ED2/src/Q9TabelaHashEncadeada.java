import java.util.LinkedList;

public class Q9TabelaHashEncadeada {

    static class Entrada {
        int matricula;

        Entrada(int matricula) {
            this.matricula = matricula;
        }

        @Override
        public String toString() {
            return String.valueOf(matricula);
        }
    }


    static class TabelaHash {
        LinkedList<Entrada>[] tabela;
        int tamanho;

        @SuppressWarnings("unchecked")
        public TabelaHash(int tamanho) {
            this.tamanho = tamanho;
            tabela = new LinkedList[tamanho];
            for (int i = 0; i < tamanho; i++) {
                tabela[i] = new LinkedList<>();
            }
        }

        public int funcaoHash(int matricula) {
            return matricula % tamanho;
        }

        public void inserir(int matricula) {
            int indice = funcaoHash(matricula);
            System.out.println("Inserindo matrícula " + matricula + " no índice " + indice);
            tabela[indice].add(new Entrada(matricula));
            exibirTabela();
        }

        public void remover(int matricula) {
            int indice = funcaoHash(matricula);
            System.out.println("Removendo matrícula " + matricula + " do índice " + indice);

            LinkedList<Entrada> lista = tabela[indice];
            Entrada paraRemover = null;

            for (Entrada e : lista) {
                if (e.matricula == matricula) {
                    paraRemover = e;
                    break;
                }
            }

            if (paraRemover != null) {
                lista.remove(paraRemover);
                System.out.println("Matrícula " + matricula + " removida.");
            } else {
                System.out.println("Matrícula " + matricula + " não encontrada.");
            }

            exibirTabela();
        }

        public void buscar(int matricula) {
            int indice = funcaoHash(matricula);
            System.out.println("Buscando matrícula " + matricula + " no índice " + indice);

            for (Entrada e : tabela[indice]) {
                if (e.matricula == matricula) {
                    System.out.println("Matrícula " + matricula + " encontrada no índice " + indice);
                    return;
                }
            }

            System.out.println("Matrícula " + matricula + " não encontrada.");
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
