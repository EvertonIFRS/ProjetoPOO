/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eficiencia;

import java.io.File;
import static java.lang.reflect.Array.get;
import java.net.URL;
import static java.nio.file.Paths.get;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author prach
 */
public class FXMLPrincipalController implements Initializable {

    @FXML
    private Button Import;

    File selectedFile;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void FuncaoImport(ActionEvent e) {
        /*try {
           Parent root;
           root = FXMLLoader.load(getClass().getResource("FXMLImport.fxml"));
           
           Scene scene = new Scene(root);
           Stage stage = new Stage();
           
           stage.setOnCloseRequest(ee -> {
               stage.hide();
           });
              stage.setScene(scene);
              stage.show();
        
        
        }catch (IOException ex) {
            ex.printStackTrace();
        } 
         */
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        Stage stage = (Stage) ((Node) Import).getScene().getWindow();
        selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            Alert dialogo = new Alert(Alert.AlertType.INFORMATION, "Janela 2 Selecionada!");
            dialogo.setContentText(selectedFile.getName());
            dialogo.showAndWait();
        }
    }

    @FXML
    private void FuncaoVisualizar(ActionEvent e) {
        if (selectedFile != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLVisualizar.fxml"));
                Parent root = loader.load();
                FXMLVisualizarController controladorVisualizar = loader.getController();
                /*
                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setOnCloseRequest(ee -> {
                    stage.hide();
                });
                stage.setScene(scene);
                stage.show();
                */
                controladorVisualizar.setArquivo(selectedFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            Alert dialogo = new Alert(Alert.AlertType.WARNING);
            dialogo.setContentText("Arquivo de dados energéticos não selecionado!");
            dialogo.showAndWait();
        }
    }

    @FXML
    private void FuncaoHistorico(ActionEvent e) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("FXMLHistorico.fxml"));

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

    @FXML
    private void FuncaoGraf(ActionEvent e) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("FXMLGraf.fxml"));

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

    @FXML
    private void FuncaoImprimir(ActionEvent e) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("FXMLImprimir.fxml"));

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

    @FXML
    private void FuncaoDate(ActionEvent e) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("FXMLDate.fxml"));

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