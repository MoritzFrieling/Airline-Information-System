package gui;

import javafx.fxml.FXML;

import java.util.function.Supplier;

public class OfficerViewController {

    private final Supplier<SceneManager> sceneManagerSupplier;

    public OfficerViewController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }





    @FXML
    private void logOut(){
        sceneManagerSupplier.get().changeScene("logInView");
    }
    
}
