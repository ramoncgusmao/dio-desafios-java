package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Teste5  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linhas;
        while((linhas = br.readLine()) != null) {
            if(linhas.length() >0) {
                if (buscarPattern("[\\W]", linhas)
                        || !buscarPattern("([A-Z])", linhas)
                        || !buscarPattern("([a-z])", linhas)
                        || !buscarPattern("([0-9])", linhas)
                        || linhas.length() <= 5
                        || linhas.length() >= 33
                ) {
                    System.out.println("Senha invalida.");
                } else {
                    System.out.println("Senha valida.");
                }
            }
    }
    }

    public static boolean buscarPattern(String regex, String senha){
        Pattern p = Pattern.compile(regex);
        return p.matcher(senha).find();
    }
}