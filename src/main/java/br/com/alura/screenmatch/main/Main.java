package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.model.DadosSeries;
import br.com.alura.screenmatch.model.DadosTemporadas;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);

    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https:www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=e945ca03";

    public void exibeMenu(){
        System.out.println("Digite o nome da serie para busca: ");
        var titulo = sc.nextLine();

        var json = consumoAPI.obterDados(ENDERECO + titulo.replace("", "+") + API_KEY);
        DadosSeries dados = conversor.obterDados(json, DadosSeries.class);
        System.out.println(dados);

        List<DadosTemporadas> temporadas = new ArrayList<>();
        for (int i = 1; i <= dados.totalTemporada(); i++) {
            json = consumoAPI.obterDados(ENDERECO + titulo.replace("", "+") + "&season=" + i + API_KEY);
            DadosTemporadas dadosTemporadas = conversor.obterDados(json, DadosTemporadas.class);
            temporadas.add(dadosTemporadas);
        }
        temporadas.forEach(System.out::println);
    }
}
