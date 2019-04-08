/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eficiencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

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
                try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                    String linha;

                    do {
                        linha = br.readLine();
                        if (linha != null) {
                            System.out.println(linha);
                        }
                    } while (linha != null);
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

}
