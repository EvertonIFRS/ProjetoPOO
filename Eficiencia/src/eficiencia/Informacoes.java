/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eficiencia;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Frederico
 */

// Criando a Class de Informações para leitura da nossa Matriz de Dados:
public class Informacoes {

    // Criando as Variáveis:
    private final StringProperty Data, Horario;
    private final DoubleProperty PT, ST, QT, FPT, EA, ER, EAT, D;

    // Criando o vetor de Propriedades:
    public Informacoes(String[] v) {
        this.Data = new SimpleStringProperty(v[0]);
        this.Horario = new SimpleStringProperty(v[1]);
        this.PT = new SimpleDoubleProperty(Double.parseDouble(v[2]));
        this.ST = new SimpleDoubleProperty(Double.parseDouble(v[3]));
        this.QT = new SimpleDoubleProperty(Double.parseDouble(v[4]));
        this.FPT = new SimpleDoubleProperty(Double.parseDouble(v[5]));
        this.EA = new SimpleDoubleProperty(Double.parseDouble(v[6]));
        this.ER = new SimpleDoubleProperty(Double.parseDouble(v[7]));
        this.EAT = new SimpleDoubleProperty(Double.parseDouble(v[8]));
        this.D = new SimpleDoubleProperty(Double.parseDouble(v[9]));
    }
    
    // Dando o retorno nas informações da Matriz com as suas propriedades necessárias:
    public StringProperty getData() {
        return Data;
    }

    public StringProperty getHorario() {
        return Horario;
    }

    public StringProperty getPT() {
        return new SimpleStringProperty(String.format("%.2f", PT.get()));
    }

    public DoubleProperty getPTProperty() {
        return PT;
    }

    public StringProperty getST() {
        return new SimpleStringProperty(String.format("%.2f", ST.get()));
    }

    public DoubleProperty getSTProperty() {
        return ST;
    }

    public StringProperty getQT() {
        return new SimpleStringProperty(String.format("%.2f", QT.get()));
    }

    public DoubleProperty getQTProperty() {
        return QT;
    }

    public StringProperty getFPT() {
        return new SimpleStringProperty(String.format("%.2f", FPT.get()));
    }

    public DoubleProperty getFPTProperty() {
        return FPT;
    }

    public StringProperty getEA() {
        return new SimpleStringProperty(String.format("%.2f", EA.get()));
    }

    public DoubleProperty getEAProperty() {
        return EA;
    }

    public StringProperty getER() {
        return new SimpleStringProperty(String.format("%.2f", ER.get()));
    }

    public DoubleProperty getERProperty() {
        return ER;
    }

    public StringProperty getEAT() {
        return new SimpleStringProperty(String.format("%.2f", EAT.get()));
    }

    public DoubleProperty getEATProperty() {
        return EAT;
    }

    public StringProperty getD() {
        return new SimpleStringProperty(String.format("%.2f", D.get()));
    }

    public DoubleProperty getDProperty() {
        return D;
    }
}
