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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 05180176
 */
// Declarando o Controller do Visualizar:
public class FXMLVisualizarController implements Initializable {

    /**
     * Initializes the controller class.
     */
    // Declarando as Variáveis Utilizadas:
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

    // Criando a Tabela:
    private final ObservableList<Informacoes> InfoData = FXCollections.observableArrayList();
    // Criando o Stage estático do Principal:
    private Stage Principal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Teste para ver se a tabela está vazia:
        if (InfoTable != null) {
            InfoTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
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

    // Criando a Função para Setar o Arquivo escolido:
    void setArquivo(File selectedFile) throws IOException {
        if (selectedFile.exists()) {
            ArrayList<Informacoes> dados = Auxiliar.ler_Data(selectedFile);

            InfoData.addAll(dados);
            InfoTable.setItems(InfoData);
            
        } else {
            // Se o Arquivo não existe:
            Alert dialogo = new Alert(Alert.AlertType.ERROR);
            dialogo.setContentText("Arquivo de dados energéticos não encontrado!");
            dialogo.showAndWait();
        }
    }
    
    // Declaração da Função Voltar:
    @FXML
    private void FuncaoVoltar(ActionEvent e) {
        Principal.show();
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.close();
    }

    // Criando a Função setPrincipal:
    void setPrincipal(Stage stage1) {
       this.Principal = stage1;
    }
}
