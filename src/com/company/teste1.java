package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;
import java.util.stream.Collectors;

public class teste1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<String> lista = new ArrayList<>();
        while(st.hasMoreTokens()) {
            while (st.hasMoreTokens()) {
                lista.add(st.nextToken());
            }

            if(lista.get(0).equals(".")){
                break;
            }

            String frase = lista.stream().collect(Collectors.joining(" ")) + " ";

            Map<String, List<String>> mapa = lista.stream().map(token -> token.replaceAll(" ", ""))
                    .filter(word -> word.length() > 2)
                    .collect(Collectors.groupingBy(String::valueOf, LinkedHashMap::new, Collectors.toList()));

            Map<Character, String> letra = new TreeMap<>();
            for (Map.Entry<String, List<String>> pair : mapa.entrySet()) {
                if(letra.containsKey(pair.getKey().charAt(0))){

                    List<String> listaAtual = mapa.get(letra.get(pair.getKey().charAt(0))).stream().collect(Collectors.toList());
                    List<String> listaNova = pair.getValue().stream().collect(Collectors.toList());
                    int quantidadeAtual = listaAtual.stream().collect(Collectors.joining(" ")).length();
                    int quantidadeNova = listaNova.stream().collect(Collectors.joining(" ")).length();
                    int quantidadeAtualReduzida = (listaAtual.size()*2)+(listaAtual.size() - 1);
                    int quantidadeNovaReduzida = (listaNova.size()*2)+(listaNova.size() - 1);

                    if(((quantidadeNova - quantidadeNovaReduzida) == (quantidadeAtual - quantidadeAtualReduzida))
                            && letra.get(pair.getKey().charAt(0)).length() < pair.getKey().length()){
                        letra.put(pair.getKey().charAt(0), pair.getKey());
                    } else if((quantidadeNova - quantidadeNovaReduzida) > (quantidadeAtual - quantidadeAtualReduzida)){
                        letra.put(pair.getKey().charAt(0), pair.getKey());
                    }

                }else{
                    letra.put(pair.getKey().charAt(0), pair.getKey());
                }

            }

            for (Map.Entry<Character, String> pair : letra.entrySet())
                frase = frase.replaceAll("(" + pair.getValue() + "\\W)", pair.getKey() + ". ");

            if(frase.charAt(frase.length() - 1) == ' '){
                frase = frase.substring(0, frase.length() -1);
            }

            System.out.println(frase);
            System.out.println(letra.size());
            letra.forEach(((key, value) -> System.out.println(key +". = "+ value)));
            lista.clear();
            letra.clear();;
            mapa.clear();
            st = new StringTokenizer(br.readLine());
        }


    }
}
