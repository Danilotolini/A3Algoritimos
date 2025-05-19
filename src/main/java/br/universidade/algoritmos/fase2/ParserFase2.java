package br.universidade.algoritmos.fase2;

import br.universidade.algoritmos.fase1.PessoasConhecemPessoas;
import br.universidade.algoritmos.fase2.GerenciadorDeFilas;

import java.io.*;
import java.util.*;

public class ParserFase2 {

    private GerenciadorDeFilas gerenciador;
    private PessoasConhecemPessoas estruturaGrupos;

    public ParserFase2(PessoasConhecemPessoas estruturaGrupos) {
        this.gerenciador = new GerenciadorDeFilas();
        this.estruturaGrupos = estruturaGrupos;
    }

    public void executar(String entrada, String saida) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(entrada));
        BufferedWriter writer = new BufferedWriter(new FileWriter(saida));
        String linha;

        while ((linha = reader.readLine()) != null) {
            linha = linha.trim();
            if (linha.isEmpty()) continue;

            if (linha.startsWith("criaFila:")) {
                String[] partes = linha.substring(9).trim().split("\\s+");
                for (String id : partes) {
                    gerenciador.criarFila(id);
                }

            } else if (linha.startsWith("atendeFila:")) {
                String[] partes = linha.substring(11).trim().split("\\s+");
                for (String id : partes) {
                    gerenciador.atenderFila(id);
                }

            } else if (linha.startsWith("chegou:")) {
                String[] nomes = linha.substring(7).trim().split("\\s+");
                for (String nome : nomes) {
                    gerenciador.chegouPessoa(nome, estruturaGrupos);
                }

            } else if (linha.startsWith("desiste:")) {
                String[] nomes = linha.substring(8).trim().split("\\s+");
                for (String nome : nomes) {
                    gerenciador.desistePessoa(nome);
                }

            } else if (linha.equals("imprime:")) {
                List<String> filas = gerenciador.imprimirFilas();
                for (String f : filas) {
                    writer.write(f);
                    writer.newLine();
                }
            }
        }

        reader.close();
        writer.close();
    }
}
