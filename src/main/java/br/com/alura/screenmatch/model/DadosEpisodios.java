package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodios(
        @JsonAlias("Title") String titulo,
        @JsonAlias("Episode") Integer numEpisodio,
        @JsonAlias("imdbRating") String avaliacoes,
        @JsonAlias("Released") String dataLancamento
) {
}
