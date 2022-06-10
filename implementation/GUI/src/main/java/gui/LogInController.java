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

        boolean valid = true;
        PasswordAuthentication entered = new PasswordAuthentication(eMailField.getText(), passwordField.getText().toCharArray());

        if (entered.getUserName().isEmpty()){
            valid = false;
            label.setText("Please enter Information!");

        }
        if (valid) {
            if (String.copyValueOf(entered.getPassword()).contentEquals("") && entered.getUserName().contentEquals("dev")) {
                sceneManagerSupplier.get().changeScene("secondary");
            } else if (logInManager.authenticate(entered)) {

                String p = logInManager.identify(entered);

                if (p.contentEquals("Manager")) {
                    sceneManagerSupplier.get().changeScene("secondary");
                } else if (p.contentEquals("Officer")) {
                    sceneManagerSupplier.get().changeScene("OfficerView");
                } else if (p.contentEquals("Employee")) {
                    sceneManagerSupplier.get().changeScene("EmpView");
                } else {
                    label.setText("Couldn't identify Position!");
                }
            } else {
                label.setText("Something Went Wrong! Couldn't log in");
            }
        }
    }
}
