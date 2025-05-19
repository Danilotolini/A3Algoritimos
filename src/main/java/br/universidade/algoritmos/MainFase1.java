package br.universidade.algoritmos;

import br.universidade.algoritmos.parser.ParserFase1;

public class MainFase1 {

    public static void main(String[] args) {
        ParserFase1 parser = new ParserFase1();
        try {
            // Ajuste o caminho conforme onde você colocou os arquivos
            parser.executar("src/main/resources/fase1_entrada.txt", "src/main/resources/fase1_saida_gerado.txt");
            System.out.println("Processamento concluído. Verifique o arquivo de saída.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
