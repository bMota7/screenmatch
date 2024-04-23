package br.com.alura.screenmatch.service;

public interface IConverteDados {
   <T> T obterDados(String json, Class<T> classe); //<T> algum tipo de dados generico
}
