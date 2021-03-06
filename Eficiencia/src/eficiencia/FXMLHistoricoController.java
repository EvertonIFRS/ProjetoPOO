/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eficiencia;

import static eficiencia.Auxiliar.ler_Data;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 05180176
 */
public class FXMLHistoricoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Stage Principal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    // Declaração dos Elementos Utilizados:
    @FXML
    private TextField PT_Min, PT_Max, ST_Min, ST_Max;

    @FXML
    private TextField QT_Min, QT_Max, EA_Min, EA_Max;

    @FXML
    private TextField ER_Min, ER_Max, FPT_Min, FPT_Max;

    @FXML
    private DatePicker datepicker;

    // Criando a Função para Setar o Arquivo Escolhido pelo Usuário:
    void setArquivo(File selectedFile) {
        try {
            ArrayList<Informacoes> informacoes = ler_Data(selectedFile);

            // Criando as Variáveis usadas no método:
            float MAXPT = 0, MAXST = 0, MAXQT = 0, MAXEA = 0, MAXER = 0, MAXFP = 0;
            float MINPT = 1000, MINST = 1000, MINQT = 1000, MINEA = 1000, MINER = 1000, MINFP = 1000;

            // for(para) para percorrer todos os elementos de cada coluna do Arquivo, 
            // e fornecer o Máximo e o Mínimo de cada Variável:
            for (Informacoes inf : informacoes) {
                if (Float.parseFloat(inf.getPT().getValue().replaceAll(",", ".")) > MAXPT) {
                    MAXPT = Float.parseFloat(inf.getPT().getValue().replaceAll(",", "."));
                } else if (Float.parseFloat(inf.getPT().getValue().replaceAll(",", ".")) < MINPT) {
                    MINPT = Float.parseFloat(inf.getPT().getValue().replaceAll(",", "."));
                }
                if (Float.parseFloat(inf.getST().getValue().replaceAll(",", ".")) > MAXST) {
                    MAXST = Float.parseFloat(inf.getST().getValue().replaceAll(",", "."));
                } else if (Float.parseFloat(inf.getST().getValue().replaceAll(",", ".")) < MINST) {
                    MINST = Float.parseFloat(inf.getST().getValue().replaceAll(",", "."));
                }
                if (Float.parseFloat(inf.getQT().getValue().replaceAll(",", ".")) > MAXQT) {
                    MAXQT = Float.parseFloat(inf.getQT().getValue().replaceAll(",", "."));
                } else if (Float.parseFloat(inf.getQT().getValue().replaceAll(",", ".")) < MINQT) {
                    MINQT = Float.parseFloat(inf.getQT().getValue().replaceAll(",", "."));
                }
                if (Float.parseFloat(inf.getEA().getValue().replaceAll(",", ".")) > MAXEA) {
                    MAXEA = Float.parseFloat(inf.getEA().getValue().replaceAll(",", "."));
                } else if (Float.parseFloat(inf.getEA().getValue().replaceAll(",", ".")) < MINEA) {
                    MINEA = Float.parseFloat(inf.getEA().getValue().replaceAll(",", "."));
                }
                if (Float.parseFloat(inf.getER().getValue().replaceAll(",", ".")) > MAXER) {
                    MAXER = Float.parseFloat(inf.getER().getValue().replaceAll(",", "."));
                } else if (Float.parseFloat(inf.getER().getValue().replaceAll(",", ".")) < MINER) {
                    MINER = Float.parseFloat(inf.getER().getValue().replaceAll(",", "."));
                }
                if (Float.parseFloat(inf.getFPT().getValue().replaceAll(",", ".")) > MAXFP) {
                    MAXFP = Float.parseFloat(inf.getFPT().getValue().replaceAll(",", "."));
                } else if (Float.parseFloat(inf.getFPT().getValue().replaceAll(",", ".")) < MINFP) {
                    MINFP = Float.parseFloat(inf.getFPT().getValue().replaceAll(",", "."));
                }
            }

            // Apresentando os Valores de Minímo e Máximo encontrados no Arquivo:
            PT_Max.setText(String.valueOf(MAXPT));
            PT_Min.setText(String.valueOf(MINPT));
            ST_Max.setText(String.valueOf(MAXST));
            ST_Min.setText(String.valueOf(MINST));
            QT_Max.setText(String.valueOf(MAXQT));
            QT_Min.setText(String.valueOf(MINQT));
            EA_Max.setText(String.valueOf(MAXEA));
            EA_Min.setText(String.valueOf(MINEA));
            ER_Max.setText(String.valueOf(MAXER));
            ER_Min.setText(String.valueOf(MINER));
            FPT_Max.setText(String.valueOf(MAXFP));
            FPT_Min.setText(String.valueOf(MINFP));

            // Teste para informar o Usuário se o minímo valor de Fator de Potência, 
            // está inferior ao menor permitido pela conssecionária:
            if (MINFP < 0.8) {
                Alert dialogo = new Alert(Alert.AlertType.WARNING);
                dialogo.setContentText("O menor Valor do Fator de Potência Encontrado\n"
                        + "Está Inferior ao Valor Minímo permitido pela Norma!");
                dialogo.showAndWait();
            }

        } catch (IOException ex) {
            System.out.println("ERRO: " + ex);
        }
    }
    
    // Criando o método de VOltar com o Principal Estático:
    @FXML
    private void FuncaoVoltar(ActionEvent e) {
        Principal.show();
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.close();
    }

    // Class para manter o Stage Principal Estático:
    void setPrincipal(Stage stage1) {
        this.Principal = stage1;
    }
}
