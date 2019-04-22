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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    @FXML
    private TableView<Informacoes> InfoTable;
    @FXML
    private TableColumn<Informacoes, String> Data;
    @FXML
    private TableColumn<Informacoes, String> Horario;
    @FXML
    private TableColumn<Informacoes, String> PT;
    @FXML
    private TableColumn<Informacoes, String> ST;
    @FXML
    private TableColumn<Informacoes, String> QT;
    @FXML
    private TableColumn<Informacoes, String> FPT;
    @FXML
    private TableColumn<Informacoes, String> EA;
    @FXML
    private TableColumn<Informacoes, String> ER;
    @FXML
    private TableColumn<Informacoes, String> EAT;
    @FXML
    private TableColumn<Informacoes, String> D;

    private final ObservableList<Informacoes> InfoData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (InfoTable != null) {
            InfoTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            //firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
            Data.setCellValueFactory(cellData -> cellData.getValue().getData());
            Horario.setCellValueFactory(cellData -> cellData.getValue().getHorario());
            PT.setCellValueFactory(cellData -> cellData.getValue().getPT());
            ST.setCellValueFactory(cellData -> cellData.getValue().getST());
            QT.setCellValueFactory(cellData -> cellData.getValue().getQT());
            FPT.setCellValueFactory(cellData -> cellData.getValue().getFPT());
            EA.setCellValueFactory(cellData -> cellData.getValue().getEA());
            ER.setCellValueFactory(cellData -> cellData.getValue().getER());
            EAT.setCellValueFactory(cellData -> cellData.getValue().getEAT());
            D.setCellValueFactory(cellData -> cellData.getValue().getD());
            InfoTable.setItems(InfoData);
        }
    }

    void setArquivo(File selectedFile) throws IOException {
        if (selectedFile.exists()) {
            ArrayList<Informacoes> dados = Auxiliar.ler_Data(selectedFile);

            InfoData.addAll(dados);
            InfoTable.setItems(InfoData);

            /* try {
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
            }*/
        } else {
            Alert dialogo = new Alert(Alert.AlertType.ERROR);
            dialogo.setContentText("Arquivo de dados energéticos não encontrado!");
            dialogo.showAndWait();
        }
    }
}
