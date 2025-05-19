package br.universidade.algoritmos;

import br.universidade.algoritmos.fase1.PessoasConhecemPessoas;
import br.universidade.algoritmos.fase2.ParserFase2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MainFase2 {
    public static void main(String[] args) {
        try {
            // Entrada e saída
            String caminhoEntrada = "src/main/resources/fase2_entrada.txt";
            String caminhoSaida = "src/main/resources/fase2_saida.txt";

            // Grupos fictícios para testar
            PessoasConhecemPessoas estrutura = new PessoasConhecemPessoas();
            estrutura.criarGrupo(List.of("Ana", "Bia", "Guga", "Pedro"));
            estrutura.criarGrupo(List.of("Joao", "Olga"));
            estrutura.criarGrupo(List.of("Maria", "Manuel", "Alface"));

            // Executa o parser
            ParserFase2 parser = new ParserFase2(estrutura);
            parser.executar(caminhoEntrada, caminhoSaida);

            System.out.println("Fase 2 executada com sucesso!");
            System.out.println("Saída gerada em: " + caminhoSaida);

            // Mostrar resultado no console também
            System.out.println("\nConteúdo da saída:");
            Files.readAllLines(Paths.get(caminhoSaida)).forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
