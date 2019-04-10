/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eficiencia;

import static eficiencia.Auxiliar.ler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 05180176
 */
public class FXMLVisualizarController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    void setArquivo(File selectedFile) {
        if (selectedFile.exists()) {
            try {
                ArrayList<String> linhas = ler(selectedFile);
                /*
                try {
                    Parent root;
                    root = FXMLLoader.load(getClass().getResource("FXMLHistorico.fxml"));

                    Scene scene = new Scene(root);
                    Stage stage = new Stage();

                    stage.setOnCloseRequest(ee -> {
                    stage.hide();
                    
                     for (String linha : linhas) {
                          System.out.println(linha);
                     }
                });
                  stage.setScene(scene);
                  stage.show();
                } catch (IOException ex) {
                        ex.printStackTrace();
                }
                */
                for (String linha : linhas) {
                          System.out.println(linha);
                }
               
            } catch (IOException ex) {
                Alert dialogo = new Alert(Alert.AlertType.ERROR);
                dialogo.setContentText("Não foi possível ler o Arquivo de dados energéticos!");
                dialogo.showAndWait();
            }
        } else {
            Alert dialogo = new Alert(Alert.AlertType.ERROR);
            dialogo.setContentText("Arquivo de dados energéticos não encontrado!");
            dialogo.showAndWait();
        }
    }
    
    @FXML
    private void FuncaoVoltar(ActionEvent e) {
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.hide();
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

}
