package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.util.function.Supplier;

public class accountRegistrationController {

    @FXML
    private RadioButton manager;
    @FXML
    private RadioButton officer;
    @FXML
    private RadioButton employee;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField eMail;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmationField;
    @FXML
    private Button submit;
    @FXML
    private Button back;


    private final Supplier<SceneManager> sceneManagerSupplier;

    public accountRegistrationController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }


    @FXML
    private void back(){
        sceneManagerSupplier.get().changeScene("secondary");
    }
}
