package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class teste2 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
           String linhas = st.nextToken();

           Integer quantidade = Integer.parseInt(linhas);

           if(quantidade == null || quantidade == 0) {
               break;
           }
           int contador = 0;
            ArrayList<String> lista = new ArrayList<>();
            while (quantidade > contador){
                st = new StringTokenizer(br.readLine());

                lista.add(st.nextToken());
                contador++;
            }
            boolean flag = false;
            for (String variavel: lista) {
                flag = lista.stream().filter(x -> x.indexOf(variavel) == 0).collect(Collectors.toList()).size() > 1;
                if (flag)
                    break;
            }
            System.out.println(flag ? "Conjunto Ruim" : "Conjunto Bom");

        }

    }
}
