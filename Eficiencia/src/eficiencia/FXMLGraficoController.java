/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eficiencia;

// import static eficiencia.Auxiliar.Funcao_Selecao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 05180176
 */
public class FXMLGraficoController implements Initializable {

    String flag_G = "G1", flag_V = "PT", Grafico_Escolhido = "G1", Variavel_Escolhida = "PT";

    /**
     * Initializes the controller class.
     */
    private Stage Principal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Image image1 = new Image(FXMLGraficoController.class.getResourceAsStream("dispersao.jpg"));
        Image image3 = new Image(FXMLGraficoController.class.getResourceAsStream("colunas.jpg"));
        Image image4 = new Image(FXMLGraficoController.class.getResourceAsStream("linhas.jpg"));

        image01.setImage(image1);
        image03.setImage(image3);
        image04.setImage(image4);

        G1.setOnAction(e -> {
            G3.setSelected(!G1.isSelected());
            G4.setSelected(!G1.isSelected());
            if(G1.isSelected()){
                flag_V = "G1";
            }
        });
        G3.setOnAction(e -> {
            G1.setSelected(!G3.isSelected());
            G4.setSelected(!G3.isSelected());
            if(G3.isSelected()){
                flag_V = "G3";
            }
        });
        G4.setOnAction(e -> {
            G3.setSelected(!G4.isSelected());
            G1.setSelected(!G4.isSelected());
            if(G4.isSelected()){
                flag_V = "G4";
            }
        });

        PT.setOnAction(e -> {
            if (!PT.isSelected()) {
                ST.setSelected(!PT.isSelected());
                QT.setSelected(!PT.isSelected());
                FPT.setSelected(!PT.isSelected());
                EA.setSelected(!PT.isSelected());
                ER.setSelected(!PT.isSelected());
                EAT.setSelected(!PT.isSelected());
                D.setSelected(!PT.isSelected());
                if (PT.isSelected()) {
                    flag_V = "PT";
                }
            }
        });

        ST.setOnAction(e -> {
            PT.setSelected(!ST.isSelected());
            QT.setSelected(!ST.isSelected());
            FPT.setSelected(!ST.isSelected());
            EA.setSelected(!ST.isSelected());
            ER.setSelected(!ST.isSelected());
            EAT.setSelected(!ST.isSelected());
            D.setSelected(!ST.isSelected());
            if (ST.isSelected()) {
                flag_V = "ST";
            }
        });

        QT.setOnAction(e -> {
            PT.setSelected(!QT.isSelected());
            ST.setSelected(!QT.isSelected());
            FPT.setSelected(!QT.isSelected());
            EA.setSelected(!QT.isSelected());
            ER.setSelected(!QT.isSelected());
            EAT.setSelected(!QT.isSelected());
            D.setSelected(!QT.isSelected());
            if (QT.isSelected()) {
                flag_V = "QT";
            }
        });

        FPT.setOnAction(e -> {
            ST.setSelected(!FPT.isSelected());
            QT.setSelected(!FPT.isSelected());
            PT.setSelected(!FPT.isSelected());
            EA.setSelected(!FPT.isSelected());
            ER.setSelected(!FPT.isSelected());
            EAT.setSelected(!FPT.isSelected());
            D.setSelected(!FPT.isSelected());
            if (FPT.isSelected()) {
                flag_V = "FPT";
            }
        });

        EA.setOnAction(e -> {
            ST.setSelected(!EA.isSelected());
            QT.setSelected(!EA.isSelected());
            FPT.setSelected(!EA.isSelected());
            PT.setSelected(!EA.isSelected());
            ER.setSelected(!EA.isSelected());
            EAT.setSelected(!EA.isSelected());
            D.setSelected(!EA.isSelected());
            if (EA.isSelected()) {
                flag_V = "EA";
            }
        });

        ER.setOnAction(e -> {
            ST.setSelected(!ER.isSelected());
            QT.setSelected(!ER.isSelected());
            FPT.setSelected(!ER.isSelected());
            EA.setSelected(!ER.isSelected());
            PT.setSelected(!ER.isSelected());
            EAT.setSelected(!ER.isSelected());
            D.setSelected(!ER.isSelected());
            if (ER.isSelected()) {
                flag_V = "ER";
            }
        });

        EAT.setOnAction(e -> {
            ST.setSelected(!EAT.isSelected());
            QT.setSelected(!EAT.isSelected());
            FPT.setSelected(!EAT.isSelected());
            EA.setSelected(!EAT.isSelected());
            ER.setSelected(!EAT.isSelected());
            PT.setSelected(!EAT.isSelected());
            D.setSelected(!EAT.isSelected());
            if (EAT.isSelected()) {
                flag_V = "EAT";
            }
        });

        D.setOnAction(e -> {
            ST.setSelected(!D.isSelected());
            QT.setSelected(!D.isSelected());
            FPT.setSelected(!D.isSelected());
            EA.setSelected(!D.isSelected());
            ER.setSelected(!D.isSelected());
            EAT.setSelected(!D.isSelected());
            PT.setSelected(!D.isSelected());
            if (D.isSelected()) {
                flag_V = "D";
            }

        });

