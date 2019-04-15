/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eficiencia;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
                Parent root;
                root = FXMLLoader.load(getClass().getResource("FXMLVisualizar.fxml"));
                
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
        } else {
            Alert dialogo = new Alert(Alert.AlertType.ERROR);
            dialogo.setContentText("Arquivo de dados energéticos não encontrado!");
            dialogo.showAndWait();
        }
    }
}
