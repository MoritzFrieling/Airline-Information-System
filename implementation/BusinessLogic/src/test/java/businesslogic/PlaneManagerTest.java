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

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlaneManagerTest {

    @Mock
    StorageServiceImpl storageServiceImpl;
    @Mock
    PlaneData planeExample;
    @Mock
    PlaneModelData planeModelData;
    PlaneManager manager;

    @Test
    void add() throws Exception {

        when(storageServiceImpl.add(planeExample)).thenReturn(true);
        manager = new PlaneManager(storageServiceImpl);
        assertThat(manager.add(planeExample)).isTrue();
    }

    @Test
    void getAllPlaneModels() {
        var newPlaneModelList = new ArrayList<PlaneModelData>();
        //       when(storageServiceImpl.getAllPlaneModels()).thenReturn(newPlaneModelList);
    }
}