/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eficiencia;

import java.io.File;
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
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 05180176
 */
public class FXMLRegisterInController implements Initializable {

    // Declarando Itens usados no FXML do Registro:
    @FXML
    TextField NewUser;
    
    @FXML
    PasswordField NewPassword, Confirm;
    
    private Stage Login;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    // Declarando a Função de Criar Usuários:
    @FXML
    public void FuncaoCreateUser(ActionEvent e) {
        // Se o password informado atende os requisitos de segurança,
        // Bem como o username, então:
        if ((NewPassword.getText().length() >= 8) && (NewPassword.getText().length() <= 10)
                && (NewUser.getText().length() >= 8) && (NewUser.getText().length() <= 10)) {
            // Se o campo de novo Usuário não está preenchido:
            if (NewUser.getText().isEmpty()) {
                // Alerta o Usuário para que seja informado um username:
                Alert dialogo = new Alert(Alert.AlertType.WARNING, "O campo de Usuário deve ser Preenchido!");
                dialogo.showAndWait();
            } else if (NewPassword.getText().isEmpty() || Confirm.getText().isEmpty()) {
                // Avisa o Usuário para preencher os 2 campos de Passwords:
                Alert dialogo = new Alert(Alert.AlertType.WARNING, "Os campos de Senhas devem ser Preenchidos!");
                dialogo.showAndWait();
            } else if (!Confirm.getText().equals(NewPassword.getText())) {
                // Se as senhas não conferirem o Usuário é informado desse fato e deve corrigir esse problema:
                Alert dialogo = new Alert(Alert.AlertType.WARNING, "As Senhas devem ser Iguais!");
                dialogo.showAndWait();
            } else {
                // Criptografa a senha:
                String senha = Auxiliar.MD5(NewPassword.getText());
                // Fecha o Stage do Registro:
                Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
                stage1.close();
                // Chama o Loader do Login, passando o novo User:
                try {
                    Auxiliar.gravar_usuario(new File("usuarios.txt"), new Usuario(NewUser.getText(), senha));
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Login.fxml"));
                    Parent root = loader.load();
                    FXML_LoginController controladorLogin = loader.getController();

                    controladorLogin.setUsuario(NewUser.getText(), senha);
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
            // Mensagem de Aviso que os requisistos de segurança não foram satisfeitos:
            Alert dialogo = new Alert(Alert.AlertType.WARNING, "Requisitos de Segurança não Atingidos!");
            dialogo.showAndWait();
        }
    }

    // Declaração da Função Voltar:
    @FXML
    private void FuncaoVoltar(ActionEvent e) {
        // Apresenta o Stage do Login:
        Login.show();
        // Esconde o Stage do Registro:
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.hide();
    }

    // Cria a class Login:
    void setLogin(Stage stage1) {
        this.Login = stage1;
    }

}
