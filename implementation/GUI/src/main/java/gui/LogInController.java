package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class LogInController implements Initializable {

    @FXML
    private TextField eMailField;

    @FXML
    private PasswordField passwordField;

    private final Supplier<SceneManager> sceneManagerSupplier;

    public LogInController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void logIn(){
        sceneManagerSupplier.get().changeScene("secondary");
    }
}