        if (flag_G.equals("G1")) {

            Grafico_Escolhido = "Gráfico de Dispersão";
            if (flag_V.equals("PT")) {

                Variavel_Escolhida = "PT";

            } else if (flag_V.equals("ST")) {

                Variavel_Escolhida = "ST";

            } else if (flag_V.equals("QT")) {

                Variavel_Escolhida = "QT";

            } else if (flag_V.equals("FPT")) {

                Variavel_Escolhida = "FPT";

            } else if (flag_V.equals("EA")) {

                Variavel_Escolhida = "EA";

            } else if (flag_V.equals("ER")) {

                Variavel_Escolhida = "ER";

            } else if (flag_V.equals("EAT")) {

                Variavel_Escolhida = "EAT";

            } else if (flag_V.equals("D")) {

                Variavel_Escolhida = "D";
            }

        } else if (flag_G.equals("G3")) {

            Grafico_Escolhido = "Gráfico de Colunas";
            if (flag_V.equals("PT")) {

                Variavel_Escolhida = "PT";

            } else if (flag_V.equals("ST")) {

                Variavel_Escolhida = "ST";

            } else if (flag_V.equals("QT")) {

                Variavel_Escolhida = "QT";

            } else if (flag_V.equals("FPT")) {

                Variavel_Escolhida = "FPT";

            } else if (flag_V.equals("EA")) {

                Variavel_Escolhida = "EA";

            } else if (flag_V.equals("ER")) {

                Variavel_Escolhida = "ER";

            } else if (flag_V.equals("EAT")) {

                Variavel_Escolhida = "EAT";

            } else if (flag_V.equals("D")) {

                Variavel_Escolhida = "D";
            }

        } else if (flag_G.equals("G4")) {

            Grafico_Escolhido = "Gráfico de Linhas";
            if (flag_V.equals("PT")) {

                Variavel_Escolhida = "PT";

            } else if (flag_V.equals("ST")) {

                Variavel_Escolhida = "ST";

            } else if (flag_V.equals("QT")) {

                Variavel_Escolhida = "QT";

            } else if (flag_V.equals("FPT")) {

                Variavel_Escolhida = "FPT";

            } else if (flag_V.equals("EA")) {

                Variavel_Escolhida = "EA";

            } else if (flag_V.equals("ER")) {

                Variavel_Escolhida = "ER";

            } else if (flag_V.equals("EAT")) {

                Variavel_Escolhida = "EAT";

            } else if (flag_V.equals("D")) {

                Variavel_Escolhida = "D";
            }
        }
    }

    @FXML
    private ImageView image01, image03, image04;

    @FXML
    private CheckBox G1, G3, G4;

    @FXML
    private CheckBox PT, ST, QT, FPT, EA, ER, EAT, D;

    @FXML
    private void FuncaoGerar(ActionEvent e) throws IOException {
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.hide();

        // Desenvolver o coletor dos dados escolhidos!!!!!
        // Setar o Gráfico Escolhido com os dados contra o tempo!!!!!
        if (this.Grafico_Escolhido.equals("Grafico de Dispersão")) {

            ScatterChart GrafDisp = new ScatterChart(new CategoryAxis(), new NumberAxis());

            if (this.Variavel_Escolhida.equals("PT")) {

            } else if (this.Variavel_Escolhida.equals("ST")) {

            } else if (this.Variavel_Escolhida.equals("QT")) {

            } else if (this.Variavel_Escolhida.equals("EA")) {

            } else if (this.Variavel_Escolhida.equals("ER")) {

            } else if (this.Variavel_Escolhida.equals("EAT")) {

            } else if (this.Variavel_Escolhida.equals("FPT")) {

            } else if (this.Variavel_Escolhida.equals("D")) {

            } else {
                Alert dialogo = new Alert(Alert.AlertType.WARNING);
                dialogo.setContentText("Variável não Selecionada!");
                dialogo.showAndWait();

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
        } else if (this.Grafico_Escolhido.equals("Grafico de Colunas")) {

            BarChart GrafBarra = new BarChart<>(new CategoryAxis(), new NumberAxis());

            if (this.Variavel_Escolhida.equals("PT")) {

            } else if (this.Variavel_Escolhida.equals("ST")) {

            } else if (this.Variavel_Escolhida.equals("QT")) {

            } else if (this.Variavel_Escolhida.equals("EA")) {

            } else if (this.Variavel_Escolhida.equals("ER")) {

            } else if (this.Variavel_Escolhida.equals("EAT")) {

            } else if (this.Variavel_Escolhida.equals("FPT")) {

            } else if (this.Variavel_Escolhida.equals("D")) {

            } else {
                Alert dialogo = new Alert(Alert.AlertType.WARNING);
                dialogo.setContentText("Variável não Selecionada!");
                dialogo.showAndWait();

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
        } else if (this.Grafico_Escolhido.equals("Grafico de Linhas")) {
            XYChart.Series GrafLinhas = new XYChart.Series();
            if (this.Variavel_Escolhida.equals("PT")) {

            } else if (this.Variavel_Escolhida.equals("ST")) {

            } else if (this.Variavel_Escolhida.equals("QT")) {

            } else if (this.Variavel_Escolhida.equals("EA")) {

            } else if (this.Variavel_Escolhida.equals("ER")) {

            } else if (this.Variavel_Escolhida.equals("EAT")) {

            } else if (this.Variavel_Escolhida.equals("FPT")) {

            } else if (this.Variavel_Escolhida.equals("D")) {

            } else {
                Alert dialogo = new Alert(Alert.AlertType.WARNING);
                dialogo.setContentText("Variável não Selecionada!");
                dialogo.showAndWait();

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
        } else {
            Alert dialogo = new Alert(Alert.AlertType.WARNING);
            dialogo.setContentText("Grafico não Selecionado!");
            dialogo.showAndWait();

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
    }

    @FXML
    private void FuncaoVoltar(ActionEvent e) {
        Principal.show();
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.hide();
    }

    void setPrincipal(Stage stage1) {
        this.Principal = stage1;
    }
}
