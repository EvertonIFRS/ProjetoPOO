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

    public static ArrayList<Informacoes> ler_Data(File arquivo) throws FileNotFoundException, IOException {
        ArrayList<Informacoes> linhas = new ArrayList();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            do {
                linha = br.readLine();
                if (linha != null) {
                    String v[] = linha.split("\t");
                    linhas.add(new Informacoes(v));
                }
            } while (linha != null);
        }
        return linhas;
    }

    public static ArrayList<String> ler_Usuario(File arquivo) throws FileNotFoundException, IOException {
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

    public static void gravar(File arquivo, Informacoes info) throws FileNotFoundException, IOException {

        try (FileWriter fw = new FileWriter(arquivo, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.println(info.getData() + "\t" + info.getHorario() + "\t"
                    + info.getPT() + "\t" + info.getST() + "\t"
                    + info.getQT() + "\t" + info.getFPT() + "\t"
                    + info.getEA() + "\t" + info.getER() + "\t"
                    + info.getEAT() + "\t" + info.getD() + "\n");

        }
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
        ArrayList<String> linhas = ler_Usuario(arquivo);

        for (String linha : linhas) {
            if (!linha.isEmpty()) {
                usuarios.add(new Usuario(linha.split("\t")[0], linha.split("\t")[1]));
            }
        }
        return usuarios;
    }

    public static String MD5(String NewPassword) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(NewPassword.getBytes());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}
