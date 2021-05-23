package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Teste3 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        String linha1, linha2, min, max; //declare suas variaveis aqui
        while (( linha1 = in.readLine()) != null) { // complete seu código
               linha2 = in.readLine();
            if ( linha1.equals("0")) {
                return;
            } else {
                if(linha1.length() > linha2.length()){
                    min = linha2;
                    max = linha1;
                }else{
                    min = linha1;
                    max = linha2;
                }
            }
            int minLength = min.length();
            int maxS = minLength;
            boolean f = true;
            while (maxS > 0 && f) { //altere as variaveis, se achar necessario
                int diff = minLength - maxS;
                for (int i = 0; i <= diff; i++) { //complete o laco de repeticao
                    if (max.contains(min.substring(i, i + maxS))) {
                        f = false;
                        maxS++;
                        break;
                    }
                }
                maxS--;
            }
            System.out.println(maxS);
        }
        out.close();
    }

}