package gui;

import javafx.fxml.FXML;

import java.util.function.Supplier;

public class EmpViewController {

    private final Supplier<SceneManager> sceneManagerSupplier;

    public EmpViewController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }


    @FXML
    private void lookUpFlight(){

    }


    @FXML
    private void lookUpBooking(){

    }


    @FXML
    private void createBooking(){

    }


    @FXML
    private void logOut(){
        sceneManagerSupplier.get().changeScene("logInView");
    }
}
