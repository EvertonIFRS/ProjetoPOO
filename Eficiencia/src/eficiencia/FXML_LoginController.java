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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 05180176
 */
public class FXML_LoginController implements Initializable {

    @FXML
    TextField User;

    @FXML
    PasswordField Password;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void FuncaoRegistro(ActionEvent e) {
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.close();
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("FXMLRegisterIn.fxml"));

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
    public void FuncaoCheck(ActionEvent e) {
        if (User.getText().isEmpty() || Password.getText().isEmpty()) {
           Alert dialogo = new Alert(Alert.AlertType.WARNING, "Campos Importantes estão em Branco!");
           dialogo.showAndWait();
        } else {
            try {
                Usuario user = new Usuario(User.getText(), Password.getText());
                ArrayList<Usuario> users = Auxiliar.ler_usuarios(new File("usuarios.txt"));
                if(!users.contains(user)){
                    Alert dialogo = new Alert(Alert.AlertType.WARNING, "Usuário Inexistente, se Registre antes!");
                    dialogo.showAndWait();
                    Parent root;
                    root = FXMLLoader.load(getClass().getResource("FXMLRegisterIn.fxml"));
                    
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();

                    stage.setOnCloseRequest(ee -> {
                        stage.hide();
                    });
                    stage.setScene(scene);
                    stage.show();
                }
                Stage stage1 = (Stage) ((Node)e.getSource()).getScene().getWindow();
                stage1.close();
                if (users.contains(user)) {
                    Parent root;
                    root = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));

                    Scene scene = new Scene(root);
                    Stage stage = new Stage();

                    stage.setOnCloseRequest(ee -> {
                        stage.hide();
                    });
                    stage.setScene(scene);
                    stage.show();
                }
            } catch (IOException ex) {
                ex.printStackTrace();

            }
        }
    }

    void setUsuario(String login, String senha) {
        User.setText(login);
        Password.setText(senha);
    }

}
