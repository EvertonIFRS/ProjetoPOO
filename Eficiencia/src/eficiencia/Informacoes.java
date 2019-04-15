/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eficiencia;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Frederico
 */
public class Informacoes {

    private final StringProperty Data, Horario, PT, ST, QT, FPT, EA, ER, EAT, D; 

    public Informacoes(String[] v) {
        this.Data = new SimpleStringProperty(v[0]);
        this.Horario = new SimpleStringProperty(v[1]);
        this.PT = new SimpleStringProperty(v[2]);
        this.ST = new SimpleStringProperty(v[3]);
        this.QT = new SimpleStringProperty(v[4]);
        this.FPT = new SimpleStringProperty(v[5]);
        this.EA = new SimpleStringProperty(v[6]);
        this.ER = new SimpleStringProperty(v[7]);
        this.EAT = new SimpleStringProperty(v[8]);
        this.D = new SimpleStringProperty(v[9]);
    }

    public Informacoes(String Data, String Horario, String PT, String ST, String QT, String FPT, String EA, String ER, String EAT, String D) {
        this.Data = new SimpleStringProperty(Data);
        this.Horario = new SimpleStringProperty(Horario);
        this.PT = new SimpleStringProperty(PT);
        this.ST = new SimpleStringProperty(ST);
        this.QT = new SimpleStringProperty(QT);
        this.FPT = new SimpleStringProperty(FPT);
        this.EA = new SimpleStringProperty(EA);
        this.ER = new SimpleStringProperty(ER);
        this.EAT = new SimpleStringProperty(EAT);
        this.D = new SimpleStringProperty(D);
    }

    public StringProperty getData() {
        return Data;
    }

    public StringProperty getHorario() {
        return Horario;
    }

    public StringProperty getPT() {
        return PT;
    }

    public StringProperty getST() {
        return ST;
    }

    public StringProperty getQT() {
        return QT;
    }

    public StringProperty getFPT() {
        return FPT;
    }

    public StringProperty getEA() {
        return EA;
    }

    public StringProperty getER() {
        return ER;
    }

    public StringProperty getEAT() {
        return EAT;
    }

    public StringProperty getD() {
        return D;
    }


}
