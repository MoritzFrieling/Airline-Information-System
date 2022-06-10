package businesslogic;

import datarecords.PlaneData;
import datarecords.PlaneModelData;
import org.junit.jupiter.api.Test;

import businesslogic.PlaneManager;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import persistence.StorageService;
import persistence.StorageServiceImpl;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

class PlaneManagerTest {

    @Mock
    StorageServiceImpl storageServiceImpl;

    @Test
    void add() throws Exception {

        var planeModelExample = new PlaneModelData("Bob", "23", 100, 30000, 20000, 4000);
        var planeExample = new PlaneData(planeModelExample, 30, 20, 50);

        when(storageServiceImpl.add(planeExample)).thenReturn(true);
        var manager = new PlaneManager(storageServiceImpl);
        assertThat(manager.add(planeExample)).isTrue();
    }

    @Test
    void getAllPlaneModels() {
    }
}