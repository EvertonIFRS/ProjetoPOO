/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eficiencia;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import java.io.IOException;
import java.time.LocalDate;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author prach
 */
public class FXMLPrincipalController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Image image1 = new Image(FXMLPrincipalController.class.getResourceAsStream("ImageMain.jpg"));

        ImageMain.setImage(image1);

    }

    @FXML
    private ImageView ImageMain;

    @FXML
    private Button Import;

    File selectedFile;

    @FXML
    private DatePicker datepicker;

    @FXML
    private void FuncaoImport(ActionEvent e) {
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
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.hide();
        if (selectedFile != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLVisualizar.fxml"));
                Parent root = loader.load();

                FXMLVisualizarController controladorVisualizar = loader.getController();
                controladorVisualizar.setArquivo(selectedFile);

                Scene sc = new Scene(root);
                Stage s = new Stage();

                s.setScene(sc);
                s.show();
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
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.hide();
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
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.hide();
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("FXMLGrafico.fxml"));

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
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.hide();
        if (selectedFile != null) {
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
        } else {
            Alert dialogo = new Alert(Alert.AlertType.WARNING);
            dialogo.setContentText("Arquivo de dados energéticos não selecionado!");
            dialogo.showAndWait();
        }
    }

    @FXML
    private void FuncaoDate(ActionEvent e
    ) {
        LocalDate date = datepicker.getValue();
    }

    @FXML
    private void FuncaoVoltar(ActionEvent e
    ) {
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.hide();
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("FXML_Login.fxml"));

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
