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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private Stage Principal;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Image Imagem = new Image(FXMLImprimirController.class.getResourceAsStream("RGE.jpg"));
        
        Imagem_Boleto.setImage(Imagem);
        
        /* chamar e receber os 3 dados a serem exibidos na aba de imprimir!!!!
        
        float MediaFP = MediaData( ); // Media do Fator de Potência
        float SomaDem = SomaData( ); // Somatório de todas as Demandas
        float SomaPot = SomaData( ); // Somatório de todas as Potências       
          */      
    }

    @FXML
    private ImageView Imagem_Boleto;
    
    @FXML
    private TextField Text01, Text02, Text03;

    @FXML
    private void FuncaoVoltar(ActionEvent e) {
        Principal.show();
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.close();
    }

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

    void setArquivo(File selectedFile) {
        try {
            ArrayList<Informacoes> informacoes = ler_Data(selectedFile);
          /*  Desenvolver for para percorrer todo o arquivo DATA
           for 
            informacoes.get(0).
            SomaData += informacoes.get(
            // Calculos de Demanda total...
            */
            
        } catch (IOException ex) {
            
        }
    }

    void setPrincipal(Stage stage1) {
        this.Principal = stage1;
    }
}
