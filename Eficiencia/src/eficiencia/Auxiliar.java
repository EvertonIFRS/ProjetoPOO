/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eficiencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author 05180176
 */
public class Auxiliar {

    public static ArrayList<String> ler(File arquivo) throws FileNotFoundException, IOException {
        ArrayList<String> linhas = new ArrayList();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            do {
                linha = br.readLine();
                if (linha != null) {
                    linhas.add(linha);
                }
            } while (linha != null);
        }
        return linhas;
    }

    public static void gravar_usuario(File arquivo, Usuario user) throws IOException {
        try (FileWriter fw = new FileWriter(arquivo, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.println(user.getLogin() + "\t" + user.getSenha());
        }
    }

    public static ArrayList<Usuario> ler_usuarios(File arquivo) throws FileNotFoundException, IOException {
        ArrayList<Usuario> usuarios = new ArrayList();
        ArrayList<String> linhas = ler(arquivo);

        for (String linha : linhas) {
            usuarios.add(new Usuario(linha.split("\t")[0], linha.split("\t")[1]));
        }
        return usuarios;
    }

}
