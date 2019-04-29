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
            ST.setSelected(!PT.isSelected());
            QT.setSelected(!PT.isSelected());
            FPT.setSelected(!PT.isSelected());
            EA.setSelected(!PT.isSelected());
            ER.setSelected(!PT.isSelected());
            EAT.setSelected(!PT.isSelected());
            D.setSelected(!PT.isSelected());
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
    private CheckBox G1, G3, G4;

    @FXML
    private CheckBox PT, ST, QT, FPT, EA, ER, EAT, D;

    @FXML
    private void FuncaoGerar(ActionEvent e) throws IOException {
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.hide();
        /*try {
            
            String X = Funcao_Selecao(G1, G3, G4);
            String Y = Funcao_Variavel(PT, ST, QT, FPT, EA, ER, EAT, D);
             
            Parent root;
            root = FXMLLoader.load(getClass().getResource("FXML.fxml"));

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