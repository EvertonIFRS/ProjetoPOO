/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eficiencia;

import java.util.Objects;

/**
 *
 * @author 05180176
 */

// Criando a Class Usuário:
public class Usuario {
    // Definindo as Variáveis Usadas:
    private String Login, Senha;

    // Construtor Vazio:
    public Usuario() {
    }

    // Construtor com as Variáveis:
    public Usuario(String Login, String Senha) {
        this.Login = Login;
        this.Senha = Senha;
    }

    // Criando os Gets e Sets para trabalharmos com as Variáveis de Interesse:
    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "Login=" + Login + ", Senha=" + Senha + '}';
    }
    
    // Criando o método para criptografar as Senhas:
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.Login);
        hash = 53 * hash + Objects.hashCode(this.Senha);
        return hash;
    }

    /* 
       Criando o método que compara para saber se o usuário é ele mesmo e se a 
       senha está correta:
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.Login, other.Login)) {
            return false;
        }
        return true;
    }
    
    
}
