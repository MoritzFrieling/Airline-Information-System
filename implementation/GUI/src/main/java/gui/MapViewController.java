package gui;

import com.esri.arcgisruntime.ArcGISRuntimeEnvironment;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.BasemapStyle;
import com.esri.arcgisruntime.mapping.Viewpoint;
import com.esri.arcgisruntime.mapping.view.MapView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class MapViewController implements Initializable {

    private final Supplier<SceneManager> sceneManagerSupplier;

    @FXML
    AnchorPane anchorPane;

    @FXML
    MapView mapView;

    public MapViewController(Supplier<SceneManager> sceneManagerSupplier) {
        this.sceneManagerSupplier = sceneManagerSupplier;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ArcGISRuntimeEnvironment.setApiKey("AAPK2f322c12c5c44960bf9a2c00ddec7210x_MTLb_lejtAdUXZoTMlcLA_A8tRmxWrSso8BfOCQEHiyTQ7buMKS7xaQ9UL2ia-");
        anchorPane.getChildren().add(mapView);
        ArcGISMap map = new ArcGISMap(BasemapStyle.ARCGIS_NAVIGATION);

        mapView.setMap(map);

        mapView.setViewpoint(new Viewpoint(34.027, -118.805, 72223.819286));
    }
}
