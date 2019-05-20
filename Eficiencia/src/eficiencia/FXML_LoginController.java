/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eficiencia;

import static eficiencia.Auxiliar.MD5;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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

    // Declarando a Função Registro:
    @FXML
    public void FuncaoRegistro(ActionEvent e) {
        // Fechando o Stage do Login
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.close();
        // Criando o Loader do Registro:
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLRegisterIn.fxml"));
            Parent root = loader.load();

            FXMLRegisterInController controladorRegisterIn = loader.getController();
            controladorRegisterIn.setLogin(stage1);

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

    // Declarando a Função Check:
    @FXML
    public void FuncaoCheck(ActionEvent e) {
        // Se o username informado está vazio ou o password:
        if (User.getText().isEmpty() || Password.getText().isEmpty()) {
            // Alerta de que há informações importantes a serem dadas:
            Alert dialogo = new Alert(Alert.AlertType.WARNING, "Campos Importantes estão em Branco!");
            dialogo.showAndWait();
        } else {
            // Se não está vazios, deve-se testar se estão registrados:
            try {
                Usuario user = new Usuario(User.getText(), Password.getText());
                ArrayList<Usuario> users = Auxiliar.ler_usuarios(new File("usuarios.txt"));

                boolean encontrou = false, senha_correta = false;

                for (Usuario u : users) {
                    if (u.getLogin().equals(user.getLogin())) {
                        // Username informado está na lista de Registrados,
                        // e a senha codificada confere, então:
                        encontrou = true;
                        if (MD5(Password.getText()).equals(u.getSenha())) {
                            // Fecha o Stage do Login:
                            Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
                            stage1.close();
                            senha_correta = true;

                            // Chama o Loader do Principal:
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLPrincipal.fxml"));
                            Parent root = loader.load();

                            FXMLPrincipalController controladorPrincipal = loader.getController();
                            controladorPrincipal.setLogin(stage1);

                            Scene scene = new Scene(root);
                            Stage stage = new Stage();

                            stage.setOnCloseRequest(ee -> {
                                stage.hide();
                            });
                            stage.setScene(scene);
                            stage.show();
                            break;
                        }
                    }
                }
                // Se não estão registrados, Alerta de Usuário não registrado:
                if (!encontrou) {
                    Alert dialogo = new Alert(Alert.AlertType.WARNING, "Usuário Inexistente, se Registre antes!");
                    dialogo.showAndWait();
                    // Chama o Loader do Registro:
                    Parent root;
                    root = FXMLLoader.load(getClass().getResource("FXMLRegisterIn.fxml"));

                    Scene scene = new Scene(root);
                    Stage stage = new Stage();

                    stage.setOnCloseRequest(ee -> {
                        stage.hide();
                    });
                    stage.setScene(scene);
                    stage.show();
                } else {
                    // Se usuário está registrado porém com senha errada:
                    if (!senha_correta) {
                        // Alerta de Senha Incorreta:
                        Alert dialogo = new Alert(Alert.AlertType.WARNING, "Senha incorreta. Verifique sua senha!");
                        dialogo.showAndWait();
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();

            }
        }
    }

    // Criando Class Usuário com os Atributos cabivéis:
    void setUsuario(String login, String senha) {
        User.setText(login);
        Password.setText(senha);
    }

}
