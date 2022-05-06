package gui;

import businesslogic.AccountManager;
import datarecords.AccountData;
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
    private final AccountManager accountManager;

    public accountRegistrationController(Supplier<SceneManager> sceneManagerSupplier, AccountManager accountManager) {
        this.sceneManagerSupplier = sceneManagerSupplier;
        this.accountManager = accountManager;
    }


    @FXML
    private void back(){
        sceneManagerSupplier.get().changeScene("secondary");
    }


    /**
     * Register the account data to the Database, doesn't check if fields are filled out and
     * doesn't catch the exceptions thrown by the database
     *
     * @throws Exception
     */

    @FXML
    private void registerAccount() throws Exception {

        String salt = AccountManager.getSalt();

        AccountData data = new AccountData(firstname.getText(),lastname.getText(), getActivePosition(),
                                            salt, eMail.getText(), accountManager.hashString(passwordField.getText(), salt ));

        accountManager.add(data);
    }


    /**
     * doesn't check if multiple options are active, just to enable the login
     *
     * @return String with Manager, Officer or Employee, depending on the active option
     *
     */
    @FXML
    private String getActivePosition(){
        if (manager.isSelected()){
            return "Manager";
        } else if (officer.isSelected() && !employee.isSelected()){
            return "Officer";
        } else{
            return "Employee";
        }
    }
}

