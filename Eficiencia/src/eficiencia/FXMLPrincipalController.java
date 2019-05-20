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

    private Stage Login; // Definindo a o Stage(Window) estatico do Login.

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Construindo a Variável para carregar a imagem principal
        Image image1 = new Image(FXMLPrincipalController.class.getResourceAsStream("ImageMain.jpg"));

        ImageMain.setImage(image1);

    }

    // Declaração dos itens usados no SceneBuilder
    @FXML
    private ImageView ImageMain;

    @FXML
    private Button Import;

    File selectedFile;

    @FXML
    private DatePicker datepicker;

    // Declaração da Função Import:
    @FXML
    private void FuncaoImport(ActionEvent e) {
        // Criando a Variável que vai ler o .txt(fileChooser):
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        // Filtrando as Extensões de Interesse:
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        // Criando o Palco para que seja feita a seleção do Arquivo:
        Stage stage = (Stage) ((Node) Import).getScene().getWindow();
        // Variável que vai armazenar o arquivo escolhido:
        selectedFile = fileChooser.showOpenDialog(stage);
        // Teste para saber se o arquivo está vazio:
        if (selectedFile != null) {
            Alert dialogo = new Alert(Alert.AlertType.WARNING, "Arquivo de Dados Energéticos não Selecionado!");
            dialogo.setContentText(selectedFile.getName());
            dialogo.showAndWait();
        }
    }

    // Declaração da Função Visualizar:
    @FXML
    private void FuncaoVisualizar(ActionEvent e) {
        // Escondendo o Stage Principal:
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.hide();
        //Teste para saber se o Usuário selecionou um Arquivo de Dados:
        if (selectedFile != null) {
            // Cria o Loader e apresenta o Stage do Visualizar:
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLVisualizar.fxml"));
                Parent root = loader.load();

                FXMLVisualizarController controladorVisualizar = loader.getController();
                controladorVisualizar.setArquivo(selectedFile);
                controladorVisualizar.setPrincipal(stage1);

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            // Se o Teste deu null o usuário recebe Advertência:
            Alert dialogo = new Alert(Alert.AlertType.WARNING);
            dialogo.setContentText("Arquivo de dados energéticos não selecionado!");
            dialogo.showAndWait();
            // Recarregar o Stage Principal:
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

    // Definindo a Função Gráfico:
    @FXML
    private void FuncaoGraf(ActionEvent e) {
        // Escondendo o Stage Principal:
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.hide();
        //Teste para saber se o Usuário selecionou um Arquivo de Dados:
        if (selectedFile != null) {
            // Cria o Loader e apresenta o Stage do Gráfico:
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGrafico.fxml"));
                Parent root = loader.load();

                FXMLGraficoController controladorGrafico = loader.getController();
                controladorGrafico.setPrincipal(stage1);
                controladorGrafico.setArquivo(selectedFile);

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            // Se o Teste deu null o usuário recebe Advertência:
            Alert dialogo = new Alert(Alert.AlertType.WARNING);
            dialogo.setContentText("Arquivo de dados energéticos não selecionado!");
            dialogo.showAndWait();
            // Recarregar o Stage Principal:
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

    // Declarando a Função Histórico:
    @FXML
    private void FuncaoHistorico(ActionEvent e) {
        // Escondendo o Stage Principal:
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.hide();
        //Teste para saber se o Usuário selecionou um Arquivo de Dados:
        if (selectedFile != null) {
            // Cria o Loader e apresenta o Stage do Histórico:
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLHistorico.fxml"));
                Parent root = loader.load();

                FXMLHistoricoController controladorHistorico = loader.getController();
                controladorHistorico.setPrincipal(stage1);
                controladorHistorico.setArquivo(selectedFile);

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
            // Se o Teste deu null o usuário recebe Advertência:
            Alert dialogo = new Alert(Alert.AlertType.WARNING);
            dialogo.setContentText("Arquivo de dados energéticos não selecionado!");
            dialogo.showAndWait();
            // Recarregar o Stage Principal:
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

    // Declaração da Função Imprimir:
    @FXML
    private void FuncaoImprimir(ActionEvent e) {
        // Escondendo o Stage Principal:
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.hide();
        //Teste para saber se o Usuário selecionou um Arquivo de Dados:
        if (selectedFile != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLImprimir.fxml"));
                Parent root = loader.load();

                FXMLImprimirController controladorImprimir = loader.getController();
                controladorImprimir.setPrincipal(stage1);
                controladorImprimir.setArquivo(selectedFile);

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
            // Se o Teste deu null o usuário recebe Advertência:
            Alert dialogo = new Alert(Alert.AlertType.WARNING);
            dialogo.setContentText("Arquivo de dados energéticos não selecionado!");
            dialogo.showAndWait();
            // Recarregar o Stage Principal:
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

    // Declaração da Função DataPicker:
    @FXML
    private void FuncaoDate(ActionEvent e) {

        LocalDate date = datepicker.getValue();

    }

    // Declaração da Função Voltar:
    @FXML
    private void FuncaoVoltar(ActionEvent e) {
        // Chamando o Stage do Login:
        Login.show();
        // Escondendo o Stage do Principal:
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.hide();
    }

    // Class do Login, para manter o Stage Login Único e Estático:
    void setLogin(Stage stage1) {
        this.Login = stage1;
    }
}
