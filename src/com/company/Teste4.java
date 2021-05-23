package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Teste4 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linhas;
        while((linhas = br.readLine()) != null) {

           if(linhas.length() >0){
               Set<String> resultados = new TreeSet();

            int minLength = linhas.length()/2;
            int quantidade;
                for (int i = 1; i <= minLength; i++) {

                    if (linhas.substring(0, linhas.length()  -i).endsWith(linhas.substring(linhas.length()  -i))) {
                        quantidade = i;
                        resultados.add(linhas.substring(0, linhas.length()  - quantidade));
                    }
                }

                if(resultados.size() ==0){
                    resultados.add(linhas);
                }
                resultados.forEach(System.out::println);
            }

        }
    }

}