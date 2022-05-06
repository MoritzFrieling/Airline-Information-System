package gui;

import businesslogic.LogInManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class LogInController implements Initializable {

    @FXML
    private TextField eMailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label label;

    private final Supplier<SceneManager> sceneManagerSupplier;
    private final LogInManager logInManager;

    public LogInController(Supplier<SceneManager> sceneManagerSupplier, LogInManager logInManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.logInManager = logInManager;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void logIn() throws Exception {
        if (logInManager.authenticate(new PasswordAuthentication(eMailField.getText(), passwordField.getText().toCharArray()))){
            sceneManagerSupplier.get().changeScene("secondary");
        }else {
            label.setText("Something Went Wrong! Couldn't log in");
        }
    }
}
