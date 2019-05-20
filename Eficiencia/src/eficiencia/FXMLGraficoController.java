/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eficiencia;

// import static eficiencia.Auxiliar.Funcao_Selecao;
import static eficiencia.Auxiliar.ler_Data;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
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

    /**
     * Initializes the controller class.
     */
    private Stage Principal;
    String flag_G = "G1", flag_V = "PT";

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
        });

        G3.setOnAction(e -> {
            G1.setSelected(!G3.isSelected());
            G4.setSelected(!G3.isSelected());
        });

        G4.setOnAction(e -> {
            G3.setSelected(!G4.isSelected());
            G1.setSelected(!G4.isSelected());
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
        });

        QT.setOnAction(e -> {
            PT.setSelected(!QT.isSelected());
            ST.setSelected(!QT.isSelected());
            FPT.setSelected(!QT.isSelected());
            EA.setSelected(!QT.isSelected());
            ER.setSelected(!QT.isSelected());
            EAT.setSelected(!QT.isSelected());
            D.setSelected(!QT.isSelected());
        });

        FPT.setOnAction(e -> {
            ST.setSelected(!FPT.isSelected());
            QT.setSelected(!FPT.isSelected());
            PT.setSelected(!FPT.isSelected());
            EA.setSelected(!FPT.isSelected());
            ER.setSelected(!FPT.isSelected());
            EAT.setSelected(!FPT.isSelected());
            D.setSelected(!FPT.isSelected());
        });

        EA.setOnAction(e -> {
            ST.setSelected(!EA.isSelected());
            QT.setSelected(!EA.isSelected());
            FPT.setSelected(!EA.isSelected());
            PT.setSelected(!EA.isSelected());
            ER.setSelected(!EA.isSelected());
            EAT.setSelected(!EA.isSelected());
            D.setSelected(!EA.isSelected());
        });

        ER.setOnAction(e -> {
            ST.setSelected(!ER.isSelected());
            QT.setSelected(!ER.isSelected());
            FPT.setSelected(!ER.isSelected());
            EA.setSelected(!ER.isSelected());
            PT.setSelected(!ER.isSelected());
            EAT.setSelected(!ER.isSelected());
            D.setSelected(!ER.isSelected());
        });

        EAT.setOnAction(e -> {
            ST.setSelected(!EAT.isSelected());
            QT.setSelected(!EAT.isSelected());
            FPT.setSelected(!EAT.isSelected());
            EA.setSelected(!EAT.isSelected());
            ER.setSelected(!EAT.isSelected());
            PT.setSelected(!EAT.isSelected());
            D.setSelected(!EAT.isSelected());
        });

        D.setOnAction(e -> {
            ST.setSelected(!D.isSelected());
            QT.setSelected(!D.isSelected());
            FPT.setSelected(!D.isSelected());
            EA.setSelected(!D.isSelected());
            ER.setSelected(!D.isSelected());
            EAT.setSelected(!D.isSelected());
            PT.setSelected(!D.isSelected());
        });
    }

    @FXML
    private ImageView image01, image03, image04;

    @FXML
    private CheckBox G1, G3, G4, PT, ST, QT, FPT, EA, ER, EAT, D;

    ArrayList<Informacoes> informacoes;

    File selectedFile;

    Stage STAGE;

    @FXML
    private void FuncaoGerar(ActionEvent e) throws IOException {
        if (G1.isSelected()) {
            if (PT.isSelected()) {
                geraGraficoDisp("SERIE_PT");
            } else if (ST.isSelected()) {
                geraGraficoDisp("SERIE_ST");
            } else if (QT.isSelected()) {
                geraGraficoDisp("SERIE_QT");
            } else if (EA.isSelected()) {
                geraGraficoDisp("SERIE_EA");
            } else if (ER.isSelected()) {
                geraGraficoDisp("SERIE_ER");
            } else if (EAT.isSelected()) {
                geraGraficoDisp("SERIE_EAT");
            } else if (FPT.isSelected()) {
                geraGraficoDisp("SERIE_FPT");
            } else if (D.isSelected()) {
                geraGraficoDisp("SERIE_D");
            } else {
                Alert dialogo = new Alert(Alert.AlertType.WARNING);
                dialogo.setContentText("Variável não Selecionada!");
                dialogo.showAndWait();
            }
        } else if (G3.isSelected()) {
            if (PT.isSelected()) {
                geraGraficoCol("SERIE_PT");
            } else if (ST.isSelected()) {
                geraGraficoCol("SERIE_ST");
            } else if (QT.isSelected()) {
                geraGraficoCol("SERIE_QT");
            } else if (EA.isSelected()) {
                geraGraficoCol("SERIE_EA");
            } else if (ER.isSelected()) {
                geraGraficoCol("SERIE_ER");
            } else if (EAT.isSelected()) {
                geraGraficoCol("SERIE_EAT");
            } else if (FPT.isSelected()) {
                geraGraficoCol("SERIE_FPT");
            } else if (D.isSelected()) {
                geraGraficoCol("SERIE_D");
            } else {
                Alert dialogo = new Alert(Alert.AlertType.WARNING);
                dialogo.setContentText("Variável não Selecionada!");
                dialogo.showAndWait();
            }
        } else if (G4.isSelected()) {
            if (PT.isSelected()) {
                geraGraficoLin("SERIE_PT");
            } else if (ST.isSelected()) {
                geraGraficoLin("SERIE_ST");
            } else if (QT.isSelected()) {
                geraGraficoLin("SERIE_QT");
            } else if (EA.isSelected()) {
                geraGraficoLin("SERIE_EA");
            } else if (ER.isSelected()) {
                geraGraficoLin("SERIE_ER");
            } else if (EAT.isSelected()) {
                geraGraficoLin("SERIE_EAT");
            } else if (FPT.isSelected()) {
                geraGraficoLin("SERIE_FPT");
            } else if (D.isSelected()) {
                geraGraficoLin("SERIE_D");
            } else {
                Alert dialogo = new Alert(Alert.AlertType.WARNING);
                dialogo.setContentText("Variável não Selecionada!");
                dialogo.showAndWait();
            }
        } else {
            Alert dialogo = new Alert(Alert.AlertType.WARNING);
            dialogo.setContentText("Grafico não Selecionada!");
            dialogo.showAndWait();
        }
    }

    void geraGraficoDisp(String titulo) {
        
        ScatterChart<Number, Number> GrafDisp = new ScatterChart(new NumberAxis(), new NumberAxis());
        XYChart.Series serie = new XYChart.Series();
        serie.setName(titulo);
        double t = 0;
        
        for (Informacoes inf : informacoes) {
            if (titulo.equals("SERIE_PT")) {
                serie.getData().add(new XYChart.Data(t, Double.parseDouble(inf.getPT().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_ST")) {
                serie.getData().add(new XYChart.Data(t, Double.parseDouble(inf.getST().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_QT")) {
                serie.getData().add(new XYChart.Data(t, Double.parseDouble(inf.getQT().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_EA")) {
                serie.getData().add(new XYChart.Data(t, Double.parseDouble(inf.getEA().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_ER")) {
                serie.getData().add(new XYChart.Data(t, Double.parseDouble(inf.getER().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_EAT")) {
                serie.getData().add(new XYChart.Data(t, Double.parseDouble(inf.getEAT().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_FPT")) {
                serie.getData().add(new XYChart.Data(t, Double.parseDouble(inf.getFPT().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_D")) {
                serie.getData().add(new XYChart.Data(t, Double.parseDouble(inf.getD().get().replace(",", "."))));
            }
            t++;
        }
        GrafDisp.getData().addAll(serie);
        Scene scene = new Scene(GrafDisp, 500, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }

    void geraGraficoCol(String titulo) {

        BarChart graficoBarra = new BarChart<>(new NumberAxis(), new NumberAxis());
        XYChart.Series serie = new XYChart.Series();
        serie.setName(titulo);
        double t = 0;
        
        for (Informacoes inf : informacoes) {

            if (titulo.equals("SERIE_PT")) {
                serie.getData().add(new BarChart.Data(t, Double.parseDouble(inf.getPT().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_ST")) {
                serie.getData().add(new BarChart.Data(t, Double.parseDouble(inf.getST().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_QT")) {
                serie.getData().add(new BarChart.Data(t, Double.parseDouble(inf.getQT().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_EA")) {
                serie.getData().add(new BarChart.Data(t, Double.parseDouble(inf.getEA().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_ER")) {
                serie.getData().add(new BarChart.Data(t, Double.parseDouble(inf.getER().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_EAT")) {
                serie.getData().add(new XYChart.Data(t, Double.parseDouble(inf.getEAT().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_FPT")) {
                serie.getData().add(new BarChart.Data(t, Double.parseDouble(inf.getFPT().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_D")) {
                serie.getData().add(new BarChart.Data(t, Double.parseDouble(inf.getD().get().replace(",", "."))));
            }
            t++;
        }
        graficoBarra.getData().addAll(serie);
        Scene scene = new Scene(graficoBarra, 500, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }

    void geraGraficoLin(String titulo) {

        LineChart graficoLinha = new LineChart<>(new NumberAxis(), new NumberAxis());
        XYChart.Series serie = new XYChart.Series();
        serie.setName(titulo);
        double t = 0;

        for (Informacoes inf : informacoes) {
            if (titulo.equals("SERIE_PT")) {
                serie.getData().add(new LineChart.Data(t, Double.parseDouble(inf.getPT().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_ST")) {
                serie.getData().add(new LineChart.Data(t, Double.parseDouble(inf.getST().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_QT")) {
                serie.getData().add(new LineChart.Data(t, Double.parseDouble(inf.getQT().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_EA")) {
                serie.getData().add(new LineChart.Data(t, Double.parseDouble(inf.getEA().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_ER")) {
                serie.getData().add(new LineChart.Data(t, Double.parseDouble(inf.getER().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_EAT")) {
                serie.getData().add(new LineChart.Data(t, Double.parseDouble(inf.getEAT().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_FPT")) {
                serie.getData().add(new LineChart.Data(t, Double.parseDouble(inf.getFPT().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_D")) {
                serie.getData().add(new LineChart.Data(t, Double.parseDouble(inf.getD().get().replace(",", "."))));
            }            
            t++;
        }

        graficoLinha.getData().addAll(serie);
        Scene scene = new Scene(graficoLinha, 500, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }

    void setArquivo(File selectedFile) {
        try {
            informacoes = ler_Data(selectedFile);
        } catch (IOException ex) {
        }
    }

    @FXML
    private void FuncaoVoltar(ActionEvent e) {
        Principal.show();
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.hide();
    }

    void setPrincipal(Stage STAGE) {
        this.Principal = STAGE;
    }
}
/*
ScatterChart<Number, Number> GrafDisp = new ScatterChart(new NumberAxis(), new NumberAxis());
        XYChart.Series serie = new XYChart.Series();
        serie.setName(titulo);
        double t = 0;
        for (Informacoes inf : informacoes) {
            if (titulo.equals("SERIE_PT")) {
                serie.getData().add(new XYChart.Data(t, Double.parseDouble(inf.getPT().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_ST")) {
                serie.getData().add(new XYChart.Data(t, Double.parseDouble(inf.getST().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_QT")) {
                serie.getData().add(new XYChart.Data(t, Double.parseDouble(inf.getQT().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_EA")) {
                serie.getData().add(new XYChart.Data(t, Double.parseDouble(inf.getEA().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_ER")) {
                serie.getData().add(new XYChart.Data(t, Double.parseDouble(inf.getER().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_EAT")) {
                serie.getData().add(new XYChart.Data(t, Double.parseDouble(inf.getEAT().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_FPT")) {
                serie.getData().add(new XYChart.Data(t, Double.parseDouble(inf.getFPT().get().replace(",", "."))));
            } else if (titulo.equals("SERIE_D")) {
                serie.getData().add(new XYChart.Data(t, Double.parseDouble(inf.getD().get().replace(",", "."))));
            }
            t++;
        }
        GrafDisp.getData().addAll(serie);
        Scene scene = new Scene(GrafDisp, 500, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
 */
