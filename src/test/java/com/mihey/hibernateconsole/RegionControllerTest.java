package com.mihey.hibernateconsole;

import com.mihey.hibernateconsole.controller.RegionController;
import com.mihey.hibernateconsole.model.Region;
import com.mihey.hibernateconsole.repository.RegionRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class RegionControllerTest {

    Region region = new Region();

    {
        region.setId(1);
        region.setName("RU");
    }

    @Mock
    private RegionRepository regionRepository;

    @InjectMocks
    private RegionController regionController = new RegionController();

    @Test
    public void getRegionByIdTest() {
        Mockito.when(regionRepository.getById(anyInt())).thenReturn(region);
        Assert.assertEquals("RU", regionController.getRegionById(1).getName());
        Assert.assertNotEquals("US", regionController.getRegionById(1).getName());
    }

    @Test
    public void saveRegionTest() {
        Mockito.when(regionRepository.save(region)).thenReturn(region);
        Assert.assertEquals(region, regionController.saveRegion(region));
        Assert.assertNotEquals("US", regionController.saveRegion(region).getName());
    }

    @Test
    public void editRegionTest() {
        region.setName("GB");
        Mockito.when(regionRepository.update(region)).thenReturn(region);
        Assert.assertEquals(region, regionController.editRegion(region));
        Assert.assertNotEquals("RU", regionController.editRegion(region).getName());
    }

    @Test
    public void deleteRegionByIdTest() {
        Mockito.doNothing().when(regionRepository).deleteById(anyInt());
    }

    @Test
    public void getAllRegionsTest() {
        List<Region> regions = new ArrayList<>();
        regions.add(region);
        Mockito.when(regionRepository.getAll()).thenReturn(regions);
        Assert.assertEquals(regions, regionController.getAllRegions());
        Assert.assertNotEquals(0, regionController.getAllRegions().size());
    }
}
