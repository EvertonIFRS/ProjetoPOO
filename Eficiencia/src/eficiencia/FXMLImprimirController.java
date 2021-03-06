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
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 05180176
 */
public class FXMLImprimirController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    // Declarando todas as Variáveis e Itens usados no fxml:
    private Stage Principal;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Setando a Imagem usada no fxml do Imprimir:
        Image Imagem = new Image(FXMLImprimirController.class.getResourceAsStream("RGE.jpg"));
        
        Imagem_Boleto.setImage(Imagem);  
    }

    @FXML
    private ImageView Imagem_Boleto;
    
    @FXML
    private TextField Text01, Text02, Text03;

    // Declarando a Função para gerar o arquivo para ser impresso:
    @FXML
    private void FuncaoPrint(ActionEvent e) {
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.close();
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setOnCloseRequest(ee -> {
                stage.hide();
            });
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Setando as Informações importantes a partir do selectedFile escolhido pelo User:
    void setArquivo(File selectedFile) {
        try {
            ArrayList<Informacoes> informacoes = ler_Data(selectedFile);
            
            int i = 0;
            float X = 0, SomaP = 0, SomaD = 0, MedFP = 0;
            
            // Calculando os Somátorios e a média das informações escolhidas para o Trabalho:
            for (Informacoes inf : informacoes) {
                i += 1;
                SomaP += Float.parseFloat(inf.getPT().getValue().replaceAll(",", "."));
                SomaD += Float.parseFloat(inf.getD().getValue().replaceAll(",", "."));
                X += Float.parseFloat(inf.getFPT().getValue().replaceAll(",", "."));
            }   
            // Fazendo a Média e apresentando os valores encontrados:
            MedFP = X/i;
            Text01.setText(String.valueOf(SomaP));
            Text02.setText(String.valueOf(MedFP));
            Text03.setText(String.valueOf(SomaD));
        } catch (IOException ex) {
            
        }
    }
    
    // Declarando a Função Voltar com Stage do Principal Estático:
    @FXML
    private void FuncaoVoltar(ActionEvent e) {
        Principal.show();
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.close();
    }

    // Classe do Stage do Principal Estático:
    void setPrincipal(Stage stage1) {
        this.Principal = stage1;
    }
}
