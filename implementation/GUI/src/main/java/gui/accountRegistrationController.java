package gui;

import businesslogic.AccountManager;
import datarecords.AccountData;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    @FXML
    private Label feedback;


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

        if (!isRadioSelected()){
            feedback.setText("Please select a position!");

        }else if(!isFirstnameEntered()){
            feedback.setText("Please enter a valid firstname!");
        }else if(!isLastnameEntered()){
            feedback.setText("Please enter a valid lastname!");
        }else if(!isMailEntered()){
            feedback.setText("Please enter a valid Mail!\n" +
                    "a valid e-Mail contains contains 3 characters + @ais.nl");
        }else if(!isPasswordEntered()){
            feedback.setText("Please enter a valid Password!\n" +
                    "a valid password is at least 3 characters long");
        }else if(!doPasswordsMatch()){
            feedback.setText("Password and confirmation field don't match!");
        }else{
            String salt = AccountManager.getSalt();

            AccountData data = new AccountData(firstname.getText(),lastname.getText(), getActivePosition(),
                    salt, eMail.getText(), AccountManager.hashString(passwordField.getText(), salt ));

            if (accountManager.add(data)){
                feedback.setText(data.getFirstname() + "'s " + "Data has been Successfully saved to the DB!");
            }else{
                feedback.setText(data.getFirstname() + "'s" + "Data could not be saved!");
            }
        }


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
        } else if (officer.isSelected()){
            return "Officer";
        } else if ( employee.isSelected()){
            return "Employee";
        } else {
            return "Please select a position!";
        }
    }

    /**
     * Checks whether a radiobutton is selected or not
     * @return true if  button selected
     */
    @FXML
    private boolean isRadioSelected(){
        return manager.isSelected() || officer.isSelected() || employee.isSelected();
    }

    /**
     * Returns whether the firstname field is filled in
     * @return true if filled in
     */
    @FXML
    private boolean isFirstnameEntered(){
        return firstname.getText().length() >= 3;
    }

    /**
     * Returns whether the lastname field is filled in
     * @return true if filled in
     */
    @FXML
    private boolean isLastnameEntered(){
        return lastname.getText().length() >= 2;
    }


    /**
     * Returns whether the e-Mail field is filled in
     * @return true if filled in
     */
    @FXML
    private boolean isMailEntered(){
        return eMail.getText().length() >= 10 && eMail.getText().contains("@ais.nl");
    }

    /**
     * Returns whether the password field is filled in
     * @return true if filled in
     */
    @FXML
    private boolean isPasswordEntered(){
        return passwordField.getText().length() >= 3;
    }

    /**
     * Returns whether the password and confirmation fields match
     * @return true if match
     */
    @FXML
    private boolean doPasswordsMatch(){
        return passwordField.getText().equals(confirmationField.getText());
    }

}

